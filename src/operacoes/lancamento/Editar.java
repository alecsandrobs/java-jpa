package operacoes.lancamento;

import contas.Fornecedor;
import contas.Lancamento;
import infra.DAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Editar {

    public static void main(String[] args) {
        DAO<Lancamento> dao = new DAO<>(Lancamento.class);

        Lancamento lancamento = dao.consultarUm("lancamentoDataFornecedorValor", "data", toData("14/04/2020"), "name", "Fornecedor Teste", "valor", 123.45);

        Fornecedor fornecedor = new DAO<>(Fornecedor.class).consultarUm("fornecedorNome", "name", "Teste 01");

        lancamento.setData(toData("15/04/2020"));
        lancamento.setFornecedor(fornecedor);
        lancamento.setValor(543.21);
        lancamento.setPagamento(toData("15/04/2020"));
        lancamento.setObservacoes("Lançamento alterado.");

        dao.abrirTransacao()
                .atualizar(lancamento)
                .fecharTransacao()
                .fechar();

        System.out.println(String.format("%d - %s - %s - %.2f - %s - %s", lancamento.getId(), toFormatedData(lancamento.getData()), lancamento.getFornecedor().getName(), lancamento.getValor(), toFormatedData(lancamento.getPagamento()), lancamento.getObservacoes()));
    }

    static String toDatabaseData(LocalDate data) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(data);
    }

    static LocalDate toData(String data) {
        return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    static String toFormatedData(LocalDate data) {
        return data != null ? DateTimeFormatter.ofPattern("dd/MM/yyyy").format(data) : "--/--/----";
    }
}
