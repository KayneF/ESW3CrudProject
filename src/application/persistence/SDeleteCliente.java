package application.persistence;

import application.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;

public class SDeleteCliente implements IDelete<Cliente> {

    private SessionFactory sf;

    public SDeleteCliente(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void delete(Cliente c) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(c);
        transaction.commit();
    }
}
