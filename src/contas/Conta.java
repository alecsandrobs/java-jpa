package contas;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "contas")
public class Conta extends EntidadeId {

    private String banco;
    private String agencia;
    private String numero;

    public Conta() {
    }

    public Conta(String banco, String agencia, String numero) {
        this.banco = banco;
        this.agencia = agencia;
        this.numero = numero;
    }

    public String getBanco() {
        return banco;
    }

    public void setBanco(String banco) {
        this.banco = banco;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

}
