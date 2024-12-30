package com.manzano.biorestserv.ServiceTest;

import com.manzano.biorestserv.services.FrecuentWordsService;
import com.manzano.biorestserv.util.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

//TODO: Descomentar los demas test agreganto utiliti al constructor
//TODO: Añadir constructor para usar un before all para el service y su inyeccion de dependencias
public class FrequentWordsServiceTest {


    @Test
    public void patterCountSucceed(){
        String genTest = "GCGCG";
        String patternTest = "GCG";
        FrecuentWordsService frecuentWordsService = new FrecuentWordsService(new Utility());
        Integer countObtained = frecuentWordsService.countPatters(genTest, patternTest);
        Assertions.assertEquals(countObtained, Integer.valueOf(2));
    }

    @Test
    public void frequentWordsFinderSucced(){
        String genTest = "ACGTTGCATGTCGCATGATGCATGAGAGCT";
        int k = 4;
        FrecuentWordsService FrecuentWordsService = new FrecuentWordsService(new Utility());
        List<String> successList = Arrays.asList("GCAT", "CATG" );
        List<String> methodList = FrecuentWordsService.frequentWordsFinder(genTest, k);
        Assertions.assertEquals(methodList, successList);
    }

    @Test
    public void reverseComplementSuccess(){
        String dnaString = "AAAACCCGGT";
        String reverseDnaStringTest = "ACCGGGTTTT";
        FrecuentWordsService FrecuentWordsService = new FrecuentWordsService(new Utility());
        String reverseStringGen = FrecuentWordsService.reversePattern(dnaString);
        Assertions.assertEquals(reverseDnaStringTest, reverseStringGen);
    }

    //Link in cogniterra: https://cogniterra.org/lesson/29851/step/5?unit=21948
    @Test
    public void patternPositionInGenSuccess(){
        String pattern = "ATAT";
        String gen = "GATATATGCATATACTT";
        FrecuentWordsService FrecuentWordsService = new FrecuentWordsService(new Utility());
        List<Integer> listOfPositions = FrecuentWordsService.listOfPositions(pattern, gen);
        List<Integer> expectedListOfPositions = Arrays.asList(1,3,9);
        Assertions.assertEquals(expectedListOfPositions, listOfPositions);
    }

    @Test
    public void patternPositionInVibrioCholerae() throws IOException {
        String pattern = "CTTGATCAT";
        Path path = Path.of("src/main/resources/static/Vibrio_cholerae.txt");
        String genoma = Files.readString(path);
        FrecuentWordsService FrecuentWordsService = new FrecuentWordsService(new Utility());
        List<Integer> listOfPositions = FrecuentWordsService.listOfPositions(pattern, genoma);
        List<Integer> expectedListOfPositions = Arrays.asList(60039, 98409, 129189, 152283, 152354, 152411, 163207, 197028, 200160, 357976, 376771, 392723, 532935, 600085, 622755, 1065555);
        Assertions.assertEquals(expectedListOfPositions, listOfPositions);
    }



}
