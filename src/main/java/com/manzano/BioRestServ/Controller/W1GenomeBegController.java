package com.manzano.BioRestServ.Controller;

import com.manzano.BioRestServ.Services.W1GenomeBegService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/w1GenomeBegin")
public class W1GenomeBegController {

    @Autowired
    private W1GenomeBegService w1GenomeBegService;

    @PostMapping("/countPatters")
    public ResponseEntity<Integer> CountPatters(String genString, String pattern){
        Integer countPatters = w1GenomeBegService.countPatters(genString, pattern);
        ResponseEntity responseEntity = new ResponseEntity(countPatters, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/frequentWordsFinder")
    public ResponseEntity<List<String>> FrequentWordsFinder(String genString, Integer kmerLong){
        List<String> kmersList = w1GenomeBegService.frequentWordsFinder(genString, kmerLong);
        return new ResponseEntity<>(kmersList, HttpStatus.OK);
    }

    @PostMapping("/reversePatterns")
    public ResponseEntity<String> reversePattern(String gen){
        String reverseGen = w1GenomeBegService.reversePattern(gen);
        return new ResponseEntity<>(reverseGen, HttpStatus.OK);
    }

    @PostMapping("listOfPositions")
    public ResponseEntity<List<Integer>> listOfPositions(String pattern, String gen){
        List<Integer> listOfPositions = w1GenomeBegService.listOfPositions(pattern, gen);
        return new ResponseEntity<>(listOfPositions, HttpStatus.OK);
    }


}
