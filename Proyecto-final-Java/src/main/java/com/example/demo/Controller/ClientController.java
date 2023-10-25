package com.example.demo.Controller;


import com.example.demo.Entity.Client;
import com.example.demo.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ResponseEntity<List<Client>> getClient(){
        List<Client> clients = clientService.getClient();
        return ResponseEntity.ok(clients);
    }


    @GetMapping("/client/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Long id) throws Exception{
        Client client = clientService.getClientById(id);
        return  ResponseEntity.ok(client);
    }

    @PostMapping("/client")
    public ResponseEntity<Client> postClient(@RequestBody Client client){
        clientService.CreatedClient(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/client/{id}")
    public void deleteClient(@PathVariable Long id) throws Exception{
        clientService.delateById(id);
    }
}
