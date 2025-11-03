public class Appointment {
    // Patient information: name, mobile number (no need for a Patient class as per requirements)
    private String patientName;
    private String patientMobile;
    // Appointment time (format like "08:00", "14:30")
    private String timeSlot;
    // Treating doctor (parent class reference, supports polymorphism, can point to general/pediatrician objects)
    private HealthProfessional doctor;

    // 1. Default constructor
    public Appointment() {
        this.patientName = "Unknown";
        this.patientMobile = "12345678901";
        this.timeSlot = "09:00";
        this.doctor = new HealthProfessional();
    }

    // 2. Full-parameter constructor (initializes all attributes)
    public Appointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        // Data validation: critical information cannot be empty
        this.patientName = patientName != null ? patientName : "Unknown";
        // Mobile number validation (simple check for 11-digit number, conforming to domestic mobile number rules)
        if (patientMobile != null && patientMobile.matches("\\d{11}")) {
            this.patientMobile = patientMobile;
        } else {
            System.out.println("Invalid mobile number format (requires 11 digits). Automatically set to 12345678901.");
            this.patientMobile = "12345678901";
        }
        // Time format validation (simple check for "HH:MM")
        if (timeSlot != null && timeSlot.matches("([01]\\d|2[0-3]):[0-5]\\d")) {
            this.timeSlot = timeSlot;
        } else {
            System.out.println("Invalid time format (requires HH:MM). Automatically set to 09:00.");
            this.timeSlot = "09:00";
        }
        this.doctor = doctor != null ? doctor : new HealthProfessional();
    }

    // 3. Print all appointment information
    public void printAppointmentDetails() {
        System.out.println("=== Appointment Details ===");
        System.out.println("Patient Name: " + this.patientName);
        System.out.println("Patient Mobile: " + this.patientMobile);
        System.out.println("Appointment Time: " + this.timeSlot);
        System.out.println("Treating Doctor Information:");
        // Print doctor information (parent class method, polymorphism takes effect)
        doctor.printDetails();
        // Additional print of doctor's subclass-specific information (requires downcasting, judge doctor type)
        if (doctor instanceof GeneralPractitioner) {
            GeneralPractitioner gp = (GeneralPractitioner) doctor;
            System.out.println("Doctor's Daily Patient Limit: " + gp.getDailyPatientLimit() + " people");
        } else if (doctor instanceof Pediatrician) {
            Pediatrician ped = (Pediatrician) doctor;
            System.out.println("Doctor's Expertise Age Range: " + ped.getAgeRange());
        }
        System.out.println("------------------------");
    }

    // Getter method (required for finding appointments by mobile number when canceling)
    public String getPatientMobile() {
        return patientMobile;
    }
}