// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public String solution(String S) {
        // Implement your solution here
        Boolean foundMatch = true;
        while (foundMatch){
            if(S.indexOf("AA") >= 0){
                S = S.replace("AA","");
            }else if(S.indexOf("BB")  >= 0){
                S = S.replace("BB","");
            }else if(S.indexOf("CC")  >= 0){
                S = S.replace("CC","");
            }else{
                foundMatch = false;
            }
        }
        return S;
    }
}
