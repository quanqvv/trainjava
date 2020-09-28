/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author 2P
 */
public class TimeCounter {
    private Runnable runnable;

    public TimeCounter(Runnable runnable) {
        this.runnable = runnable;
    }
    
    public void count(){
        long start = System.currentTimeMillis();
        runnable.run();
        long end = System.currentTimeMillis();
        System.out.printf("Total time: %s ms\n", end-start);
        return;
    }
    
    
    
}
