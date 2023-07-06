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

    @Autowired //TODO: Review the dependency injection and why need to be explicit instantiate
    private Utility utility = new Utility();

    /**
     * Given a pattern provide, it counts how many times it repeats into the gen
     * @param genString: String representativo of a string
     * @param pattern: string pattern to be search in the gen
     * */
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

    /**
     * Method that retreives the kmers of long k that repeat more times into a gen
     * @param genString: the string that would be annalized
     * @param kmerLong = int value that would define the long of the kmer pattern to be retreive
     * */
    public List<String> frequentWordsFinder(String genString, Integer kmerLong) {
        log.info("into frequentWordsFinder()");
        List<String> mostFrequentKmers = new ArrayList<>();
        Map<String, Integer> frequenKmersMap ;
        try {
            frequenKmersMap = utility.frequencyMap(genString, kmerLong);
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

    /**
     * Method that retreives the reverse of a gen string given the rules of substitusion:
     * A<->T
     * C<->G
     * given the reverse complementary, a concept of biochemistry, reference can be here:
     * https://stepik.org/lesson/3/step/1?unit=8232
     * @param gen: string that will be reversed.
     * */
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

    /**
     * Method that retreives the list of possitions where a patter is located within a gen
     * @param pattern: string that would be search into the gen
     * @param gen: string where the pattern would be looked for, the list of positions would be refering the index
     * of this string.
     * */
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

    /**
     * This is a hard one, this would look for different substrings of lenght L from the
     * gen string provided, getting all the kmers of lenght k that repet more thant t times
     * @param gen: string that will be annalized
     * @param kmerLength : size of the kmer that would be looked for
     * @param l: longitud of the substring window where the kmers will be search for
     * @param t: times that the kmer is spected to appear inside every window.
     * */
    public Set<String> clumpFinding(String gen, int kmerLength, int l, int t) {
        Set<String> pattersList = new HashSet<>();
        String genWindow="";
        Map<String, Integer> frequenKmersMap;
        for (int i=0; i<=gen.length()-l; i++){
            genWindow = gen.substring(i, i+l);
            frequenKmersMap = utility.frequencyMap(genWindow, kmerLength);
            frequenKmersMap.forEach((k,v) -> {
                if (v>=t){
                    pattersList.add(k);
                }
            });
        }
        log.info("patternList " + pattersList);
        return pattersList;
    }
}
