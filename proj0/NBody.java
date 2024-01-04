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

    /** ReadPlanets*/
    public static Planet[] readPlanets(String fileName) {
        In in = new In(fileName);
        int num = in.readInt();
        double radius = in.readDouble();
        Planet[] planets = new Planet[num];
        for (int i = 0; i < num; i++) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m = in.readDouble();
            String img = in.readString();
            planets[i] = new Planet(xP, yP, xV, yV, m, img);
        }
        return planets;
    }

    /** Drawing the Initial Universe State*/
    public static void main(String[] args) {
        double T = new Double(args[0]);
        double dt = new Double(args[1]);
        String fileName = args[2];
        double r = readRadius(fileName);
        Planet[] planets = readPlanets(fileName);

        /** Drawing the background */
        StdDraw.setXscale(-r, r);
        StdDraw.setYscale(-r, r);
        //to prevent flickering in the animation
        StdDraw.enableDoubleBuffering();

        double t = 0;
        int num = planets.length;
        while (t < T) {
            double[] xForces = new double[num];
            double[] yForces = new double[num];
            for (int i = 0; i < num; i++) {
                xForces[i] = planets[i].calcNetForceExertedByX(planets);
                yForces[i] = planets[i].calcNetForceExertedByY(planets);
            }
            for (int i = 0; i < num; i++) {
                planets[i].update(dt, xForces[i], yForces[i]);
            }

            StdDraw.picture(0, 0, "images/starfield.jpg");
            //drawing all planets
            for (Planet planet : planets) {
                planet.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            t += dt;
        }

    }
}
