package com.itheima.service;

import com.itheima.domain.Book;
import com.itheima.domain.Client;

import java.util.List;

public interface ClientService {

    public boolean save (Client client);

    public boolean update(Client client);

    public boolean delete(Integer id);

    public Client getById(Integer id);

    public List<Client> getByClientName(String clientname);
    public List<Client> getByCompanyName(String companyname);
    public List<Client> getByClientCompanyName(String clientname,String companyname);

    public List<Client> getAll();

    public List<Client> getByPage(int pageSize,int index);
}
