// Inherit from the base class HealthProfessional
public class GeneralPractitioner extends HealthProfessional {
    // Unique instance variable: daily patient limit (specific to general practitioners)
    private int dailyPatientLimit;

    // 1. Default constructor
    public GeneralPractitioner() {
        super(); // Call parent class's default constructor
        this.dailyPatientLimit = 20; // Default daily limit is 20 patients
    }

    // 2. Full-parameter constructor (including parent class attributes)
    public GeneralPractitioner(int id, String name, String specialtyArea, int dailyPatientLimit) {
        // Call parent class's full-parameter constructor to initialize inherited attributes
        super(id, name, specialtyArea);
        // Data validation: daily limit cannot be less than 0
        this.dailyPatientLimit = dailyPatientLimit > 0 ? dailyPatientLimit : 20;
    }

    // 3. Print detailed information (including type identifier and parent class attributes)
    public void printGPDetails() {
        System.out.println("=== Health Professional Type: General Practitioner ===");
        super.printDetails(); // Call parent class's print method to avoid code duplication
        System.out.println("Daily Patient Limit: " + this.dailyPatientLimit + " people");
        System.out.println("------------------------");
    }

    // Getter method (may be used later)
    public int getDailyPatientLimit() {
        return dailyPatientLimit;
    }
}