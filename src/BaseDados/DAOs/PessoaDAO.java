package BaseDados.DAOs;

import BaseDados.BaseDAO;
import Entidades.Enumeradores.EstadoCivil;
import Entidades.Pessoa;
import Entidades.Ticket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;

public class PessoaDAO extends BaseDAO {

    /*
     * Construtor que recebe como parametro uma conexao com o banco de dado. 
     */
    public PessoaDAO(Connection con) {
        this.con = con;
    }

    public boolean Cadastrar(Pessoa pessoa) throws Exception {
        PreparedStatement p
                = con.prepareStatement("insert into pessoas (nome, email, estado_civil, sexo, maior_idade, escolaridade, outras_informacoes) "
                        + "values (?,?,?,?,?,?,?)");
        p.setString(1, pessoa.getNome());
        p.setString(2, pessoa.getEmail());
        p.setInt(3, pessoa.getEstadoCivil());
        p.setInt(4, pessoa.getSexo());
        p.setBoolean(5, pessoa.isMaior18());
        p.setString(6, pessoa.getEscolaridade());
        p.setString(7, pessoa.getOutrasInformacoes());
        p.executeUpdate();
        p.close();
        return true;
    }

    public boolean Deletar(Pessoa pessoa) throws Exception {
        PreparedStatement p = con.prepareStatement("delete from pessoas where id = ?");
        p.setInt(1, pessoa.getId());
        p.executeUpdate();
        p.close();
        return true;
    }

    public boolean Atualizar(Pessoa pessoa) throws Exception {
        PreparedStatement p
                = con.prepareStatement("update pessoas set "
                        + "nome = ?, email = ?, estado_civil = ?, sexo = ?, maior_idade = ?, escolaridade = ?, outras_informacoes = ?"
                        + " where id = ?");
        p.setString(1, pessoa.getNome());
        p.setString(2, pessoa.getEmail());
        p.setInt(3, pessoa.getEstadoCivil());
        p.setInt(4, pessoa.getSexo());
        p.setBoolean(5, pessoa.isMaior18());
        p.setString(6, pessoa.getEscolaridade());
        p.setString(7, pessoa.getOutrasInformacoes());
        p.executeUpdate();
        p.close();
        return true;
    }

    public List<Pessoa> listarTodos() throws Exception {
        List<Pessoa> pessoas = new ArrayList<Pessoa>();
        PreparedStatement p = con.prepareStatement("select * from pessoas");
        ResultSet rs = p.executeQuery();
        while (rs.next()) {
            Pessoa pessoa = new Pessoa();
            pessoa.setId(rs.getInt("idPessoa"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setEmail(rs.getString("email"));
            pessoa.setEstadoCivil(rs.getInt("estado_civil"));
            pessoa.setSexo(rs.getInt("sexo"));
            pessoa.setMaior18(rs.getBoolean("maior_idade"));
            pessoa.setEscolaridade(rs.getString("escolaridade"));
            pessoa.setOutrasInformacoes(rs.getString("outras_informacoes"));
            pessoas.add(pessoa);
        }
        rs.close();
        p.close();
        return pessoas;
    }

    public Pessoa BuscarNome(String nome) throws Exception {
        PreparedStatement p = con.prepareStatement("select * from pessoas where nome like ?");
        p.setString(1, "%" + nome + "%");
        ResultSet rs = p.executeQuery();
        Pessoa pessoa = new Pessoa();
        if (rs.next()) {
            pessoa.setId(rs.getInt("idPessoa"));
            pessoa.setNome(rs.getString("nome"));
            pessoa.setEmail(rs.getString("email"));
            pessoa.setEstadoCivil(rs.getInt("estado_civil"));
            pessoa.setSexo(rs.getInt("sexo"));
            pessoa.setMaior18(rs.getBoolean("maior_idade"));
            pessoa.setEscolaridade(rs.getString("escolaridade"));
            pessoa.setOutrasInformacoes(rs.getString("outras_informacoes"));
        }
        rs.close();
        p.close();
        return pessoa;
    }

}
