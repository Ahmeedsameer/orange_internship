package Vehicles;

import java.util.Map;

public abstract class vehicle {
    private String registeration_number;
    private String vechiltype ;
    private String fueltype ;
    private boolean is_Available;
    private Map<String,Object> features;

    public vehicle(String vechiltype, String fueltype, String registerationn_number, boolean is_Available, Map<String, Object> features) {
        this.vechiltype = vechiltype;
        this.fueltype = fueltype;
        this.registeration_number = registerationn_number;
        this.is_Available = is_Available;
        this.features = features;
    }

    public String getRegisterationn_number() {
        return registeration_number;
    }

    public void setRegisterationn_number(String registerationn_number) {
        this.registeration_number = registerationn_number;
    }

    public String getVechiltype() {
        return vechiltype;
    }

    public void setVechiltype(String vechiltype) {
        this.vechiltype = vechiltype;
    }

    public String getFueltype() {
        return fueltype;
    }

    public void setFueltype(String fueltype) {
        this.fueltype = fueltype;
    }

    public boolean isIs_Available() {
        return is_Available;
    }

    public void setIs_Available(boolean is_Available) {
        this.is_Available = is_Available;
    }

    public Map<String, Object> getFeatures() {
        return features;
    }

    public void setFeatures(Map<String, Object> features) {
        this.features = features;
    }
    public abstract double calculatePrice();
    public abstract String gettype();
}
