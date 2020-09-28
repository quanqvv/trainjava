/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.TimeCounter;


/**
 *
 * @author 2P
 */
public class Ex1 {
    
    public static Set<Integer> createRandomSet(int start, int end, int size){
        Set<Integer> list = ThreadLocalRandom.current()
        .ints(start, end)
        .boxed()
        .distinct()
        .limit(size)
        .collect(Collectors.toSet());
       return list;
    }
//    123 456
    public static void main(String[] args) {
        final int SIZE = 2000000;
//        final int ADD = 100
        Set<Integer> set1 = createRandomSet(0, SIZE+200000, SIZE);
        Set<Integer> set2 = createRandomSet(100000, SIZE+200000, SIZE);
        new TimeCounter(()->{
            set1.addAll(set2); // union
        }).count();
        
        new TimeCounter(()->{
            set1.retainAll(set2);
        }).count();
        
    }
}
