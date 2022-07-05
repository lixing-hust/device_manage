package com.itheima.controller;

import com.itheima.domain.Client;
import com.itheima.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @PostMapping
    @ResponseBody
    public boolean save(@RequestBody Client client){
        return clientService.save(client);
    }

    @PutMapping
    @ResponseBody
    public boolean update(@RequestBody Client client){
        return clientService.update(client);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Integer id){
        return clientService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Client getById(@PathVariable Integer id){
        return clientService.getById(id);
    }

    @PostMapping("/name")
    @ResponseBody
    public List<Client> getByClientName(@RequestBody Client client){
        String clientname=client.getClientname();
        String companyname=client.getCompanyname();
        if(clientname!=null && clientname!=""&&(companyname==null || companyname ==""))
            return clientService.getByClientName(clientname);
        else if((clientname==null || clientname=="")&&(companyname!=null && companyname !=""))
            return clientService.getByCompanyName(companyname);
        else if((clientname!=null && clientname!="")&&(companyname!=null && companyname !=""))
            return clientService.getByClientCompanyName(clientname,companyname);
        else return clientService.getAll();
    }

    @GetMapping
    @ResponseBody
    public int getAll(){
        return clientService.getAll().size();
    }

    @GetMapping("/page")
    @ResponseBody
    public List<Client> getByPage(@RequestParam int pageSize,@RequestParam int index){
        return clientService.getByPage(pageSize,index);
    }


}
