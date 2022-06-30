package application.persistence;

import application.model.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

public class SSelectAllCliente implements ISelectAll<Cliente> {

    private SessionFactory sf;

    public SSelectAllCliente(SessionFactory sf) {
        this.sf = sf;
    }

    @Override
    public List<Cliente> selectAll() {
        List<Cliente> clientes = new ArrayList<>();
        StringBuffer sql = new StringBuffer();
        sql.append("SELECT nome, cpf, endereco, cep, telefone, email ");
        sql.append("FROM clientes ");
        sql.append("ORDER BY nome");
        EntityManager entityManager = sf.createEntityManager();
        Query query = entityManager.createNativeQuery(sql.toString());
        List<Object[]> lista = query.getResultList();
        for (Object[] obj : lista) {
            Cliente c = new Cliente();
            c.setNome(obj[0].toString());
            c.setCpf(obj[1].toString());
            c.setEndereco(obj[2].toString());
            c.setCep(obj[3].toString());
            c.setTelefone(obj[4].toString());
            c.setEmail(obj[5].toString());
            clientes.add(c);
        }
        return clientes;
    }
}
