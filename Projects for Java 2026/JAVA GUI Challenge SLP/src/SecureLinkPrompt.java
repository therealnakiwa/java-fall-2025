import javax.swing.JOptionPane;

///
    public class SecureLinkPrompt {
    public static void main(String[] args) {
        String userurl = JOptionPane.showInputDialog("Enter a URL");
        if (userurl.contains("http://")) {
            JOptionPane.showMessageDialog(null, userurl + " is not secure URL");
        } else if (userurl.contains("https://")) {
            JOptionPane.showMessageDialog(null, userurl + " is a secure URL");
        } else {
            JOptionPane.showMessageDialog(null, userurl + " contains unknown protocol");
        }
    }
}