package camada_dados;

import entidades.result_set.Resultset;
import entidades.result_set.Tabela;
import java.util.HashMap;
import java.util.Map;

public class DiscenteGateway {

    // Método que simula a recuperação do discente e seus dados
    public Resultset buscarDiscente(String email, String senha) {
        // Criando um Resultset para armazenar os dados do discente
        Resultset resultset = new Resultset();
        
        // Criando a tabela 'discente' e preenchendo com os dados do discente
        Tabela discenteTabela = new Tabela();
        Map<String, Object> linha = new HashMap<>();
        
        // Adicionando dados do discente
        linha.put("email", "jessica@exemplo.com"); // Email do discente
        linha.put("senha", "123456");

        // Adicionando a linha à tabela
        discenteTabela.addLinha(linha);
        
        // Adicionando a tabela 'discente' ao Resultset
        resultset.addTabela("discente", discenteTabela);
        
        return resultset;
    }
}