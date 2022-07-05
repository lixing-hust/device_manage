package com.itheima.dao;

import com.itheima.domain.Client;
import com.itheima.domain.Repair;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RepairDao {
    @Insert("insert into tb_repair values(null,#{repairname},#{clientname},#{description},#{state})")
    public int save (Repair repair);

    @Update("update tb_repair set clientname=#{clientname},repairname=#{repairname},description=#{description} where id = #{id}")
    public int update(Repair repair);

    @Delete("delete from tb_repair where id=#{id}")
    public int delete(Integer id);

    @Select("select * from tb_repair where id=#{id}")
    public Repair getById(Integer id);

    @Select("select * from tb_repair where clientname like CONCAT('%',#{clientname},'%')")
    public List<Repair> getByClientName(String clientname);

    @Select("select * from tb_repair where repairname like CONCAT('%',#{repairname},'%')")
    public List<Repair> getByRepairName(String repairname);

    @Select("select * from tb_repair where clientname like CONCAT('%',#{clientname},'%') and repairname like CONCAT('%',#{repairname},'%')")
    public List<Repair> getByClientRepairName(@Param("clientname") String clientname,@Param("repairname") String repairname);


    @Select("select * from tb_repair ")
    public List<Repair> getAll();

    @Select("select * from tb_repair limit #{index} ,#{pageSize}")
    public List<Repair> getByPage(@Param("pageSize") int pageSize, @Param("index") int index);
}
