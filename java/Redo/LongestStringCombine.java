package Redo;

public class LongestStringCombine {

    public static int solution(int AA, int BB, int AB){

        String str = "";

        if(AA > BB && AA > 0){
            str +="AA";
            AA--;

        }else if(BB > AA && BB > 0){
            str +="BB";
            BB--;
        }

        // use AA and BB first
        while(AA > 0 || BB > 0){
            if(str.endsWith("A") && BB > 0){
                str +="BB";
                BB--;
            }else if(str.endsWith("B") && AA > 0 && BB > 0){
                str +="AA";
                AA--;
            }else{
                break;
            }
        }

        // this point str will definitely end with B
        while (AB > 0) {
            str +="AB";
            AB--;
        }

        // do AA,BB again
        while(AA > 0 || BB > 0){
            if(str.endsWith("A") && BB > 0){
                str +="BB";
                BB--;
            }else if(str.endsWith("B") && AA > 0){
                str +="AA";
                AA--;
            }else{
                break;
            }
        }

        return str.length();

    }
    
    public static void main(String[] args) {
        System.out.println(solution(3,2,4));
        System.out.println(solution(2,5,1));
    }
}
