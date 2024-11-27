<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Criar pedido de Inten��o de Est�gio</title>
</head>
<body>
    <h1>Criar pedido de Inten��o de Est�gio</h1>
    <form action="PedidoIntencaoEstagioServlet" method="post">
        <label for="ira">IRA:</label>
        <input type="number" id="ira" name="ira" step="0.01" required>
        <br>
        <label for="creditosCumpridos">Cr�ditos Cumpridos:</label>
        <input type="number" id="creditosCumpridos" name="creditosCumpridos" required>
        <br>
        <label for="enderecoResidencial">Endere�o Residencial:</label>
        <input type="text" id="enderecoResidencial" name="enderecoResidencial" required>
        <br>
        <label for="primeiroEstagio">� o primeiro est�gio?</label>
        <select id="primeiroEstagio" name="primeiroEstagio" required>
            <option value="true">Sim</option>
            <option value="false">N�o</option>
        </select>
        <br>
        <label for="nomeEmpresa">Nome da Empresa:</label>
        <input type="text" id="nomeEmpresa" name="nomeEmpresa" required>
        <br>
        <label for="enderecoEmpresa">Endere�o da Empresa:</label>
        <input type="text" id="enderecoEmpresa" name="enderecoEmpresa" required>
        <br>
        <label for="modalidadeEstagio">Modalidade do Est�gio:</label>
        <input type="text" id="modalidadeEstagio" name="modalidadeEstagio" required>
        <br>
        <label for="cargaHorariaSemanal">Carga Hor�ria Semanal:</label>
        <input type="number" id="cargaHorariaSemanal" name="cargaHorariaSemanal" required>
        <br>
        <label for="valorBolsa">Valor da Bolsa:</label>
        <input type="number" id="valorBolsa" name="valorBolsa" step="0.01" required>
        <br>
        <label for="resumoAtividades">Resumo das Atividades:</label>
        <textarea id="resumoAtividades" name="resumoAtividades" required></textarea>
        <br>
        <label for="conteudosTeoricos">Conte�dos Te�ricos:</label>
        <textarea id="conteudosTeoricos" name="conteudosTeoricos" required></textarea>
        <br>
        <label for="motivoIntencao">Motivo da Inten��o:</label>
        <textarea id="motivoIntencao" name="motivoIntencao" required></textarea>
        <br>
        <button type="submit">Enviar Pedido</button>
    </form>
</body>
</html>
