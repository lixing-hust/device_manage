package com.itheima.service.impl;

import com.itheima.dao.TaskDao;
import com.itheima.domain.Task;
import com.itheima.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    public boolean save(Task task) {
        return taskDao.save(task)>0;
    }

    public boolean update(Task task) {
        return taskDao.update(task)>0;
    }

    public boolean delete(Integer id) {
        return taskDao.delete(id)>0;
    }

    public Task getById(Integer id) {
        return taskDao.getById(id);
    }

    public List<Task> getByName(String name) {
        return taskDao.getByName(name);
    }

    public List<Task> getAll() {
        return taskDao.getAll();
    }

    public List<Task> getByPage(int pageSize, int index) {
        return taskDao.getByPage(pageSize,index);
    }
}
