package in.karan.suman.bloodbanktracker;

/**
 * Created by Suman on 28-Oct-17.
 */

public class Subject {


    private String state,district,hospital,value;


    public Subject(){}
    public Subject(String state,String district,String hospital,String value) {

        this.state = state;
        this.district = district;
        this.hospital = hospital;
        this.value=value;

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }


}
