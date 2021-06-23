package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Cliente;
import jdbc.ConnectionFactory;

public class ClienteDAO {
    
    public void create(Cliente cliente){
        
        Connection banco = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try{
            String sql = "insert into cliente(id, nome, estado) values (?,?,?)";

            stmt = banco.prepareStatement(sql);

            stmt.setString(1, cliente.getId());
            stmt.setString(2, cliente.getNome());
            stmt.setString(3, cliente.getEstado());

            stmt.executeUpdate();

            System.out.println("Cliente cadastrado com sucesso !!");
        }
        catch(SQLException e){
            System.out.println("Erro ao cadastrar cliente.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }
    }

    // select do cliente
    public List<Cliente> read(){
        
        List<Cliente> listaClientes = new ArrayList<Cliente>();

        Connection banco = ConnectionFactory.getConnection();
		PreparedStatement stmt = null;
		ResultSet rs = null;

        String sql = "select id, nome, estado from cliente";

        try{
            stmt = banco.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Cliente cliente = new Cliente();

                cliente.setId(rs.getString("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEstado(rs.getString("estado"));

                listaClientes.add(cliente);
            }
        }
        catch(SQLException e){
            System.out.println("Erro ao ler cliente.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }

        return listaClientes;
    }

    //Update do cliente
    public void update(Cliente cliente){

        Connection banco = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try{
            String sql = "update cliente set nome = ?, estado = ? where id = ?";

            stmt = banco.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEstado());
            stmt.setString(3, cliente.getId());

            stmt.executeUpdate();
            System.out.println("Dados do cliente alterados com sucesso !!");
        }
        catch(SQLException e){

            System.out.println("Erro no update do cliente.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }
    }

    public void delete(Cliente cliente){

        Connection banco = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{
            String sql = "delete from cliente where id = ?";

            stmt = banco.prepareStatement(sql);

            stmt.setString(1, cliente.getId());

            stmt.executeUpdate();

            System.out.println("Cliente excluido com sucesso !!");
        }
        catch(SQLException e){
            System.out.println("Erro no delete do cliente.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }
    }
}
