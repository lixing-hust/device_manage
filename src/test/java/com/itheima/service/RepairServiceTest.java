package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Repair;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class RepairServiceTest {
    @Autowired
    private RepairService repairService;


    @Test
    public void testGetById(){
        int id=2;
        System.out.println(repairService.getById(id));
    }


//    @Test
//    public void testInsert(){
//        Repair repair=new Repair("王五","王宏瑞","电脑蓝屏");
//        System.out.println(repairService.save(repair));
//    }
//
//
//    @Test
//    public void testUpdate(){
//        Repair repair=new Repair(1,"张三","李星","清洗洗衣机");
//        System.out.println(repairService.update(repair));
//    }

    @Test
    public void testGetAll(){
        System.out.println(repairService.getAll());
    }

    @Test
    public void testGetByClientName(){
        String name="李";
        System.out.println(repairService.getByClientName(name));
    }

    @Test
    public void testGetByRepairName(){
        String name="李";
        System.out.println(repairService.getByRepairName(name));
    }


    @Test
    public void testGetByClientRepairName(){
        String clientname="李";
        String repairname="四";
        System.out.println(repairService.getByClientRepairName("李","李"));
    }


    @Test
    public void testDelete(){
        System.out.println(repairService.delete(3));
    }

}


