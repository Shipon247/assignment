import java.util.Scanner;

public class SeriesSum{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input: Number of cases
        System.out.print("Number of cases you want to try: ");
        int cases = scanner.nextInt();

        for (int i = 1; i <= cases; i++) {
            // Input: Ending value for the series in each case
            System.out.print("Case " + i + ": Enter n" + i + ": ");
            int n = scanner.nextInt();

            // Generate the series
            StringBuilder series = new StringBuilder();
            for (int j = 1; j <= n; j++) {
                series.append(j);
                if (j < n) {
                    series.append("+");
                }
            }

            // Calculate the sum using Gauss' formula
            int sum = n * (n + 1) / 2;

            // Output the result
            System.out.println(series + " = " + sum);
        }

        scanner.close();
    }
}