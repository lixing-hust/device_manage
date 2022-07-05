package com.itheima.service.impl;

import com.itheima.dao.PartsDao;
import com.itheima.domain.Parts;
import com.itheima.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PartsServiceImpl implements PartsService {

    @Autowired
    private PartsDao partsDao;
    public boolean save(Parts parts) {
        return partsDao.save(parts)>0;
    }

    public boolean update(Parts parts) {
        return partsDao.update(parts)>0;
    }

    public boolean updateIn(Parts parts) {
        return partsDao.updateIn(parts)>0;
    }

    public boolean updateOut(Parts parts) {
        return partsDao.updateOut(parts)>0;
    }

    public boolean delete(Integer id) {
        return partsDao.delete(id)>0;
    }

    public Parts getById(Integer id) {
        return partsDao.getById(id);
    }

    public List<Parts> getByName(String name) {
        return partsDao.getByName(name);
    }

    public List<Parts> getAll() {
        return partsDao.getAll();
    }

    public List<Parts> getSmallCount() {
        return partsDao.getSmallCount();
    }

    public List<Parts> getByPage(int pageSize, int index) {
        return partsDao.getByPage(pageSize,index);
    }
}
