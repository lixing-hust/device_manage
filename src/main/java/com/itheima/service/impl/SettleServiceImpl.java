package com.itheima.service.impl;

import com.itheima.dao.SettleDao;
import com.itheima.domain.Settle;
import com.itheima.service.SettleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettleServiceImpl implements SettleService {
    @Autowired
    private SettleDao settleDao;

    public boolean save(Settle settle) {
        return settleDao.save(settle)>0;
    }

    public boolean update(Settle settle) {
        return settleDao.update(settle)>0;
    }

    public boolean delete(Integer id) {
        return settleDao.delete(id)>0;
    }

    public Settle getById(Integer id) {
        return settleDao.getById(id);
    }

    public List<Settle> getByClientName(String clientname) {
        return settleDao.getByClientName(clientname);
    }

    public List<Settle> getByRepairName(String repairname) {
        return settleDao.getByRepairName(repairname);
    }

    public List<Settle> getByClientRepairName(String clientname, String repairname) {
        return settleDao.getByClientRepairName(clientname,repairname);
    }

    public List<Settle> getAll() {
        return settleDao.getAll();
    }

    public List<Settle> getByPage(int pageSize, int index) {
        return settleDao.getByPage(pageSize,index);
    }
}
