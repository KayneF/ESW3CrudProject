package application.controller;

import application.model.Produto;
import application.persistence.SSelectOne;
import application.util.HibernateUtil;
import javafx.scene.control.TextField;
import org.hibernate.SessionFactory;

public class SProcurarC implements IProcurarC {

    private TextField fieldId;
    private TextField fieldItem;
    private TextField fieldMarca;
    private TextField fieldModelo;
    private TextField fieldCor;
    private TextField fieldPreco;

    public SProcurarC(TextField fieldId, TextField fieldItem, TextField fieldMarca, TextField fieldModelo, TextField fieldCor, TextField fieldPreco) {
        this.fieldId = fieldId;
        this.fieldItem = fieldItem;
        this.fieldMarca = fieldMarca;
        this.fieldModelo = fieldModelo;
        this.fieldCor = fieldCor;
        this.fieldPreco = fieldPreco;
    }

    @Override
    public void procurar(Produto produto) {
        SLimparC cl = new SLimparC(fieldId, fieldItem, fieldMarca, fieldModelo, fieldCor, fieldPreco);
        SessionFactory sf = HibernateUtil.getSessionFactory();
        SSelectOne dao = new SSelectOne(sf);
        cl.limpar();
        Produto p = dao.selectOne(produto);

        fieldId.setText(p.getId());
        fieldItem.setText(p.getItem());
        fieldMarca.setText(p.getMarca());
        fieldModelo.setText(p.getModelo());
        fieldCor.setText(p.getCor());
        fieldPreco.setText(p.getPreco());
    }
}
