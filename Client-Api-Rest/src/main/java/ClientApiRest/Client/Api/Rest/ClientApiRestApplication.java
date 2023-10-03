package ClientApiRest.Client.Api.Rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientApiRestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClientApiRestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server escuchando en el puerto H2 on: http://localhost:8888/h2-console");
	}

}
