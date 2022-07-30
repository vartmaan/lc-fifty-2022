package com.kol.lc.july.twenty.two;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {

        public List<String> wordSubsets(String[] words1, String[] words2) {

                List<String> res = new ArrayList<>();

                int bFreq[] = new int[26];

                for(String word : words2) {

                        int currWordCharFreq[] = new int[26];

                        for(char ch : word.toCharArray()) {

                                currWordCharFreq[ch - 'a']++;
                                bFreq[ch - 'a'] = Math.max(bFreq[ch - 'a'],currWordCharFreq[ch-'a']);
                        }

                }

                for(String a : words1) {
                        int currAFreq[] = new int[26];
                        for(char ch : a.toCharArray()) {
                               currAFreq[ch - 'a']++;
                        }

                        if(isSubset(currAFreq,bFreq)) {
                                res.add(a);
                        }
                }

                return res;
        }

        private boolean isSubset(int[] currAFreq, int[] bFreq) {

                for(int i = 0; i < 26;i++) {
                        if(bFreq[i] > currAFreq[i]) {
                                return false;
                        }
                }

                return true;
        }
}
