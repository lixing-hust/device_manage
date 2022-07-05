package com.itheima.dao;

import com.itheima.domain.Client;
import com.itheima.domain.Task;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TaskDao {
    @Insert("insert into tb_task values(null,#{clientname},#{description},#{state},null)")
    public int save (Task task);

    @Update("update tb_task set clientname=#{clientname},description=#{description},state=#{state} where id = #{id}")
    public int update(Task task);

    @Delete("delete from tb_task where id=#{id}")
    public int delete(Integer id);

    @Select("select * from tb_task where id=#{id}")
    public Task getById(Integer id);

    @Select("select * from tb_task where clientname like CONCAT('%',#{clientname},'%')")
    public List<Task> getByName(String clientname);

    @Select("select * from tb_task ")
    public List<Task> getAll();

    @Select("select * from tb_task limit #{index} ,#{pageSize}")
    public List<Task> getByPage(@Param("pageSize") int pageSize, @Param("index") int index);

}
