package camada_servico;

import camada_dominio.EstagioMTE;
import camada_dados.PedidoIntencaoEstagioGateway;
import entidades.PedidoIntencaoEstagio;
import entidades.result_set.Resultset;
import entidades.result_set.Tabela;

public class PedidoIntencaoEstagioServico {

    private PedidoIntencaoEstagioGateway pedidoIntencaoEstagioGateway;

    public PedidoIntencaoEstagioServico() {
        this.pedidoIntencaoEstagioGateway = new PedidoIntencaoEstagioGateway();
    }

    public Resultset processarPedido(int creditosCumpridos, double ira, String enderecoResidencial, 
            boolean primeiroEstagio, String nomeEmpresa, String enderecoEmpresa, 
            String modalidadeEstagio, int cargaHorariaSemanal, double valorBolsa,
            String resumoAtividades, String conteudosTeoricos, String motivoIntencao) throws Exception {

        // Validar o IRA e outros dados de entrada
        if (!EstagioMTE.verificarRN2(ira)) {
            throw new Exception("O seu Indice de Rendimento Academico (IRA) precisa ser superior a 6.0 para criar um pedido de intencao de estagio.");
        }

        // Criar a instância de PedidoIntencaoEstagio
        PedidoIntencaoEstagio pedido = new PedidoIntencaoEstagio();
        pedido.setCreditosCumpridos(creditosCumpridos);
        pedido.setIra(ira);
        pedido.setEnderecoResidencial(enderecoResidencial);
        pedido.setPrimeiroEstagio(primeiroEstagio);
        pedido.setNomeEmpresa(nomeEmpresa);
        pedido.setEnderecoEmpresa(enderecoEmpresa);
        pedido.setModalidadeEstagio(modalidadeEstagio);
        pedido.setCargaHorariaSemanal(cargaHorariaSemanal);
        pedido.setValorBolsa(valorBolsa);
        pedido.setResumoAtividades(resumoAtividades);
        pedido.setConteudosTeoricos(conteudosTeoricos);
        pedido.setMotivoIntencao(motivoIntencao);

        // Salvar o pedido e retornar o Resultset
        return pedidoIntencaoEstagioGateway.salvarPedido(pedido);
    }
}
