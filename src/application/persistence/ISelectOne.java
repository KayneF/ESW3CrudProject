package application.persistence;

import application.model.Produto;

public interface ISelectOne {

    Produto selectOne(Produto p);
}
