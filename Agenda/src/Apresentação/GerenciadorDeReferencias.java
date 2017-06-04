/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Apresentação;

import Aplicacao.ContatosRepositorio;
import Persitencia.ContatosDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class GerenciadorDeReferencias {

    private static ContatosRepositorio daoContatos;

    public static ContatosRepositorio getContatos() {
        try {
            if (daoContatos == null) {
                daoContatos = new ContatosDao();
            }
            return daoContatos;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return null;
    }

}
