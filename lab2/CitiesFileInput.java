import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
public class CitiesFileInput {
    public static void main(String[] args) {
        int num_cities=4;
        String[] cityNames = new String[num_cities];
        double[][] coordinates = new double[num_cities][2];
        try {
            FileInputStream fis=new FileInputStream("input.txt");
            Scanner sc=new Scanner(fis);
            int i=0;
            while(sc.hasNextLine())
            {
                String line = sc.nextLine();
                String[] lineSplit = line.split(" ");
                cityNames[i] = lineSplit[0];
                coordinates[i][0] = Double.parseDouble(lineSplit[1]);
                coordinates[i][1] = Double.parseDouble(lineSplit[2]);
                i++;
            }
            sc.close();
        }
        catch(
                IOException e)
        {
            e.printStackTrace();
        }
        double minDistance = Double.MAX_VALUE;
        double maxDistance = Double.MIN_VALUE;
        int cityInd1_max = 0;
        int cityInd2_max = 0;
        int cityInd1_min = 0;
        int cityInd2_min = 0;
        for (int i = 0; i < coordinates.length-1; i++) { for (int j = i + 1; j < coordinates.length; j++) {
            double x1 = coordinates[i][0];
            double y1 = coordinates[i][1];
            double x2 = coordinates[j][0];
            double y2 = coordinates[j][1];
            double distance = Math.pow(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2), 0.5);
            if (distance >maxDistance ) { maxDistance = distance; cityInd1_max = i;
                cityInd2_max = j;
            }
            if (distance < minDistance) { minDistance = distance; cityInd1_min = i;
                cityInd2_min = j;
            }
        }
        }
        //STDRAW
        int canvas_width = 400;
        int canvas_height = 400;
        StdDraw.setCanvasSize(canvas_width, canvas_height);
        StdDraw.setXscale(25,55);
        StdDraw.setYscale(10,40);
        double circle_radius = 1.4;
        StdDraw.clear(StdDraw.WHITE);
        StdDraw.setFont( new Font("Helvetica Bold", Font.BOLD, 10) );
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(StdDraw.BOOK_BLUE);
        String MaxDistanceStr= String.format("MaxDistance: %.3f" , maxDistance);
        String MinDistanceStr= String.format("MinDistance: %.3f" , minDistance);
        StdDraw.line(coordinates[cityInd1_max][0], coordinates[cityInd1_max][1],coordinates[cityInd2_max][0], coordinates[cityInd2_max][1]);
        StdDraw.textRight((coordinates[cityInd2_max][0]+coordinates[cityInd1_max][0])/2-0.5, (coordinates[cityInd2_max][1]+coordinates[cityInd1_max][1])/2, MaxDistanceStr);
        StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);
        StdDraw.line(coordinates[cityInd1_min][0], coordinates[cityInd1_min][1],coordinates[cityInd2_min][0], coordinates[cityInd2_min][1]);
        StdDraw.textRight((coordinates[cityInd2_min][0]+coordinates[cityInd1_min][0])/2-0.5, (coordinates[cityInd2_min][1]+coordinates[cityInd1_min][1])/2+2, MinDistanceStr);
        for (int i = 0; i < cityNames.length; i++) {
            StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            StdDraw.filledCircle(coordinates[i][0], coordinates[i][1], circle_radius);
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.setFont( new Font("Serif", Font.BOLD, 10));
            StdDraw.text(coordinates[i][0], coordinates[i][1], cityNames[i]);
        }
        StdDraw.show();

        System.out.printf("Closest cities are: %s and %s. Distance = %5.2f\n", cityNames[cityInd1_min], cityNames[cityInd2_min], minDistance);
      System.out.printf("Farthest cities are: %s and %s. Distance = %5.2f\n", cityNames[cityInd1_max], cityNames[cityInd2_max], maxDistance);
    }
}

