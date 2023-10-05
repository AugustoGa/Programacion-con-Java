package SegEntrega.SegundaEntrega.Controller;

import SegEntrega.SegundaEntrega.Entity.Client;
import SegEntrega.SegundaEntrega.Service.ClientService;
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
    public ResponseEntity<Client>getClientById(@PathVariable Integer id) throws Exception{
        Client client = clientService.getClientById(id);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/client")
    public ResponseEntity<Client>postClient(@RequestBody Client client){
        clientService.createdClient(client);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/client/{id}")
    public void deleteClient(@PathVariable Integer id) throws Exception{
        clientService.deleteClientById(id);
    }
}
