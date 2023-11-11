import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Pair2Nums {
    public static int solution(int[] A) {

        // char[] digits1 = number.toCharArray();

        int pairCount = 0;
        
        Map<Character, List<Integer>> mapnum = new HashMap<Character, List<Integer>>();
        for(int i=0; i<A.length ; i++){
            Character firstChar = String.valueOf(A[i]).charAt(0);
            if(mapnum.containsKey(firstChar)){
                List<Integer> chs = mapnum.get(firstChar);
                chs.add(A[i]);
                mapnum.put(firstChar ,chs);
                
            }else{
                mapnum.put(firstChar,  new ArrayList<Integer>(Arrays.asList(A[i])));
            }
        }
        for(int i=0; i<A.length ; i++){
            String chStr = String.valueOf(A[i]);
            Character lastChar = chStr.charAt(chStr.length()-1);
            if(mapnum.containsKey(lastChar)) pairCount = pairCount + mapnum.get(lastChar).size();
        }
        return pairCount;

    }

    public static void main(String[] args){
        int[] intArrayA = new int[]{ 122, 21 , 23 ,19 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        System.out.println(solution(intArrayA));
        // System.out.println(solution(""));

    }
}
