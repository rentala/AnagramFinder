package com.anagram;

import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println("Welcome to the Anagram Finder");
        System.out.println("------------------------------");
        List<String> list = null;
        try {
            FileHelper fh = new FileHelper();
            if (args.length > 0) {
                list = fh.read(args[0]);
            } else {
                System.out.println(" Must contain path to dictionary ");
                System.exit(0);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(" Enter a word : ");
        String inputWord = reader.readLine();
        long start = System.currentTimeMillis();
        AnagramDetector ad = new AnagramDetector(list);
        List<String> res = ad.find(inputWord);
        long end = System.currentTimeMillis();
        if (res.size() == 0) {
            System.out.println(" No anagram found for " + inputWord + " in " + (end - start) + " ms");
            System.exit(0);
        }

        StringBuilder sb = new StringBuilder();
        int ct = 1;
        int size = res.size();
        System.out.println(size + " anagrams found for " + inputWord + " in " + (end - start) + " ms");
        for(String r: res) {
            sb.append(r);
            if(ct < size) sb.append(',');
            ct++;
        }
        System.out.println(sb.toString());
    }
}
