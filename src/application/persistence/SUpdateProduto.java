package application.persistence;

import application.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;

public class SUpdateProduto implements IUpdate<Produto> {

    private SessionFactory sf;

    public SUpdateProduto(SessionFactory sf) {
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
