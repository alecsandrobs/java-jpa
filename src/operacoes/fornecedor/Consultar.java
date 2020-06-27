package operacoes.fornecedor;

import contas.Fornecedor;
import infra.DAO;

import java.util.List;

public class Consultar {

    public static void main(String[] args) {

        DAO<Fornecedor> dao = new DAO<>(Fornecedor.class);

        List<Fornecedor> fornecedores = dao.obterTodos();

        dao.fechar();

        System.out.println();
        fornecedores.forEach(fornecedor -> System.out.println(String.format("%d - %s", fornecedor.getId(), fornecedor.getNome())));
    }
}
