package exercise;

public class ParityDegree {
    public int solution(int N) {
        // Implement your solution here
        int maxNDivisible = (int)Math.ceil(Math.sqrt(N));
        int result = 0;
        for(int i=1; i<=maxNDivisible; i++){
            double pw2 = Math.pow(2, i);
            if(N%pw2 == 0){
                result = i;
            }
        }

        return result;

    }
}
