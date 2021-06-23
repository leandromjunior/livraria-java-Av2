package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Funcionario;
import jdbc.ConnectionFactory;

public class FuncionarioDAO{

    public void create(Funcionario func){

        Connection banco = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{
            String sql = "insert into funcionario(codigoFunc, nome, cargo, nascimento) values (?,?,?,?)";

            stmt = banco.prepareStatement(sql);

            stmt.setString(1, func.getCodigoFunc());
            stmt.setString(2, func.getNome());
            stmt.setString(3, func.getCargo());
            stmt.setString(4, func.getNascimento());

            stmt.executeUpdate();

            System.out.println("Funcionario cadastrado com sucesso !!");
        }
        catch(SQLException e){
            System.out.println("Erro no cadastro de funcionario.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }
    }

    //select do funcionario
    public List<Funcionario> read(){

        List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

        Connection banco = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select codigoFunc, nome, cargo, nascimento from funcionario";

        try{
            stmt = banco.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Funcionario func = new Funcionario();

                func.setCodigoFunc(rs.getString("codigoFunc"));
                func.setNome(rs.getString("nome"));
                func.setCargo(rs.getString("cargo"));
                func.setNascimento(rs.getString("nascimento"));

                listaFuncionarios.add(func);
            }
        }
        catch(SQLException e){
            System.out.println("Erro ao listar funcionarios.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }

        return listaFuncionarios;
    }

    public void update(Funcionario func){

        Connection banco = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try{
            String sql = "update funcionario set nome = ?, cargo = ?, nascimento = ? where codigoFunc = ?";

            stmt = banco.prepareStatement(sql);

            stmt.setString(1, func.getNome());
            stmt.setString(2, func.getCargo());
            stmt.setString(3, func.getNascimento());
            stmt.setString(4, func.getCodigoFunc());

            stmt.executeUpdate();
            System.out.println("Dados do funcionario alterados com sucesso !!");
        }
        catch(SQLException e){
            System.out.println("Erro no update do funcionario.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }
    }

    public void delete(Funcionario func){

        Connection banco = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{
            String sql = "delete from funcionario where codigoFunc = ?";

            stmt = banco.prepareStatement(sql);

            stmt.setString(1, func.getCodigoFunc());

            stmt.executeUpdate();

            System.out.println("Dados do funcionario excluidos com sucesso !!");
        }
        catch(SQLException e){
            System.out.println("Erro no delete do funcionario.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }
    }
}