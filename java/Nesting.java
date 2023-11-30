import java.util.Stack;

public class Nesting {

    /**
     * 
     * @param S contains ( or )
     * @return 1 if nested, else 0
     * 
     */

    public static int solution(String S){
        // Implement your solution here
        Stack<Character> st = new Stack<Character>();
        for(int i=0;i <S.length(); i++){
            if(st.isEmpty()){
                if(S.charAt(i) == '('){
                    st.push(S.charAt(i));
                }else{
                    return 0;
                }
            }else{
                if(st.peek() == '(' && S.charAt(i) == ')'){
                    st.pop();
                }else if(S.charAt(i) == '('){
                    st.push(S.charAt(i));
                }else{
                    return 0;
                }
            }
        }
        if(st.isEmpty()){
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("()()()"));
    }
}
