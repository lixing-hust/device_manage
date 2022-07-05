package com.itheima.controller;

import com.itheima.domain.Client;
import com.itheima.domain.Task;
import com.itheima.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    @ResponseBody
    public boolean save(@RequestBody Task task){
        return taskService.save(task);
    }

    @PutMapping
    @ResponseBody
    public boolean update(@RequestBody Task task){
        return taskService.update(task);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Integer id){
        return taskService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Task getById(@PathVariable Integer id){
        return taskService.getById(id);
    }

    @PostMapping("/name")
    @ResponseBody
    public List<Task> getByClientName(@RequestBody Task task){
        String clientname=task.getClientname();
        if(clientname!=null&&clientname!="")
        return taskService.getByName(clientname);
        else return taskService.getAll();
    }

    @GetMapping
    @ResponseBody
    public int getAll(){
        return taskService.getAll().size();
    }

    @GetMapping("/page")
    @ResponseBody
    public List<Task> getByPage(@RequestParam int pageSize, @RequestParam int index){
        return taskService.getByPage(pageSize,index);
    }
}
