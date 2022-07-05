package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Client;
import com.itheima.domain.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class TaskServiceTest {
    @Autowired
    private TaskService taskService;


    @Test
    public void testGetById(){
        int id=2;
        System.out.println(taskService.getById(id));
    }


//    @Test
//    public void testInsert(){
//        Task task=new Task("王宏瑞","维修电脑，电脑蓝屏了",0);
//        System.out.println(taskService.save(task));
//    }
//
//
//    @Test
//    public void testUpdate(){
//        Task task=new Task(1,"李星","洗衣机有脏东西，需要清洗",0);
//        System.out.println(taskService.update(task));
//    }

    @Test
    public void testGetAll(){
        System.out.println(taskService.getAll());
    }

    @Test
    public void testGetByName(){
        String name="李";
        System.out.println(taskService.getByName(name));
    }

    @Test
    public void testDelete(){
        System.out.println(taskService.delete(3));
    }

}


