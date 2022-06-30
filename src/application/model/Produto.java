package application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "produtos")
public class Produto {

    @Id
    @Column(name = "id")
    @NotNull
    private String id;

    @Column(name = "item", length = 25)
    @NotNull
    private String item;

    @Column(name = "marca", length = 25)
    @NotNull
    private String marca;

    @Column(name = "modelo", length = 25)
    private String modelo;

    @Column(name = "cor", length = 25)
    @NotNull
    private String cor;

    @Column(name = "preco")
    @NotNull
    private String preco;


    // ============================================
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }
}
