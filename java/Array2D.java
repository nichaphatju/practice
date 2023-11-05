import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Array2D {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        List<List<Integer>> arr = new ArrayList<>();

        IntStream.range(0, 6).forEach(i -> {
            try {
                arr.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        //0,0 0,1 0,2
        //1,0 1,1 1,2
        //2,0 2,1 2,2
        
        //3,2 3,3 3,4
        //4,2 4,3 4,4
        //5,2 5,3 5,4
        
        // i,j | i,j+1 | i,j+2 
        // i+1, j | i+1,j+1 | i+1,j+2
        // i+2, j | i+2,j+1 | i+2,j+2
        
        int maxSum = Integer.MIN_VALUE;
        for(int i=0; i< arr.size()-2; i++){
            
            for(int j=0; j< arr.get(i).size()-2 ; j++){
                int sumAtEachPoint = 0;
                //System.out.println(" num "+ arr.get(i).get(j));
                
                sumAtEachPoint = arr.get(i).get(j) + arr.get(i).get(j+1) + arr.get(i).get(j+2) +
                arr.get(i+1).get(j+1) + 
                arr.get(i+2).get(j) + arr.get(i+2).get(j+1) + arr.get(i+2).get(j+2);            
                //System.out.println(" num mid"+ arr.get(i+1).get(j+1));
                //System.out.println(" sumAtEachPoint "+ sumAtEachPoint);
                maxSum = Math.max(sumAtEachPoint, maxSum);
            }
            
            
        }

        bufferedReader.close();
        System.out.println(maxSum);
    }
}
