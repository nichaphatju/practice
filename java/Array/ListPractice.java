import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListPractice {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String lstStr = in.nextLine();
        List<Integer> lst = new ArrayList<Integer>();
        for(String s: lstStr.split(" ")){
            try{
                lst.add(Integer.parseInt(s));
            }catch(Exception ex){
                continue;
            }
        }
        //System.out.println(Arrays.toString(lst.toArray()));
        int q = Integer.parseInt(in.nextLine());
        //System.out.println(q);
        for(int i=0; i< q ; i++){
            String cmd = in.nextLine();
            String ind = in.nextLine();
            //System.out.println(cmd);
            //System.out.println(ind);
            if("Insert".equals(cmd)){
                int indAdd =Integer.parseInt(ind.split(" ")[0]);
                int valAdd =Integer.parseInt(ind.split(" ")[1]);
                if(indAdd > lst.size()-1){
                    lst.add(valAdd);
                }else{
                    lst.add(indAdd, valAdd);
                }
            }else if("Delete".equals(cmd)){
                lst.remove(Integer.parseInt(ind.split(" ")[0]));
            }
        }
        String l = lst.toString();
        //System.out.println(lst.toString());
        System.out.println(l
                  .substring(1, l.length() - 1)
                  .replaceAll(", ", " "));
    }
}
