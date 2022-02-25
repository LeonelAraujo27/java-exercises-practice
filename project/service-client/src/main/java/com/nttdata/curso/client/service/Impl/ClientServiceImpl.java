package com.nttdata.curso.client.service.Impl;

import com.nttdata.curso.client.entity.ClientEntity;
import com.nttdata.curso.client.repository.ClientRepository;
import com.nttdata.curso.client.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository repository;

    @Override
    public List<ClientEntity> listClients() {
        return repository.findAll();
    }

    @Override
    public ClientEntity getOne(Long id) {
        if (id==null){
            return null;
        }
        return repository.findById(id).get();
    }

    @Override
    public ClientEntity save(ClientEntity clientEntity) {
        if(clientEntity==null){
            return null;
        }else{
            return repository.save(clientEntity);
        }

    }

    @Override
    public ClientEntity update(Long id, ClientEntity clientEntity) {
        ClientEntity client=getOne(id);
        if(client==null){
            return new ClientEntity();
        }else {
            client.setName(clientEntity.getName());
            client.setLastName(clientEntity.getLastName());
            client.setDocumentType(clientEntity.getDocumentType());
            client.setDocumentNumber(clientEntity.getDocumentNumber());
            client.setBirthday(clientEntity.getBirthday());
            return save(client);
        }

    }

    @Override
    public boolean deleteClient(Long id) {
        try {
            repository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
