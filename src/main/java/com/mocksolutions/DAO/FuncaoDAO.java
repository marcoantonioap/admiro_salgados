/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mocksolutions.DAO;

import java.sql.SQLException;
import com.mocksolutions.Model.Funcao;
import com.mocksolutions.Persistencia.Banco;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author marco
 */
public class FuncaoDAO implements DAO <Funcao>{

    //variaveis auxiliares
    private Funcao funcao;
    //auxiliares para acesso aos dados
    
    //para conter os comandos DML
    private PreparedStatement pst;
    //para conter os dados vindos do BD
    private ResultSet rs;
    
    @Override
    public boolean insere(Funcao dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean remove(Funcao dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean altera(Funcao dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Funcao buscaID(Funcao dado) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Collection<Funcao> lista(String filtro) throws SQLException {
        //Criar uma coleção
        Collection<Funcao> listagem = new ArrayList<>();
               
        //Comando SELECT
        String sql = "SELECT * FROM tb_tipo_usuario";
        
        //colocar filtro ou nao
        if(filtro.length() != 0){
            sql += "WHERE " + filtro;
        }
        
        //conecta ao banco
        Banco.conectar();
        
        pst = Banco.obterConexao().prepareStatement(sql);
        
        //Executa o comando SELECT
        rs = pst.executeQuery();
        
        //le o próximo registro
        while(rs.next()){
            //cria o objeto funcao
            funcao = new Funcao();
            //move os dados do resultSet para o objeto funcao
            funcao.setId(rs.getInt("id"));
            funcao.setNomeFuncao(rs.getString("nome_funcao"));
            
            //adicionar na coleção
            listagem.add(funcao);
        }
        
        Banco.desconectar();
        return listagem;
    }
    
}
