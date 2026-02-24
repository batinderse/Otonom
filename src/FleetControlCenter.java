import java.util.ArrayList;

public class FleetControlCenter {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Employee> employees;
    private ArrayList<Mission> missions;

    public FleetControlCenter() {
        this.vehicles = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.missions = new ArrayList<>();
    }

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
    }

    public void addEmployee(Employee e) {
        employees.add(e);
    }

    public void addMission(Mission m) {
        missions.add(m);
    }

    public ArrayList<Mission> searchMission(String keyword) {
        ArrayList<Mission> results = new ArrayList<>();
        for (Mission m : missions) {
            if (m.containsKeyword(keyword)) {
                results.add(m);
            }
        }
        return results;
    }

    public void listVehiclesByStatus() {
        System.out.println("\n FİLO DURUM RAPORU ");
        for (Vehicle v : vehicles) {
            System.out.println(v.getStatus());
        }
        System.out.println("-------------------------\n");
    }
}