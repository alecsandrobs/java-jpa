package contas;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "lancamentos")
public class Lancamento extends EntidadeId {

    @Column(nullable = false)
    private LocalDate data;

    @ManyToOne()
    private Fornecedor fornecedor;

    @Column(nullable = false)
    private Double valor;

    private LocalDate pagamento;

    private String observacoes;

    public Lancamento() {
    }

    public Lancamento(LocalDate data, Fornecedor fornecedor, Double valor, LocalDate pagamento, String observacoes) {
        this.data = data;
        this.fornecedor = fornecedor;
        this.valor = valor;
        this.pagamento = pagamento;
        this.observacoes = observacoes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public LocalDate getPagamento() {
        return pagamento;
    }

    public void setPagamento(LocalDate pagamento) {
        this.pagamento = pagamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }
}
