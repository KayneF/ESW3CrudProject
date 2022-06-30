package application.persistence;

import application.model.Cliente;
import jakarta.persistence.EntityManager;
import org.hibernate.SessionFactory;

public class SSelectOneCliente implements ISelectOne<Cliente> {

    private SessionFactory sf;

    public SSelectOneCliente(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public Cliente selectOne(Cliente c) {
        EntityManager entityManager = sf.createEntityManager();
        c = entityManager.find(Cliente.class, c.getCpf());
        return c;
    }
}
