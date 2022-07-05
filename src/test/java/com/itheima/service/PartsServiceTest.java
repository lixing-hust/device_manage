package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Parts;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class PartsServiceTest {
    @Autowired
    private PartsService partsService;


    @Test
    public void testGetById(){
        int id=1;
        System.out.println(partsService.getById(id));
    }


    @Test
    public void testInsert(){
        Parts parts=new Parts("洗衣机涡轮",20,100.0);
        System.out.println(partsService.save(parts));
    }

    @Test
    public void testUpdate(){
        Parts parts=new Parts(2,"电脑屏幕",50,150.0);
        System.out.println(partsService.update(parts));
    }

    @Test
    public void testupdateIn(){
        Parts parts=new Parts(3,"洗衣机涡轮",10,100.0);
        System.out.println(partsService.updateIn(parts));
    }

    @Test
    public void testupdateOut(){
        Parts parts=new Parts(4,"洗衣机涡轮",15,100.0);
        System.out.println(partsService.updateOut(parts));
    }

    @Test
    public void testGetAll(){
        System.out.println(partsService.getAll());
    }

    @Test
    public void testGetByName(){
        String name="空调";
        System.out.println(partsService.getByName(name));
    }

    @Test
    public void testDelete(){
        System.out.println(partsService.delete(3));
    }

    @Test
    public void testgetSmallCount(){
        System.out.println(partsService.getSmallCount());
    }

}


