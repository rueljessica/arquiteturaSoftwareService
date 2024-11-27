package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.Map;

import camada_dominio.EstagioMTE;
import camada_dominio.PedidoIntencaoEstagioMTE;
import camada_servico.PedidoIntencaoEstagioServico;

@WebServlet("/PedidoIntencaoEstagioServlet")
public class PedidoIntencaoEstagioServlet extends HttpServlet {
	
	private PedidoIntencaoEstagioServico pedidoIntencaoEstagioServico;
	
	public PedidoIntencaoEstagioServlet() {
        pedidoIntencaoEstagioServico = new PedidoIntencaoEstagioServico();
    }
	
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        // Recuperando os dados do discente como um HashMap
        Map<String, Object> discente = (Map<String, Object>) session.getAttribute("discente");

        if (discente == null) {
            response.getWriter().println("Erro: Sessao expirada ou usuario nao autenticado.");
            return;
        }

        try {
            // Captura os parâmetros do formulário
            int creditosCumpridos = Integer.parseInt(request.getParameter("creditosCumpridos"));
            double ira = Double.parseDouble(request.getParameter("ira"));
            String enderecoResidencial = request.getParameter("enderecoResidencial");
            boolean primeiroEstagio = Boolean.parseBoolean(request.getParameter("primeiroEstagio"));
            String nomeEmpresa = request.getParameter("nomeEmpresa");
            String enderecoEmpresa = request.getParameter("enderecoEmpresa");
            String modalidadeEstagio = request.getParameter("modalidadeEstagio");
            int cargaHorariaSemanal = Integer.parseInt(request.getParameter("cargaHorariaSemanal"));
            double valorBolsa = Double.parseDouble(request.getParameter("valorBolsa"));
            String resumoAtividades = request.getParameter("resumoAtividades");
            String conteudosTeoricos = request.getParameter("conteudosTeoricos");
            String motivoIntencao = request.getParameter("motivoIntencao");

            // Chama o serviço para processar o pedido de intenção de estágio
            pedidoIntencaoEstagioServico.processarPedido(creditosCumpridos, ira, enderecoResidencial,
                primeiroEstagio, nomeEmpresa, enderecoEmpresa, modalidadeEstagio, cargaHorariaSemanal, valorBolsa,
                resumoAtividades, conteudosTeoricos, motivoIntencao);

            response.getWriter().println("<div style='color: green;'>Seu pedido de intençao de estagio foi criado com sucesso!</div>");
        } catch (Exception e) {
            response.getWriter().println("<div style='color: red;'>Nao foi possível criar o pedido: " + e.getMessage() + "</div>");
        }
    }
}
