/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author 2P
 */
public class Ex2 {
    public static final String INPUT_FILE = Constants.getInputPath(2)+"\\01.txt";
    public static final String OUTPUT_FILE = Constants.getInputPath(2)+"\\output.txt";


    public static void main(String[] args) throws FileNotFoundException, IOException {
        Set<Integer> set = new HashSet<>();
        Runnable run = ()->{};
        String file_path = INPUT_FILE;
        BufferedReader fileReader = new BufferedReader(new FileReader(file_path));
        String line = null;
        Map<String, Integer> countFreq = new HashMap<>();
        String word = null;
        while((line = fileReader.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line,  " .,!=+-”", true);
            while(st.hasMoreTokens()){
                word = st.nextToken();
                if(!countFreq.containsKey(word)){
                    countFreq.put(word, 1);
                }
                else{
                    countFreq.put(word, countFreq.get(word)+1);
                }
            }
        }
        final StringBuilder strBuilder = new StringBuilder("");
        countFreq.forEach((k, v)->{
            strBuilder.append(k + " " + v + '\n') ;
        });
        BufferedWriter fout = new BufferedWriter(new FileWriter(OUTPUT_FILE));
        fout.write(strBuilder.toString().toCharArray());
//        System.out.println(countFreq);
        
    }
    
}
