public class LongestStringWithoutConsecutiveSameLetters {
    
    public static String longestString(int AA, int AB, int BB) {
        StringBuilder result = new StringBuilder();
        
        // Decide which character to start with based on their counts
        // and append characters without creating sequences of three consecutive identical characters
        if (AA >= AB && AA >= BB) {
            int count = appendWithoutConsecutive(AA, 'A', 'B',result);
            appendWithoutConsecutive(AB, 'B', 'A',result);
            appendWithoutConsecutive(BB, 'B', 'A',result);
        } else if (AB >= AA && AB >= BB) {
            int count = appendWithoutConsecutive(AB, 'B', 'A',result);
            appendWithoutConsecutive(AA, 'A', 'B',result);
            appendWithoutConsecutive(BB, 'A', 'B',result);
        } else {
            int count = appendWithoutConsecutive(BB, 'B', 'A',result);
            appendWithoutConsecutive(AA, 'A', 'B',result);
            appendWithoutConsecutive(AB, 'A', 'B',result);
        }
        
        return result.toString();
    }

    
        
        // Function to append a character 'ch' to the result 'count' times
        // without creating a sequence of three consecutive identical characters
        // If such a sequence is about to be formed, it changes the character to append
        // to avoid the sequence.
        // 'current' is the current character being appended, 'other' is the alternate character
        // to append in case of a sequence of three identical characters.
        // Returns the count of characters appended.
    public static int appendWithoutConsecutive(int count, char current, char other,StringBuilder result) {
        
        for (int i = 0; i < count; i++) {
            int len = result.length();
            // Check if adding 'current' character would create three consecutive identical characters
            if (len >= 2 && result.charAt(len - 1) == current && result.charAt(len - 2) == current) {
                // If so, append the 'other' character instead
                result.append(other);
            } else {
                // Otherwise, append the 'current' character
                result.append(current);
            }
        }
        return count;
    }
    
    public static void main(String[] args) {
        int AA = 3; // Replace with the number of 'AA' strings
        int AB = 4; // Replace with the number of 'AB' strings
        int BB = 2; // Replace with the number of 'BB' strings
        
        String longest = longestString(AA, AB, BB);
        System.out.println("Longest possible string without 3 consecutive 'A's or 'B's: " + longest);
    }
}
