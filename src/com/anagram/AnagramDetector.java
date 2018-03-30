package com.anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by rentala on 3/30/18.
 */
public class AnagramDetector {
    HashMap<String, List<String>> map;
    public AnagramDetector(List<String> words) {
        map = new HashMap<>();

        for(String word : words) {
            String sortedWord = sort(word);
            List<String> list = map.containsKey(sortedWord) ? map.get(sortedWord) :
                    new LinkedList<>();
            list.add(word);
            map.put(sortedWord, list);
        }
    }
    public String sort(String word) {
        char[] chars = word.toLowerCase().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
    public List<String> find(String word) {
        return map.get(sort(word));
    }
}
