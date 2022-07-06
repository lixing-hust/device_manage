package com.itheima.controller;

import com.itheima.domain.Parts;
import com.itheima.domain.Task;
import com.itheima.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/partss")
public class PartsController {

    @Autowired
    private PartsService partsService;

    @PostMapping
    @ResponseBody
    public boolean save(@RequestBody Parts parts){
        return partsService.save(parts);
    }

    @PutMapping
    @ResponseBody
    public boolean update(@RequestBody Parts parts){
        return partsService.update(parts);
    }

    @PutMapping("/in")
    @ResponseBody
    public boolean updateIn(@RequestBody Parts parts){
        return partsService.updateIn(parts);
    }

    @PutMapping("/out")
    @ResponseBody
    public boolean updateOut(@RequestBody Parts parts){
        return partsService.updateOut(parts);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Integer id){
        return partsService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Parts getById(@PathVariable Integer id){
        return partsService.getById(id);
    }

    @PostMapping("/name")
    @ResponseBody
    public List<Parts> getByName(@RequestBody Parts parts){
        String name = parts.getName();
        if(name!=null&&name!="")
            return partsService.getByName(name);
        else return partsService.getByPage(5,0);
    }

    @GetMapping
    @ResponseBody
    public int getAll(){
        return partsService.getAll().size();
    }

    @GetMapping("/state")
    @ResponseBody
    public List<Parts> getSmallCount(){
        return partsService.getSmallCount();
    }

    @GetMapping("/page")
    @ResponseBody
    public List<Parts> getByPage(@RequestParam int pageSize, @RequestParam int index){
        return partsService.getByPage(pageSize,index);
    }

}
