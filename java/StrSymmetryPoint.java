public class StrSymmetryPoint {
    public int solution(String S) {
        // Implement your solution here
        int strLen = S.length();
        if(strLen < 1 || strLen%2 == 0){
            return -1;
        }
        if(strLen == 1){
            return 0;
        }
        int mid = strLen/2;
        for(int i=mid, j=mid+1; i>= 0 && j < S.length(); i--, j++){
            String subLeft = S.substring(0, i);
            StringBuffer sbr = new StringBuffer(subLeft);
            String subRight = S.substring(j, S.length());
            String leftRv = sbr.reverse().toString();
            //System.out.println(sbr.reverse().toString());
            //System.out.println(subRight);
            if(subRight.equals(leftRv)){
                return i;
            }
        }
        return -1;
    }

    public int solutionCorrect(String S) {
        // Implement your solution here
        int strLen = S.length();
        if(strLen < 1 || strLen%2 == 0){
            return -1;
        }
        if(strLen == 1){
            return 0;
        }
        int mid = (int) Math.floor(strLen/2);
        String subLeft = S.substring(0, mid);
        StringBuffer sbr = new StringBuffer(subLeft);
        String subRight = S.substring(mid+1, S.length());
        String leftRv = sbr.reverse().toString();
        if(subRight.equals(leftRv)){
            return mid;
        }
        return -1;
    }

    public static char[] getReverseString(int ind, String A, char[] rvStr){
        int mid = (int) Math.floor(A.length()/2);
        
        if(ind < mid){
            rvStr[ind] = A.charAt(A.length()-ind-1);
            rvStr[A.length()-ind-1] = A.charAt(ind);
            return getReverseString(ind +1, A, rvStr);
        }
        
        if(A.length()%2 != 0){
            rvStr[mid] = A.charAt(mid);
        }
        return rvStr;
    }
}
