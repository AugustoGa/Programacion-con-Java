package com.example.demo.Controller;


import com.example.demo.Entity.Client;
import com.example.demo.Service.ClientService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/")
public class ClientController {

    @Autowired
    private ClientService clientService;


    @Operation(summary = "Get all clients", description = "Get all clients", tags = { "Client" })
    public ResponseEntity<List<Client>> getClient(){
        List<Client> clients = clientService.getClient();
        return ResponseEntity.ok(clients);
    }

    @Operation(summary = "Get a client by id", description = "Get a client by id", tags = { "Client" })
    @ApiResponses(value = {
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Client found", content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = Client.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "Client not found", content = @io.swagger.v3.oas.annotations.media.Content)
    })
    @GetMapping(value = "/client/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Client> getClientById(@PathVariable Long id) throws Exception{
        Client client = clientService.getClientById(id);
        return  ResponseEntity.ok(client);
    }


    @Operation(summary = "Save a client", description = "Save a client", tags = { "Client" })
    @PostMapping("/client")
    public ResponseEntity<Client> postClient(@RequestBody Client client){
        clientService.CreatedClient(client);
        return ResponseEntity.ok(client);
    }


    @Operation(summary = "Delete a client", description = "Delete a client", tags = { "Client" })
    @PostMapping("/client/{id}")
    public void deleteClient(@PathVariable Long id) throws Exception{
        clientService.delateById(id);
    }
}
