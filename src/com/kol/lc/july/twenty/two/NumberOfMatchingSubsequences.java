package com.kol.lc.july.twenty.two;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String s, String[] words) {

        Map<Character, Queue<String>> map = new HashMap<>();


        for(char ch : s.toCharArray()) {
            map.put(ch,new LinkedList<String>());
        }

        for(String w : words) {
            if(map.containsKey(w.charAt(0))) {
                map.get(w.charAt(0)).add(w);
            }
        }

        int ans = 0;
        for(int i = 0; i < s.length(); i++) {

            char startChar = s.charAt(i);
            Queue<String> q = map.get(startChar);
            int size = q.size();

            for(int k = 0; k < size; k++) {
                String w = q.poll();

                if(w.substring(1).length() == 0) {
                    ans++;
                }else{
                    if(map.containsKey(w.charAt(1))) {
                        map.get(w.charAt(1)).add(w.substring(1));
                    }
                }
            }


        }

        return ans;

    }




}
