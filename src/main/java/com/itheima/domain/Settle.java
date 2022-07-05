package com.itheima.domain;

public class Settle {
    private Integer id;
    private String clientname;
    private String repairname;
    private String description;
    private String money;



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

    public String getRepairname() {
        return repairname;
    }

    public void setRepairname(String repairname) {
        this.repairname = repairname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
