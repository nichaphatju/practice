public class InsertDigit {
    public static int solution(int N, int digit){
        String n = String.valueOf(N);
        String result = "";
        Boolean added = false;
        if(N != 0){
            for(int i=0; i < n.length(); i++){
                if(Character.isDigit(n.charAt(i))){
                    int dg = Character.getNumericValue(n.charAt(i));
                    System.out.println(dg);
                    if(dg < digit && N > 0 && !added){
                        result += String.valueOf(digit);
                        added = true;
                    }else if(dg > digit && N < 0 && !added){
                        result += String.valueOf(digit);
                        added = true;
                    }
                    result += dg;
                }else{
                    result += '-';
                }
                
                // System.out.println(result);
            }
        }else if(N == 0){
            result = String.valueOf(digit) + n;
        }

        // System.out.println(result);

        return Integer.parseInt(result);
    }

    public static void main(String[] args){
        // System.out.println(solution(268, 5));
        // System.out.println(solution(670, 5));
        // System.out.println(solution(0, 5));
        System.out.println(solution(-999, 5));
    }
}
