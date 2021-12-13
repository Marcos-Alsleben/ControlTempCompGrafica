/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTCG.dao;

import CTCG.jdbc.ConnectionFactory;
import CTCG.model.HorasCompGraf;
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
public class HorasCompGrafDAO {

    private Connection con;

    public HorasCompGrafDAO() {
        this.con = new ConnectionFactory().getConnection();
    }

    //Metodo cadastrar
    public void cadastrar(HorasCompGraf obj) {
        try {
            //Cria comando sql
            String sql = "insert into horascompgraf (cadoperador, nomeoperador, ordemprod,"
                    + "obs, inicio, termino, criado, modificado) values (?,?,?,?,?,?,?,?)";

            //Conecta ao banco de dados e organiza o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCadoperador());
            stmt.setString(2, obj.getNomeoperador());
            stmt.setString(3, obj.getOrdemprod());
            stmt.setString(4, obj.getObs());
            stmt.setString(5, obj.getInicio());
            stmt.setString(6, obj.getTermino());
            stmt.setString(7, obj.getCriado());
            stmt.setString(8, obj.getModificado());

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
    public void alterar(HorasCompGraf obj) {
        try {
            //Cria comando sql
            String sql = "update horascompgraf set "
                    + "cadoperador=?, nomeoperador=?, ordemprod=?, obs=?, inicio=?,"
                    + "termino=?, criado=?, modificado=? where cod_hcg=?";

            //Conecta ao banco de dados e organiza o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCadoperador());
            stmt.setString(2, obj.getNomeoperador());
            stmt.setString(3, obj.getOrdemprod());
            stmt.setString(4, obj.getObs());
            stmt.setString(5, obj.getInicio());
            stmt.setString(6, obj.getTermino());
            stmt.setString(7, obj.getCriado());
            stmt.setString(8, obj.getModificado());
            stmt.setInt(9, obj.getCod_hcg());

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
    public void excluir(HorasCompGraf obj) {
        try {
            //Cria o comando sql
            String sql = "delete from horascompgraf where cod_hcg=?";

            //Conecta ao banco de dados e organiza o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, obj.getCod_hcg());

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
    public List<HorasCompGraf> listar() {
        try {
            //Cria Lista
            List<HorasCompGraf> lista = new ArrayList<>();

            //Cria comando sql
            String sql = "SELECT *, TIMESTAMPDIFF\n"
                    + "(HOUR, inicio + INTERVAL TIMESTAMPDIFF(DAY,  inicio, termino) DAY, \n"
                    + "termino) AS h, TIMESTAMPDIFF\n"
                    + "(MINUTE, inicio + INTERVAL TIMESTAMPDIFF(HOUR, inicio, termino) HOUR, \n"
                    + "termino) AS m from bdchapa.horascompgraf order by criado asc;";

            //Conecta ao banco de dados e organiza o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                HorasCompGraf obj = new HorasCompGraf();
                obj.setCod_hcg(rs.getInt("cod_hcg"));
                obj.setCadoperador(rs.getInt("cadoperador"));
                obj.setNomeoperador(rs.getString("nomeoperador"));
                obj.setOrdemprod(rs.getString("ordemprod"));
                obj.setObs(rs.getString("obs"));
                obj.setInicio(rs.getString("inicio"));
                obj.setTermino(rs.getString("termino"));
                obj.setCriado(rs.getString("criado"));
                obj.setModificado(rs.getString("modificado"));
                obj.setH(rs.getInt("h"));
                obj.setM(rs.getInt("m"));

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
    public List<HorasCompGraf> Pesquisar(String rp){
        
        try {
            //Cria a Lista
            List<HorasCompGraf> lista = new ArrayList<>();
            
            //Cria comando sql
            String sql = "SELECT *, TIMESTAMPDIFF\n"
                    + "(HOUR, inicio + INTERVAL TIMESTAMPDIFF(DAY,  inicio, termino) DAY, \n"
                    + "termino) AS h, TIMESTAMPDIFF\n"
                    + "(MINUTE, inicio + INTERVAL TIMESTAMPDIFF(HOUR, inicio, termino) HOUR, \n"
                    + "termino) AS m from bdchapa.horascompgraf where ordemprod=? order by criado asc";
            
            //Conecta ao banco de dados e organiza o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, rp);                      
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()){
                
                HorasCompGraf obj = new HorasCompGraf();
                obj.setCod_hcg(rs.getInt("cod_hcg"));
                obj.setCadoperador(rs.getInt("cadoperador"));
                obj.setNomeoperador(rs.getString("nomeoperador"));
                obj.setOrdemprod(rs.getString("ordemprod"));
                obj.setObs(rs.getString("obs"));
                obj.setInicio(rs.getString("inicio"));
                obj.setTermino(rs.getString("termino"));
                obj.setCriado(rs.getString("criado"));
                obj.setModificado(rs.getString("modificado"));
                obj.setH(rs.getInt("h"));
                obj.setM(rs.getInt("m"));
                
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
