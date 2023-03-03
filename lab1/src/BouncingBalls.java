import java.util.Random;
import java.awt.Color;
public class BouncingBalls {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(400, 400); // set the size of the drawing canvas
        StdDraw.setXscale(-1.0, 1.0); // set the scale of the coordinate system
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering(); // Use for faster animations
        int numBalls = 20; // number of balls to create
        Random rand = new Random(); // create a new random number generator
        int pauseDuration = 15; // pause duration in milliseconds
        double[] position_x_array = new double[numBalls];
        double[] position_y_array = new double[numBalls];
        double[] velocity_x_array = new double[numBalls];
        double[] velocity_y_array = new double[numBalls];
        double[] radius = new double[numBalls];
        Color[] color = new Color[numBalls];
        for (int i = 0; i < numBalls; i++) {
            radius[i] = rand.nextDouble() * 0.05 + 0.05;
            position_x_array[i] = rand.nextDouble() * (1.0 - radius[i] * 2) + radius[i];
            position_y_array[i] = rand.nextDouble() * (1.0 - radius[i] * 2) + radius[i];
            velocity_x_array[i] = rand.nextDouble() * 0.05 - 0.025;
            velocity_y_array[i] = rand.nextDouble() * 0.05 - 0.025;
            color[i] = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
        }
        // main animation loop
        while (true) {
            StdDraw.clear();
            for (int i = 0; i < numBalls; i++) {
                if (Math.abs(position_x_array[i] + velocity_x_array[i]) > 1.0 - radius[i] )
                    velocity_x_array[i] = -velocity_x_array[i];
                if (Math.abs(position_y_array[i] + velocity_y_array[i]) > 1.0 - radius[i] )
                    velocity_y_array[i] = -velocity_y_array[i];
                position_x_array[i] = position_x_array[i] + velocity_x_array[i];
                position_y_array[i] =position_y_array[i] + velocity_y_array[i];
                StdDraw.setPenColor(color[i]);
                StdDraw.filledCircle(position_x_array[i],position_y_array[i], radius[i]);
            }
            StdDraw.show(); // show the drawing on the screen
            StdDraw.pause(pauseDuration); // pause the drawing at each iteration
        }
    }
}
