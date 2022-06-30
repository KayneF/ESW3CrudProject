package application.persistence;

import application.model.Cliente;
import application.persistence.IUpdate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;

public class SUpdateCliente implements IUpdate<Cliente> {

    private SessionFactory sf;

    public SUpdateCliente(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void update(Cliente c) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(c);
        transaction.commit();
    }
}
