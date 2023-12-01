package lessons.leader;

import java.util.Arrays;

public class Leader {
    
    public static void goldenLeader(int[] A){

        //Arrays.sort(A);  // no need to sort if using golden leader O(n)

        int n = A.length;
        int size = 0;
        int value = -1;

        for(int i=0; i<A.length; i++){
            
            // if size = 0 means current value occur less than other numbers
            if(size == 0){
                // count this and keep it as a temp
                size++;
                value = A[i];
            }else{
                if(value != A[i]){
                    // found different value -> reduce occurance of this one
                    // example we have 6,6,6,4,4,4 -> current value=4,size=3 if we found 4 this time, reduce counting of 6 but it's still the most frequent. 
                    // then checking next one if we still see 4, reduce size
                    // if frequency of 4 = 3 -> means size = 0, and no one is the leader
                    size--;
                }else{
                    // if found same element value -> keep counting
                    size++;
                }
            }
        }

        

        int candidate = -1;
        if(size > 0){
            // value -> the left one will be the one with most occurances
            candidate = value;
        }
        int leader = -1;
        int count = 0;
        for(int i=0 ; i<A.length; i++){
            // check if candidate is a leader (occur more than n/2)
            if(A[i] == candidate){
                count++;
            }
            if(count > n/2){
                leader = candidate;
            }
        }

        System.out.println(leader);
    }

    public static void fastLeader(int[] A){
        // O(n log n)
        int n = A.length;
        int leader = -1;
        Arrays.sort(A);

        int candidate = A[n/2]; // Assuming leader is at the center point (sorted array) since it occurs more than n/2
        int count = 0;
        for(int i=0; i<A.length; i++){
            // to make sure the candidate occur more than half of the elements
            if(A[i] == candidate){
                count++;
            }
        }
        if(count > n/2){
            leader = candidate;
        }

        System.out.println(leader);

    }

    public static void main(String[] args) {
        int[] arr = new int[]{6,8,4,6,8,6,6};   // Leader is the number whose value occurs more than n/2 times
        goldenLeader(arr);
    }
}
