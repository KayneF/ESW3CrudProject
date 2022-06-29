package application.persistence;

import application.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;

public class SUpdate implements IUpdate {

    private SessionFactory sf;

    public SUpdate(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void update(Produto p) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(p);
        transaction.commit();
    }
}
