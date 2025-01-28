package com.manzano.biorestserv.ServiceTest;

import com.manzano.biorestserv.services.ClumpsService;
import com.manzano.biorestserv.services.FrecuentWordsService;
import com.manzano.biorestserv.util.Utility;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ClumpsServiceTest {

    private ClumpsService clumpsService;

    @BeforeEach
    public void setUp(){
        Utility utility = new Utility();
        clumpsService = new ClumpsService(utility);

    }

    @Test
    public void clumpFindingSuccess(){
        String gen = "CGGACTCGACAGATGTGAAGAACGACAATGTGAAGACTCGACACGACAGAGTGAAGAGAAGAGGAAACATTGTAA";
        int kmerLenght = 5;
        int LongOfWindow = 50;
        int timesKmerRepeats = 4;
        Set<String> resolvedOutput = clumpsService.clumpFinding(gen, kmerLenght, LongOfWindow, timesKmerRepeats);
        Set<String> expectedOutput =new HashSet<>(Arrays.asList("GAAGA", "CGACA"));
        Assertions.assertEquals(expectedOutput, resolvedOutput);
    }

    @Test
    public void clumpFindingSuccess2(){
        String gen = "CTAAAACGTCG";
        int kmerLenght = 2;
        int LongOfWindow = 4;
        int timesKmerRepeats = 2;
        Set<String> resolvedOutput = clumpsService.clumpFinding(gen, kmerLenght, LongOfWindow, timesKmerRepeats);
        Set<String> expectedOutput =new HashSet<>(Arrays.asList("AA"));
        Assertions.assertEquals(expectedOutput, resolvedOutput);
    }

    @Test
    public void clumpFindingSuccess3(){
        String gen = "ACGTACGT";
        int kmerLenght = 1;
        int LongOfWindow = 5;
        int timesKmerRepeats = 2;
        Set<String> resolvedOutput = clumpsService.clumpFinding(gen, kmerLenght, LongOfWindow, timesKmerRepeats);
        Set<String> expectedOutput =new HashSet<>(Arrays.asList("T", "C", "A", "G"));
        Assertions.assertEquals(expectedOutput, resolvedOutput);
    }

    @Test
    public void clumpFindingSuccess4(){
        String gen = "CCATATACC";
        int kmerLenght = 3;
        int LongOfWindow = 5;
        int timesKmerRepeats = 2;
        Set<String> resolvedOutput = clumpsService.clumpFinding(gen, kmerLenght, LongOfWindow, timesKmerRepeats);
        Set<String> expectedOutput =new HashSet<>(Arrays.asList("ATA"));
    Assertions.assertEquals(expectedOutput, resolvedOutput);
    }




}
