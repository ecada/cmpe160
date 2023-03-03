/**
 * Program animates a 2D bouncing ball
 * @author Sedgewick, Wayne
 */
public class BouncingBall {
    public static void main(String[] args) {

        StdDraw.setCanvasSize(400, 400); // set the size of the drawing canvas
        StdDraw.setXscale(-1.0, 1.0); // set the scale of the coordinate system
        StdDraw.setYscale(-1.0, 1.0);
        StdDraw.enableDoubleBuffering(); // Use for faster animations

        int pauseDuration = 15; // pause duration in milliseconds

        double position_x = 0.480, position_y = 0.860;  // initial (x,y) ball position
        double velocity_x = 0.015, velocity_y = 0.017;  // initial velocity components
        double radius = 0.05;  // radius of the ball

        while (true)  { // main animation loop
            // bounce off wall according to law of elastic collision
            if (Math.abs(position_x + velocity_x) > 1.0 - radius)
                velocity_x = -velocity_x;
            if (Math.abs(position_y + velocity_y) > 1.0 - radius)
                velocity_y = -velocity_y;

            position_x = position_x + velocity_x; // update positions
            position_y = position_y + velocity_y;

            StdDraw.clear(StdDraw.WHITE); // clear the background
            StdDraw.setPenColor(StdDraw.BLACK); // draw ball on the screen
            StdDraw.filledCircle(position_x, position_y, radius);
            StdDraw.show(); // show the drawing on the screen
            StdDraw.pause(pauseDuration); // pause the drawing at each iteration
        }
    }
}
