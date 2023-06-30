package com.manzano.BioRestServ.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * This Class is defined to construct the methods devine en W1 from this course:
 * https://stepik.org/lesson/2/step/6?auth=login&unit=8231
 * NOTE: This one wont use lombok just to practice.
 * */

@Service
public class W1GenomeBegService {
    /**
     * Certanly can be an easy way to do it with Java capabilities
     * but, gonna implement the logic decribed in the course for practice
     * */

    private static final Logger log = LoggerFactory.getLogger(W1GenomeBegService.class);

    public Integer countPatters(String genString, String pattern) {
        log.info("Gitting into countPatterns()");
        Integer count = 0;
        try {
            int patternLength = pattern.length();
            StringBuilder genBuilder = new StringBuilder(genString);
            for(int i=0; i<=genString.length() - patternLength ;i++){
                if(genBuilder.substring(i, i+patternLength).equals(pattern)){
                    count++;
                }
            }

        } catch (Exception e){
            log.error("Error in W1GenomeBegService.countPatters given excp: " + e);
        }
        log.info("Exiting of countPatterns()");
        return count;
    }

    public List<String> frequentWordsFinder(String genString, Integer kmerLong) {
        log.info("into frequentWordsFinder()");
        List<String> mostFrequentKmers = new ArrayList<>();
        Map<String, Integer> frequenKmersMap = new HashMap<>();
        StringBuilder genBuilder = new StringBuilder(genString);
        try {
            for (int i = 0; i<=genString.length()-kmerLong; i++){
                String key = genBuilder.substring(i, i+kmerLong);
                if (!frequenKmersMap.containsKey(key)){
                    frequenKmersMap.put(key, 1);
                } else {
                    int value = frequenKmersMap.get(key);
                    frequenKmersMap.put(key, value+1);
                }

            }
            Map.Entry<String, Integer> maxEntry = Collections
                    .max(frequenKmersMap.entrySet(), Comparator.comparing(Map.Entry::getValue));
            int maxValue = maxEntry.getValue();

            frequenKmersMap.forEach((k,v) -> {
                if (v==maxValue){
                    mostFrequentKmers.add(k);
                }
            });
        } catch (Exception e ){
            log.error("W1GenomeBegService.frequentWordsFinder() exeption given: " + e);
        }
        log.info("exiting frequentWordsFinder()");
        return mostFrequentKmers;
    }
}
