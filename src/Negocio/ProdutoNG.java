/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import BaseDados.ConnectionFactory;
import Entidades.Produto;
import Entidades.Sessao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author usrlab09
 */
public class ProdutoNG extends BaseNG{
    private Connection conexao;    

    public ProdutoNG(Sessao sessao) throws Exception {
        
        try {
            this.conexao = ConnectionFactory.createConnection();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ProdutoNG(){        
    }
    
    public boolean Cadastrar(Produto produto) throws Exception {
        return new BaseDados.DAOs.ProdutoDAO(conexao).Cadastrar(produto);
    }
    
    public Produto buscarNome(String nome) throws Exception {
        return new BaseDados.DAOs.ProdutoDAO(conexao).BuscarNome(nome);
    }
    
    public List<Produto> listarTodos() throws Exception {
        return new BaseDados.DAOs.ProdutoDAO(conexao).listarTodos();
    }
    
}
