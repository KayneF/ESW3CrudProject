package application.model;

public class ClienteBuilder {

    private Cliente cliente;

    public ClienteBuilder() {
        this.cliente = new Cliente();
    }

    public static ClienteBuilder builder() {
        return new ClienteBuilder();
    }


    // ========================================================================
    public ClienteBuilder addNome(String nome) {
        this.cliente.setNome(nome);
        return this;
    }

    public ClienteBuilder addCpf(String cpf) {
        this.cliente.setCpf(cpf);
        return this;
    }

    public ClienteBuilder addEndereco(String endereco) {
        this.cliente.setEndereco(endereco);
        return this;
    }

    public ClienteBuilder addCep(String cep) {
        this.cliente.setCep(cep);
        return this;
    }

    public ClienteBuilder addTelefone(String telefone) {
        this.cliente.setTelefone(telefone);
        return this;
    }

    public ClienteBuilder addEmail(String email) {
        this.cliente.setEmail(email);
        return this;
    }


    public Cliente get() {
        this.cliente.setNome(this.cliente.getNome());
        this.cliente.setCpf(this.cliente.getCpf());
        this.cliente.setEndereco(this.cliente.getEndereco());
        this.cliente.setCep(this.cliente.getCep());
        this.cliente.setTelefone(this.cliente.getTelefone());
        this.cliente.setEmail(this.cliente.getEmail());
        return this.cliente;
    }
}
