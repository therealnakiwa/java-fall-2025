import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;
//This code lets the user input various extensions that should be blocked by the program, then it
// asks the user to put three filenames which will be judged by their

public class BlockedAttachmentFilter {
    public static void main(String[] args) {
        String[] bExtensions = {"exe", "bat", "js", "vbs", "scr", "ps1"};
        ArrayList<String> blocked = new ArrayList<>();
        Collections.addAll(blocked, bExtensions);
        ArrayList<String> uInput = new ArrayList();

        for (int i = 0; i < 3; i++) {
            String uExt = JOptionPane.showInputDialog("Insert up to 3 extensions for block");
            if (uExt == null || uExt.length() == 0) {
                break;
            }
            uExt = uExt.trim().toLowerCase();
            if (uExt.startsWith(".")){
                uExt = uExt.substring(1);

            }
            if (uExt.length() == 0){
                break;

            }
            blocked.add(uExt);
        }
        String fReport = "";
        int bCount = 0;
        for (int i = 1; i<= 3; i++){
            String filename = JOptionPane.showInputDialog("Enter filename " + i + "of 3: ").trim();
            String ext = "";
            String result;
            int dot = filename.lastIndexOf(".");
            if(dot !=-1){
                ext = filename.substring(dot + 1).toLowerCase();
            }
            if(blocked.contains(ext)){
                result = "Blocked";
                bCount++;
            } else{
                result = "OK";
            }
            fReport += i + ") \"" + filename + "\"  -> " + result + "\n";
            }
        Collections.sort(blocked);
        String summary = "Blocked Attachment Filter - Summary\n"
                + "-----------------------------------\n"
                + "Final blocked extensions:\n"
                + String.join(", ", blocked) + "\n\n"
                + "Files checked:\n"
                + fReport + "\n"
                + "Blocked: " + bCount + " of 3";
        JOptionPane.showMessageDialog(null,summary);



    }
    }
