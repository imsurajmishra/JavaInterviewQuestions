package com.asyncq.questions;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubstrings {

    public void generateSubStringsUsingRecursion(String inputString, int startPos, List<String> res){
        if(startPos>=inputString.length()){
            return;
        }

        for(int j=startPos; j<inputString.length();j++) {
            res.add(inputString.substring(startPos, j + 1));
        }

        generateSubStringsUsingRecursion(inputString,startPos+1, res);
    }

    public List<String> generateSubStringsUsingRecursion1(String inputString, String curr, int startPos, List<String> glRes){
        if(startPos>=inputString.length()){
            List<String> currList = new ArrayList<>();
            currList.add(curr);
            return currList;
        }

        List<String> subStringChars = generateSubStringsUsingRecursion1(inputString,"" + inputString.charAt(startPos), startPos + 1, glRes);

        List<String> result = new ArrayList<>();
        result.add(""+inputString.charAt(startPos));

        if(startPos<inputString.length()-1){
            for(String sub: subStringChars){
                result.add(""+inputString.charAt(startPos)+sub);
            }
        }

        glRes.addAll(result);
        return result;
    }

    public void generateSubStringsUsingForLoop(String inputString, List<String> res) {
        for(int i = 0; i< inputString.length(); i++){
            String s = "";
            for(int j = i+1; j<= inputString.length(); j++){
                s = inputString.substring(i, j);
                res.add(s);
            }
        }
    }

    public void generateSubStringsUsingForLoop1(String inputString, List<String> res) {
        for(int i = 0; i< inputString.length(); i++){
            String s = "";
            for(int j = i+1; j<= inputString.length(); j++){
                s += inputString.charAt(j-1);
                res.add(s);
            }
        }
    }
}
