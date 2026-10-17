import javax.swing.*;

class SecurityIncident {
        private String id;
        private String reporter;
        private String category;
        private int severity;
        private String description;
        public SecurityIncident() {
            id = "";
            reporter = "";
            category = "";
            severity = 1;
            description = "";
        }
        public SecurityIncident(String newReporter, String newCategory, int newSeverity, String newDescription){
            id = "";
            reporter = newReporter;
            category = newCategory;
            severity = newSeverity;
            description = newDescription;


        }
        public void escalate(){
            if (severity < 5){
                severity = severity + 1;
            }
        }
        public String summary(){
            return "Incident Summary \n" + "Reporter: " + reporter + "\nCategory: " +
                    category + "\n Severity: " + severity + "\nDescrption: " + description;

        }




}
