package com.manzano.BioRestServ.Services;

import com.manzano.BioRestServ.Util.Utility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired //TODO: Review the dependency injection and why need to be explicit instanciate
    private Utility utility = new Utility();

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
        Map<String, Integer> frequenKmersMap = utility.frequencyMap(genString, kmerLong);
        try {
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

    public String reversePattern(String gen){
        log.info("into reversePattern()");
        Map<String, String> genMap = new HashMap<>();
        genMap.put("A", "T");
        genMap.put("T", "A");
        genMap.put("C", "G");
        genMap.put("G", "C");
        StringBuilder reversePattern = new StringBuilder();
        StringBuilder patternBuilder = new StringBuilder(gen).reverse();
        for (int i =0; i<=patternBuilder.length()-1; i++){
            reversePattern.append(genMap.get(patternBuilder.substring(i, i+1)));
        }
        log.info("exiting reversePattern()");
        return reversePattern.toString();
    }

    public List<Integer> listOfPositions(String pattern, String gen) {
        log.info("into listOfPositions()");
        List<Integer> listOfPositions = new ArrayList<>();
        for (int i = 0; i<= gen.length()-pattern.length(); i++){
            if (gen.substring(i,i+pattern.length()).equals(pattern)){
                listOfPositions.add(i);
            }
        }
        log.info("exiting listOfPositions()" + listOfPositions);
        return listOfPositions;
    }
}
