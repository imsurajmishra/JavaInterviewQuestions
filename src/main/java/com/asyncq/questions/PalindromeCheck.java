package com.asyncq.questions;

public class PalindromeCheck {

    public boolean validate(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
               return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean validateRec(String s, int left, int right){
       if(left>=right){
           return true;
       }

       if(s.charAt(left)!=s.charAt(right)){
           return false;
       }

       return validateRec(s, left+1, right-1);
    }
}
