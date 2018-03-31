package com.anagram;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rentala on 3/30/18.
 */
public class AnagramDetector {
    HashMap<String, List<String>> map;
    FileHelper fh = null;
    boolean saveToDisk;

    public AnagramDetector(List<String> words, boolean saveToDisk) throws IOException {
        this.saveToDisk = saveToDisk;
        this.map = new HashMap<>();
        this.fh = new FileHelper();
        for(String word : words) {
            String sortedWord = sort(word);
            List<String> list = map.containsKey(sortedWord) ? map.get(sortedWord) :
                    new LinkedList<>();
            list.add(word);
            map.put(sortedWord, list);
        }
        if (saveToDisk) {
            System.out.println(" Saving to disk . . ");
            fh.writeToDisk(map);
        }
    }
    public String sort(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public List<String> find(String word) {
        if (!saveToDisk)
            return map.get(sort(word));
        return fh.getIndexData(sort(word));

    }
}
