/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persitencia;

import Aplicacao.Entidade;
import Aplicacao.Repositorio;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public abstract class DaoGenerica <T extends Entidade> implements Repositorio<T>{
   
    protected Connection conn;
    private String consultaCadastrar;
    private String consultaEditar;
    private String consultaExcluir;
    private String consultaBuscar;
    private String consultaFiltrar;
    
    private String where;
    
    DaoGenerica(){
        try{
            Conexao.iniciar();
            conn = Conexao.criarConexao();
        }catch(ClassNotFoundException ex){
            System.out.println("Driver não encontrado");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        where = "";
    }

    @Override
    public boolean cadastrar(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(T obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> buscar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<T> filtrar(T filtro) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
            
    
}
