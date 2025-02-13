package com.manzano.biorestserv.services;

import com.manzano.biorestserv.util.Utility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@AllArgsConstructor
public class HammingDistanceService {

    private final Utility utility;

    public String skewMinimumList(String gen) {
        log.info("into skewMinimumList()");
        int minimumValue = 0;
        int checkMinValue = 0;
        String nucleotide;
        StringBuilder skewMinimumList = new StringBuilder();
        List<Integer> posicion = new ArrayList<>();
        try {
            for (int i = 0; i <=gen.length()-1; i++){
                nucleotide = Character.toString(gen.charAt(i));
                switch (nucleotide) {
                    case "C":
                        checkMinValue--;
                        break;
                    case "G":
                        checkMinValue++;
                        break;
                    default:
                        break;
                }
                if (checkMinValue < minimumValue) {
                    minimumValue = checkMinValue;
                    posicion.clear();
                    posicion.add(i + 1);
                } else if (checkMinValue == minimumValue) {
                    posicion.add(i + 1);
                }
            }
        } catch (Exception e){
            log.error("Error in skewMinimumList given: " + e);
        }
        for (int pos : posicion) {
            skewMinimumList.append(pos).append(" ");
        }
        log.info("exiting skewMinimumList");
        return skewMinimumList.toString().trim();
}

    public Integer calculateHammingDistance(String kmer1, String kmer2) throws Exception{
        Integer hammingDistance = 0;

        if (kmer1.length()!=kmer2.length()){
            throw new Exception();
        }
        for (int i = 0; i <=kmer1.length()-1 ; i++) {
            if (kmer1.charAt(i)!=kmer2.charAt(i)){
                hammingDistance++;
            }
        }
        return hammingDistance;
    }

    public List<Integer> getPosHammingDistanceEqualOrMinorValue(String pattern, String gen, int maxHdAllowed){
        List<Integer> listOfPositions = new ArrayList<>();
        for (int i = 0; i <=gen.length()-pattern.length() ; i++) {
            if (utility.isValidHM(pattern, gen.substring(i,i+pattern.length()), maxHdAllowed)){
                listOfPositions.add(i);
            }
        }
        log.info(listOfPositions.toString());
        return listOfPositions;
    }
}
