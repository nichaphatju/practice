import java.util.Scanner;

// Failed
public class MovingGame {
    public static boolean canWin(int leap, int[] game) {
        // Return true if you can win the game; otherwise, return false.
        Boolean canwin = checkRoute(game, leap, 0);
        return canwin;
    }
    
    public static boolean checkRoute(int[] game,int leap, int ind){
        //System.out.println(ind);
        if(ind+1 >= game.length  || ind+leap >= game.length){
            return true;
        }
        
        
        
        if(game[ind] == 0 && ind == game.length -1 ){
            game[ind] = 5;
            return true;
        }
        
        if(game[ind] == 0 &&  (ind > 0 && game[ind-1] == 0)){
            game[ind] = 5;
            if(checkRoute(game, leap,  ind-1)){
                return true;
            }
        }
        
        if(game[ind] == 0 &&  (ind+1 >= game.length || game[ind+1] == 0)){
            game[ind] = 5;
            if(checkRoute(game, leap,  ind+1)){
                return true;
            }
        }
        
        if(game[ind] == 0 && (ind+leap >= game.length || game[ind+leap] == 0)){
            game[ind] = 5;
            if(checkRoute(game, leap,  ind+leap)){
                return true;
            }
            
        }
        
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            
            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
