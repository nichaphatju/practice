package lessons.primeandcompositenumbers;

public class ReversingCoin {
    

    public static void main(String[] args) {
        int coinNum = 10;

        // All coins are in the same side
        // A person flip the coins with numbers that are multiples of i -> i,2i,3i,...
        // count the number of coins that are reversed

        // O(n log n)
        int result = 0;
        int[] coins = new int[coinNum+1];

        for(int i=1; i<= coinNum; i++){
            int k = i;
            while(k <= coinNum){
                coins[k] = (coins[k] + 1)%2;
                k+=i;
            }
            result += coins[i];
        }

        System.out.println(result);
    }
}
