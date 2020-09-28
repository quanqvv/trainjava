/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package train;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 *
 * @author 2P
 */


public class Ex4 {
    public static List<Integer> createRandomNumbers(int start, int end, int size){
        if(size > (end-start+1)){
            size = end-start;
        }
        List<Integer> list = ThreadLocalRandom.current()
        .ints(start, end)
        .boxed()
        .distinct()
        .limit(size)
        .collect(Collectors.toList());
       return list;
    }
    
    public static Set<Point> createRandomPointSet(Point center, int distance, int size){
        List<Integer> xList = createRandomNumbers(center.x-distance, distance+center.x, size);
//        xList.forEach(System.out::print);
        List<Integer> distanceList = new ArrayList<>();
        distanceList = createRandomNumbers(0, (int)Math.pow(distance, 2), size);

//        distanceList.forEach(System.out::print);
        Set<Point> pointSet = new HashSet<>();
        for(int i=0; i<size; i++){
            int x = xList.get(new Random().nextInt(xList.size()));
            int dis = distanceList.get(i);
            double temp = Math.sqrt(dis - Math.pow(center.x-x, 2));
            if(pointSet.size() < size)
                pointSet.add(new Point(x, (int)(temp+center.y)));
            if(pointSet.size() < size)
                pointSet.add(new Point(x, (int)(-temp+center.y)));
        }

        return pointSet;
    }
    public static void main(String[] args)  throws Exception{
        Set<Point> pointSet = createRandomPointSet(new Point(800, 800), 400, 8000);
        Set<Point> pointSet2 = createRandomPointSet(new Point(4000, 800), 500, 10000);
        Set<Point> pointSet3 = createRandomPointSet(new Point(2400, 2400), 600, 12000);
        pointSet.addAll(pointSet2);
        pointSet.addAll(pointSet3);
        System.out.println(pointSet.size());
        BufferedWriter bw = new BufferedWriter(new FileWriter(Constants.getInputPath(4)+"\\output.txt"));
        StringBuilder res = new StringBuilder("");
        pointSet.forEach(point->{
            res.append(point.x+" "+point.y+"\n");
        });
        bw.write(res.toString().toCharArray());
    }
}
