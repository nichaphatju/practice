public class MovingPlayers {

    /**
     * 
     * @param S -> format >,<,^,v represent player direction
     * @return
     */

    public static int solution(String S){
        int count = 0;
        Boolean isLeftOk = true;
        for(int i=0; i<S.length(); i++){
            if(S.charAt(i) == '>'){
                isLeftOk = false;
                if(i == S.length()-1) count++;
            }else if(S.charAt(i) == '^' || S.charAt(i) == 'v'){
                isLeftOk = true;
                count++;
            }else{
                // < Go left
                if(isLeftOk){
                    count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(solution(">><<"));
        System.out.println(solution(">>^<"));
        System.out.println(solution("<>>^<"));
        System.out.println(solution("<<<<v<"));
        System.out.println(solution("<<><v<"));
    }
}
