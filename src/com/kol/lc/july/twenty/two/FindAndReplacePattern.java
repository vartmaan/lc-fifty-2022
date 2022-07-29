package com.kol.lc.july.twenty.two;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAndReplacePattern {

    public static void main(String[] args) {
      String  words[] = {"abc","deq","mee","aqq","dkd","ccc"};
      String pattern = "abb";

      FindAndReplacePattern object = new FindAndReplacePattern();
      List<String> res = object.findAndReplacePattern(words,pattern);
        System.out.println("Res is "+res);
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {

        List<String> res = new ArrayList<>();

        for(String w : words) {
            if(isMatchingPattern(w,pattern)) {
                res.add(w);
            }
        }

        return res;
    }


    public boolean isMatchingPattern(String word, String pattern) {
        Map<Character,Character> fwdMap = new HashMap<>();
        Map<Character,Character> bwdMap = new HashMap<>();

        for(int i = 0; i < word.length(); i++) {
            char wCh = word.charAt(i);
            char pCh = pattern.charAt(i);
            if(!fwdMap.containsKey(wCh)) fwdMap.put(wCh,pCh);
            if(!bwdMap.containsKey(pCh)) bwdMap.put(pCh,wCh);

            if(fwdMap.get(wCh) != pCh || bwdMap.get(pCh) != wCh) return false;

        }

        return true;
    }
}
