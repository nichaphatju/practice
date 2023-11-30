package lessons.greedy;
public class TieRopes{
    public int solution(int K, int[] A) {
        // Implement your solution here

        int countRopes = 0;
        int tmpSum = 0;

        for(int i=0; i< A.length; i++){
            tmpSum = tmpSum + A[i];
            if(tmpSum >= K){
                countRopes++;
                tmpSum = 0;
            }
        }

        return countRopes;

    }
}