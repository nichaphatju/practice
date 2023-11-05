import java.util.Scanner;

public class IsAnagram {
    static boolean isAnagram(String a, String b) {
        // Complete the function
        if(a.length() != b.length()){
            return false;
        }
        
        java.util.Map<String, Integer> countCharA = new java.util.TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        java.util.Map<String, Integer> countCharB = new java.util.TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        
        for(int i=0;i <a.length();i++){
            String chA = String.valueOf(a.charAt(i));
            if(countCharA.containsKey(chA)){
                countCharA.put(chA,countCharA.get(chA) +1);
            }else{
                countCharA.put(chA, 1);
            }
            
            String chB = String.valueOf(b.charAt(i));
            if(countCharB.containsKey(chB)){
                countCharB.put(chB,countCharB.get(chB) +1);
            }else{
                countCharB.put(chB, 1);
            }
        }
        
        if(countCharA.size() != countCharB.size()){
            return false;
        }
        
        for(String ch: countCharA.keySet()){
            if(countCharA.get(ch) != countCharB.get(ch)){
                return false;
            }
        }
        
        
        return true;
    }

    public static void main(String[] args) {
    
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
