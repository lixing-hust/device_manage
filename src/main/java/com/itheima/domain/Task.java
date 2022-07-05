package com.itheima.domain;

public class Task {

    private Integer id;
    private String clientname;
    private String description;
    private String state;

    private String repairname;
    public Task() {
    }


    public Task(Integer id, String clientname, String description, String state, String repairname) {
        this.id = id;
        this.clientname = clientname;
        this.description = description;
        this.state = state;
        this.repairname = repairname;
    }

    public Task(String clientname, String description, String state, String repairname) {
        this.clientname = clientname;
        this.description = description;
        this.state = state;
        this.repairname = repairname;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", clientname='" + clientname + '\'' +
                ", description='" + description + '\'' +
                ", state='" + state + '\'' +
                ", repairname='" + repairname + '\'' +
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

    public String getRepairname() {
        return repairname;
    }

    public void setRepairname(String repairname) {
        this.repairname = repairname;
    }
}
