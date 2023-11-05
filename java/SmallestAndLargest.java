public class SmallestAndLargest {
    public static String getSmallestAndLargest(String s, int k) {
        String smallest = "";
        String largest = "";
        
        // Complete the function
        // 'smallest' must be the lexicographically smallest substring of length 'k'
        // 'largest' must be the lexicographically largest substring of length 'k'
        String[] subStrList = new String[s.length()-k+1];
        for(int i=0; i<=s.length()-k; i++){
            subStrList[i] = s.substring(i, i+k);
        }
        java.util.Arrays.sort(subStrList);
        
        //System.out.println(java.util.Arrays.toString(subStrList));
        
        if(subStrList.length > 0){
            smallest = subStrList[0];
            largest = subStrList[subStrList.length-1];
        }
        
        return smallest + "\n" + largest;
    }
}
