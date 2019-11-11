/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDados.DAOs;

import BaseDados.BaseDAO;
import Entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author usrlab09
 */
public class ProdutoDAO extends BaseDAO {

    /*
     * Construtor que recebe como parametro uma conexao com o banco de dado. 
     */
    public ProdutoDAO(Connection con) {
        this.con = con;
    }

    public boolean Cadastrar(Produto produto) throws Exception {
        PreparedStatement p
                = con.prepareStatement("INSERT INTO produto (descricao, marca) "
                        + " VALUES (?,?) ");
        p.setString(1, produto.getDescricao());
        p.setString(2, produto.getMarca());        
        p.executeUpdate();
        p.close();
        return true;
    }

    public boolean Deletar(Produto produto) throws Exception {
        PreparedStatement p = con.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
        p.setInt(1, produto.getIdProduto());
        p.executeUpdate();
        p.close();
        return true;
    }

    public boolean Atualizar(Produto produto) throws Exception {
        PreparedStatement p
                = con.prepareStatement("UPDATE produto SET "
                        + "descricao = ?, marca = ? "
                        + " WHERE idProduto = ?");
        p.setInt(1, produto.getIdProduto());
        p.setString(2, produto.getDescricao());
        p.setString(3, produto.getMarca());
        p.executeUpdate();
        p.close();
        return true;
    }

    public List<Produto> listarTodos() throws Exception {
        List<Produto> produtos = new ArrayList<Produto>();
        PreparedStatement p = con.prepareStatement("SELECT * FROM produto");
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            Produto produto = new Produto();
            produto.setIdProduto(rs.getInt("idProduto"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setMarca(rs.getString("marca"));
            produtos.add(produto);
        }
        rs.close();
        p.close();
        return produtos;
    }

    public Produto BuscarNome(String nome) throws Exception {
        PreparedStatement p = con.prepareStatement("SELECT * FROM produto WHERE nome LIKE ?");
        p.setString(1, "%" + nome + "%");
        ResultSet rs = p.executeQuery();
        Produto produto = new Produto();
        if (rs.next()) {
            produto.setIdProduto(rs.getInt("idProduto"));
            produto.setDescricao(rs.getString("descricao"));
            produto.setMarca(rs.getString("marca"));
        }
        rs.close();
        p.close();
        return produto;
    }
    
}
