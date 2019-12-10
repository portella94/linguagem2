/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import BaseDados.ConnectionFactory;
import Entidades.Pessoa;
import Entidades.Sessao;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author usrlab09
 */
public class PessoaNG extends BaseNG{
    private Connection conexao;

    public PessoaNG(Sessao sessao) throws Exception {
        
        try {
            this.conexao = ConnectionFactory.createConnection();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public boolean Cadastrar(Pessoa pessoa) throws Exception {
        return new BaseDados.DAOs.PessoaDAO(conexao).Cadastrar(pessoa);
    }
    
    public Pessoa buscarNome(String nome) throws Exception {
        return new BaseDados.DAOs.PessoaDAO(conexao).BuscarNome(nome);
    }
    
    public List<Pessoa> listarTodos() throws Exception {
        return new BaseDados.DAOs.PessoaDAO(conexao).listarTodos();
    }
}
