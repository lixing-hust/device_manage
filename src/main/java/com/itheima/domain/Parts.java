package com.itheima.domain;

public class Parts {
    private Integer id;
    private String name;
    private Integer count;
    private double money;


    public Parts() {
    }

    public Parts(String name, Integer count, double money) {
        this.name = name;
        this.count = count;
        this.money = money;
    }

    public Parts(Integer id, String name, Integer count, double money) {
        this.id = id;
        this.name = name;
        this.count = count;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Parts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", count=" + count +
                ", money=" + money +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
