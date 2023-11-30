package exercise;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SocksLaundering {

    public static int solution(int K, int[] C, int[] D) {
        // 100% - Performance not assessed
        // Implement your solution here
        int countPairs = 0;
        Set<Integer> cleanSocks = new HashSet<Integer>();

        // cases
        // clean sock left
        // dirty socks more

        List<Integer> dirtySocks = new ArrayList<Integer>();

        for(int i=0; i<C.length; i++){
            if(cleanSocks.contains(C[i])){
                countPairs++;
                cleanSocks.remove(C[i]);
            }else{
                cleanSocks.add(C[i]);
            }
        }

        for(int i=0; i< D.length; i++){
            if(K > 0 && cleanSocks.contains(D[i])){
                countPairs++;
                cleanSocks.remove(D[i]);
                K--;
            }else{
                dirtySocks.add(D[i]);
            }
        }

        //System.out.println(dirtySocks);

        if(K > 0){
            Collections.sort(dirtySocks);
            int tmp = -1;
            for(int i=0; i< dirtySocks.size(); i++){
                if(K == 0) break;
                int ds = dirtySocks.get(i);

                if(tmp == ds && K > 1){
                    countPairs++;
                    tmp = -1;
                    K-=2;
                }else{
                    tmp = ds;
                }
                
            }
        }

        return countPairs;
    }


    public static void main(String[] args) {

        System.out.println(solution(5, new int[]{1,1,2}, new int[]{2,2,3}));
        System.out.println(solution(2, new int[]{1}, new int[]{3,2,5,5}));
        System.out.println(solution(3, new int[]{1,2}, new int[]{8,8,8,8,9}));

    }
}