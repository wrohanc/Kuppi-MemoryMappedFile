package com.ro.learn;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by rohan on 2016-10-28.
 */
public class MemoryMapWriter {
    private static final int ITERATIONS = 1024;

    public static void main(String[] args) throws Exception {
        byte[] data = "Text to insert".getBytes();//text to be written
        long start = System.currentTimeMillis();
        write("data", data);
        long end = System.currentTimeMillis();
        long tot = end - start;
        System.out.println(String.format("No Of Message %s , Time(ms) %s ", ITERATIONS, tot));

    }

    public static void write(final String fileName, byte[] data) throws Exception {
        FileChannel channel = new RandomAccessFile(fileName, "rw").getChannel();
        int position = 0;
        MappedByteBuffer buffer = null;
        for (long i = 0; i < ITERATIONS; i++) {
            buffer = channel.map(FileChannel.MapMode.READ_WRITE, position,
                        position + data.length);
            buffer.put(data);
            position = position + data.length;
        }

        channel.close();

    }

}
