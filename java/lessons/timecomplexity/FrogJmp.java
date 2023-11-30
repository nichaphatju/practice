package lessons.timecomplexity;
public class FrogJmp {

    //Count minimal number of jumps from position X to Y.

    public int solution(int X, int Y, int D) {
        // Implement your solution here
        int distance = Y-X;
        double d = (double) distance/D;
        int numOfJump = (int) Math.ceil(d);
        return numOfJump;
    }
}
