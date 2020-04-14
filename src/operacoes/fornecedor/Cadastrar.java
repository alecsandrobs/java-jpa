package operacoes.fornecedor;

import contas.Fornecedor;
import infra.DAO;

public class Cadastrar {

    public static void main(String[] args) {
        DAO<Fornecedor> dao = new DAO<>();
        
        Fornecedor fornecedor = new Fornecedor("Teste 03");

        dao.abrirTransacao()
                .incluir(fornecedor)
                .fecharTransacao()
                .fechar();

        System.out.println(fornecedor.getId() + " - " + fornecedor.getName());

    }
}
