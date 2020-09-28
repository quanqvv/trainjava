/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 *
 * @author 2P
 */
public class Ex3 {
    static String FOLDER_PATH = Constants.getInputPath(3);

    public static Map<String, Integer> mapCountWord(File file) throws FileNotFoundException, IOException{
        BufferedReader fileReader = new BufferedReader(new FileReader(file));
        String line = null;
        Map<String, Integer> countFreq = new HashMap<>();
        String word = null;
        while((line = fileReader.readLine()) != null){
            StringTokenizer st = new StringTokenizer(line,  " .)(;:.,!=+-?—\'\"", false);
//            StringTokenizer st = new StringTokenizer(line,  ".");
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
        return countFreq;
    }

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newFixedThreadPool(6);

        File[] files = new File(FOLDER_PATH).listFiles();

        final List<Callable<Object>> callables = new ArrayList<>();
        Arrays.stream(files).forEach(file -> {
            callables.add(()->{
                return mapCountWord(file);
            });
        });
        final Map<String, Integer> mapWordToForce= new HashMap<>();
        executorService.invokeAll(callables)
                .stream()
                .map(future -> {
                    try {
                       return future.get();
                    }
                    catch (Exception e){
                    }
                    return null;
                })
                .forEach(mapObj ->{
                    if(mapObj != null) {
                        ((Map<String, Integer>) mapObj).forEach((word, force) -> {
                            if(word != null) {
                                if (!mapWordToForce.containsKey(word)) {
                                    mapWordToForce.put(word, force);
                                } else {
                                    mapWordToForce.put(word, mapWordToForce.get(word) + force);
                                }
                            }
                        });
                    }
                });
        executorService.shutdown();
        Stream<Map.Entry<String,Integer>> sorted =
                mapWordToForce.entrySet().stream()
                        .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));
        List<String> top10 = new ArrayList<>();
        sorted.forEach(k->{
            if(top10.size()<10){
                top10.add(k.getKey());
                System.out.println(k);
            }
        });


    }
}
