package com.itheima.dao;

import com.itheima.domain.Client;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ClientDao {
    @Insert("insert into tb_client values(null,#{clientname},#{phonenumber},#{description},#{companyname})")
    public int save (Client client);

    @Update("update tb_client set clientname=#{clientname},phonenumber=#{phonenumber},description=#{description},companyname=#{companyname} where id = #{id}")
    public int update(Client client);

    @Delete("delete from tb_client where id=#{id}")
    public int delete(Integer id);

    @Select("select * from tb_client where id=#{id}")
    public Client getById(Integer id);

    @Select("select * from tb_client where clientname like CONCAT('%',#{clientname},'%')")
    public List<Client> getByClientName(String clientname);

    @Select("select * from tb_client where companyname like CONCAT('%',#{companyname},'%')")
    public  List<Client> getByCompanyName(String companyname);

    @Select("select * from tb_client where companyname like CONCAT('%',#{companyname},'%') and clientname like CONCAT('%',#{clientname},'%')")
    public List<Client> getByClientCompanyName(@Param("clientname") String clientname,@Param("companyname") String companyname);

    @Select("select * from tb_client ")
    public List<Client> getAll();

    @Select("select * from tb_client limit #{index} ,#{pageSize}")
    public List<Client> getByPage(@Param("pageSize") int pageSize,@Param("index") int index);
}
