package operacoes.lancamento;

import contas.Fornecedor;
import contas.Lancamento;
import infra.DAO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Cadastrar {

    public static void main(String[] args) {
        DAO<Object> dao = new DAO<>();

        String nome = "Fornecedor Teste";
        LocalDate data = toData("14/04/2020");
        Double valor = 123.45;
        LocalDate pagamento = toData("14/04/2020");
        String observacoes = "Teste de inserção de lançamento com JPA";

        DAO<Fornecedor> daoFornecedor = new DAO<>(Fornecedor.class);
        Fornecedor fornecedor = daoFornecedor.consultarUm("fornecedorNome", "name", nome);

        if (fornecedor == null) {
            fornecedor = new Fornecedor(nome);
            dao.abrirTransacao()
                    .incluir(fornecedor)
                    .fecharTransacao();
        }

        Lancamento lancamento = new Lancamento(data, fornecedor, valor, pagamento, observacoes);
        dao.abrirTransacao()
                .incluir(lancamento)
                .fecharTransacao();
        dao.fechar();
    }

    static String toDatabaseData(LocalDate data) {
        return DateTimeFormatter.ofPattern("yyyy-MM-dd").format(data);
    }

    static LocalDate toData(String data) {
        return LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
