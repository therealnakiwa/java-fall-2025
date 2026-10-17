import javax.swing.JOptionPane;

public class AverageGrade {
    static double calcAverage(double s1, double s2, double s3, double s4, double s5) {
        double total = s1 + s2 + s3 + s4 + s5;
        return total / 5;

    }
    static String determineGrade(double score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }
    static double getValidScore(String dscore) {
        double score = Double.parseDouble(JOptionPane.showInputDialog(dscore));
        while (score <= 0 || score >= 100) {
            JOptionPane.showMessageDialog(null, "Score must be between 0 and 100. Please try again.");
            score = Double.parseDouble(JOptionPane.showInputDialog(dscore));
        }
        return score;
    }
    public static void main(String[] args) {
        double s1 = getValidScore("Score #1:");
        double s2 = getValidScore("Score #2:");
        double s3 = getValidScore("Score #3:");
        double s4 = getValidScore("Score #4:");
        double s5 = getValidScore("Score #5:");
        String g1 = determineGrade(s1);
        String g2 = determineGrade(s2);
        String g3 = determineGrade(s3);
        String g4 = determineGrade(s4);
        String g5 = determineGrade(s5);
        double average = calcAverage(s1, s2, s3, s4, s5);
        String averageGrade = determineGrade(average);
        String results = "Test Average and Grade - Results\n"
                + "Score 1: " + s1 + "   " + g1 + "\n"
                + "Score 2: " + s2 + "   " + g2 + "\n"
                + "Score 3: " + s3 + "   " + g3 + "\n"
                + "Score 4: " + s4 + "   " + g4 + "\n"
                + "Score 5: " + s5 + "   " + g5 + "\n"
                + "Average: " + String.format("%.2f",average) + "\n"
                + "Grade: " + averageGrade;
        JOptionPane.showMessageDialog(null, results);
    }
}