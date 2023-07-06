package com.manzano.BioRestServ.ServiceTest;

import com.manzano.BioRestServ.Services.W1GenomeBegService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class W1GenBegServiceTest {


    @Test
    public void patterCountSucceed(){
        String genTest = "GCGCG";
        String patternTest = "GCG";
        W1GenomeBegService w1GenomeBegService = new W1GenomeBegService();
        Integer countObtained = w1GenomeBegService.countPatters(genTest, patternTest);
        Assertions.assertEquals(countObtained, Integer.valueOf(2));
    }

    @Test
    public void frequentWordsFinderSucced(){
        String genTest = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
        int k = 4;
        W1GenomeBegService w1GenomeBegService = new W1GenomeBegService();
        List<String> successList = Arrays.asList("GCAT", "CATG" );
        List<String> methodList = w1GenomeBegService.frequentWordsFinder(genTest, k);
        Assertions.assertEquals(methodList, successList);
    }

    @Test
    public void reverseComplementSuccess(){
        String dnaString = "AAAACCCGGT";
        String reverseDnaStringTest = "ACCGGGTTTT";
        W1GenomeBegService w1GenomeBegService = new W1GenomeBegService();
        String reverseStringGen = w1GenomeBegService.reversePattern(dnaString);
        Assertions.assertEquals(reverseDnaStringTest, reverseStringGen);
    }

    @Test
    public void patternPositionInGenSuccess(){
        String pattern = "ATAT";
        String gen = "GATATATGCATATACTT";
        W1GenomeBegService w1GenomeBegService = new W1GenomeBegService();
        List<Integer> listOfPositions = w1GenomeBegService.listOfPositions(pattern, gen);
        List<Integer> expectedListOfPositions = Arrays.asList(1,3,9);
        Assertions.assertEquals(expectedListOfPositions, listOfPositions);
    }

    @Test//TODO: Next method to solve: https://stepik.org/lesson/4/step/3?unit=8233
    public void clumpFindingSuccess(){
        String gen = "CGGACTCGACAGATGTGAAGAACGACAATGTGAAGACTCGACACGACAGAGTGAAGAGAAGAGGAAACATTGTAA";
        int kmerLenght = 5;
        int LongOfWindow = 50;
        int timesKmerRepeats = 4;
        W1GenomeBegService w1GenomeBegService = new W1GenomeBegService();
        Set<String> resolvedOutput = w1GenomeBegService.clumpFinding(gen, kmerLenght, LongOfWindow, timesKmerRepeats);
        Set<String> expectedOutput =new HashSet<>(Arrays.asList("GAAGA", "CGACA"));
        Assertions.assertEquals(expectedOutput, resolvedOutput);
    }

}
