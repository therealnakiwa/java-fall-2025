import javax.swing.JOptionPane;
import java.util.ArrayList;
public class IncidentRegistryApp {
    public static void main(String[] args) {
        ArrayList<Incident> registry = new ArrayList<Incident>();
        int duplicates = 0;
        for (int i = 0; i < 3; i++) {
            Incident inc = createIncidentFromDialogs();
            if (registry.contains(inc)) duplicates++;
            else registry.add(inc);
        }
        JOptionPane.showMessageDialog(null, buildSummary(registry, duplicates));
    }
    static String prompt(String message, String title) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.QUESTION_MESSAGE);
    }
    static IncidentType parseType(String s) {
        for (IncidentType t : IncidentType.values())
            if (s != null && t.name().equals(s.trim().toUpperCase())) return t;
        return IncidentType.OTHER;
    }
    static Severity parseSeverity(String s) {
        for (Severity v : Severity.values())
            if (s != null && v.name().equals(s.trim().toUpperCase())) return v;
        return Severity.LOW;
    }
    static Incident createIncidentFromDialogs() {
        String t = "New Incident";
        return new Incident(prompt("Reporter:", t),
                parseType(prompt("Type (PHISHING, MALWARE, ACCESS, NETWORK, OTHER):", t)),
                parseSeverity(prompt("Severity (LOW, MEDIUM, HIGH, CRITICAL):", t)),
                prompt("Description:", t));
    }
    static String buildSummary(ArrayList<Incident> registry, int duplicatesIgnored) {
        String s = "Incident Registry - Summary\n---------------------------\n"
                + "Incidents stored:    " + registry.size() + "\n"
                + "Duplicates ignored:  " + duplicatesIgnored + "\n\n";
        for (int i = 0; i < registry.size(); i++)
            s += (i + 1) + ") " + registry.get(i) + "\n";
        return s;
    }
}
enum IncidentType { PHISHING, MALWARE, ACCESS, NETWORK, OTHER }
enum Severity { LOW, MEDIUM, HIGH, CRITICAL }
class Incident {
    private String reporter, description;
    private IncidentType type;
    private Severity severity;
    public Incident() { this(null, null, null, null); }
    public Incident(String reporter, IncidentType type, Severity severity, String description) {
        this.setReporter(reporter);
        this.setType(type);
        this.setSeverity(severity);
        this.setDescription(description);
    }
    public String getReporter() { return reporter; }
    public IncidentType getType() { return type; }
    public Severity getSeverity() { return severity; }
    public String getDescription() { return description; }
    public void setReporter(String reporter) {
        this.reporter = (reporter == null || reporter.trim().isEmpty()) ? "Unknown" : reporter.trim();
    }
    public void setType(IncidentType type) {
        this.type = (type == null) ? IncidentType.OTHER : type;
    }
    public void setSeverity(Severity severity) {
        this.severity = (severity == null) ? Severity.LOW : severity;
    }
    public void setDescription(String description) {
        this.description = (description == null || description.trim().isEmpty()) ? "N/A" : description.trim();
    }
    public String toString() {
        return "Reporter: " + reporter + " | Type: " + type + " | Severity: " + severity
                + "\n   Description: " + description;
    } public boolean equals(Object obj) {
        if (!(obj instanceof Incident)) return false;
        Incident o = (Incident) obj;
        return reporter.equalsIgnoreCase(o.reporter) && type == o.type
                && description.equalsIgnoreCase(o.description);
    }
}