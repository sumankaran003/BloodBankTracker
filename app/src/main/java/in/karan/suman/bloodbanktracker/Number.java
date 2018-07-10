package in.karan.suman.bloodbanktracker;

/**
 * Created by Suman on 29-Oct-17.
 */





public class Number {


    private String state,district,hospital,value;
    Long count;


    public Number(){}
    public Number(String state,String district,String hospital,String value,Long count) {

        this.state = state;
        this.district = district;
        this.hospital = hospital;
        this.value=value;
        this.count=count;

    }
    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
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

