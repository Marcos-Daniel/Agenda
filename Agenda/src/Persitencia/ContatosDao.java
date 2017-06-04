/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persitencia;

import Aplicacao.Contatos;
import Aplicacao.ContatosRepositorio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class ContatosDao extends DaoGenerica<Contatos> implements ContatosRepositorio {
        
        public ContatosDao() throws SQLException{
            setConsultaCadastrar("INSERT INTO CONTATOS(NOME,EMAIL,TELEFONE)VALUES(?,?,?)");
            setConsultaEditar("UPDATE CONTATOS SET NOME=?, EMAIL=?, TELEFONE=? WHERE ID=?");
            setConsultaExcluir("DELETE FROM CONTATOS WHERE ID=?");
            setConsultaBuscar("SELECT NOME,EMAIL,TELEFONE FROM CONTATOS");
            setConsultaFiltrar("SELECT NOME,EMAIL,TELEFONE FROM CONTATOS");
        }

    @Override
    protected Contatos preencherObjeto(ResultSet resultado) {
        try {
            Contatos tmp = new Contatos();
            tmp.setId(resultado.getInt(1));
            tmp.setNome(resultado.getString(2));
            tmp.setEmail(resultado.getString(3));
            tmp.setTelefone(resultado.getString(4));
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherObjeto");
        }
        return null;
    }

    @Override
    protected void preencherConsulta(PreparedStatement sql, Contatos obj) {
        try {
            sql.setString(1, obj.getNome());
            sql.setString(2, obj.getEmail());
            sql.setString(3, obj.getTelefone());
            if(obj.getId() > 0) sql.setInt(1, obj.getId());
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherConsulta");
        }
        
    }

    @Override
    protected void preencherFiltros(Contatos filtro) {
        if(filtro.getId() > 0) adicionarFiltro("id", "=");
        if(filtro.getNome() != null) adicionarFiltro("nome", "=");
        if(filtro.getTelefone()!= null) adicionarFiltro("telefone", "=");
    }

    @Override
    protected void preencherParametros(PreparedStatement sql, Contatos filtro) {
        try {
            int cont=1; 
            if(filtro.getId() > 0){
                sql.setInt(cont, filtro.getId());
                cont++;
            }    
            
            if(filtro.getNome() != null){
                sql.setString(cont, filtro.getNome());
                cont++;
            }
            
            if(filtro.getTelefone()!= null){
                sql.setString(cont, filtro.getTelefone());
                cont++;
            }
                
        } catch (SQLException ex) {
            System.out.println(ex + "ContatosDao preencherParametros");
        }
                
    }
    
}
