import java.util.Stack;

public class DisappearingPairs {
    
    public static String solution(String S) {
        // 83%
        // Implement your solution here
        return remove(S);
    }

    public static String remove(String S){
        if(S.contains("AA")){
            S = S.replace("AA", "");
        }else if(S.contains("BB")){
            S = S.replace("BB", "");
        }else if(S.contains("CC")){
            S = S.replace("CC", "");
        }else{
            return S;
        }

        return remove(S);
    }

    public static String solution2(String S) {
        // Implement your solution here
        // 100%
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<S.length(); i++){
            if(st.isEmpty()){
                st.push(S.charAt(i));
            }else{
                if(st.peek() == S.charAt(i)){
                    st.pop();
                }else{
                    st.push(S.charAt(i));
                }
            }
        }
        
        String result = st.toString();
        result = result.replaceAll(",", "");
        result = result.replaceAll("\\[", "");
        result = result.replaceAll("\\]", "");
        result = result.replaceAll(" ", "");

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution2("ABCCAACBA"));
        System.out.println(solution2("ABCCBA"));
    }
}
