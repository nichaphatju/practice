package exercise;
public class ThreeLetters {
    
    /*
     *  Given number of letter a and b, return a string which contains A letters "a" and B letters "b"
     * with no three consecutive letters being the same
     * 
     */

    public static String solution(int A, int B){
        String result = "";
        if(A > B || B > A){
            if( A > B){
                if(A > 1){
                    result += "aa";
                    A-=2;
                }else{
                    result += "a";
                    A--;
                }
            }else{
                if(B > 1){
                    result += "bb";
                    B-=2;
                }else{
                    result += "b";
                    B--;
                }
            }
            while(A > 0 || B > 0){
                if(result.endsWith("a") && B > 0){
                    if(B > A && B > 1){
                        result += "bb";
                        B-=2;
                    }else{
                        result += "b";
                        B--;
                    }
                    
                }else if(result.endsWith("b") && A > 0){
                    if(A > B && A > 1){
                        result += "aa";
                        A-=2;
                    }else{
                        result += "a";
                        A--;
                    }
                    
                }else{
                    break;
                }
            }
        }else if(A == B && A > 0){
            result += "a";
            A--;
            while(A > 0 || B > 0){
                if(result.endsWith("a") && B > 0){
                    if(B > A && B > 1){
                        result += "bb";
                        B-=2;
                    }else{
                        result += "b";
                        B--;
                    }
                }else if(result.endsWith("b") && A > 0){
                    result += "a";
                    A--;
                }else{
                    break;
                }
            }
        }
        

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(0, 0));
    }
}
