package questions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.asyncq.questions.GenerateAllSubstrings;

public class GenerateAllSubstringTest {

    @Test
    public void givenInputString_whenGenerateSubStrings_ThenGenerateAllStrings(){
        String inputString = "ABCD";

        var generateAllSubstrings = new GenerateAllSubstrings();
        var res =  new ArrayList<String>();
        generateAllSubstrings.generateSubStringsUsingForLoop(inputString, res);
        Collections.sort(res);
        var res1 =  new ArrayList<String>();
        generateAllSubstrings.generateSubStringsUsingForLoop1(inputString, res1);
        Collections.sort(res1);
        var res2 =  new ArrayList<String>();
        generateAllSubstrings.generateSubStringsUsingRecursion(inputString, 0, res2);
        Collections.sort(res2);

        var res3 =  new ArrayList<String>();
        generateAllSubstrings.generateSubStringsUsingRecursion1(inputString, "", 0, res3);
        Collections.sort(res3);
        List<String> expected = expected();
        assertEquals(expected, res);
        assertEquals(expected, res1);
        assertEquals(expected, res2);
        assertEquals(expected, res3);
    }

    private static List<String> expected() {
        return Arrays.stream("A, AB, ABC, ABCD, B, BC, BCD, C, CD, D".split(","))
            .map(e -> e.replace(" ",""))
            .sorted()
            .toList();
    }
}
