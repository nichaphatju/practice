import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayListJava {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int line = in.nextInt();
        in.nextLine();
        List<List<Integer>> lst = new ArrayList<List<Integer>>();
        int ln = 0;
        while(ln < line){
            String numbers = in.nextLine();
            String[] numsplit = numbers.split(" ");
            
            List<Integer> nums = new ArrayList<Integer>();
            if(numsplit.length > 0){
                try {
                    for(int ind =1 ; ind < numsplit.length ; ind++){
                        String n  = numsplit[ind];
                        if(n != "" && n != null ) nums.add(Integer.parseInt(n));
                    }
                    lst.add(ln, nums);
                }catch(Exception ex){}
                
            }else{
                lst.add(ln, nums);
            }
            ln++;
        }
        int X = in.nextInt();
        for(int i=0; i< X; i++){
            try{
                int arrNo = in.nextInt();
                //System.out.println("iarrNo " + Arrays.deepToString(lst.get(arrNo).toArray()));
                int arrInd = in.nextInt();
                //System.out.println("arrInd " + arrInd);
                Integer numGet = lst.get(arrNo-1).get(arrInd-1);
                System.out.println(numGet);
            }catch(Exception ex){
                System.out.println("ERROR!");
            }
            
        }
        in.close();
        
    }
}
