/**
 * @author 18389
 * simulation
 */
public class NBody {
    /** readRadius */
    public static double readRadius(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        double radius = in.readDouble();
        return  radius;
    }
}
