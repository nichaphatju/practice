import java.util.ArrayList;

public class ABOrder {
    public static int solution(String T){
        int sizeOfA = 0;
        int sizeOfB = 0;
        
        if(T.charAt(0) == 'A'){
            sizeOfA +=1;
        }else{
            sizeOfB += 1;
        }
        ArrayList<Integer> AafterB = new ArrayList<Integer>();
        ArrayList<Integer> BBeforeA = new ArrayList<Integer>();
        for(int i=1; i< T.length(); i++){
            System.out.println(T + " " + T.length() +" char at "+ i + " = " + T.charAt(i));
            if(T.charAt(i) == 'A' && T.charAt(i-1) == 'B'){
                AafterB.add(i);
                BBeforeA.add(i-1);
            }
            if(T.charAt(i) == 'A'){
                sizeOfA++;
            }else if(T.charAt(i) == 'B'){
                sizeOfB++;
            }
        }

        if(sizeOfA >= sizeOfB){
            int toRemoveB = 0;
            for(int i=0; i< BBeforeA.size(); i++){
                Integer st = BBeforeA.get(i);
                while(st >= 0 && T.charAt(st) == 'B'){
                    toRemoveB++;
                    st--;
                }
                
                
            }
            return toRemoveB;
        }
        return AafterB.size();
    }

    public static void main(String[] args){
        // int[] intArrayA = new int[]{ 4, 3, 2, 1, 5 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        System.out.println("Result BAAABAB " +solution("BAAABAB"));
        System.out.println("Result BBA " +solution("BBA"));
        System.out.println("Result BBABA " +solution("BBABA"));
        System.out.println("Result AAABAABB " +solution("AAABAABB"));
        System.out.println("Result AABBAA " +solution("AABBAA"));


    }
}
