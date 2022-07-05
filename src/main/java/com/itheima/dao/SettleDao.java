package com.itheima.dao;

import com.itheima.domain.Client;
import com.itheima.domain.Settle;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SettleDao {
    @Insert("insert into tb_settle values(null,#{clientname},#{repairname},#{description},#{money})")
    public int save (Settle settle);

    @Update("update tb_settle set clientname=#{clientname},repairname=#{repairname},description=#{description},money=#{money} where id = #{id}")
    public int update(Settle settle);

    @Delete("delete from tb_settle where id=#{id}")
    public int delete(Integer id);

    @Select("select * from tb_settle where id=#{id}")
    public Settle getById(Integer id);

    @Select("select * from tb_settle where clientname like CONCAT('%',#{clientname},'%')")
    public List<Settle> getByClientName(String clientname);

    @Select("select * from tb_settle where repairname like CONCAT('%',#{repairname},'%')")
    public List<Settle> getByRepairName(String repairname);

    @Select("select * from tb_settle where clientname like CONCAT('%',#{clientname},'%') and repairname like CONCAT('%',#{repairname},'%')")
    public List<Settle> getByClientRepairName(@Param("clientname") String clientname,@Param("repairname") String repairname);


    @Select("select * from tb_settle ")
    public List<Settle> getAll();

    @Select("select * from tb_settle limit #{index} ,#{pageSize}")
    public List<Settle> getByPage(@Param("pageSize") int pageSize, @Param("index") int index);
}
