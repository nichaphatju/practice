import java.util.ArrayList;

public class ABOrder {
    public static int solution(String T){
        int sizeOfA = 0;
        int sizeOfB = 0;
        int countB = 0;
        if(T.charAt(0) == 'A'){
            sizeOfA +=1;
        }else{
            sizeOfB += 1;
            countB +=1;
        }
        ArrayList<Integer> AafterB = new ArrayList<Integer>();
        ArrayList<Integer> BBeforeA = new ArrayList<Integer>();
        int countBDelete = 0;
        
        for(int i=1; i< T.length(); i++){
            //System.out.println(T + " " + T.length() +" char at "+ i + " = " + T.charAt(i));
            if(T.charAt(i) == 'A' && T.charAt(i-1) == 'B'){
                AafterB.add(i);
                BBeforeA.add(i-1);
            }
            if(T.charAt(i) == 'A'){
                sizeOfA++;
                countBDelete += countB;
                countB = 0;
            }else if(T.charAt(i) == 'B'){
                sizeOfB++;
                countB++;
            }
        }
        //System.out.println(" countBDelete " + countBDelete);
        if(sizeOfA >= sizeOfB){
            // int toRemoveB = 0;
            // for(int i=0; i< BBeforeA.size(); i++){
            //     Integer st = BBeforeA.get(i);
            //     while(st >= 0 && T.charAt(st) == 'B'){
            //         toRemoveB++;
            //         st--;
            //     }
                
                
            // }
            return countBDelete;
        }
        return AafterB.size();
    }

    public static int solutionRefactor(String T){
        int countA = 0, countAafterB = 0;
        int countB = 0, tmpB = 0, countDelB = 0;
        for(int i=0; i< T.length(); i++){
            if(T.charAt(i) == 'B'){
                countB++;
                tmpB++;
            }else{
                countA++;
                if(tmpB > 0){
                    countAafterB++;
                }
                countDelB += tmpB;
                tmpB = 0;
            }
            
        }
        return countA < countB ? countAafterB : countDelB;
    }

    public static int solution2(String T){
        int countB = 0;
        int deletions = 0;
        for(int i=0; i< T.length(); i++){
            if(T.charAt(i) == 'B'){
                countB++;
            }else{
                /** Now countB = all B before A */
                // If A -> check deletions +1 and B
                /** 
                 *  Now countB is B found before A (since this is A)
                 *  Deletions stores what to delete
                 *  deletion is 0 if there's no B before
                 *  1 is current A -> what is less between delete B and current deletion plus A
                 */
                deletions = Math.min(deletions +1, countB);
            }
        }
        return deletions;
    }

    public static void main(String[] args){
        // int[] intArrayA = new int[]{ 4, 3, 2, 1, 5 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        // System.out.println("Result BAAABAB " +solution2("BAAABAB"));
        // System.out.println("Result BBA " +solution2("BBA"));
        // System.out.println("Result BBABA " +solution2("BBABA"));
        // System.out.println("Result AAABAABB " +solution2("AAABAABB"));
        // System.out.println("Result AABBAA " +solution2("AABBAA"));
        // System.out.println("Result BBABAA " +solution2("BBABAA"));


        System.out.println("Result BAAABAB " +solutionRefactor("BAAABAB"));
        System.out.println("Result BBA " +solutionRefactor("BBA"));
        System.out.println("Result BBABA " +solutionRefactor("BBABA"));
        System.out.println("Result AAABAABB " +solutionRefactor("AAABAABB"));
        System.out.println("Result AABBAA " +solutionRefactor("AABBAA"));
        System.out.println("Result BBABAA " +solutionRefactor("BBABAA"));


    }
}
