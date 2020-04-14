package operacoes.lancamento;

import contas.Fornecedor;
import contas.Lancamento;
import infra.DAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Excluir {

    public static void main(String[] args) {
        DAO<Lancamento> dao = new DAO<>(Lancamento.class);

        Lancamento lancamento = dao.consultarUm("lancamentoDataFornecedorValor", "data", toData("15/04/2020"), "name", "Teste 01", "valor", 543.21);

        dao.abrirTransacao()
                .remover(lancamento);

        dao.fecharTransacao().fechar();

    }

    static LocalDate toData(String data) {
        return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
