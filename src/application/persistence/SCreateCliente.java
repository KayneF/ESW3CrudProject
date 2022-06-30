package application.persistence;

import application.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;

public class SCreateCliente implements ICreate<Cliente> {

    private SessionFactory sf;

    public SCreateCliente(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void create(Cliente c) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(c);
        transaction.commit();
    }
}
