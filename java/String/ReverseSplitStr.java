import java.util.Arrays;

public class ReverseSplitStr {
    
    public static String solution(String S){
        
        char[] rvs = new char[S.length()];
        for(int i=0; i< S.length()/2; i++){
            rvs[i] = S.charAt(S.length()-1-i);
            rvs[S.length()-i-1] = S.charAt(i);
        }

        //System.out.println(Arrays.toString(rvs));

        String result = "";
        String tmpResult = "";
        for(int i=0; i<rvs.length; i++){
            tmpResult += rvs[i];
            if(rvs[i] == ' '){
                result = tmpResult + result;
                tmpResult = "";
            }else if(i == rvs.length-1){
                result = tmpResult + " " + result;
            }
            
        }

        return result;

    }

    public static String solution2(String S){
        
        String result = "";
        String tmpStr = "";
        for(int i=0; i< S.length(); i++){
            if(S.charAt(i) == ' '){
                result = result.length() > 0 ? result + " " +  tmpStr :  result +  tmpStr;
                tmpStr = "";
            }else if(i == S.length()-1){
                tmpStr = S.charAt(i) + tmpStr;
                result = result.length() > 0 ? result + " " +  tmpStr :  result +  tmpStr;
            }else{
                tmpStr = S.charAt(i) + tmpStr;
            }
            
        }

        //System.out.println(Arrays.toString(rvs));

        return result;

    }

    public static void main(String[] args){
        System.out.println(solution2("we test coders"));
    }
}
