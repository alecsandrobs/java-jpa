package operacoes.contas;

import contas.Conta;
import contas.Fornecedor;
import infra.DAO;

import java.util.List;

public class Consultar {

    public static void main(String[] args) {

        DAO<Conta> dao = new DAO<>(Conta.class);

        List<Conta> contas = dao.obterTodos();

        dao.fechar();

        System.out.println();
        contas.forEach(conta -> System.out.println(String.format("%d - %s", conta.getId(), conta.getBanco())));
    }
}
