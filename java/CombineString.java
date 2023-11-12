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
            result = next("AA", AA, AB, BB, result);
        }else if(AB > BB && AB > 0){
            result += "AB";
            result = next("AB", AA, AB, BB, result);
        }else{
            result += "BB";
            result = next("BB", AA, AB, BB, result);
        }

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

    public static void main(String[] args){
        System.out.println(solution(1,2,3));
        System.out.println(solution(0,2,3));
        System.out.println(solution(5,2,3));
    }
}
