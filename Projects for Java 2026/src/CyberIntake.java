import javax.swing.JOptionPane;

public class CyberIntake {
    public static void main(String[] args) {
        String yourName = JOptionPane.showInputDialog("Your full name");
        String YourGrade = JOptionPane.showInputDialog("Your Role/Title");
        String YourSchool = JOptionPane.showInputDialog("What School do you go to?");
        String alltogether = yourName + " a is a " + YourGrade + " at " + YourSchool;
        JOptionPane.showMessageDialog(null, alltogether);
    }
}



