package com.kol.lc.aug.tt2;


import java.util.Map;
import java.util.TreeMap;

public class MyCalendar1 {


    TreeMap<Integer,Integer> eventCalender;

    public MyCalendar1() {
         eventCalender = new TreeMap<>();
    }

    public boolean book2(int start, int end) {

        Map.Entry<Integer,Integer> prevEntry= eventCalender.floorEntry(start);
        Map.Entry<Integer,Integer> nextEntry = eventCalender.ceilingEntry(start);

        if((prevEntry == null || prevEntry.getValue() <= start) && (nextEntry == null || end <= nextEntry.getKey())) {
            eventCalender.put(start,end);
            return true;
        }

        return false;

    }

    public boolean book(int start, int end) {

       Integer prev =  eventCalender.floorKey(start);
       Integer next = eventCalender.ceilingKey(start);

       if(prev == null || eventCalender.get(prev) <= start && next == null || end <= next){
           eventCalender.put(start,end);
           return true;
       }

       return false;
    }
}



