package Redo;

public class FindPalindrome {

    /**
     * 
     * 
     * @param S
     * @return any palindrome which can be obtain by replacing all question masks, return NO if no palindrome can be obtained
     * 
     * 
     */

    public static String solution(String S){

        Boolean isOdd = S.length()%2 != 0;
        int mid = isOdd ? (int) Math.ceil(S.length()/2) : S.length()/2;
        
        String firstHalf = "";
        String secondHalf = "";

        // Use 2 pointers
        
        for(int i=0, j=S.length()-1; i<mid && j>=mid; i++, j--){
            if(S.charAt(i) != '?' && S.charAt(j) != '?'){
                if(S.charAt(i) == S.charAt(j)){
                    firstHalf += S.charAt(i);
                    secondHalf = S.charAt(i) + secondHalf;
                }else{
                    return "NO";
                }
            }else if(S.charAt(i) == '?' && S.charAt(j) != '?'){
                firstHalf += S.charAt(j);
                secondHalf = S.charAt(j) + secondHalf;
            }else if(S.charAt(i) != '?' && S.charAt(j) == '?'){
                firstHalf += S.charAt(i);
                secondHalf = S.charAt(i) + secondHalf;
            }else{
                firstHalf += 'x';
                secondHalf = 'x' + secondHalf;
            }
        }

        if(isOdd){
            firstHalf += S.charAt(mid-1);
        }

        return firstHalf+secondHalf;


    }

    public static void main(String[] args) {
        System.out.println(solution("k?y??"));
        System.out.println(solution("?ab??a"));
        System.out.println(solution("bab??a"));
        System.out.println(solution("?a?"));
    }
}
