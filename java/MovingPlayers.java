import java.util.Stack;

public class MovingPlayers {



    public static int solution(String S){
        int count = 0;
        Stack<Character> st = new Stack<Character>();
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '>'){
                st.push('>');
                if(i == S.length()-1) count++;
            }else if(S.charAt(i) == '^' || S.charAt(i) == 'v'){
                if(!st.isEmpty()){
                    st.clear();
                }
                count++;
            }else{
                
                if(i==0){
                    count++;
                }else
                if(st.isEmpty()){
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(solution(">><<"));

        System.out.println(solution(">>^<"));
        System.out.println(solution("<>>^<"));

        System.out.println(solution("<<<<v<"));
        System.out.println(solution("<<><v<"));
    }
}
