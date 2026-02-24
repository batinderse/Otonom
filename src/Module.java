public class Module {
    private String name;
    private String version;

    public Module(String name, String version) {
        this.name = name;
        this.version = version;
    }

    public String getInfo() {
        return "Modül: " + name + " v" + version;
    }
}


class NavigationModule extends Module {
    private String mapVersion;

    public NavigationModule(String name, String version, String mapVersion) {
        super(name, version);
        this.mapVersion = mapVersion;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Harita: " + mapVersion;
    }
}


class SafetyModule extends Module {
    private int riskLevel;

    public SafetyModule(String name, String version, int riskLevel) {
        super(name, version);
        this.riskLevel = riskLevel;
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", Risk Seviyesi: " + riskLevel;
    }
}


class AIControlModule extends Module {
    private String modelName;

    public AIControlModule(String name, String version, String modelName) {
        super(name, version);
        this.modelName = modelName;
    }

    public void updateModel(String newModel) {
        this.modelName = newModel;
        System.out.println("AI Modeli güncellendi: " + newModel);
    }

    public void updateModel(String newModel, boolean verbose) {
        this.modelName = newModel;
        if (verbose) {
            System.out.println("AI Detaylı Güncelleme: Eski model silindi, yeni model " + newModel + " yüklendi.");
        }
    }

    @Override
    public String getInfo() {
        return super.getInfo() + ", AI Model: " + modelName;
    }
}