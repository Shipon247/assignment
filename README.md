#helloworld.java
#code
~~~
DisplayPattern  
{     public static void main(String[] args)  
{ 
        System.out.println("      J    A    V     V    A   "); 
        System.out.println("      J   A A    V   V    A A  "); 
        System.out.println(" J    J  AAAAA    V V    AAAAA "); 
        System.out.println("  J J   A     A    V    A     A");     } 
} 


~~~
#helloworld.java
#code
~~~
package ict._22.ClassNames; public class SumClass {     public static SumClass instance = new SumClass();     private SumClass() {}     public double calculateSum() {         double sum = 0; 
 
        for (double i = 1.0; i >= 0.1; i -= 0.1) { 
            sum += i; 
        }         return sum; 
    } 
} 
 
package ict._22.ClassNames; 
 
public class DivisorMultipleClass {     public static DivisorMultipleClass instance = new DivisorMultipleClass();     private DivisorMultipleClass() {}     public int gcd(int a, int b) {         if (b == 0)             return a;         return gcd(b, a % b); 
    }     public int lcm(int a, int b) {         return (a * b) / gcd(a, b); 
    } 
} 
 
package ict._22.ClassNames; public class NumberConversionClass {     public static NumberConversionClass instance = new NumberConversionClass();     private NumberConversionClass() {}     public void convert(int num) { 
        System.out.println("Decimal : " + num); 
        System.out.println("Binary  : " + Integer.toBinaryString(num)); 
        System.out.println("Octal   : " + Integer.toOctalString(num));         System.out.println("Hexa    : " + Integer.toHexString(num)); 
    } 
} 
 
package ict._22.ClassNames; public class CustomPrintClass {     public static CustomPrintClass instance = new CustomPrintClass();     private CustomPrintClass() {}     public void pr(String msg) { 
        System.out.println(msg); 
    } 
} 
 
package ict._22.ClassNames; public class MainClass {     public static void main(String[] args) { 
        // Sum         double result = SumClass.instance.calculateSum(); 
        CustomPrintClass.instance.pr("Sum = " + result); 
        // GCD & LCM 
        int a = 12, b = 18; 
        CustomPrintClass.instance.pr("GCD = " + DivisorMultipleClass.instance.gcd(a, b)); 
        CustomPrintClass.instance.pr("LCM = " + DivisorMultipleClass.instance.lcm(a, b)); 
        // Number Conversion 
        NumberConversionClass.instance.convert(25); 
        // Custom Print 
        CustomPrintClass.instance.pr("All classes executed successfully!"); 
    } 
} 
~~~
#helloworld.java
#code
~~~import java.io.*; import java.util.*; public class MathPuzzle {     public static void main(String[] args) { 
        Scanner input = new Scanner(System.in); 
 
        System.out.print("Enter your name: "); 
        String name = input.nextLine(); 
 
        System.out.print("Enter difficulty (easy / medium / hard): "); 
        String difficulty = input.nextLine().toLowerCase(); 
 
        int questionsToAsk = 5;         if (difficulty.equals("medium")) questionsToAsk = 7;         else if (difficulty.equals("hard")) questionsToAsk = 10;         int score = 0;         try { 
            File qFile = new File("questions.txt"); 
            Scanner qReader = new Scanner(qFile); 
 
            List<String> questions = new ArrayList<>(); 
            List<Integer> answers = new ArrayList<>(); 
 
            while (qReader.hasNextLine()) { 
                String line = qReader.nextLine();                 String[] parts = line.split("=");                 questions.add(parts[0].trim());                 answers.add(Integer.parseInt(parts[1].trim())); 
            } 
            qReader.close(); 
 
            for (int i = 0; i < questionsToAsk && i < questions.size(); i++) {                 System.out.print(questions.get(i) + "= ");                 int userAns = input.nextInt();                 if (userAns == answers.get(i)) {                     System.out.println("Correct!");                     score++; 
                } else { 
                    System.out.println("Wrong! Correct answer: " + answers.get(i)); 
                } 
            } 
            FileWriter writer = new FileWriter("score.txt", true);             writer.write(name + " | Difficulty: " + difficulty + " | Score: " + score + "\n");             writer.close(); 
            System.out.println("\nGame Over! Your score has been saved."); 
        } catch (Exception e) { 
            System.out.println("Error reading file: " + e.getMessage()); 
        } 
    } 
} 
~~~
#helloworld.java
#code
~~~
import java.util.*; public class Main {     static class Question {         String prompt;         String[] options;         char answer; 
        Question(String prompt, String[] options, char answer) {             this.prompt = prompt;             this.options = options;             this.answer = Character.toUpperCase(answer); 
        } 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        List<Question> bank = buildQuestionBank(); 
        Collections.shuffle(bank); 
        System.out.println("\n=== GK Quiz (5 Questions) ===\n"); 
        int score = 0;         for (int i = 0; i < bank.size(); i++) { 
            Question q = bank.get(i); 
            System.out.println("Question " + (i + 1));             System.out.println(q.prompt);             char label = 'A';             for (String opt : q.options) { 
                System.out.println(label + ") " + opt);                 label++; 
            } 
 
            char user = getUserAnswer(sc);             if (user == q.answer) { 
                System.out.println("Correct!\n");                 score++; 
            } else { 
                System.out.println("Wrong! Correct answer: " + q.answer + "\n"); 
            } 
        } 
        System.out.println("Quiz Finished!"); 
        System.out.println("Score: " + score + " out of 5");         double percent = (score * 100.0) / 5; 
        System.out.println("Percentage: " + percent + "%");         System.out.println("Grade: " + grade(percent));         sc.close(); 
    } 
    private static List<Question> buildQuestionBank() {         List<Question> q = new ArrayList<>(); 
        q.add(new Question( 
                "Which planet is known as the Red Planet?",                 new String[]{"Venus", "Mars", "Jupiter", "Mercury"}, 
                'B' 
        )); 
        q.add(new Question( 
                "What is the capital of France?",                 new String[]{"Rome", "Berlin", "Paris", "Madrid"}, 
                'C' 
        )); 
 
q.add(new Question( 
                "What is H2O?",                 new String[]{"Salt", "Oxygen", "Water", "Hydrogen"}, 
                'C' 
        )); 
        q.add(new Question( 
                "Who is Father of Nation of Bangladesh?", 
                new String[]{"Ziaur Rahman", "Sheikh Mujibur Rahman", "Jinnah", "Hasina"}, 
                'B' 
        )); 
        q.add(new Question(                 "CPU stands for?", 
                new String[]{"Central Process Unit", "Central Processing Unit", "Control Unit", "Computer Unit"}, 
                'B'         ));         return q; 
    } 
    private static char getUserAnswer(Scanner sc) {         while (true) { 
            System.out.print("Your answer (A/B/C/D): ");             char ch = Character.toUpperCase(sc.next().charAt(0));             if (ch >= 'A' && ch <= 'D')                 return ch; 
            System.out.println("Invalid input!"); 
        } 
    } 
 
    private static String grade(double p) {         if (p >= 80) return "A";         if (p >= 60) return "B";         if (p >= 40) return "C";         return "F"; 
    } 
} 
~~~~
#helloworld.java
#code
~~~
import java.util.Scanner; public class FactorionNumber { 
    static int factorial(int n) {         int fact = 1; 
int i = 1;         while (i <= n) {             fact *= i;             i++;         }         return fact; 
    } 
    static boolean isFactorion(int num) {         int temp = num;         int sum = 0;         while (temp > 0) {             int digit = temp % 10;             sum += factorial(digit);             temp /= 10; 
        } 
        return sum == num; 
    } 
    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.print("Enter the lower bound of the range: ");         int low = sc.nextInt(); 
        System.out.print("Enter the upper bound of the range: ");         int high = sc.nextInt(); 
        System.out.println("Factorion numbers in the range:");         for (int i = low; i <= high; i++) {             if (isFactorion(i)) { 
                System.out.println(i); 
            } 
        } 
sc.close(); 
    } 
} 
~~~~
#helloworld.java
#code
~~~
import java.io.PrintWriter; import java.util.Scanner; public class Main {     public static void main(String[] args) throws Exception { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Enter numbers separated by comma:"); 
        String data = sc.nextLine(); 
        Scanner fileScanner = new Scanner(data);         fileScanner.useDelimiter(",");         int highest = Integer.MIN_VALUE;         int sumOfSeries = 0; 
while (fileScanner.hasNextInt()) {             int num = fileScanner.nextInt();             sumOfSeries += num;             if (num > highest) {                 highest = num; 
            } 
        } 
        fileScanner.close();         int naturalSum = highest * (highest + 1) / 2;         PrintWriter pw = new PrintWriter(System.out);         pw.println("Highest Number: " + highest);         pw.println("Sum of Given Numbers: " + sumOfSeries);         pw.println("Sum of Natural Numbers up to " + highest + ": " + naturalSum);         pw.flush();         pw.close();         sc.close(); 
    } 
} 
~~~
#helloworld.java
#code
~~~
public class ArraySum {     static int calculateSum(int[] arr) {         int sum = 0;         for (int i = 0; i < arr.length; i++) {             sum += arr[i]; 
        }         return sum; 
    } 
    public static void main(String[] args) {         int[] numbers = {10, 20, 30, 40, 50};         int result = calculateSum(numbers); 
        System.out.println("Sum of array elements: " + result); 
    } 
} 

#helloworld.java
#code
~~~
import java.util.Scanner; public class SmallestPositiveRoot {     public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
System.out.print("Enter coefficients a, b, and c: ");         int a = sc.nextInt();         int b = sc.nextInt();         int c = sc.nextInt();         double discriminant = b * b - 4 * a * c;         if (discriminant >= 0) {             double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);             double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);             if (root1 > 0 && root2 > 0) { 
                System.out.println("The smallest positive root is: " + Math.min(root1, root2)); 
            } else if (root1 > 0) { 
                System.out.println("The smallest positive root is: " + root1); 
            } else if (root2 > 0) { 
                System.out.println("The smallest positive root is: " + root2);             } else { 
                System.out.println("No positive roots."); 
            } 
        } else { 
            System.out.println("No real roots."); 
        }         sc.close(); 
    } 
}
#helloworld.java
#code
~~~
import java.util.Scanner; public class CheckCharacter {     public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);         System.out.print("Enter a character: ");         char ch = sc.next().charAt(0);         if (Character.isLetter(ch)) { 
            System.out.println("It is a Letter."); 
        } 
        else if (Character.isDigit(ch)) { 
            System.out.println("It is a Digit."); 
        } 
        else if (Character.isWhitespace(ch)) { 
            System.out.println("It is a Whitespace."); 
        }         else { 
            System.out.println("Other character."); 
        }         sc.close(); 
    } 
} 
~~~
#helloworld.java
#code
~~~
import java.util.Scanner; public class MathPractice {     public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in); 
        System.out.println("Equation 1: Calculate the height of a right triangle.");         System.out.print("Enter base (b): ");         double b = sc.nextDouble(); 
        System.out.print("Enter angle (theta in degrees): ");         double theta = sc.nextDouble();         double height = b * Math.tan(Math.toRadians(theta)); 
        System.out.println("Height: " + height); 
        System.out.println("\nEquation 2: Compound Interest Calculation.");         System.out.print("Enter Principal (P): ");         double P = sc.nextDouble(); 
        System.out.print("Enter Annual Interest Rate (r as a decimal): ");         double r = sc.nextDouble(); 
        System.out.print("Enter Number of Compounds per Year (n): "); 
        int n = sc.nextInt(); 
        System.out.print("Enter Time in Years (t): ");         double t = sc.nextDouble();         double A = P * Math.pow(1 + r / n, n * t); 
        System.out.println("Total Amount: " + A); 
        System.out.println("\nEquation 3: Convert Cartesian to Polar Coordinates.");         System.out.print("Enter x: ");         double x = sc.nextDouble();         System.out.print("Enter y: ");         double y = sc.nextDouble();         double rPolar = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));         double thetaPolar = Math.toDegrees(Math.atan(y / x)); 
        System.out.println("Radius: " + rPolar + ", Angle: " + thetaPolar + "°"); 
        System.out.println("\nEquation 4: Calculate Distance Between Two Points.");         System.out.print("Enter x1: ");         double x1 = sc.nextDouble();         System.out.print("Enter y1: ");         double y1 = sc.nextDouble();         System.out.print("Enter x2: ");         double x2 = sc.nextDouble();         System.out.print("Enter y2: ");         double y2 = sc.nextDouble();         double distance = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); 
        System.out.println("Distance: " + distance); 
        System.out.println("\nEquation 5: Solve Quadratic Equation.");         System.out.print("Enter coefficient a: ");         double a = sc.nextDouble(); 
        System.out.print("Enter coefficient b: ");         double bQuad = sc.nextDouble();         System.out.print("Enter coefficient c: ");         double c = sc.nextDouble();         double discriminant = Math.pow(bQuad, 2) - 4 * a * c;         if (discriminant >= 0) {             double root1 = (-bQuad + Math.sqrt(discriminant)) / (2 * a);             double root2 = (-bQuad - Math.sqrt(discriminant)) / (2 * a);             System.out.println("Roots: " + root1 + ", " + root2); 
            System.out.println("Smallest root: " + Math.min(root1, root2)); 
        } else { 
            System.out.println("No real roots."); 
        }         sc.close(); 
    } 
} 
~~~~


