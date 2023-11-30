package lessons.stacksandqueues;
import java.util.Stack;

public class Fish {

    /*
     * 
     * Count number of fish alive
     * 
     */

    public static int solution(int[] A, int[] B){
        // Implement your solution here
        int aliveFish = 0;
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0; i<A.length; i++){
            
            // downsteam fish in st
            if(B[i] == 1){
                st.push(A[i]);
            }else{
                if(st.isEmpty()){
                    aliveFish++;
                }else{
                    while(!st.isEmpty()){
                        if(st.peek() > A[i]){
                            // get eaten
                            break;
                        }else{
                            // eat it
                            st.pop();
                        }
                    }
                    // eat them all - i alive
                    if(st.isEmpty()){
                        aliveFish++;
                    }
                }
            }
        }

        return aliveFish + st.size();
    }

    public static void main(String[] args) {
        
    }
}
