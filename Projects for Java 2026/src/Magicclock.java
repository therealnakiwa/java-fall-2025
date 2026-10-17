/**
 * This program will let us know if a date is magical, based on the sum of month and day, if they equal 2 digit years, then it
 * is a magic date
 */
import javax.swing.JOptionPane;
public class Magicclock {
    public static void main(String[] args) {
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter Year "));
        int month = Integer.parseInt(JOptionPane.showInputDialog("Enter Month "));
        int day = Integer.parseInt(JOptionPane.showInputDialog("Enter Day "));
        int result = month * day;

        if (result == year){
            System.out.println("Your DOB is a magic date");
        } else{
            System.out.println("Your DOB is not a magic date");
        }

    }

}
