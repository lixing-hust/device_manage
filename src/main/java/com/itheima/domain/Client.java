package com.itheima.domain;

public class Client {
    private Integer id;
    private String clientname;
    private String phonenumber;
    private String description;
    private String companyname;


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", clientname='" + clientname + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", description='" + description + '\'' +
                ", companyname='" + companyname + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }
}
