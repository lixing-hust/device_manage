package com.itheima.controller;

import com.itheima.domain.Client;
import com.itheima.domain.Repair;
import com.itheima.domain.Task;
import com.itheima.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/repairs")
public class RepairController {
    @Autowired
    private RepairService repairService;

    @PostMapping
    @ResponseBody
    public boolean save(@RequestBody Repair repair){
        return repairService.save(repair);
    }

    @PutMapping
    @ResponseBody
    public boolean update(@RequestBody Repair repair){
        return repairService.update(repair);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Integer id){
        return repairService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Repair getById(@PathVariable Integer id){
        return repairService.getById(id);
    }

    @PostMapping("/name")
    @ResponseBody
    public List<Repair> getByName(@RequestBody Repair repair){
        String clientname=repair.getClientname();
        String repairname=repair.getRepairname();
        if((clientname!=null && clientname!="")&&(repairname==null || repairname ==""))
            return repairService.getByClientName(clientname);
        else if((clientname==null || clientname=="")&&(repairname!=null && repairname !=""))
            return repairService.getByRepairName(repairname);
        else if((clientname!=null && clientname!="")&&(repairname!=null && repairname !=""))
            return repairService.getByClientRepairName(clientname,repairname);
        else return repairService.getAll();
    }

    @GetMapping
    @ResponseBody
    public int getAll(){
        return repairService.getAll().size();
    }

    @GetMapping("/page")
    @ResponseBody
    public List<Repair> getByPage(@RequestParam int pageSize, @RequestParam int index){
        return repairService.getByPage(pageSize,index);
    }
}
