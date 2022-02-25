package com.nttdata.curso.client.controller;

import com.nttdata.curso.client.entity.ClientEntity;
import com.nttdata.curso.client.service.ClientService;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/list")
    public ResponseEntity<List<ClientEntity>> listClients(){
        List<ClientEntity> clientEntities=service.listClients();
        if(clientEntities.isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(clientEntities);
        }
    }

    @GetMapping("get/{id}")
    public ResponseEntity<ClientEntity> getClient(@PathVariable Long id){
        ClientEntity clientEntity=service.getOne(id);
        if(clientEntity==null){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(clientEntity);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<ClientEntity> saveClient(@RequestBody ClientEntity clientEntity){

        try {
            ClientEntity client=service.save(clientEntity);
            if(client.getId()==null){
                return ResponseEntity.status(HttpStatus.CONFLICT).body(new ClientEntity());
            }else{
                return ResponseEntity.ok(client);
            }
        }catch(Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ClientEntity());
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientEntity> updateClient(@PathVariable Long id,@RequestBody ClientEntity clientEntity){
        ClientEntity client=service.update(id,clientEntity);
        if(client.getId()==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(new ClientEntity());
        }else{
            return  ResponseEntity.ok(client);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ClientEntity> deleteClient(@PathVariable Long id){
        ClientEntity client=service.getOne(id);
        boolean isDelete=service.deleteClient(id);
        if(!isDelete){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            return ResponseEntity.ok(client);
        }
    }


}
