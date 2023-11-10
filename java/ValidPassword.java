public class ValidPassword {
    
    public static void main(String[] args) {
        System.out.println(solution("a0B"));
        System.out.println(solution("a0Ba"));
        System.out.println(solution("a0bb"));
    }

    public static int solution(String S){
        int result = -1;

        Boolean isValid = false;
        String pwd = "";
        for(int i=0; i<S.length(); i++){
            char s = S.charAt(i);
            if(Character.isDigit(s)){
                if(isValid) result = Math.max(result, pwd.length());
                pwd = "";
                isValid = false;  
            }else if(Character.isUpperCase(s)){
                isValid = true;
                pwd = pwd + s;
            }else{
                pwd = pwd + s;
            }
        }
        System.out.println(pwd);
        if(isValid) result = Math.max(result, pwd.length());

        return result;
    }
}
