package com.timberliu.algorithm.leetcode.binary_search.no0035_1_searchInsertPosition.related.no0981_timeBasedKeyValueStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liujie on 2021/3/18
 */

public class TimeMap {

    private class Entry {
        String value;
        int timestamp;
        Entry(String value, int tiemstamp) {
            this.value = value;
            this.timestamp = tiemstamp;
        }
    }

    private Map<String, List<Entry>> map;

    /** Initialize your data structure here. */
    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (map.containsKey(key)) {
            map.get(key).add(new Entry(value, timestamp));
        } else {
            List<Entry> list = new ArrayList<>();
            list.add(new Entry(value, timestamp));
            map.put(key, list);
        }
    }

    public String get(String key, int timestamp) {
        List<Entry> entries = map.get(key);
        int left = 0, right = entries.size() - 1;
        while (left <= right) {
            int mid = (left + right) >>> 1;
            Entry entry = entries.get(mid);
            if (entry.timestamp == timestamp) {
                return entry.value;
            } else if (entry.timestamp > timestamp) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right < 0 ? "" : entries.get(right).value;
    }

    public static void main(String[] args) {
        System.out.println("----- https://leetcode-cn.com/problems/time-based-key-value-store/ -----");
        System.out.println("----- 1 -----");
        TimeMap timeMap = new TimeMap();
        timeMap.set("love", "high", 10);
        timeMap.set("love", "low", 20);

        System.out.println(timeMap.get("love", 5));
        System.out.println(timeMap.get("love", 10));
        System.out.println(timeMap.get("love", 15));
        System.out.println(timeMap.get("love", 20));
        System.out.println(timeMap.get("love", 25));
    }
}