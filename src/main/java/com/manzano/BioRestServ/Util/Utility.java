package com.manzano.BioRestServ.Util;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Utility {

    private static final Logger log = LoggerFactory.getLogger(Utility.class);

    public Map<String, Integer> frequencyMap(String genString, Integer kmerLong){
        Map<String, Integer> frequenKmersMap = new HashMap<>();
        StringBuilder genBuilder = new StringBuilder(genString);
        for (int i = 0; i<=genBuilder.length()-kmerLong; i++){
            String key = genBuilder.substring(i, i+kmerLong);
            if (!frequenKmersMap.containsKey(key)){
                frequenKmersMap.put(key, 1);
            } else {
                int value = frequenKmersMap.get(key);
                frequenKmersMap.put(key, value+1);
            }
        }
        return frequenKmersMap;
    }

    public boolean isValidHM(String kmer, String subGen, int MaxHD){
        int hammingDistance = 0;
        for (int i = 0; i <=subGen.length()-1 ; i++) {
            if (kmer.charAt(i)!=subGen.charAt(i)){
                hammingDistance++;
            }
            if (hammingDistance>MaxHD){
                return false;
            }
        }
        return true;
    }

    public List<Integer> turnCsvTO_List(String CsvPath) throws IOException, CsvException {
        List<Integer> listIntegers = new ArrayList<>();
        try(CSVReader csvReader = new CSVReader(new FileReader(CsvPath))){
            List<String[]> rows = csvReader.readAll();
            for(String[] row:rows){
                for(String value: row){
                    listIntegers.add(Integer.parseInt(value.trim()));
                }
            }
        }
        return listIntegers;
    }
}
