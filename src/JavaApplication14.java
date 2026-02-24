import java.util.ArrayList;

public class JavaApplication14 {
    public static void main(String[] args) {
        System.out.println(" OTONOM FİLO SİSTEMİ \n");

        FleetControlCenter center = new FleetControlCenter();

        
        Car car1 = new Car("TOGG T10F", "C-101", 4);
        CargoBot bot1 = new CargoBot("Amazon Scout", "B-202", 50.0);
        GroundDrone drone1 = new GroundDrone("Boston Dynamics Spot", "D-303", 5);

        
        car1.addModule(new NavigationModule("Google Maps Nav", "2.0", "Global-2025"));
        car1.addModule(new SafetyModule("Volvo Safety", "1.1", 1));
        
        AIControlModule aiMod = new AIControlModule("NVIDIA Drive", "3.5", "Standard Pilot");
        bot1.addModule(aiMod);
        aiMod.updateModel("Advanced Pilot Pro", true);

       
        Engineer eng = new Engineer("Batin Derse", " batinderse@gmail.com ", "E-01", "AI Systems");
        Technician tech = new Technician("Yusuf Demir", "yusufdemir@gmail.com", "T-01", 5);
        Manager mgr = new Manager("Yunus Akgun", "yunusakgun@gmail.com", "M-01");

        mgr.addTeamMember(eng);
        mgr.addTeamMember(tech);

        
        Mission m1 = new Mission("M-001", "Fabrika sahasının termal kamera ile taranmasi.");
        m1.assignVehicle(drone1);
        m1.assignEmployee(tech);

     
        center.addVehicle(car1);
        center.addVehicle(bot1);
        center.addVehicle(drone1);
        
        center.addEmployee(eng);
        center.addEmployee(tech);
        center.addMission(m1);

        
        System.out.println("\n Gorev Arama ('thermal'):");
        ArrayList<Mission> searchResults = center.searchMission("thermal");
        for (Mission m : searchResults) {
            System.out.println("Bulunan Gorev: " + m);
            drone1.scan("thermal"); 
        }

        center.listVehiclesByStatus();

        System.out.println("Personel Detaylari:");
        System.out.println(eng.describe()); 
        System.out.println(tech.describe()); 
        System.out.println(mgr.describe());
        
        System.out.println("\n Şarj Testi:");
        bot1.setBatteryLevel(10);
        bot1.charge(); 
    }
}