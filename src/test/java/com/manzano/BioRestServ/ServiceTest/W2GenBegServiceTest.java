package com.manzano.BioRestServ.ServiceTest;

import com.manzano.BioRestServ.Services.W2GenomaBegService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class W2GenBegServiceTest {


    @Test
    public void skewMinimumSucced(){
        String gen = "TAAAGACTGCCGAGAGGCCAACACGAGTGCTAGAACGAGGGGCGTAAACGCGGGTCCGAT";
        List<Integer> expectedlistOfMimimuSkewValues = Arrays.asList(11, 24);
        W2GenomaBegService w2GenomaBegService = new W2GenomaBegService();
        List<Integer> actualListOfMinimumSkewCalues = w2GenomaBegService.skewMinimumList(gen);
        Assertions.assertEquals(expectedlistOfMimimuSkewValues, actualListOfMinimumSkewCalues);
    }

    @Test
    public void hammingDistanceSucced() throws Exception {
        String kmer1 = "GGGCCGTTGGT";
        String kmer2 = "GGACCGTTGAC";
        W2GenomaBegService w2GenomaBegService = new W2GenomaBegService();
        Integer expectedDistance = 3;
        Integer actualDistance = w2GenomaBegService.calculateHammingDistance(kmer1, kmer2);
        Assertions.assertEquals(expectedDistance, actualDistance);
    }
    @Test
    public void hammingDistanceFileSucced() throws Exception {
        Path path1 = Path.of("src/main/resources/static/hammingDistancekm1.txt");
        Path path2 = Path.of("src/main/resources/static/hammingDistancekm2.txt");
        String kmer1 = Files.readString(path1);
        String kmer2 = Files.readString(path2);
        W2GenomaBegService w2GenomaBegService = new W2GenomaBegService();
        Integer expectedDistance = 754; //Validated into the stepik challange for such dataset
        Integer actualDistance = w2GenomaBegService.calculateHammingDistance(kmer1, kmer2);
        Assertions.assertEquals(expectedDistance, actualDistance);
    }

    @Test //Direct test on challange example: https://stepik.org/lesson/9/step/4?unit=8224
    public void getListOfValidPattersHammingDistanceSucced(){
        String pattern = "ATTCTGGA";
        String gen = "CGCCCGAATCCAGAACGCATTCCCATATTTCGGGACCACTGGCCTCCACGGTACGGACGTCAATCAAAT";
        int maxAlloedHd = 3;
        W2GenomaBegService w2GenomaBegService = new W2GenomaBegService();
        List<Integer> expectedListOfPositions = Arrays.asList(6, 7, 26, 27);
        List<Integer> actualListOfPositions = w2GenomaBegService
                .getPosHammingDistanceEqualOrMinorValue(pattern, gen, maxAlloedHd);
        Assertions.assertEquals(expectedListOfPositions, actualListOfPositions);
    }

    @Test //Result of this return succes on test page: https://stepik.org/lesson/9/step/4?unit=8224
    public void getListOfValidPattersHammingDistanceFileSucced() throws IOException {
        String pattern = "CGTGCCTGATA";
        Path pathGen = Path.of("src/main/resources/static/SuccesTesttListValPatternHD.txt");
        String gen = Files.readString(pathGen);
        int maxAlloedHd = 6;
        W2GenomaBegService w2GenomaBegService = new W2GenomaBegService();
        List<Integer> expectedListOfPositions = Arrays.asList(6, 7, 26, 27);
        List<Integer> actualListOfPositions = w2GenomaBegService
                .getPosHammingDistanceEqualOrMinorValue(pattern, gen, maxAlloedHd);
        Assertions.assertEquals(expectedListOfPositions, actualListOfPositions);
    }

}
