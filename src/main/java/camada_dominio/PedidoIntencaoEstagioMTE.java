package camada_dominio;

public class PedidoIntencaoEstagioMTE {

    //Cria o pedido de intenção de estágio após validação das regras de negócio.
    public static void criarPedidoDeIntencao(int creditosCumpridos, double ira,
                                             String enderecoResidencial, boolean primeiroEstagio,
                                             String nomeEmpresa, String enderecoEmpresa,
                                             String modalidadeEstagio, int cargaHorariaSemanal,
                                             double valorBolsa, String resumoAtividades,
                                             String conteudosTeoricos, String motivoIntencao) throws Exception {
        if (!EstagioMTE.verificarRN1(creditosCumpridos)) {
            throw new Exception("O(a) discente tem que ter cumprido 80 (oitenta) creditos dentre as disciplinas obrigatorias.");
        }

        if (!EstagioMTE.verificarRN2(ira)) {
            throw new Exception("O(a) discente tem que ter o Indice de Rendimento Academico (IRA) maior ou igual a 6,0 (seis) "
            		+ "ou IRA dos dois ultimos periodos maiores ou iguais a 7,0 (sete).");
        }

        if (!EstagioMTE.verificarRN3(cargaHorariaSemanal)) {
            throw new Exception("O Estagio Supervisionado devera ter carga horaria\r\n"
            		+ "maxima de 30 (trinta) horas por semana.");
        }

        System.out.println("Pedido de intençao de estagio criado com sucesso!");
    }
}