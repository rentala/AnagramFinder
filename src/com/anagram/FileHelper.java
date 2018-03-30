package com.anagram;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rentala on 3/30/18.
 */
public class FileHelper {

    public List<String> read(String filePath) {
        List<String> list = new LinkedList<>();
        long start = System.currentTimeMillis();
        try {
            File f = new File(filePath);
            BufferedReader b = new BufferedReader(new FileReader(f));

            String line = "";

            System.out.println("Reading file using Buffered Reader");

            while ((line = b.readLine()) != null) {
                //System.out.println(line);
                list.add(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(" Dictionary loaded in " + (end - start) + " ms \n");
        return list;
    }
}
