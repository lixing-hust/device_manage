package com.itheima.service;

import com.itheima.domain.Parts;
import com.itheima.domain.Repair;

import java.util.List;

public interface PartsService {
    public boolean save (Parts parts);

    public boolean update(Parts parts);

    public boolean updateIn(Parts parts);

    public boolean updateOut(Parts parts);

    public boolean delete(Integer id);

    public Parts getById(Integer id);

    public List<Parts> getByName(String name);

    public List<Parts> getAll();

    public List<Parts> getSmallCount();

    public List<Parts> getByPage(int pageSize, int index);
}
