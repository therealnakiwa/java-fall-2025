import javax.swing.JOptionPane;
import java.util.ArrayList;
public class NumberListAnalyzerApp {
    public static String prompt(String message, String title){
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }
    static class NumberStats{
        private int count;
        private double sum;
        private double min;
        private double max;
        public void add(double value){
            if (count == 0 || value < min) min = value;
            if (count == 0 || value > max) max = value;
            sum += value;
            count++;

        }
        public double getAverage(){
            return count == 0 ? 0 : sum / count;
        }
        public String toString(){
            return String.format("Sum: %.2f\nAverage: %.2f\n Min: %.2f\n Max: %.2f", sum, getAverage(), min, max);
        }

    }
    public static Double tryParseDouble(String tok){
        if (tok.matches("[+-]?(\\d+\\.?\\d*|\\.\\d+)")) {
            return Double.parseDouble(tok);
        }
        return null;
    }
    public static String[] tokenize(String pUser){
        return pUser.trim().split("[;\\s]+");
    }
    public static String cleanToken(String tok){
        return tok.trim().replace("$", "").replace(",", "");
    }
    private static final String titulo = "Number List Analyszer";
    public static void main(String[] args){
        String pUser = prompt("Enter a single line of values", titulo);
        if (pUser == null || pUser.trim().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Nothing to analyze, good bye.");
            return;
        }
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<String> invalid = new ArrayList<>();
        NumberStats stats = new NumberStats();
        for (String tok : tokenize(pUser)){
            String cleaned = cleanToken(tok);
            if (cleaned.isEmpty()) continue;
            Double d = tryParseDouble(cleaned);
            if (d != null) {
                values.add(d);
                stats.add(d);
            } else {
                invalid.add(tok);
            }
        }
        String summary = "Number List Analyzer - Summary\n"
                + "------------------------------\n"
                + "Valid values (" + values.size() + "): " + values + "\n"
                + "Invalid tokens (" + invalid.size() + "): "
                + (invalid.isEmpty() ? "(none)" : invalid.toString()) + "\n\n"
                + stats;

        JOptionPane.showMessageDialog(null, summary);


    }


}
