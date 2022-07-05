package com.itheima.service.impl;

import com.itheima.dao.RepairDao;
import com.itheima.domain.Repair;
import com.itheima.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairServiceImpl implements RepairService {
    @Autowired
    private RepairDao repairDao;

    public boolean save(Repair repair) {
        return repairDao.save(repair)>0;
    }

    public boolean update(Repair repair) {
        return repairDao.update(repair)>0;
    }

    public boolean delete(Integer id) {
        return repairDao.delete(id)>0;
    }

    public Repair getById(Integer id) {
        return repairDao.getById(id);
    }

    public List<Repair> getByClientName(String clientname) {
        return repairDao.getByClientName(clientname);
    }

    public List<Repair> getByRepairName(String repairname) {
        return repairDao.getByRepairName(repairname);
    }

    public List<Repair> getByClientRepairName(String clientname, String repairname) {
        return repairDao.getByClientRepairName(clientname,repairname);
    }

    public List<Repair> getAll() {
        return repairDao.getAll();
    }

    public List<Repair> getByPage(int pageSize, int index) {
        return repairDao.getByPage(pageSize,index);
    }
}
