package com.ro.learn;

import java.io.IOException;
import java.text.DecimalFormat;

/**
 * Created by rohan on 2017-05-20.
 */
public class MemoryMappedJournalMain {
    public static void main(String[] args) throws IOException {
        DecimalFormat format = new DecimalFormat("###,###,###,###");
        MemoryMappedJournal journal = new MemoryMappedJournal("test.txt");

        long start = System.nanoTime();
        for(int i = 0; i < 1000; i++){
            journal.add("1123123123123213");
        }
        long end = System.nanoTime();
        journal.stop();
        long endAll = System.nanoTime();

        System.out.println("Time taken : " + format.format(end - start) + "ns");
        System.out.println("Time taken : " + format.format(endAll - start) + "ns");
    }
}
