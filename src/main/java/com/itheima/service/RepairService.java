package com.itheima.service;

import com.itheima.domain.Repair;

import java.util.List;

public interface RepairService {
    public boolean save (Repair repair);

    public boolean update(Repair repair);

    public boolean delete(Integer id);

    public Repair getById(Integer id);

    public List<Repair> getByClientName(String clientname);

    public List<Repair> getByRepairName(String repairname);

    public List<Repair> getByClientRepairName(String clientname,String repairname);

    public List<Repair> getAll();

    public List<Repair> getByPage(int pageSize,int index);
}
