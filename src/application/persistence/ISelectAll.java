package application.persistence;

import application.model.Produto;

import java.util.List;

public interface ISelectAll {

    List<Produto> selectAll();
}
