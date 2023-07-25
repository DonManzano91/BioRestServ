package com.manzano.BioRestServ.Controller;

import com.manzano.BioRestServ.Services.W2GenomaBegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * */

@RestController
@RequestMapping("/w1GenomaBegin")
public class W2GenomeBegController {

    @Autowired
    private W2GenomaBegService w2GenomaBegService;

    @PostMapping
    public ResponseEntity skewMinimumList(String gen){
        List<Integer> skewMiniumList = w2GenomaBegService.skewMinimumList(gen);
        return new ResponseEntity(skewMiniumList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity hammingDistance(String kmer1, String kmer2) throws Exception {
        Integer hammingDistance = w2GenomaBegService.calculateHammingDistance(kmer1, kmer2);
        return new ResponseEntity(hammingDistance, HttpStatus.OK);
    }
}
