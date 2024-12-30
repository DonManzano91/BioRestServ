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
    private Utility utility;

    @BeforeEach
    public void setUp(){
        utility = new Utility();
        clumpsService = new ClumpsService(utility);

    }

    @Test//TODO: Next method to solve: https://stepik.org/lesson/4/step/3?unit=8233
    public void clumpFindingSuccess(){
        String gen = "CGGACTCGACAGATGTGAAGAACGACAATGTGAAGACTCGACACGACAGAGTGAAGAGAAGAGGAAACATTGTAA";
        int kmerLenght = 5;
        int LongOfWindow = 50;
        int timesKmerRepeats = 4;
        Set<String> resolvedOutput = clumpsService.clumpFinding(gen, kmerLenght, LongOfWindow, timesKmerRepeats);
        Set<String> expectedOutput =new HashSet<>(Arrays.asList("GAAGA", "CGACA"));
        Assertions.assertEquals(expectedOutput, resolvedOutput);
    }


}
