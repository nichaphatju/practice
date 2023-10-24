public class Palindrome {

    public static void main(String[] args){
        System.out.println(solution("?ab??a"));
        System.out.println(solution("bab??a"));
        System.out.println(solution("?a?"));
        System.out.println(solution("???aaaa"));
        System.out.println(solution("k?yak"));
    }

    public static String solution(String T) {
        System.out.println("----->> Input " + T);
        String firstpart = "";
        String secondpart = "";
        String midpart = "";
        int mid = (int) Math.floor(T.length()/2);
        if(T.length() % 2 == 0){
            firstpart = T.substring(0, T.length()/2);
            secondpart = T.substring(T.length()/2, T.length());
        }else{
            
            firstpart = T.substring(0, mid);
            secondpart = T.substring(mid+1, T.length());
            midpart = T.substring(mid,mid+1);
        }
        String rvSecondpart = reverse(secondpart);
        // console.log(' firstpart ', firstpart);
        // console.log(' secondpart ', secondpart);
        // console.log(' rv secondpart ', rvSecondpart);
        // console.log(' midpart ', midpart);
    
        String result = "";
        
        for(int i=0; i<firstpart.length();i++){
            Character fChar = firstpart.charAt(i);
            Character sChar = rvSecondpart.charAt(i);
            // console.log(fChar + sChar)
            if(fChar != '?' && sChar != '?' && fChar != sChar){
                return "NO";
            }else if(fChar == '?' && sChar != '?'){
                result += sChar;
            }else if(fChar != '?' && sChar == '?'){
                result += fChar;
            }else if(fChar == '?' && sChar == '?'){
                result += 'a';
            }else{
                result += fChar;
            }
        }
        result += midpart;
        if(result.length() > 0){
            for(int i=result.length()-2; i>=0;i--){
                result += result.charAt(i);
            }
        }
        // console.log(result);
        return result;
    }
    
    public static String reverse(String  str){
        String newStr = "";
        for(int i=str.length()-1; i >= 0 ; i--){
            newStr += str.charAt(i);
        }
        return newStr;
    }
    
    
}
