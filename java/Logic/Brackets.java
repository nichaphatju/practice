import java.util.Stack;

public class Brackets {
    public static int solution(String S) {
        // Implement your solution here
        // 100%
        if(S.length() == 0) return 1;
        Stack<Character> brackets = new Stack<Character>();
        brackets.push(S.charAt(0));
        for(int i=1; i<S.length();i ++){
            if(!brackets.isEmpty()){
                Character latest = brackets.peek();
                if(S.charAt(i) == '(' || S.charAt(i) == '{' || S.charAt(i) == '['){
                    brackets.push(S.charAt(i));
                }else if(latest == '(' && S.charAt(i) == ')'){
                    brackets.pop();
                }else if(latest == '{' && S.charAt(i) == '}'){
                    brackets.pop();
                }else if(latest == '[' && S.charAt(i) == ']'){
                    brackets.pop();
                }else{
                    return 0;
                }
            }else{
                brackets.push(S.charAt(i));
            }
            
        }
        if(brackets.isEmpty()){
            return 1;
        }
        return 0;

    }

    public static int solution2(String S){
        // 100%
        // Implement your solution here
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i< S.length(); i++){
            Character ch = S.charAt(i);
            if(st.isEmpty()){
                if(ch == ')' || ch == '}' || ch == ']'){
                    return 0;
                }
                st.push(ch);
            }else{
                if(st.peek() == '(' && ch == ')'){
                    st.pop();
                }else if(st.peek() == '{' && ch == '}'){
                    st.pop();
                }else if(st.peek() == '[' && ch == ']'){
                    st.pop();
                }else if(ch == '(' || ch == '{' || ch == '['){
                    st.push(ch);
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
        // int[] intArrayA = new int[]{ 3, 4, 3, 2, 3, -1, 3, 3 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        System.out.println(solution(""));
        // System.out.println(solution(""));

    }
}
