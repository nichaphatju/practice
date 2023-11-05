import java.util.Scanner;

public class ReversString {
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        /* Enter your code here. Print output to STDOUT. */
        
        if(A.length() == 0){
            System.out.println("No");
        }
        
        String rvA = String.valueOf(getReverseString(0, A, new char[A.length()]));
        //System.out.print(rvA);
        
        if(rvA.equals(A)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
        
        
        
    }
    
    public static char[] getReverseString(int ind, String A, char[] rvStr){
        int mid = (int) Math.floor(A.length()/2);
        
        if(ind < mid){
            rvStr[ind] = A.charAt(A.length()-ind-1);
            rvStr[A.length()-ind-1] = A.charAt(ind);
            return getReverseString(ind +1, A, rvStr);
        }
        
        if(A.length()%2 != 0){
            rvStr[mid] = A.charAt(mid);
        }
        return rvStr;
    }
}
