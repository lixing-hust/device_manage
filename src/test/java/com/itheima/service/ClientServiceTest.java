package com.itheima.service;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Client;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ClientServiceTest {
    @Autowired
    private ClientService clientService;


    @Test
    public void testGetById(){
        int id=1;
        System.out.println(clientService.getById(id));
    }


//    @Test
//    public void testInsert(){
//        Client client=new Client("李星","15844225555","我负责后端开发","华科");
//        System.out.println(clientService.save(client));
//    }
//
//    @Test
//    public void testUpdate(){
//        Client client=new Client(2,"李东浩","15844225555","我负责前端开发","武带");
//        System.out.println(clientService.update(client));
//    }

    @Test
    public void testGetAll(){
        System.out.println(clientService.getAll());
    }

    @Test
    public void testGetByClientName(){
        String name="李";
        System.out.println(clientService.getByClientName(name));
    }

    @Test
    public void testGetByCompanyName(){
        String name="华";
        System.out.println(clientService.getByCompanyName(name));
    }

    @Test
    public void testGetByClientCompanyName(){
        String clientname="李";
        String companyname="华科";
        System.out.println(clientService.getByClientCompanyName(clientname,companyname));
    }
    @Test
    public void testDelete(){
        System.out.println(clientService.delete(4));
    }

}


