package com.itheima.service.impl;

import com.itheima.dao.ClientDao;
import com.itheima.domain.Client;
import com.itheima.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientDao clientDao;

    public boolean save(Client client) {
        return clientDao.save(client)>0;
    }

    public boolean update(Client client) {
        return clientDao.update(client)>0;
    }

    public boolean delete(Integer id) {
        return clientDao.delete(id)>0;
    }

    public Client getById(Integer id) {
        return clientDao.getById(id);
    }

    public List<Client> getByClientName(String clientname) {
        return clientDao.getByClientName(clientname);
    }

    public List<Client> getByCompanyName(String companyname) {
        return clientDao.getByCompanyName(companyname);
    }

    public List<Client> getByClientCompanyName(String clientname,String companyname) {
        return clientDao.getByClientCompanyName(clientname,companyname);
    }
    public List<Client> getAll() {
        return clientDao.getAll();
    }

    public List<Client> getByPage(int pageSize, int index) {
        return clientDao.getByPage(pageSize,index);
    }
}
