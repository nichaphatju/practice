import java.util.Scanner;

public class Array {
    public static void main(String[] args) {
	   
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        int ind=0;
        while(ind<n){
            //System.out.println(scan.nextInt());
            a[ind] = scan.nextInt();
            ind++;
        }
        
        
        
        scan.close();

        // Prints each sequential element in array a
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
