package com.itheima.service;

import com.itheima.domain.Task;

import java.util.List;

public interface TaskService {
    public boolean save (Task task);

    public boolean update(Task task);

    public boolean delete(Integer id);

    public Task getById(Integer id);

    public List<Task> getByName(String name);

    public List<Task> getAll();

    public List<Task> getByPage(int pageSize,int index);
}
