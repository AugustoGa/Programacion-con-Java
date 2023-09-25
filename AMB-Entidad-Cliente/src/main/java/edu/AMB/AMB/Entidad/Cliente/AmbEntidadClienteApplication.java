package edu.AMB.AMB.Entidad.Cliente;

import edu.AMB.AMB.Entidad.Cliente.Entity.Client;
import edu.AMB.AMB.Entidad.Cliente.Service.DaoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AmbEntidadClienteApplication implements CommandLineRunner {

	@Autowired
	private DaoClient daoClient;

	public static void main(String[] args) {
		SpringApplication.run(AmbEntidadClienteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		try{
			System.out.println("Listado de clientes inicial");
			daoClient.getClient().forEach((client -> {
				System.out.println(client.getNombre() + "" + client.getApellido());}
		));
			System.out.println("Lista Clientes con nuevo Cliente");
			Client alumno = new Client(1, "Augusto", "Gallo", 12345677);
			alumno.setId(4);
			daoClient.create(alumno);
			daoClient.getClient().forEach((alumno2) -> {
				System.out.println(alumno2.getNombre() + " " + alumno2.getApellido());
			});

			System.out.println("Lista Clientes con Cliente modificado");
			alumno.setNombre("Estebanquito");
			daoClient.update(alumno);
			daoClient.getClient().forEach((alumno2) -> {
				System.out.println(alumno2.getNombre() + " " + alumno2.getApellido());
			});

			System.out.println("Lista Cliente con Cliente buscado por dni");
			Client alumno3 = daoClient.getClientById(12345678);
			System.out.println(alumno3.getNombre() + " " + alumno3.getApellido());

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}

