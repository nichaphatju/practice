public class CombineString {

    /**
     * 
     * @param AA
     * @param AB
     * @param BB
     * @return
     * 
     * AA -> BB
     * AB -> AA, AB
     * BB -> AA
     * 
     */

    public static String solution(int AA, int AB, int BB) {
        String result = "";

        int max = Math.max(AA, BB);
        max = Math.max(max, AB);
        System.out.println(max);
        if(AA == max && AA > 0){
            result += "AA";
            AA--;
            result = next("AA", AA, AB, BB, result);
        }else if(AB > BB && AB > 0){
            result += "AB";
            AB--;
            result = next("AB", AA, AB, BB, result);
        }else{
            result += "BB";
            BB--;
            result = next("BB", AA, AB, BB, result);
        }

        System.out.println(result.length());

        return result;
    }

    /** Accepted */
    public static String solution2(int AA, int AB, int BB) {
        
        String result;
        if(AA > BB){
            result = "AA";
            AA--;
        }else{
            result = "BB";
            BB--;
        }
        while(AA > 0 && BB > 0){
            if(result.endsWith("A") && BB > 0){
                result += "BB";
                BB--;
            }else if (result.endsWith("B") && AA > 0){
                result += "AA";
                AA--;
            }
        }

        if(result.endsWith("A") && BB > 0){
            result += "BB";
            BB--;
        }
        if(result.endsWith("B")){
            while (AB > 0) {
                result += "AB";
                AB--;
            }
        }

        if(result.endsWith("B") && AA > 0){
            result += "AA";
            AA--;
        }

        System.out.println(result.length());

        return result;

    }

    public static String next(String prev, int AA, int AB, int BB, String result){
        if(prev == "AA"){
            if(BB > 0){
                result += "BB";
                prev = "BB";
                BB--;
                return next(prev, AA, AB, BB, result);
            }
            return result;
        }else if(prev == "AB" || prev == "BB"){
            if(AA > 0 && BB > 0){
                result += "AA";
                prev = "AA";
                AA--;
                return next(prev, AA, AB, BB, result);
            }else if(AB > 0 && (AA > 0 || AB > 0)){
                result += "AB";
                prev = "AB";
                AB--;
                return next(prev, AA, AB, BB, result);
            }else if(AA > 0 && AA > AB){
                result += "AA";
                prev = "AA";
                AA--;
                return next(prev, AA, AB, BB, result);
            }else if(AB > 0){
                result += "AB";
                prev = "AB";
                AB--;
                return next(prev, AA, AB, BB, result);
            }
            return result;
        }
        return result;
    }

    public static String longestString(int AA, int AB, int BB) {
        StringBuilder result = new StringBuilder();
        
        // Determine which string type ('A' or 'B') should come first based on their count
        char first = 'A', second = 'B';
        int firstCount = AA, secondCount = AB;
        if (AB > AA) {
            first = 'B';
            second = 'A';
            firstCount = BB;
            secondCount = AB;
        }
        
        // Loop until both counts become zero
        while (firstCount > 0 || secondCount > 0) {
            // Append 'first' character as long as there's a count for it and no three consecutive 'first' characters
            if (firstCount > 0) {
                if (result.length() >= 2 && result.charAt(result.length() - 1) == first && result.charAt(result.length() - 2) == first) {
                    // If the last two characters are the same as 'first', switch to 'second'
                    result.append(second);
                    secondCount--;
                } else {
                    result.append(first);
                    firstCount--;
                }
            } else if (secondCount > 0) {
                // If there are no more 'first' characters to add, add 'second' character
                result.append(second);
                secondCount--;
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args){
        // System.out.println(solution(1,2,3));
        // System.out.println(solution(0,2,3));
        // System.out.println(solution(5,2,3));

        // System.out.println(solution(3,4,2));
        System.out.println(solution2(3,4,2));

        // System.out.println(solution(2,1,5));
        System.out.println(solution2(2,1,5));


        int AA = 3; // Replace with the number of 'AA' strings
        int AB = 4; // Replace with the number of 'AB' strings
        int BB = 2; // Replace with the number of 'BB' strings
        
        // String longest = longestString(AA, AB, BB);
        // System.out.println("Longest possible string without 3 consecutive 'A's or 'B's: " + longest);

    }
}
