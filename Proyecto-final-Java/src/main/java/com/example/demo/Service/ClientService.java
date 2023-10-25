package com.example.demo.Service;


import com.example.demo.Entity.Client;
import com.example.demo.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public void CreatedClient(Client client){
        clientRepository.save(client);
    }

    public List<Client> getClient(){
        return clientRepository.findAll();
    }

    public Client getClientById(Long id) throws Exception{
        Optional<Client> client = clientRepository.findById(id);
            if (client.isPresent()){
                return client.get();
            }else {
                throw new  Exception("Client not found");
            }
    }

    public void delateById (Long id) throws Exception{
        Client client = getClientById(id);
        clientRepository.delete(client);
    }
}
