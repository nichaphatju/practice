import java.util.Scanner;
import java.util.Stack;

public class StackPractice {
    public static void main(String []argh)
	{
		Scanner sc = new Scanner(System.in);
		
		while (sc.hasNext()) {
			String input=sc.nextLine();
            //System.out.println(input);
            //Complete the code\
            Stack<Character> st = new Stack<Character>();
            for(int i=0; i< input.length(); i++){
                char c = input.charAt(i);
                if(st.isEmpty()){
                    if(c == '(' || c == '{' || c == '[') st.push(c);
                    else  {
                        st.push(c);
                        break;
                    }
                        
                }else{
                    if(c == '(' || c == '{' || c == '[') st.push(c);
                    else
                    if(st.peek().equals('{') && c == '}'){
                        st.pop();
                    }else if(st.peek().equals('[') && c == ']'){
                        st.pop();
                    }else if(st.peek().equals('(') && c == ')'){
                        st.pop();
                    }else{
                        st.push(c);
                        break;
                    }
                }
            }
            
            if(st.isEmpty()){
                System.out.println(true);
            }else{
                System.out.println(false);
            }
            
		}
        
        
		
	}
}
