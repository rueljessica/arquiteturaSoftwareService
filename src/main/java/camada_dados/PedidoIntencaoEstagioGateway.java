package camada_dados;

import java.util.HashMap;
import java.util.Map;

import entidades.PedidoIntencaoEstagio;
import entidades.result_set.Resultset;
import entidades.result_set.Tabela;

/**
 * Classe responsável pela persistência dos pedidos de intenção de estágio.
 */
public class PedidoIntencaoEstagioGateway {

	private Tabela tabelaPedido; // Simula a tabela onde os pedidos são armazenados.

    public PedidoIntencaoEstagioGateway() {
        tabelaPedido = new Tabela(); // Inicializa a tabela
    }

    /**
     * Método para salvar um pedido de intenção de estágio na tabela simulada.
     *
     * @param pedido Objeto contendo os dados do pedido a ser salvo
     * @return A tabela atualizada contendo os dados do pedido
     */
    public Resultset salvarPedido(PedidoIntencaoEstagio pedido) {
        System.out.println("Salvando pedido de intenção no banco de dados...");

        // Criando um Resultset para armazenar os dados do pedido
        Resultset resultset = new Resultset();

        if (pedido == null) {
            System.out.println("Erro: O pedido está vazio.");
            return resultset; // Retorna um Resultset vazio
        }

        // Criar um mapa para representar os dados do pedido
        Map<String, Object> linhaPedido = new HashMap<>();
        linhaPedido.put("nomeEmpresa", pedido.getNomeEmpresa());
        linhaPedido.put("enderecoEmpresa", pedido.getEnderecoEmpresa());
        linhaPedido.put("modalidadeEstagio", pedido.getModalidadeEstagio());
        linhaPedido.put("cargaHorariaSemanal", pedido.getCargaHorariaSemanal());
        linhaPedido.put("valorBolsa", pedido.getValorBolsa());
        linhaPedido.put("resumoAtividades", pedido.getResumoAtividades());
        linhaPedido.put("conteudosTeoricos", pedido.getConteudosTeoricos());
        linhaPedido.put("motivoIntencao", pedido.getMotivoIntencao());

        // Criando a tabela e adicionando a linha
        Tabela tabelaPedido = new Tabela();
        tabelaPedido.addLinha(linhaPedido);

        // Adicionando a tabela ao Resultset
        resultset.addTabela("pedidoIntencaoEstagio", tabelaPedido);

        // Retorna o Resultset com a tabela de pedidos
        return resultset;
    }
}
   