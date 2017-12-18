package client;

import java.io.*;

import java.util.*;

import java.text.*;

import java.math.*;

import java.util.regex.*;
/* 
This class has got two solutions one using reqular expression and split etc...
First solution using numberNeeded function is effective for String that are longer
Second solution is effective for shorter Strings.  numberNeeded1 function 
is written without any libraries with O(n) solution.

*/
public class Anagram {
    public static int countSubstring(String subStr, String str) {
        // the result of split() will contain one more element than the delimiter
        // the "-1" second argument makes it not discard trailing empty strings
        return str.split(Pattern.quote(subStr), -1).length ;
    }

    
    public static int numberNeeded(String first, String second) {
        int result = 0;
        for (int i = 97; i < 124; i++) {
            result += Math.abs(countSubstring(((char)i + ""), first) - countSubstring(((char)i + ""), second));
        }
        return result;
    }
    
        public static int numberNeeded1(String first, String second) {
        int[] asciiArr= new int[26];
        int noOfCharToRemove=0, minLength, maxLength;
        String longString ;
        
        if(first.length()<second.length()){
            minLength = first.length();
            maxLength = second.length();
            longString = second;
        }
        else{
            maxLength = first.length();
            minLength = second.length();
            longString = first;
        }

        for(int i=0;i<minLength;i++){
            asciiArr[first.charAt(i)-97]++;
            asciiArr[second.charAt(i)-97]--;
        }
        for(int i=0;i<maxLength-minLength;i++){
            asciiArr[longString.charAt(minLength+i)-97]--;
        }              
        for(int i=0;i<26;i++){
            if(asciiArr[i]!=0) noOfCharToRemove+= Math.abs(asciiArr[i]);
        }
        return  noOfCharToRemove;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = "fcrxzwscanmligyxyvym";
        String b = "jxwtrhvujlmrpdoqbisbwhmgpmeoke";
        System.out.println(a.split(Pattern.quote("d"),-1)[0]);
        System.out.println(countSubstring("abc",a));
        System.out.println(numberNeeded(a, b));
        System.out.println(numberNeeded1(a, b));
    }
}
