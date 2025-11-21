import java.io.*;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

class Question {
    String difficulty;
    String text;
    String[] options = new String[4];
    char correct;

    Question(String difficulty, String text, String[] options, char correct) {
        this.difficulty = difficulty;
        this.text = text;
        this.options = options;
        this.correct = Character.toUpperCase(correct);
    }
}

public class QuizApp {
    private static final String QUESTIONS_FILE = "questions.txt";
    private static final String SCORES_FILE = "scores.txt";
    private static final DateTimeFormatter TF = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String player = sc.nextLine().trim();
        if (player.isEmpty()) player = "Player";

        System.out.println("Choose difficulty (easy / medium / hard): ");
        String difficulty = sc.nextLine().trim().toLowerCase();
        if (!difficulty.equals("easy") && !difficulty.equals("medium") && !difficulty.equals("hard")) {
            difficulty = "easy";
        }

        List<Question> questions = loadQuestions(QUESTIONS_FILE);
        if (questions.isEmpty()) return;

        List<Question> pool = new ArrayList<>();
        for (Question q : questions) {
            if (q.difficulty.equalsIgnoreCase(difficulty)) pool.add(q);
        }
        if (pool.isEmpty()) pool = new ArrayList<>(questions);

        int numQuestions = difficulty.equals("easy") ? 5 : difficulty.equals("medium") ? 7 : 10;
        numQuestions = Math.min(numQuestions, pool.size());

        Collections.shuffle(pool);
        List<Question> quiz = pool.subList(0, numQuestions);

        int score = 0;
        System.out.println("\nStarting quiz (" + numQuestions + " questions)\n");

        int qnum = 1;
        for (Question q : quiz) {
            System.out.println("Q" + qnum + ": " + q.text);
            System.out.println("  A) " + q.options[0]);
            System.out.println("  B) " + q.options[1]);
            System.out.println("  C) " + q.options[2]);
            System.out.println("  D) " + q.options[3]);
            System.out.print("Your answer: ");
            String ans = sc.nextLine().trim().toUpperCase();
            while (ans.isEmpty() || "ABCD".indexOf(ans.charAt(0)) < 0) {
                System.out.print("Enter A/B/C/D: ");
                ans = sc.nextLine().trim().toUpperCase();
            }
            char a = ans.charAt(0);
            if (a == q.correct) score++;
            qnum++;
        }

        System.out.println("Your score: " + score + " / " + numQuestions);
        saveScore(player, difficulty, score, numQuestions, SCORES_FILE);
        sc.close();
    }

    private static List<Question> loadQuestions(String path) {
        List<Question> list = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                line = line.trim();
                if (line.isEmpty() || line.startsWith("#")) continue;
                String[] parts = line.split("\\|");
                if (parts.length != 7) continue;
                String diff = parts[0].trim().toLowerCase();
                String txt = parts[1].trim();
                String[] opts = new String[4];
                for (int i = 0; i < 4; i++) opts[i] = parts[2 + i].trim();
                char corr = parts[6].trim().charAt(0);
                list.add(new Question(diff, txt, opts, corr));
            }
        } catch (IOException e) {}
        return list;
    }

    private static void saveScore(String player, String difficulty, int score, int total, String path) {
        String time = LocalDateTime.now().format(TF);
        String line = String.format("%s | %s | %s | %d/%d%n", time, player, difficulty, score, total);
        try (FileWriter fw = new FileWriter(path, true)) {
            fw.write(line);
        } catch (IOException e) {}
    }
}

