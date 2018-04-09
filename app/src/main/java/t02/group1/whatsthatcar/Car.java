package t02.group1.whatsthatcar;

/**
 * Created by Administrator on 2018/4/8.
 */

public class Car {
    private String make;
    private String model;
    private String Year;
    private String EngineFuelType;
    private String EngineHP;
    private String EngineCylinders;

    public Car(String str[])
    {
        make = str[0];
        model = str[1];
        Year = str[2];
        EngineFuelType = str[3];
        EngineHP = str[4];
        EngineCylinders    = str[5];
        TransmissionType = str[6];
        Driven_Wheels = str[7];
        NumberofDoors = str[8];
        MarketCategory = str[9];
        VehicleSize = str[10];
        VehicleStyle = str[11];
        highwayMPG = str[12];
        citympg = str[13];
        Popularity = str[14];
        MSRP = str[15];
    }
    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getEngineFuelType() {
        return EngineFuelType;
    }

    public void setEngineFuelType(String engineFuelType) {
        EngineFuelType = engineFuelType;
    }

    public String getEngineHP() {
        return EngineHP;
    }

    public void setEngineHP(String engineHP) {
        EngineHP = engineHP;
    }

    public String getEngineCylinders() {
        return EngineCylinders;
    }

    public void setEngineCylinders(String engineCylinders) {
        EngineCylinders = engineCylinders;
    }

    public String getTransmissionType() {
        return TransmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        TransmissionType = transmissionType;
    }

    public String getDriven_Wheels() {
        return Driven_Wheels;
    }

    public void setDriven_Wheels(String driven_Wheels) {
        Driven_Wheels = driven_Wheels;
    }

    public String getNumberofDoors() {
        return NumberofDoors;
    }

    public void setNumberofDoors(String numberofDoors) {
        NumberofDoors = numberofDoors;
    }

    public String getMarketCategory() {
        return MarketCategory;
    }

    public void setMarketCategory(String marketCategory) {
        MarketCategory = marketCategory;
    }

    public String getVehicleSize() {
        return VehicleSize;
    }

    public void setVehicleSize(String vehicleSize) {
        VehicleSize = vehicleSize;
    }

    public String getVehicleStyle() {
        return VehicleStyle;
    }

    public void setVehicleStyle(String vehicleStyle) {
        VehicleStyle = vehicleStyle;
    }

    public String getHighwayMPG() {
        return highwayMPG;
    }

    public void setHighwayMPG(String highwayMPG) {
        this.highwayMPG = highwayMPG;
    }

    public String getCitympg() {
        return citympg;
    }

    public void setCitympg(String citympg) {
        this.citympg = citympg;
    }

    public String getPopularity() {
        return Popularity;
    }

    public void setPopularity(String popularity) {
        Popularity = popularity;
    }

    public String getMSRP() {
        return MSRP;
    }

    public void setMSRP(String MSRP) {
        this.MSRP = MSRP;
    }

    private String TransmissionType;
    private String Driven_Wheels;
    private String NumberofDoors;
    private String MarketCategory;
    private String VehicleSize;
    private String VehicleStyle;
    private String highwayMPG;
    private String citympg;
    private String Popularity;
    private String MSRP;
    public String toString()
    {
        return "make:" + make
                + "\nModel:" + model
                + "\nYear:" + Year
                + "\nEngine FuelType:" + EngineFuelType
                + "\nEngine HP:" + EngineHP
                + "\nEngine Cylinders:" + EngineCylinders
                + "\nTransmission Type:" + TransmissionType
                + "\nDriven_Wheels:" + Driven_Wheels
                + "\nNumber of Doors:" + NumberofDoors
                + "\nMarket Category:" + MarketCategory
                + "\nVehicle Size:" + VehicleSize
                + "\nVehicle Style:" + VehicleStyle
                + "\nhighway MPG:" + highwayMPG
                + "\ncity mpg:" + citympg
                + "\nPopularity:" + Popularity
                + "\nMSRP:" + MSRP + "\n";

    }
}
