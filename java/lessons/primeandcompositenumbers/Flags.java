package lessons.primeandcompositenumbers;
import java.util.ArrayList;
import java.util.List;

public class Flags {

    /*
     * Peak is where A[i] is higher than A[i-1] and A[i+1]
     * Find the maximum number of flags which can be placed on the peaks
     * The distance between flags have to be greater than or equal to the number of flags placed on the peaks
     * 
     */
    
    public int solution(int[] A) {
        // Implement your solution here
        List<Integer> peaks = new ArrayList<Integer>();

        // Find peaks
        for(int i=1; i< A.length-1; i++){
            if(A[i-1] < A[i] && A[i] > A[i+1]){
                peaks.add(i);
            }
        }

        if(peaks.size() <= 1){
            return peaks.size();
        }

        
        

        int maxFlag = (int)Math.ceil(Math.sqrt(peaks.get(peaks.size()-1)-peaks.get(0)));
        // max possible flags 

        // attempt max flags first, if not possible then reduce
        for(int flags=maxFlag; flags>1; flags--){

            int flgCheck1 = 0;
            int flgCheck2 = peaks.size()-1;

            int startFlag = peaks.get(flgCheck1);
            int endFlag = peaks.get(flgCheck2);

            int flagPlaced = 2;

            // try putting 2 flags first then moving these 2 flags closing to each other
            while(flgCheck1 < flgCheck2){
                
                // first flag start from the beginning of the peaks then moving to the right
                flgCheck1++;
                // second flag start from the end of the peaks then moving to the left
                flgCheck2--;

                // try these 2 because we know that it's possible to place the flags on these both peaks because it's far from each other

                
                int tryPlaceFlagStart = peaks.get(flgCheck1);
                // start flag
                if(tryPlaceFlagStart >= flags+startFlag
                    && tryPlaceFlagStart <= endFlag-flags){
                    flagPlaced++;
                    startFlag = peaks.get(flgCheck1);
                    
                }

                int tryPlaceFlagEnd = peaks.get(flgCheck2);

                // end flag
                if(tryPlaceFlagEnd >= flags+startFlag
                    && tryPlaceFlagEnd <= endFlag - flags){
                    flagPlaced++;
                    endFlag = peaks.get(flgCheck2);
                    
                }

                // if we can place all attempted flags, then we got the answer
                if(flagPlaced == flags){
                    return flags;
                }

                // if flagPlaced != flags attempted, we try reduce flag attempt

                

            }
        }

        return 0;
    }

    public static void main(String[] args) {
        
    }
}
