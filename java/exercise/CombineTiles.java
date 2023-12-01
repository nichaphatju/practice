package exercise;

public class CombineTiles {
    
    /*
     * 
     * N = number of 2*2 Tile
     * M = number of 1*1 Tile
     * Find the length of the side of the largest square we can create
     * return 0 if no square can be create
     * 
     */

    public static int solution(int M, int N){
        int currentWidth = 0;
        int currentTileCol = 0;

        while(N > 0 || M > 0){
            // try 2 sq first
            int sqNeed = currentTileCol == 0 ? 1 : currentTileCol*2 +1;
            boolean sqOk = false;
            int nUse = 0;
            int mUse = 0;

            if( N > 0){
                if(N >= sqNeed){
                    // use N only
                    nUse += sqNeed;
                    sqOk = true;
                }else if(N < sqNeed && M >= (sqNeed - N) *4){
                    int mNeed = (sqNeed - N) *4;
                    mUse += mNeed;
                    nUse += N;
                    sqOk = true;
                }else if(M >= sqNeed*4){
                    mUse += sqNeed*4;
                    sqOk = true;
                }
                
            }else{
                // square all m
                int mNeed = sqNeed*4;
                if(M >= mNeed){
                    mUse += mNeed;
                    sqOk = true;
                }

            }

            if(sqOk){
                M = M - mUse;
                N = N - nUse;
                currentTileCol += 1;
                currentWidth += 2;
            }else{
                
                // try round with M only
                int mNeed = currentWidth*2 + 1;
                if(M >= mNeed){
                    mUse += mNeed;
                    currentTileCol +=1;
                    currentWidth += 1;
                }else{
                    break;
                }
            }

        }


        return currentWidth;
    }

    public static void main(String[] args) {
        System.out.println(solution(8, 0));
        System.out.println(solution(4, 3));
        System.out.println(solution(0, 18));
        System.out.println(solution(13, 3));
        System.out.println(solution(24, 3));
    }
}
