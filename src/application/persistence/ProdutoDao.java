package application.persistence;

import application.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDao implements InterfaceDao {

    private SessionFactory sf;

    public ProdutoDao(SessionFactory sf) {
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

    @Override
    public void update(Produto p) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(p);
        transaction.commit();
    }

    @Override
    public void delete(Produto p) {
        EntityManager entityManager = sf.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.remove(p);
        transaction.commit();
    }

    @Override
    public Produto selectOne(Produto p) {
        EntityManager entityManager = sf.createEntityManager();
        p = entityManager.find(Produto.class, p.getItem());
        return p;
    }


    @Override
    public List<Produto> selectAll() {
        List<Produto> produtos = new ArrayList<>();
        StringBuffer buffer = new StringBuffer();
        buffer.append("SELECT id, item, marca, modelo, cor, preco ");
        buffer.append("FROM produtos ");
        buffer.append("ORDER BY item");
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(buffer.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Produto produto = new Produto();
            produto.setId(obj[0].toString());
            produto.setItem(obj[1].toString());
            produto.setMarca(obj[2].toString());
            produto.setModelo(obj[3].toString());
            produto.setCor(obj[4].toString());
            produto.setPreco(obj[5].toString());
            produtos.add(produto);
        }
        return produtos;
    }
}
