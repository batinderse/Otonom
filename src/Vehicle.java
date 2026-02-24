import java.util.ArrayList;


public class Vehicle {
    private String model;
    private String serialNumber;
    private double batteryLevel;
    private ArrayList<Module> modules;

    public Vehicle() {
        this.model = "Unknown";
        this.serialNumber = "0000";
        this.batteryLevel = 100;
        this.modules = new ArrayList<>();
    }

    public Vehicle(String model, String serialNumber) {
        this.model = model;
        this.serialNumber = serialNumber;
        this.batteryLevel = 100; // Varsayılan tam şarj
        this.modules = new ArrayList<>();
    }

    public String getModel() { return model; }
    public double getBatteryLevel() { return batteryLevel; }

    public void setBatteryLevel(double batteryLevel) {
        if (batteryLevel >= 0 && batteryLevel <= 100) {
            this.batteryLevel = batteryLevel;
        } else {
            System.out.println("Hata: Batarya seviyesi 0-100 arasında olmalıdır.");
        }
    }

    public void addModule(Module m) {
        this.modules.add(m);
        System.out.println(m.getClass().getSimpleName() + " eklendi: " + this.model);
    }

    //overloading
    public void charge(double amount) {
        double newLevel = this.batteryLevel + amount;
        setBatteryLevel(newLevel > 100 ? 100 : newLevel);
        System.out.println("Araç şarj edildi (+" + amount + "%). Mevcut: " + this.batteryLevel + "%");
    }

    public void charge() {
        this.batteryLevel = 100;
        System.out.println("Araç tam şarj edildi.");
    }

    public String getStatus() {
        return "Model: " + model + ", Seri No: " + serialNumber + ", Batarya: %" + batteryLevel;
    }
}


class Car extends Vehicle {
    private int passengerCapacity;

    public Car(String model, String serialNumber, int passengerCapacity) {
        super(model, serialNumber);
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public String getStatus() {
        return super.getStatus() + ", Kapasite: " + passengerCapacity + " yolcu";
    }
}


class CargoBot extends Vehicle {
    private double maxLoadKg;
    private double currentLoad;

    public CargoBot(String model, String serialNumber, double maxLoadKg) {
        super(model, serialNumber);
        this.maxLoadKg = maxLoadKg;
        this.currentLoad = 0;
    }

    public void load(double kg) {
        if (currentLoad + kg <= maxLoadKg) {
            currentLoad += kg;
            System.out.println(kg + "kg yüklendi. Güncel yük: " + currentLoad);
        } else {
            System.out.println("Hata: Kapasite aşıldı! Maks: " + maxLoadKg);
        }
    }

    public void unload() {
        currentLoad = 0;
        System.out.println("Yük boşaltıldı.");
    }

    @Override
    public String getStatus() {
        return super.getStatus() + ", Yük: " + currentLoad + "/" + maxLoadKg + "kg";
    }
}


class GroundDrone extends Vehicle {
    private int sensorCount;

    public GroundDrone(String model, String serialNumber, int sensorCount) {
        super(model, serialNumber);
        this.sensorCount = sensorCount;
    }

    
    public void scan() {
        System.out.println(getModel() + " genel tarama yapıyor...");
    }

    public void scan(String mode) {
        System.out.println(getModel() + " " + mode + " modunda tarama yapıyor...");
    }

    @Override
    public String getStatus() {
        return super.getStatus() + ", Sensör Sayısı: " + sensorCount;
    }
}