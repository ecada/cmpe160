import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentScores {
    public static void main(String[] args) {
        File file = new File("students.txt");
        try {
            Scanner scanner = new Scanner(file);
            int numStudents = Integer.parseInt(scanner.nextLine());
            String[] names = new String[numStudents];
            double[] scores = new double[numStudents];
            double totalScore = 0;
            for (int i = 0; i < numStudents; i++) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                names[i] = parts[0];
                scores[i] = Double.parseDouble(parts[1]);
                totalScore += scores[i];
            }
            scanner.close();
            double averageScore = totalScore / numStudents;
            double barWidth = 0.2;
            double maxScore = 100;
            StdDraw.setCanvasSize(400, 400);
            StdDraw.setXscale(-1, names.length);
            StdDraw.setYscale(0, maxScore + 10);
            StdDraw.setPenRadius(0.02);
            StdDraw.setFont( new Font("Helvetica Bold", Font.BOLD, 12));
            for (int i = 0; i < names.length; i++) {
                double x = i;
                double y = scores[i];
                StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
                StdDraw.filledRectangle(x, y/2, barWidth/2, y/2);
                StdDraw.text(x, y+5, names[i]);
            }
            StdDraw.setPenRadius(0.01);
            StdDraw.setPenColor(StdDraw.PRINCETON_ORANGE);

            StdDraw.line(-1, averageScore, names.length, averageScore);
            StdDraw.textRight(names.length/4, averageScore + 5, "Average Score: " + averageScore);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }


}
