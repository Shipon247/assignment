Simport java.io.*;
import java.util.*;

public class MathPuzzle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Player Name: ");
        String playerName = sc.nextLine();

        System.out.print("Enter Difficulty Level (easy/medium/hard): ");
        String level = sc.nextLine().toLowerCase();

        int score = 0;

        List<String> questions = new ArrayList<>();

        try {
            Scanner fileReader = new Scanner(new File("questions.txt"));
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine().trim();
                if (!line.isEmpty()) questions.add(line);
            }
            fileReader.close();
        } catch (Exception e) {
            System.out.println("Error reading questions file.");
            return;
        }

        System.out.println("\n--- Math Puzzle Starts ---");

        for (String q : questions) {
            String[] parts = q.split(" ");
            if (parts.length < 3) continue;

            int a = Integer.parseInt(parts[0]);
            String op = parts[1];
            int b = Integer.parseInt(parts[2]);

            int correct = 0;

            if (op.equals("+")) correct = a + b;
            if (op.equals("-")) correct = a - b;
            if (op.equals("*")) correct = a * b;

            System.out.print(a + " " + op + " " + b + " = ");
            int ans = sc.nextInt();

            if (ans == correct) {
                if (level.equals("easy")) score += 1;
                else if (level.equals("medium")) score += 2;
                else if (level.equals("hard")) score += 3;
            }
        }

        try {
            FileWriter fw = new FileWriter("scores.txt", true);
            fw.write(playerName + " (" + level + "): " + score + "\n");
            fw.close();
        } catch (Exception e) {
            System.out.println("Error writing score file.");
        }

        System.out.println("\nFinal Score: " + score);
        System.out.println("Score saved successfully!");
    }
}

