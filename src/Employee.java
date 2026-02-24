import java.util.ArrayList;


public class Employee {
    private String name;
    private String email;
    private String employeeId;

    public Employee(String name, String email, String employeeId) {
        this.name = name;
        this.email = email;
        this.employeeId = employeeId;
    }

    public String getNormalizedEmail() {
        return this.email.trim().toLowerCase();
    }

    public String describe() {
        return "Personel: " + name + " (ID: " + employeeId + ")";
    }
    
    public String getName() { return name; }
}


class Engineer extends Employee {
    private String specialty;

    public Engineer(String name, String email, String employeeId, String specialty) {
        super(name, email, employeeId);
        this.specialty = specialty;
    }

    @Override
    public String describe() {
        return super.describe() + ", Uzmanlık: Mühendis (" + specialty + ")";
    }
}


class Technician extends Employee {
    private int experienceYears;

    public Technician(String name, String email, String employeeId, int experienceYears) {
        super(name, email, employeeId);
        this.experienceYears = experienceYears;
    }

    public void maintenanceReport() {
        System.out.println(getName() + " bakım raporunu tamamladı.");
    }

    public void maintenanceReport(boolean includeTimestamp) {
        System.out.println(getName() + " bakım raporunu tamamladı. (Tarih eklendi)");
    }

    @Override
    public String describe() {
        return super.describe() + ", Teknisyen (" + experienceYears + " yıl tecrübe)";
    }
}


class Manager extends Employee {
    private ArrayList<Employee> team;

    public Manager(String name, String email, String employeeId) {
        super(name, email, employeeId);
        this.team = new ArrayList<>();
    }

    public void addTeamMember(Employee e) {
        team.add(e);
        System.out.println(e.getName() + ", yöneticinin ekibine eklendi.");
    }

    @Override
    public String describe() {
        return super.describe() + ", Yönetici (Ekip büyüklüğü: " + team.size() + ")";
    }
}