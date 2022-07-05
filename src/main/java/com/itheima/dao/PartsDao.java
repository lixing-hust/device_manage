package com.itheima.dao;

import com.itheima.domain.Client;
import com.itheima.domain.Parts;
import com.itheima.domain.Settle;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PartsDao {
    @Insert("insert into tb_parts values(null,#{name},#{count},#{money})")
    public int save (Parts parts);

    @Update("update tb_parts set name=#{name},count=#{count},money=#{money} where id = #{id}")
    public int update(Parts parts);

    @Update("update tb_parts set count=count + #{count} where id=#{id}")
    public int  updateIn(Parts parts);

    @Update("update tb_parts set count=count - #{count} where id=#{id} and count>=#{count}")
    public int  updateOut(Parts parts);

    @Delete("delete from tb_parts where id=#{id}")
    public int delete(Integer id);

    @Select("select * from tb_parts where id=#{id}")
    public Parts getById(Integer id);

    @Select("select * from tb_parts where name like CONCAT('%',#{name},'%')")
    public List<Parts> getByName(String name);

    @Select("select * from tb_parts ")
    public List<Parts> getAll();

    @Select("select * from tb_parts where count<=5")
    public List<Parts> getSmallCount();

    @Select("select * from tb_parts limit #{index} ,#{pageSize}")
    public List<Parts> getByPage(@Param("pageSize") int pageSize, @Param("index") int index);
}
