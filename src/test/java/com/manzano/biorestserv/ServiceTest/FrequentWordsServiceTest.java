package com.manzano.biorestserv.ServiceTest;

import com.manzano.biorestserv.services.FrecuentWordsService;
import com.manzano.biorestserv.util.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class FrequentWordsServiceTest {

    @Autowired
    private FrecuentWordsService frecuentWordsService;

    @Autowired
    private Utility utility;

    @BeforeEach
    public void setUp(){
        utility = new Utility();
        frecuentWordsService = new FrecuentWordsService(utility);
    }

    @Test
    public void patterCountSucceed(){
        String genTest = "GCGCG";
        String patternTest = "GCG";
        Integer countObtained = frecuentWordsService.countPatters(genTest, patternTest);
        Assertions.assertEquals(countObtained, Integer.valueOf(2));
    }

    @Test
    public void frequentWordsFinderSucced(){
        String genTest = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
        int k = 4;
        List<String> successList = Arrays.asList("GCAT", "CATG" );
        List<String> methodList = frecuentWordsService.frequentWordsFinder(genTest, k);
        Assertions.assertEquals(methodList, successList);
    }

    @Test
    public void reverseComplementSuccess(){
        String dnaString = "AAAACCCGGT";
        String reverseDnaStringTest = "ACCGGGTTTT";
        String reverseStringGen = frecuentWordsService.reversePattern(dnaString);
        Assertions.assertEquals(reverseDnaStringTest, reverseStringGen);
    }

    //Link in cogniterra: https://cogniterra.org/lesson/29851/step/5?unit=21948
    @Test
    public void patternPositionInGenSuccess(){
        String pattern = "ATAT";
        String gen = "GATATATGCATATACTT";
        List<Integer> listOfPositions = frecuentWordsService.listOfPositions(pattern, gen);
        List<Integer> expectedListOfPositions = Arrays.asList(1,3,9);
        Assertions.assertEquals(expectedListOfPositions, listOfPositions);
    }

    @Test
    public void patternPositionInVibrioCholerae() throws IOException {
        String pattern = "CTTGATCAT";
        Path path = Path.of("src/main/resources/static/Vibrio_cholerae.txt");
        String genoma = Files.readString(path);
        List<Integer> listOfPositions = frecuentWordsService.listOfPositions(pattern, genoma);
        List<Integer> expectedListOfPositions =
                Arrays.asList(60039, 98409, 129189, 152283, 152354, 152411,
                        163207, 197028, 200160, 357976, 376771, 392723, 532935, 600085, 622755, 1065555);
        Assertions.assertEquals(expectedListOfPositions, listOfPositions);
    }



}
