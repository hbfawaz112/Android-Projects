package com.example.bbmc;
//All donor class :
public class Donor {
    private String id;
    private String fname;
    private String lname;
    private String databirth;
    private String phnb;
    private String blood_type;
    private String iscorona;

    public Donor(String id, String fname, String lname, String databirth, String phnb, String blood_type) {

        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.databirth = databirth;
        this.phnb = phnb;
        this.blood_type = blood_type;
        //this.iscorona = iscorona ;
    }
    public Donor(String id, String fname, String lname, String databirth, String phnb, String blood_type, String iscorona) {

        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.databirth = databirth;
        this.phnb = phnb;
        this.blood_type = blood_type;
        this.iscorona = iscorona ;
    }

    public String getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getDatabirth() {
        return databirth;
    }

    public String getPhnb() {
        return phnb;
    }

    public String getBlood_type() {
        return blood_type;
    }

    public String getIscorona() { return iscorona; }
}
