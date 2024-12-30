package com.manzano.biorestserv.ServiceTest;

import com.manzano.biorestserv.services.HammingDistanceService;
import com.manzano.biorestserv.util.Utility;
import com.opencsv.exceptions.CsvException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class HammingDistanceServiceTest {

    private HammingDistanceService hammingDistanceService;
    private Utility utility;

    @BeforeEach
    public void setUp(){
        utility = new Utility();
        hammingDistanceService = new HammingDistanceService(utility);
    }

    @Test
    public void skewMinimumSucced(){
        String gen = "TAAAGACTGCCGAGAGGCCAACACGAGTGCTAGAACGAGGGGCGTAAACGCGGGTCCGAT";
        List<Integer> expectedlistOfMimimuSkewValues = Arrays.asList(11, 24);
        List<Integer> actualListOfMinimumSkewCalues = hammingDistanceService.skewMinimumList(gen);
        Assertions.assertEquals(expectedlistOfMimimuSkewValues, actualListOfMinimumSkewCalues);
    }

    @Test
    public void hammingDistanceSucced() throws Exception {
        String kmer1 = "GGGCCGTTGGT";
        String kmer2 = "GGACCGTTGAC";
        Integer expectedDistance = 3;
        Integer actualDistance = hammingDistanceService.calculateHammingDistance(kmer1, kmer2);
        Assertions.assertEquals(expectedDistance, actualDistance);
    }
    @Test
    public void hammingDistanceFileSucced() throws Exception {
        Path path1 = Path.of("src/main/resources/static/hammingDistancekm1.txt");
        Path path2 = Path.of("src/main/resources/static/hammingDistancekm2.txt");
        String kmer1 = Files.readString(path1);
        String kmer2 = Files.readString(path2);
        Integer expectedDistance = 754; //Validated into the stepik challange for such dataset
        Integer actualDistance = hammingDistanceService.calculateHammingDistance(kmer1, kmer2);
        Assertions.assertEquals(expectedDistance, actualDistance);
    }

    @Test //Direct test on challange example: https://stepik.org/lesson/9/step/4?unit=8224
    public void getListOfValidPattersHammingDistanceSucced(){
        String pattern = "ATTCTGGA";
        String gen = "CGCCCGAATCCAGAACGCATTCCCATATTTCGGGACCACTGGCCTCCACGGTACGGACGTCAATCAAAT";
        int maxAlloedHd = 3;
        List<Integer> expectedListOfPositions = Arrays.asList(6, 7, 26, 27);
        List<Integer> actualListOfPositions = hammingDistanceService
                .getPosHammingDistanceEqualOrMinorValue(pattern, gen, maxAlloedHd);
        Assertions.assertEquals(expectedListOfPositions, actualListOfPositions);
    }

    @Test //Result of this return succes on test page: https://stepik.org/lesson/9/step/4?unit=8224
    public void getListOfValidPattersHammingDistanceFileSucced() throws IOException, CsvException {
        String pattern = "CGTGCCTGATA";
        Path pathGen = Path.of("src/main/resources/static/SuccesTesttListValPatternHD.txt");
        String gen = Files.readString(pathGen);
        int maxAlloedHd = 6;
        List<Integer> expectedListOfPositions = utility
                .turnCsvTO_List("src/main/resources/static/FileSuccedHammingPattersTestL9.csv");
        List<Integer> actualListOfPositions = hammingDistanceService
                .getPosHammingDistanceEqualOrMinorValue(pattern, gen, maxAlloedHd);
        Assertions.assertEquals(expectedListOfPositions, actualListOfPositions);
    }
}
