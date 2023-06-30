package com.manzano.BioRestServ.Services;

import org.springframework.stereotype.Service;

/**
 * This Class is defined to construct the methods devine en W1 from this course:
 * https://stepik.org/lesson/2/step/6?auth=login&unit=8231
 * */

@Service
public class W1GenomeBegService {

    /**
     * Certanly can be an easy way to do it with Java but, gonna implement the logic decribed in the course
     * */
    public Integer countPatters(String genString, String pattern) {
        Integer count = 0;
        int patternLength = pattern.length();
        StringBuilder genBuilder = new StringBuilder(genString);
        for(int i=0; i<=genString.length() - patternLength ;i++){
            if(genBuilder.substring(i, i+patternLength).equals(pattern)){
                count++;
            }
        }
        return count;
    }
}
