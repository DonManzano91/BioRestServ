package com.manzano.biorestserv.controller;

import com.manzano.biorestserv.services.ClumpsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Set;


@RestController
@RequestMapping("/clumps")
@AllArgsConstructor
public class ClumpsController {

    private final ClumpsService clumpsService;

    @PostMapping("/clumpFinding")
    public ResponseEntity<Set<String>> clumpFinding(String gen, int kmerLength, int l, int t){
        Set<String> clumpsFind = clumpsService.clumpFinding(gen, kmerLength, l, t);
        ResponseEntity<Set<String>> response = new ResponseEntity<>(clumpsFind, HttpStatus.OK);
        return response;
    }
}
