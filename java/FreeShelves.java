import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public static void main(String[] args){
        int[] intArrayB = new int[]{ 1, 2, 3, 2, 1, 2 }; 
        System.out.println(findOptimalShelf(intArrayB, 3));
        // System.out.println(solution(intArrayA));
        // System.out.println(solution(""));
        int[] shelves = {1, 2, 2, 3, 4, 4, 4, 5, 6, 6, 6, 6};
        int R = 3;

        int optimalShelf = findOptimalShelf3(shelves, R);

        System.out.println("Optimal Shelf: " + optimalShelf);

    }
}