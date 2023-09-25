package edu.AMB.AMB.Entidad.Cliente.Service;


import edu.AMB.AMB.Entidad.Cliente.Entity.Client;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaoClient {
    @Autowired
    private SessionFactory sessionFactory;

    public DaoClient(EntityManagerFactory entityManagerFactory){
        this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
    }

    public void create(Object obj) throws Exception{
        Session session = this.sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(obj);
        session.getTransaction().commit();
    }

    public List<Client> getClient(){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        Query<Client> query = session.createNativeQuery("SELECT * FROM alumno", Client.class); // SQL nativo
        List<Client> ListaClient = query.list();
        session.getTransaction().commit();
        return ListaClient;
    }

    public void update(Object object){
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.merge(object);
        session.getTransaction().commit();
    }

    public Client getClientById(int dni){
        Session session = sessionFactory.getCurrentSession();
        session.getTransaction();
        TypedQuery<Client> query = session.createQuery("SELECT al FROM Alumno al WHERE al.dni = ?1", Client.class);
        Client client = query.setParameter(1, dni).getSingleResult();
        session.getTransaction().commit();
        return client;
    }
}
