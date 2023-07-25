package com.manzano.BioRestServ.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class Utility {

    private static final Logger log = LoggerFactory.getLogger(Utility.class);

    public Map<String, Integer> frequencyMap(String genString, Integer kmerLong){
        log.info("into frquencyMap");
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
        log.info("exiting frquencyMap");
        return frequenKmersMap;
    }

    public boolean isValidHM(String kmer, String subGen, int MaxHD){
        log.info("into isValidHM");
        int hammingDistance = 0;
        for (int i = 0; i <=subGen.length()-1 ; i++) {
            if (kmer.charAt(i)!=subGen.charAt(i)){
                hammingDistance++;
            }
            if (hammingDistance>MaxHD){
                return false;
            }
        }
        log.info("exiting isValidHM true value");
        return true;
    }
}
