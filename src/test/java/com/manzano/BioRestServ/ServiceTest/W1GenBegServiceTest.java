package com.manzano.BioRestServ.ServiceTest;

import com.manzano.BioRestServ.Services.W1GenomeBegService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class W1GenBegServiceTest {
    @Test
    public void patterCountSucceed(){
        String genTest = "GCGCG";
        String patternTest = "GCG";
        W1GenomeBegService w1GenomeBegService = new W1GenomeBegService();
        Integer countObtained = w1GenomeBegService.countPatters(genTest, patternTest);
        Assertions.assertEquals(countObtained, Integer.valueOf(2));
    }

}
