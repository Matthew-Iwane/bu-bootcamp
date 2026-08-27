import java.io.*;
import java.util.ArrayList;

public class GradeAnalyzer {

    public static void main(String[] args) {
        String inputFile = "scores.txt";
        String outputFile = "report.txt";

        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores(inputFile);

        // Step 2: calculate statistics
        double avg = calculateAverage(scores);

        int maxScore = Integer.MIN_VALUE;
        int minScore = Integer.MAX_VALUE;

        for (int score : scores) {
            if (score > maxScore) maxScore = score;
            if (score < minScore) minScore = score;
        }
        if (scores.isEmpty()) {
            maxScore = 0;
            minScore = 0;
        }

        // Step 3: write and print report
        writeReport(scores, avg, maxScore, minScore, outputFile);
    }

    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                if (line.isEmpty()) {
                    continue;
                }

                try {
                    scores.add(Integer.parseInt(line));
                } catch (NumberFormatException e) {
                    System.out.println("Warning: invalid score: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Could not read file: " + e.getMessage());
        }

        return scores;
    }

    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.isEmpty()) {
            return 0.0;
        }

        double total = 0;
        for (int score : scores) {
            total += score;
        }

        return total / scores.size();
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low, String outputFile) {

        int A = 0;
        int B = 0;
        int C = 0;
        int D = 0;
        int F = 0;

        for (int score : scores) {
            if (score >= 90) {
                A++;
            } else if (score >= 80) {
                B++;
            } else if (score >= 70) {
                C++;
            } else if (score >= 60) {
                D++;
            } else {
                F++;
            }
        }

        String report;
        if (scores.isEmpty()) {
            report = String.format("=== Grade Analysis Report ===%nNo valid scores found.%n");
        } else {
            report = String.format(
                "=== Grade Analysis Report ===%n" +
                "Total scores processed: %d%n%n" +
                "Average score: %.2f%n" +
                "Highest score: %d%n" +
                "Lowest score: %d%n%n" +
                "Grade distribution:%n" +
                "  A (90-100): %d%n" +
                "  B (80-89): %d%n" +
                "  C (70-79): %d%n" +
                "  D (60-69): %d%n" +
                "  F (below 60): %d%n",
                scores.size(), avg, high, low,
                A, B, C, D, F
            );
        }

        System.out.print(report);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(report);
        } catch (IOException e) {
            System.out.println("Could not write report: " + e.getMessage());
        }
    }
}