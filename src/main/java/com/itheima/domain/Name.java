package com.itheima.domain;

public class Name {
    private String clientname;
    private String companyname;

    private String repairname;


    @Override
    public String toString() {
        return "Name{" +
                "clientname='" + clientname + '\'' +
                ", companyname='" + companyname + '\'' +
                ", repairname='" + repairname + '\'' +
                '}';
    }

    public String getRepairname() {
        return repairname;
    }

    public void setRepairname(String repairname) {
        this.repairname = repairname;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
