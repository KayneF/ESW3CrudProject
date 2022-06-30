package application.persistence;

import application.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.hibernate.SessionFactory;

public class SCreateProduto implements ICreate<Produto> {

    private SessionFactory sf;

    public SCreateProduto(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public void create(Produto p) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(p);
        transaction.commit();
    }
}
