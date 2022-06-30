package application.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Column(name = "nome", length = 40)
    @NotNull
    private String nome;

    @Id
    @Column(name = "cpf", length = 15)
    @NotNull
    private String cpf;

    @Column(name = "endereco", length = 50)
    @NotNull
    private String endereco;

    @Column(name = "cep", length = 10)
    @NotNull
    private String cep;

    @Column(name = "telefone", length = 15)
    @NotNull
    private String telefone;

    @Column(name = "email", length = 40)
    @NotNull
    private String email;


    // ==============================================
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
