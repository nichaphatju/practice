import java.util.Stack;

public class RemoveAdjacentDuplicatesStr {
    public String removeDuplicates(String s) {
        Stack<Character> st = new Stack<Character>();
        String sResult = "";
        st.push(s.charAt(0));
        for(int i=1; i<s.length() ; i++){
            if(st.isEmpty()){
                st.push(s.charAt(i));
            }else{
                if(st.peek() == s.charAt(i)){
                    st.pop();
                }else{
                    st.push(s.charAt(i));
                }
            }
        }
        while(!st.isEmpty()){
            sResult = st.peek() + sResult;
            st.pop();
        }
        return sResult;
    }
}
