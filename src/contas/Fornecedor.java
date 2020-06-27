package contas;

import javax.persistence.*;

@Entity
@Table(name = "fornecedores")
public class Fornecedor extends EntidadeId {

    private String nome;

    public Fornecedor() {
    }

    public Fornecedor(String name) {
        this.nome = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}


