package com.itheima.domain;

public class Repair {
    private Integer id;
    private String repairname;
    private String clientname;
    private String description;

    private String state;


    @Override
    public String toString() {
        return "Repair{" +
                "id=" + id +
                ", repairname='" + repairname + '\'' +
                ", clientname='" + clientname + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
