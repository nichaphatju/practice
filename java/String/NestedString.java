import java.util.Stack;

public class NestedString {
    
    public static int solution(String S){
        if(S.length() == 0) return 1;

        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<S.length(); i++){
            if(st.isEmpty()){
                st.push(S.charAt(i));
            }else{
                
                if(st.peek() == '(' && S.charAt(i) == ')'){
                    st.pop();
                }else if(st.peek() == '{' && S.charAt(i) == '}'){
                    st.pop();
                }else if(st.peek() == '[' && S.charAt(i) == ']'){
                    st.pop();
                }else if(S.charAt(i) == '(' || S.charAt(i) == '{' || S.charAt(i) == '['){
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

    public static void main(String[] args){
        System.out.println(solution("{[()()]}"));
        System.out.println(solution("{[[)()]}"));
        System.out.println(solution("{[(])()]}"));
        System.out.println(solution("{[())()]}"));
    }
}
