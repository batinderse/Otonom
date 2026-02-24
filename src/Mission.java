import java.util.ArrayList;

public class Mission {
    private String missionId;
    private String description;
    private ArrayList<Vehicle> assignedVehicles;
    private ArrayList<Employee> responsibleStaff;

    public Mission(String missionId, String description) {
        this.missionId = missionId;
        this.description = description;
        this.assignedVehicles = new ArrayList<>();
        this.responsibleStaff = new ArrayList<>();
    }

    public void assignVehicle(Vehicle v) {
        assignedVehicles.add(v);
        System.out.println("Araç " + v.getModel() + " göreve atandı.");
    }

    public void assignEmployee(Employee e) {
        responsibleStaff.add(e);
        System.out.println("Personel " + e.getName() + " göreve atandı.");
    }

    public boolean containsKeyword(String keyword) {
        return description.toLowerCase().contains(keyword.toLowerCase());
    }

    @Override
    public String toString() {
        return "Görev ID: " + missionId + " - " + description;
    }
}