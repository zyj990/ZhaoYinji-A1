import java.util.ArrayList;
import java.util.Iterator;

public class AssignmentOne {
    // Declare static ArrayList (stores appointment objects, shared by all methods)
    private static ArrayList<Appointment> appointmentList = new ArrayList<>();

    public static void main(String[] args) {
        // ==================== Part 3 – Using classes and objects ====================
        System.out.println("=================== Part 3: Creation and Information Printing of Health Professional Objects ====================");
        // 1. Create 3 general practitioner objects
        GeneralPractitioner gp1 = new GeneralPractitioner(101, "Dr. Zhang", "General Medicine", 25);
        GeneralPractitioner gp2 = new GeneralPractitioner(102, "Dr. Li", "General Medicine", 22);
        GeneralPractitioner gp3 = new GeneralPractitioner(103, "Dr. Wang", "General Medicine", 18);

        // 2. Create 2 pediatrician objects
        Pediatrician ped1 = new Pediatrician(201, "Dr. Liu", "Child Health", "0-6 years");
        Pediatrician ped2 = new Pediatrician(202, "Dr. Chen", "Child Health", "7-14 years");

        // 3. Print information of all health professionals
        gp1.printGPDetails();
        gp2.printGPDetails();
        gp3.printGPDetails();
        ped1.printPediatricianDetails();
        ped2.printPediatricianDetails();

        // Add separator as required
        System.out.println("------------------------------");

        // ==================== Part 5 – Collection of appointments ====================
        System.out.println("\n=================== Part 5: Appointment Collection Management ====================");
        // 1. Create 2 appointments with general practitioners
        createAppointment("Xiao Ming", "13800138000", "08:30", gp1);
        createAppointment("Xiao Hong", "13900139000", "10:15", gp2);

        // 2. Create 2 appointments with pediatricians
        createAppointment("Xiao Gang", "13700137000", "14:00", ped1);
        createAppointment("Xiao Li", "13600136000", "15:30", ped2);

        // 3. Print all appointments
        System.out.println("\n[First Print] All current appointments:");
        printExistingAppointments();

        // 4. Cancel an appointment (example with mobile number 13900139000)
        System.out.println("\n[Cancel Appointment] Attempting to cancel appointment with mobile number 13900139000:");
        cancelBooking("13900139000");

        // 5. Print appointments again (verify cancellation effect)
        System.out.println("\n[Second Print] Appointment list after cancellation:");
        printExistingAppointments();

        // Add separator as required
        System.out.println("------------------------------");
    }

    // ------------------------------ Methods required by Part 5 ------------------------------
    /**
     * Create an appointment and add it to the collection (supports polymorphism, can handle any HealthProfessional subclass object)
     * @param patientName Patient's name
     * @param patientMobile Patient's mobile number
     * @param timeSlot Appointment time
     * @param doctor Treating doctor (general practitioner/pediatrician, polymorphic parameter)
     */
    public static void createAppointment(String patientName, String patientMobile, String timeSlot, HealthProfessional doctor) {
        // Validate all required information (avoid creating invalid appointments)
        if (patientName == null || patientMobile == null || timeSlot == null || doctor == null) {
            System.out.println("Failed to create appointment: All information (name, mobile, time, doctor) cannot be empty!");
            return;
        }
        // Create appointment object and add to collection
        Appointment newAppt = new Appointment(patientName, patientMobile, timeSlot, doctor);
        appointmentList.add(newAppt);
        System.out.println("Appointment created successfully! Patient: " + patientName + ", Doctor: " + doctor.getName());
    }

    /**
     * Print all existing appointments (prompt if none)
     */
    public static void printExistingAppointments() {
        if (appointmentList.isEmpty()) {
            System.out.println("No appointment records currently.");
            return;
        }
        System.out.println("Total existing appointments: " + appointmentList.size());
        for (Appointment appt : appointmentList) {
            appt.printAppointmentDetails(); // Call appointment object's print method
        }
    }

    /**
     * Cancel an appointment by mobile number (prompt if no match)
     * @param mobile Patient's mobile number
     */
    public static void cancelBooking(String mobile) {
        // Use iterator to traverse (avoid ConcurrentModificationException)
        Iterator<Appointment> iterator = appointmentList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Appointment appt = iterator.next();
            if (appt.getPatientMobile().equals(mobile)) {
                iterator.remove(); // Safely remove the appointment
                System.out.println("Cancellation successful! Appointment with mobile number " + mobile + " has been deleted.");
                found = true;
                break; // Assume one mobile number corresponds to one appointment, exit loop after finding
            }
        }

        if (!found) {
            System.out.println("Cancellation failed: No appointment record found with mobile number " + mobile + ".");
        }
    }
}