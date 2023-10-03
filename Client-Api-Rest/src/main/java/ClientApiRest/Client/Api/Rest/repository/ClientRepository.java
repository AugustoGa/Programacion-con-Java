package ClientApiRest.Client.Api.Rest.repository;

import ClientApiRest.Client.Api.Rest.model.Clint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Clint, Integer> {
}
