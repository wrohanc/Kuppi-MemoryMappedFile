package com.ro.learn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by rohan on 2017-05-20.
 */
public class MemoryMappedJournal {//to show the concept
    private FileChannel channel;
    private int position;

    public MemoryMappedJournal(String fileName) throws FileNotFoundException {
        channel = new RandomAccessFile(fileName, "rw").getChannel();
    }

    public void add(String message) throws IOException {
        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, position,
                position + message.length());
        buffer.put(message.getBytes());
        position = position + message.length();
    }

    public void stop() throws IOException {
        if(channel != null)
            channel.close();
    }
}
