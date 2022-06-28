package application.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Column(name = "nome_cliente", length = 25)
    @NotNull
    private String nome;

    @Id
    @Column(name = "cpf", length = 5)
    @NotNull
    private String cpf;

    @Column(name = "endereco", length = 25)
    @NotNull
    private String endereco;

    @Column(name = "cep", length = 25)
    @NotNull
    private String cep;

    @Column(name = "telefone", length = 25)
    @NotNull
    private String telefone;

    @Column(name = "email", length = 25)
    private String email;

    // =====================================================

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
