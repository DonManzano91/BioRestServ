package com.manzano.BioRestServ.Util;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Utility {

    public Map<String, Integer> frequencyMap(String genString, Integer kmerLong){
        Map<String, Integer> frequenKmersMap = new HashMap<>();
        StringBuilder genBuilder = new StringBuilder(genString);
        for (int i = 0; i<=genBuilder.length()-kmerLong; i++){
            String key = genBuilder.substring(i, i+kmerLong);
            if (!frequenKmersMap.containsKey(key)){
                frequenKmersMap.put(key, 1);
            } else {
                int value = frequenKmersMap.get(key);
                frequenKmersMap.put(key, value+1);
            }
        }
        return frequenKmersMap;
    }
}
