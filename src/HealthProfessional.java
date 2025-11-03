public class HealthProfessional {
    // Required instance variables: ID (numbers only), name
    private int id; // Using int to ensure ID is numeric only
    private String name;
    // Additional instance variable: specialty area (basic info for all health professionals)
    private String specialtyArea;

    // 1. Default constructor (no parameters)
    public HealthProfessional() {
        this.id = 0;
        this.name = "Unknown";
        this.specialtyArea = "General Health";
    }

    // 2. Full-parameter constructor (initializes all instance variables)
    public HealthProfessional(int id, String name, String specialtyArea) {
        // Data validation: ID cannot be negative
        if (id > 0) {
            this.id = id;
        } else {
            System.out.println("ID must be a positive number. Automatically set to 1.");
            this.id = 1;
        }
        this.name = name != null ? name : "Unknown"; // Avoid null values
        this.specialtyArea = specialtyArea != null ? specialtyArea : "General Health";
    }

    // 3. Method to print all instance variables
    public void printDetails() {
        System.out.println("Basic Information of Health Professional:");
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Specialty Area: " + this.specialtyArea);
    }

    // Getter methods (required for the Appointment class to access these attributes)
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpecialtyArea() {
        return specialtyArea;
    }
}