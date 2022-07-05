package com.itheima.controller;

import com.itheima.domain.Client;
import com.itheima.domain.Settle;
import com.itheima.domain.Task;
import com.itheima.service.SettleService;
import com.itheima.service.SettleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/settles")
public class SettleController {
    @Autowired
    private SettleService settleService;

    @PostMapping
    @ResponseBody
    public boolean save(@RequestBody Settle settle){
        return settleService.save(settle);
    }

    @PutMapping
    @ResponseBody
    public boolean update(@RequestBody Settle settle){
        return settleService.update(settle);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Integer id){
        return settleService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Settle getById(@PathVariable Integer id){
        return settleService.getById(id);
    }

    @PostMapping("/name")
    @ResponseBody
    public List<Settle> getByClientName(@RequestBody Settle settle){
        String clientname=settle.getClientname();
        String repairname=settle.getRepairname();
        if(clientname!=null && clientname!=""&&(repairname==null || repairname ==""))
            return settleService.getByClientName(clientname);
        else if((clientname==null || clientname=="")&&(repairname!=null && repairname !=""))
            return settleService.getByRepairName(repairname);
        else if((clientname!=null && clientname!="")&&(repairname!=null && repairname !=""))
            return settleService.getByClientRepairName(clientname,repairname);
        else return settleService.getAll();
    }

    @GetMapping
    @ResponseBody
    public int getAll(){
        return settleService.getAll().size();
    }

    @GetMapping("/page")
    @ResponseBody
    public List<Settle> getByPage(@RequestParam int pageSize, @RequestParam int index){
        return settleService.getByPage(pageSize,index);
    }
}
