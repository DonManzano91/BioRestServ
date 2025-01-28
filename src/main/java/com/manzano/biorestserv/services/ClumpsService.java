package com.manzano.biorestserv.services;

import com.manzano.biorestserv.util.Utility;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
    import java.util.Map;
import java.util.Set;

@Service
@AllArgsConstructor
public class ClumpsService {

    private static final Logger log = LoggerFactory.getLogger(ClumpsService.class);

    private final Utility utility;

    /**
     * This is a hard one, this would look for different substrings of lenght L from the
     * gen string provided, getting all the kmers of lenght k that repet more thant t times
     * @param gen: string that will be annalized
     * @param kmerLength : size of the kmer that would be looked for
     * @param l: longitud of the substring window where the kmers will be search for
     * @param t: times that the kmer is spected to appear inside every window.
     * */
    public Set<String> clumpFinding(String gen, int kmerLength, int l, int t) {
        Set<String> pattersList = new HashSet<>();
        String genWindow;
        Map<String, Integer> frequenKmersMap;
        for (int i=0; i<=gen.length()-l; i++){
            genWindow = gen.substring(i, i+l);
            frequenKmersMap = utility.frequencyMap(genWindow, kmerLength);
            frequenKmersMap.forEach((k,v) -> {
                if (v>=t){
                    pattersList.add(k);
                }
            });
        }
        log.info("patternList " + pattersList);
        return pattersList;
    }

}
