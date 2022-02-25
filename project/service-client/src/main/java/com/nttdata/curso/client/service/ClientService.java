package com.nttdata.curso.client.service;

import com.nttdata.curso.client.entity.ClientEntity;

import java.util.List;

public interface ClientService {
    List<ClientEntity> listClients();
    ClientEntity getOne(Long id);
    ClientEntity save(ClientEntity clientEntity);
    ClientEntity update(Long id,ClientEntity clientEntity);
    boolean deleteClient(Long id);

}
