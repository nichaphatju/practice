package lessons.iterations;
public class BinaryGap {

    public static int solution1(int N){
        String binaryN = Integer.toBinaryString(N);
        System.out.println(binaryN);
        if(binaryN.length() <= 2){
            return 0;
        }
        int first1 = 0;
        char[] binChars = binaryN.toCharArray();
        int countFirst1 = binChars.length-1;
        for(int i=0; i<binChars.length; i++){
            if(binChars[i] == '1'){
                first1 = countFirst1;
                break;
            }
            countFirst1--;
        }
        return searchGap(first1, N, 0, 0);
    }

    public static int searchGap(int digit, int N, int gap, int maxGap){
        System.out.println("maxGapn --> " +maxGap);
        if(N > 0 && digit >= 0){
            int cal = (int) Math.pow(2, digit);
            System.out.println("digit " +digit);
            System.out.println("cal " +cal);
            if(N >= cal){
                // 1
                N = N - cal;
                maxGap = Math.max(gap, maxGap);
                
                gap = 0;
                return searchGap(digit-1, N, gap, maxGap);
            }else{
                // 0
                gap++;
                return searchGap(digit-1, N, gap, maxGap);
            }
        }
        System.out.println("maxGapn --> " +maxGap);
        return maxGap;

    }


    public static int solution2(int N) {
        // write your code in Java SE 8
        
        int max_gap = 0;
        int current_gap =0;
        boolean counting = false; 
        
        // Using the "concept of bit manipulation" and "& operation"
        
        while( N !=0 ){
        
            if(counting == false){    // for the first "1"   
                if( (N&1) == 1){      // note: cannot use n&1 without "()" -> if N&1 = 1 means current binary digit is 1
                    counting = true;  // found first 1 -> start to count
                }
            }
            else{                    // counting = true
                if( (N&1) == 0){      // note: cannot use n&1 without "()" -> if N&1 = 1 means current binary digit is 0
                    current_gap ++;  
                }
                else{ // N & 1 == 1     // found the next 1
                    max_gap = Math.max(max_gap, current_gap);
                    current_gap = 0; // reset counting
                }
            }
            
            N = N >> 1; // shift by one (shift to right side) 
                        // note: cannot just write "N >> 1"
        }
        
        return max_gap;
    }

    public static void main(String[] args){
        // int[] intArrayA = new int[]{ 3, 4, 3, 2, 3, -1, 3, 3 }; 
        // int[] intArrayB = new int[]{ 1, 1, 0, 0, 0 }; 
        // System.out.println(solution(intArrayA, intArrayB));
        System.out.println(solution1(10));
        // System.out.println(solution(""));

    }
}
