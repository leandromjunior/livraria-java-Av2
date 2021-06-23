package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bo.Livro;
import jdbc.ConnectionFactory;

public class LivroDAO {
    
    public void create(Livro livro){
        
        Connection banco = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{
            String sql = "insert into livro(codigo, titulo, categoria, preco) values (?,?,?,?)";

            stmt = banco.prepareStatement(sql);

            stmt.setString(1, livro.getCodigo());
            stmt.setString(2, livro.getTitulo());
            stmt.setString(3, livro.getCategoria());
            stmt.setString(4, livro.getPreco());

            stmt.executeUpdate();

            System.out.println("Livro cadastrado com sucesso !!");
        }
        catch(SQLException e){
            System.out.println("Erro no cadastro do livro.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }
    }

    public List<Livro> read(){

        List<Livro> listaLivros = new ArrayList<Livro>();

        Connection banco = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "select codigo, titulo, categoria, preco from livro";

        try{
            stmt = banco.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Livro livro = new Livro();

                livro.setCodigo(rs.getString("codigo"));
                livro.setTitulo(rs.getString("titulo"));
                livro.setCategoria(rs.getString("categoria"));
                livro.setPreco(rs.getString("preco"));

                listaLivros.add(livro);
            }
        }
        catch(SQLException e){
            System.out.println("Erro ao ler lista de livros.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }
        return listaLivros;
    }

    public void update(Livro livro){

        Connection banco = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{
            String sql = "update livro set titulo = ?, categoria = ?, preco = ? where codigo = ?";

            stmt = banco.prepareStatement(sql);

            stmt.setString(1, livro.getTitulo());
            stmt.setString(2, livro.getCategoria());
            stmt.setString(3, livro.getPreco());
            stmt.setString(4, livro.getCodigo());

            stmt.executeUpdate();
            System.out.println("Dados do livro atualizados com sucesso !!");
        }
        catch(SQLException e){
            System.out.println("Erro no update de livro.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }
    }

    public void delete(Livro livro){

        Connection banco = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try{
            String sql = "delete from livro where codigo = ?";

            stmt = banco.prepareStatement(sql);

            stmt.setString(1, livro.getCodigo());

            stmt.executeUpdate();

            System.out.println("Livro excluido com sucesso !!");
        }
        catch(SQLException e){
            System.err.println("Erro no delete do cliente.");
        }
        finally{
            ConnectionFactory.closeConnection(banco, stmt);
        }
    }
}
