import java.io.*;
import java.util.*;

public class HighestValueSeries {
    public static void main(String[] args) throws Exception {
        File inputFile = new File("Input.txt");
        File outputFile = new File("Output.txt");
        Scanner sc = new Scanner(inputFile);
        sc.useDelimiter("[, ]+");
        PrintWriter pw = new PrintWriter(outputFile);
        int highest = Integer.MIN_VALUE;
        while (sc.hasNextInt()) {
            int value = sc.nextInt();
            if (value > highest) highest = value;
            pw.print(highest);
            if (sc.hasNextInt()) pw.print(", ");
        }
        sc.close();
        pw.close();
    }
}
