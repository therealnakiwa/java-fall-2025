import javax.swing.JOptionPane;
import java.nio.file.*;
import java.io.*;
import java.io.IOException;

public class BannedPasswordGate {
    public static void main(String[] args) throws IOException {
        int tries = 0;

        while (tries < 3) {
            String passwordTried = JOptionPane.showInputDialog("Try to create a unbanned password in 3 attempts");

            if (passwordTried == null) {
                break;
            }

            tries++;

            boolean isBanned = false;
            BufferedReader reader = new BufferedReader(new FileReader("banned-passwords.txt"));
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.equals(passwordTried)) {
                    isBanned = true;
                    break;
                }
            }
            reader.close();


            if (isBanned) {
                JOptionPane.showMessageDialog(null, "That password is banned! Try again.");
            } else {
                JOptionPane.showMessageDialog(null, "Access Granted!");

                FileWriter fw = new FileWriter("audit-log.txt", true);
                PrintWriter pw = new PrintWriter(fw);
                pw.println(passwordTried);
                pw.close();

                break;
            }
        }

        if (tries == 3) {
            JOptionPane.showMessageDialog(null, "too many attempts, goodbye");
        }
    }
}
