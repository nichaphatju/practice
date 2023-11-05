import java.util.Scanner;
import java.util.regex.Pattern;

public class PatternCheck {
    public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(in.hasNextLine()){
			String pattern = in.nextLine();
          	//Write your code
            try{
                Pattern.compile(pattern);
                System.out.println("Valid");
            }catch(Exception ex){
                System.out.println("Invalid");
            }
		}
	}
}
