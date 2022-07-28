package com.kol.lc.july.twenty.two;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        ValidAnagram object = new ValidAnagram();
        boolean res = object.isAnagram("krishna","anshirk");
        System.out.println("Is Anagram "+res);
    }

    public boolean isAnagram(String s, String t) {

        if(s.length() != t.length()) {
            return false;
        }


        Map<Character,Integer> map = new HashMap<>();

        for( char ch : s.toCharArray()) {

            map.put(ch, map.getOrDefault(ch,0) + 1);
        }


        for( char ch : t.toCharArray()) {

            int count = map.getOrDefault(ch,0);

            if(count == 0) return false;
            map.put(ch, map.get(ch) - 1 );



        }

        return true;
    }
}
