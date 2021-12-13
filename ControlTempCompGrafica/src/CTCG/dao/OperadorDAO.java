/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTCG.dao;

import CTCG.jdbc.ConnectionFactory;
import CTCG.model.Operador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class OperadorDAO {

    private Connection con;

    public OperadorDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodo cadastrar
    public void cadastrar(Operador obj) {
        try {
            //Cria comando sql
            String sql = "insert into operador (cadastro, nome) values (?,?)";

            //Conecta ao banco de dados e organiza o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCadastro());
            stmt.setString(2, obj.getNome());

            //Executa o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!");

        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    //Metodo Alterar
    public void alterar(Operador obj) {
        try {
            //Cria comando sql
            String sql = "update operador set "
                    + "cadastro=?, nome=? where cod_oper=?";

            //Conecta ao banco de dados e organiza o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCadastro());
            stmt.setString(2, obj.getNome());
            stmt.setInt(3, obj.getCod_oper());

            //Executa o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Alterado com Sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    //Metodo Excluir
    public void excluir(Operador obj) {
        try {
            //Cria o comando sql
            String sql = "delete from operador where cod_oper=?";

            //Conecta ao banco de dados e organiza o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCod_oper());

            //Executa o comando sql
            stmt.execute();
            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(null, "Excluido com Sucesso!");
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro: " + erro);
        }
    }

    //Metodo Listar
    public List<Operador> listar() {
        try {
            //Cria Lista
            List<Operador> lista = new ArrayList<>();

            //Cria comando sql
            String sql = "select * from operador order by nome asc";

            //Conecta ao banco de dados e organiza o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Operador obj = new Operador();
                obj.setCod_oper(rs.getInt("cod_oper"));
                obj.setCadastro(rs.getInt("cadastro"));
                obj.setNome(rs.getString("nome"));

                //Executa
                lista.add(obj);
            }
            con.close();
            return lista;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }
    
    //Metodo Pesquisar
    public List<Operador> pesquisarCadOperador(String nome){
        
        try {
            //Cria a Lista
            List<Operador> lista = new ArrayList<>();
            
            //Cria comando sql
            String sql = "select * from operador where nome=?";
            
            //Conecta ao banco de dados e organiza o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);                                        
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                
                Operador obj = new Operador();
                obj.setCod_oper(rs.getInt("cod_oper"));
                obj.setCadastro(rs.getInt("cadastro"));
                obj.setNome(rs.getString("nome"));
                
                //Executa
                lista.add(obj);
            }
            con.close();
            return lista;
        } catch (Exception erro) {
            JOptionPane.showMessageDialog(null, "Erro:" + erro);
            return null;
        }
    }

}
