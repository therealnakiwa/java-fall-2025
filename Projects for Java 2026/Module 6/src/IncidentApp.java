import javax.swing.JOptionPane;

    public class IncidentApp {
        public static void main(String[] args) {
            String inputReporter = JOptionPane.showInputDialog("Enter name of reporter");
            String inputCategory = JOptionPane.showInputDialog("Enter category of incident");
            String inputDeverity = JOptionPane.showInputDialog("Enter the severity");
            String inputDescription = JOptionPane.showInputDialog("Enter the description of the incident");
            int inputSeverity = Integer.parseInt(inputDeverity);
            SecurityIncident incident = new SecurityIncident(inputReporter, inputCategory, inputSeverity, inputDescription);
            incident.escalate();
            JOptionPane.showMessageDialog(null, incident.summary());
        }

    }
