package com.manzano.biorestserv.controller;

import com.manzano.biorestserv.services.FrecuentWordsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
//TODO: Create controller versions that can allow consume of txt files
//TODO: Create controller versions that can allow consume of json body

@RestController
@RequestMapping("/frequentWords")
@AllArgsConstructor
public class FrequentWordsController {

    private final FrecuentWordsService frecuentWordsService;

    @PostMapping("/countPatters")
    public ResponseEntity<Integer> CountPatters(String genString, String pattern){
        Integer countPatters = frecuentWordsService.countPatters(genString, pattern);
        ResponseEntity responseEntity = new ResponseEntity(countPatters, HttpStatus.OK);
        return responseEntity;
    }

    @PostMapping("/frequentWordsFinder")
    public ResponseEntity<List<String>> FrequentWordsFinder(String genString, Integer kmerLong){
        List<String> kmersList = frecuentWordsService.frequentWordsFinder(genString, kmerLong);
        return new ResponseEntity<>(kmersList, HttpStatus.OK);
    }

    @PostMapping("/reversePatterns")
    public ResponseEntity<String> reversePattern(String gen){
        String reverseGen = frecuentWordsService.reversePattern(gen);
        return new ResponseEntity<>(reverseGen, HttpStatus.OK);
    }

    @PostMapping("listOfPositions")
    public ResponseEntity<List<Integer>> listOfPositions(String pattern, String gen){
        List<Integer> listOfPositions = frecuentWordsService.listOfPositions(pattern, gen);
        return new ResponseEntity<>(listOfPositions, HttpStatus.OK);
    }


}
