package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Settle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class SettleServiceTest {
    @Autowired
    private SettleService settleService;


    @Test
    public void testGetById(){
        int id=3;
        System.out.println(settleService.getById(id));
    }


//    @Test
//    public void testInsert(){
//        Settle settle=new Settle("李星","张三","洗衣机清洗",100.0);
//        System.out.println(settleService.save(settle));
//    }
//
//
//    @Test
//    public void testUpdate(){
//        Settle settle=new Settle(3,"李星","张三","清洗洗衣机",50.0);
//        System.out.println(settleService.update(settle));
//    }

    @Test
    public void testGetAll(){
        System.out.println(settleService.getAll());
    }

    @Test
    public void testGetByClientName(){
        String name="李";
        System.out.println(settleService.getByClientName(name));
    }

    @Test
    public void testGetByRepairName(){
        String name="李";
        System.out.println(settleService.getByRepairName(name));
    }


    @Test
    public void testGetByClientRepairName(){
        String clientname="李";
        String settlename="四";
        System.out.println(settleService.getByClientRepairName("李","李"));
    }


    @Test
    public void testDelete(){
        System.out.println(settleService.delete(3));
    }

}


