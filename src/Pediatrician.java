// Inherit from the base class HealthProfessional
public class Pediatrician extends HealthProfessional {
    // Unique instance variable: age range of expertise (specific to pediatricians)
    private String ageRange;

    // 1. Default constructor
    public Pediatrician() {
        super();
        this.ageRange = "0-12 years"; // Default expertise in 0-12 year olds
    }

    // 2. Full-parameter constructor (including parent class attributes)
    public Pediatrician(int id, String name, String specialtyArea, String ageRange) {
        super(id, name, specialtyArea);
        // Data validation: age range cannot be empty
        this.ageRange = ageRange != null ? ageRange : "0-12 years";
    }

    // 3. Print detailed information (including type identifier)
    public void printPediatricianDetails() {
        System.out.println("=== Health Professional Type: Pediatrician ===");
        super.printDetails(); // Reuse parent class method
        System.out.println("Expertise Age Range: " + this.ageRange);
        System.out.println("------------------------");
    }

    // Getter method
    public String getAgeRange() {
        return ageRange;
    }
}