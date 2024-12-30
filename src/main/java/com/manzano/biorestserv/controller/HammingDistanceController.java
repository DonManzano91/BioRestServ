package com.manzano.biorestserv.controller;

import com.manzano.biorestserv.services.HammingDistanceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/hamming")
public class HammingDistanceController {

    private final HammingDistanceService hammingDistanceService;

    @PostMapping("/skerMinimumList")
    public ResponseEntity skewMinimumList(String gen){
        List<Integer> skewMiniumList = hammingDistanceService.skewMinimumList(gen);
        return new ResponseEntity(skewMiniumList, HttpStatus.OK);
    }

    @PostMapping("hammingDistance")
    public ResponseEntity hammingDistance(String kmer1, String kmer2) throws Exception {
        Integer hammingDistance = hammingDistanceService.calculateHammingDistance(kmer1, kmer2);
        return new ResponseEntity(hammingDistance, HttpStatus.OK);
    }
}
