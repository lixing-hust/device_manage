package com.itheima.service;

import com.itheima.domain.Repair;
import com.itheima.domain.Settle;

import java.util.List;

public interface SettleService {
    public boolean save (Settle settle);

    public boolean update(Settle settle);

    public boolean delete(Integer id);

    public Settle getById(Integer id);

    public List<Settle> getByClientName(String clientname);

    public List<Settle> getByRepairName(String repairname);

    public List<Settle> getByClientRepairName(String clientname,String repairname);

    public List<Settle> getAll();

    public List<Settle> getByPage(int pageSize, int index);
}
