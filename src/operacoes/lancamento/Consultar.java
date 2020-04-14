package operacoes.lancamento;

import contas.Lancamento;
import infra.DAO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class Consultar {

    public static void main(String[] args) {
        DAO<Lancamento> dao = new DAO<>(Lancamento.class);

        List<Lancamento> lancamentos = dao.obterTodos();

        System.out.println();
        lancamentos.forEach(lancamento -> {
            System.out.println(String.format("%d - %s - %s - %.2f - %s - %s", lancamento.getId(), toFormatedData(lancamento.getData()), lancamento.getFornecedor().getName(), lancamento.getValor(), toFormatedData(lancamento.getPagamento()), lancamento.getObservacoes()));
        });
    }

    static String toFormatedData(LocalDate data) {
        return data != null ? DateTimeFormatter.ofPattern("dd/MM/yyyy").format(data) : "--/--/----";
    }
}
