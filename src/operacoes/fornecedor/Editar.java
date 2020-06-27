package operacoes.fornecedor;

import contas.Fornecedor;
import infra.DAO;

public class Editar {

    public static void main(String[] args) {
        DAO<Fornecedor> dao = new DAO<>(Fornecedor.class);

        Fornecedor fornecedor = dao.consultarUm("fornecedorNome", "name", "Teste 01");

        fornecedor.setNome("Teste 007");

        dao.abrirTransacao()
                .atualizar(fornecedor)
                .fecharTransacao()
                .fechar();

        System.out.println(String.format("%d - %s", fornecedor.getId(), fornecedor.getNome()));

    }
}
