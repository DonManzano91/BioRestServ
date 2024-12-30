package com.manzano.biorestserv.controller;

import com.manzano.biorestserv.services.ClumpsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * */

@RestController
@RequestMapping("/clumps")
@AllArgsConstructor
public class ClumpsController {

    private final ClumpsService clumpsService;


}
