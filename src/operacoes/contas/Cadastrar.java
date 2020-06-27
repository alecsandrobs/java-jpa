package operacoes.contas;

import contas.Conta;
import contas.Fornecedor;
import infra.DAO;

public class Cadastrar {

    public static void main(String[] args) {
        DAO<Conta> dao = new DAO<>();

        Conta conta = new Conta("NuConta", "1", "123456-7");

        dao.abrirTransacao()
                .incluir(conta)
                .fecharTransacao()
                .fechar();

        System.out.println(conta.getBanco() + " - " + conta.getAgencia() + " - " + conta.getNumero());

    }
}
