//https://www.hackerrank.com/challenges/ctci-making-anagrams/copy-from/61876192
/* 
 * Determine the number of characters that must be deleted from two strings
 * for them to become anagrams of one another.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    public static int numberNeeded(String first, String second) {
        HashMap<Character, Integer> fm = new HashMap<Character, Integer>();
        int solution = 0;
        char c, b;
        for(int x = 0; x<first.length(); x++){
            c = first.charAt(x);
            if(fm.get(c)!=null){
                fm.put(c, fm.get(c)+1);
            } else {
                fm.put(c, 1);
            }
        }
        for(int y = 0; y<second.length(); y++){
            b = second.charAt(y);
            if(fm.get(b)!=null){
                fm.put(b, fm.get(b)-1);
                continue;
            }
            if(fm.get(b)==null){
                solution++;
            }
        }
        for(int i : fm.values()){
            solution+=Math.abs(i);
        }
        return solution;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
