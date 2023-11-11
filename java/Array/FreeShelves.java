import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

public class FreeShelves {
    public static int solution(int[] A, int R){

        for(int i=0; i< A.length; i++){
            Set<Integer> remove = new HashSet<Integer>();
            int check = i;
            
            while(check < R){
                remove.add(check);
                check++;
            }

            

        }
        return 1;
    }

    public static int findIndexWithMostUniqueValues(int[] A, int R) {
        int n = A.length;
        HashMap<Integer, Integer> frequency = new HashMap<>();
        int uniqueCount = 0;

        // Initialize frequency for first window
        for (int i = 0; i < R; i++) {
            int element = A[i];
            frequency.put(element, frequency.getOrDefault(element, 0) + 1);
            if (frequency.get(element) == 1) {
                uniqueCount++;
            }
        }

        int maxUniqueCount = uniqueCount;
        int resultIndex = 0;

        for (int i = R; i < n; i++) {
            int removedElement = A[i - R];
            int addedElement = A[i];

            frequency.put(removedElement, frequency.get(removedElement) - 1);
            if (frequency.get(removedElement) == 0) {
                uniqueCount--;
            }

            frequency.put(addedElement, frequency.getOrDefault(addedElement, 0) + 1);
            if (frequency.get(addedElement) == 1) {
                uniqueCount++;
            }

            if (uniqueCount > maxUniqueCount) {
                maxUniqueCount = uniqueCount;
                resultIndex = i - R + 1;
            }
        }

        return resultIndex;
    }

    public static List<Integer> findIndicesToRemove(int[] arr, int R) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int maxUniqueCount = 0;
        int start = 0;

        for (int i = 0; i < arr.length; i++) {
            // Update frequency map
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);

            // Update maxUniqueCount if necessary
            if (frequencyMap.size() > maxUniqueCount) {
                maxUniqueCount = frequencyMap.size();
                start = i - R + 1;
            }

            // Slide the window
            if (i >= R - 1) {
                int removedElement = arr[i - R + 1];
                int frequency = frequencyMap.get(removedElement);
                if (frequency == 1) {
                    frequencyMap.remove(removedElement);
                } else {
                    frequencyMap.put(removedElement, frequency - 1);
                }
            }
        }

        List<Integer> indicesToRemove = new ArrayList<>();
        for (int i = start; i < start + R; i++) {
            indicesToRemove.add(i);
        }

        return indicesToRemove;
    }

    public static int findOptimalShelf(int[] shelves, int R) {
        HashMap<Integer, Integer> productFrequency = new HashMap<>();
        int maxUniqueCount = 0;
        int start = 0;

        for (int i = 0; i < shelves.length; i++) {
            // Update frequency map
            productFrequency.put(shelves[i], productFrequency.getOrDefault(shelves[i], 0) + 1);

            // Update maxUniqueCount if necessary
            if (productFrequency.size() > maxUniqueCount) {
                maxUniqueCount = productFrequency.size();
                start = i - R + 1;
            }

            // Slide the window
            if (i >= R - 1) {
                int removedShelf = shelves[i - R + 1];
                int frequency = productFrequency.get(removedShelf);
                if (frequency == 1) {
                    productFrequency.remove(removedShelf);
                } else {
                    productFrequency.put(removedShelf, frequency - 1);
                }
            }
        }

        return start;
    }

    public static int findOptimalShelf2(int[] shelves, int R) {
        HashMap<Integer, Integer> productFrequency = new HashMap<>();
        int maxUniqueCount = 0;
        int start = 0;

        for (int i = 0; i < shelves.length; i++) {
            // Update frequency map
            int currentShelf = shelves[i];
            productFrequency.put(currentShelf, productFrequency.getOrDefault(currentShelf, 0) + 1);

            // Slide the window
            if (i >= R - 1) {
                // Check unique product count
                int uniqueCount = productFrequency.size();
                if (uniqueCount > maxUniqueCount) {
                    maxUniqueCount = uniqueCount;
                    start = i - R + 1;
                }

                // Remove the leftmost shelf from the window
                int removedShelf = shelves[i - R + 1];
                int frequency = productFrequency.get(removedShelf);
                if (frequency == 1) {
                    productFrequency.remove(removedShelf);
                } else {
                    productFrequency.put(removedShelf, frequency - 1);
                }
            }
        }

        return start;
    }

    public static int findOptimalShelf3(int[] shelves, int R) {
        HashMap<Integer, Integer> productFrequency = new HashMap<>();
        int maxUniqueCount = 0;
        int start = 0;

        for (int i = 0; i < shelves.length; i++) {
            // Update frequency map
            int currentShelf = shelves[i];
            productFrequency.put(currentShelf, productFrequency.getOrDefault(currentShelf, 0) + 1);

            // Slide the window
            if (i >= R - 1) {
                // Check unique product count
                int uniqueCount = productFrequency.size();
                if (uniqueCount > maxUniqueCount) {
                    maxUniqueCount = uniqueCount;
                    start = i - R + 1;
                }

                // Remove the leftmost shelf from the window
                int removedShelf = shelves[i - R + 1];
                int frequency = productFrequency.get(removedShelf);
                if (frequency == 1) {
                    productFrequency.remove(removedShelf);
                } else {
                    productFrequency.put(removedShelf, frequency - 1);
                }
            }
        }

        return start;
    }

        public static int freeRShelves(int[] shelves, int R) {
            if(shelves.length < R) return 0;
            System.out.println("shelves " + Arrays.toString(shelves));
            // count product type of each position
            Map<Integer, Set<Integer>> countProd = new HashMap<Integer,Set<Integer>>();
            Map<Integer, Set<Integer>> countProdR = new HashMap<Integer,Set<Integer>>();

            int[] leftProds = new int[shelves.length];
            int[] rightProd = new int[shelves.length];

            // leftProds[0] = 1;
            // rightProd[0] = 1;
            for(int i=1; i < shelves.length ;i++){
                Set<Integer> shCount = new HashSet<>();
                if(countProd.containsKey(i-1)){
                    /** COPY to new Set instead of using pointer */
                    shCount = new HashSet<>(countProd.get(i-1));
                }
                if(!shCount.contains(shelves[i-1])){
                    leftProds[i] = shCount.size() + 1;
                    shCount.add(shelves[i-1]);
                }else{
                    leftProds[i] = shCount.size();
                }
                // System.out.println("i " + i);
                // System.out.println("shCount " + shCount);
                countProd.put(i, shCount);
                
            }

            // System.out.println("countProd " + countProd);
            // System.out.println("leftProds " + Arrays.toString(leftProds));

            // {1, 2, 2, 3, 4, 4, 4, 5, 6, 6, 6, 6};
            for(int j=shelves.length-2; j >= shelves.length-(shelves.length-R); j--){
                Set<Integer> shCount = new HashSet<>();
                if(countProdR.containsKey(j+1)){
                    /** COPY to new Set instead of using pointer */
                    shCount = new HashSet<>(countProdR.get(j+1));
                }
                Set<Integer> leftCount = countProd.getOrDefault(j-(R-1), new HashSet<>());
                if(!leftCount.contains(shelves[j+1]) && !shCount.contains(shelves[j+1])){
                    rightProd[j] = rightProd[j+1] + 1;
                    shCount.add(shelves[j+1]);
                }else{
                    rightProd[j] = rightProd[j+1];
                }

                countProdR.put(j, shCount);
            }
            // System.out.println("countProd " + countProd);
            // System.out.println("rightProd " + Arrays.toString(rightProd));

            int countProdLeft = 0;
            int indx = 0;
            for(int i=0; i< leftProds.length-R+1 ; i++){
                if(leftProds[i] + rightProd[i+(R-1)] > countProdLeft){
                    countProdLeft = leftProds[i] + rightProd[i+(R-1)];
                    indx = i;
                }
                // System.out.println("--- "  + indx);
            }

            return indx;
        }

    public static void main(String[] args){
        int[] intArrayB = new int[]{ 1, 2, 3, 2, 1, 2 }; 
        System.out.println(freeRShelves(intArrayB, 3));
        // System.out.println(solution(intArrayA));
        // System.out.println(solution(""));
        int[] shelves = {1, 2, 2, 3, 4, 4, 4, 5, 6, 6, 6, 6};
        int R = 3;
        int optimalShelf = freeRShelves(shelves, R);

        System.out.println("Optimal Shelf: " + optimalShelf);

        int[] intArrayC = new int[]{ 9, 8 ,2, -1, -1, -1, 5, 7, 8, 8, 8, 8, 8, 8, 9 }; 
        System.out.println(freeRShelves(intArrayC, 8));

    }
}