/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CTCG.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author mrs_a
 */
public class ConnectionFactory {

    public Connection getConnection() {

        try {

            return DriverManager.getConnection("jdbc:mysql://localhost:3306/bdchapa", "carton", "2574");

        } catch (Exception erro) {
            throw new RuntimeException(erro);
        }

    }

    
     

  
}