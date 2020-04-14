package operacoes.fornecedor;

import contas.Fornecedor;
import infra.DAO;

public class Excluir {

    public static void main(String[] args) {
        DAO<Fornecedor> dao = new DAO<>(Fornecedor.class);

        Fornecedor fornecedor = dao.consultarUm("fornecedorNome", "name", "Teste 007");

        dao.abrirTransacao()
                .remover(fornecedor);

        dao.fecharTransacao().fechar();

    }
}
