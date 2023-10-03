package ClientApiRest.Client.Api.Rest.repository;

import ClientApiRest.Client.Api.Rest.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
