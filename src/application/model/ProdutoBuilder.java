package application.model;

public class ProdutoBuilder {

    private Produto produto;

    public ProdutoBuilder() {
        this.produto = new Produto();
    }

    public static ProdutoBuilder builder() {
        return new ProdutoBuilder();
    }

    public ProdutoBuilder addId(String id){
        this.produto.setId(id);
        return this;
    }

    public ProdutoBuilder addItem(String item){
        this.produto.setItem(item);
        return this;
    }

    public ProdutoBuilder addMarca(String marca){
        this.produto.setMarca(marca);
        return this;
    }

    public ProdutoBuilder addModelo(String modelo){
        this.produto.setModelo(modelo);
        return this;
    }

    public ProdutoBuilder addCor(String cor){
        this.produto.setCor(cor);
        return this;
    }

    public ProdutoBuilder addPreco(String preco){
        this.produto.setPreco(preco);
        return this;
    }


    public Produto get() {
        this.produto.setId(this.produto.getId());
        this.produto.setItem(this.produto.getItem());
        this.produto.setMarca(this.produto.getMarca());
        this.produto.setModelo(this.produto.getModelo());
        this.produto.setCor(this.produto.getCor());
        this.produto.setPreco(this.produto.getPreco());
        return this.produto;
    }
}
