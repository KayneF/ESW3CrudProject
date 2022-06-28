package application.persistence;

import application.model.Produto;

import java.sql.SQLException;
import java.util.List;

public interface InterfaceDao {

    void create(Produto p) throws SQLException;
    void update(Produto p) throws SQLException;
    void delete(Produto p) throws SQLException;
    Produto selectOne(Produto p) throws SQLException;
    List<Produto> selectAll() throws SQLException;

}
