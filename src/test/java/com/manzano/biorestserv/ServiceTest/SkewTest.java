package com.manzano.biorestserv.ServiceTest;

import com.manzano.biorestserv.services.HammingDistanceService;
import com.manzano.biorestserv.util.Utility;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/*
* Clase para visualizar los diferentes escenarios de skew creation:
* link: https://cogniterra.org/lesson/29855/step/10?unit=21952
* */

public class SkewTest {

    private HammingDistanceService hammingDistanceService;

    @BeforeEach
    public void setUp(){
        Utility utility = new Utility();
        hammingDistanceService = new HammingDistanceService(utility);
    }

    //TODO [HIGH] Priodidad crear los test adicionales en https://cogniterra.org/lesson/29855/step/10?unit=21952
    @Test
    public void skewMinimumSucced(){
        String gen = "TAAAGACTGCCGAGAGGCCAACACGAGTGCTAGAACGAGGGGCGTAAACGCGGGTCCGAT";
        String expectedlistOfMimimuSkewValues = "11 24";
        String actualListOfMinimumSkewCalues = hammingDistanceService.skewMinimumList(gen);
        Assertions.assertEquals(expectedlistOfMimimuSkewValues, actualListOfMinimumSkewCalues);
    }

    @Test
    public void skewMinimumSucced1(){
        String gen = "ACCG";
        String expectedlistOfMimimuSkewValues = "3";
        String actualListOfMinimumSkewCalues = hammingDistanceService.skewMinimumList(gen);
        Assertions.assertEquals(expectedlistOfMimimuSkewValues, actualListOfMinimumSkewCalues);
    }
}
