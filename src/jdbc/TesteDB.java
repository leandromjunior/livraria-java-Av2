package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteDB {
	
	public static void main(String[] args) {
        
        try{
            Connection banco = ConnectionFactory.getConnection();
            System.out.println("Conexão OK!!");
            
          createNewTable(banco);
          createNewTableFunc(banco);
          createNewTableLivro(banco);

        }
        catch(Exception e){
            System.out.println("Erro na conexão<<<>>>");
            System.out.println(e);
        }
    }
	
public static void createNewTable(Connection banco) {
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS cliente (\n"
                + "	id varchar(10) NOT NULL ,\n"
                + "	nome varchar(50) NOT NULL,\n"
                + "	estado varchar(50) NOT NULL\n"
                + ");";
        
        try {
			
        	Statement stmt = banco.createStatement();
            
        	//create a new table
            stmt.execute(sql);
                
			System.out.println("Tabela Cliente criada!!!");
		}
		catch(Exception e)
		{
			System.out.println("Erro na criacao da tabela Cliente");
			System.out.println(e);
		}
             
    }

    public static void createNewTableFunc(Connection banco) {
        
        // SQL statement for creating a new table
        String sql2 = "CREATE TABLE IF NOT EXISTS funcionario (\n"
                + "	codigoFunc varchar(10) NOT NULL ,\n"
                + "	nome varchar(50) NOT NULL,\n"
                + "	cargo varchar(50) NOT NULL,\n"
                + "	nascimento varchar(50) NOT NULL\n"
                + ");";
        
        try {
			
        	Statement stmt = banco.createStatement();
            
        	//create a new table
            stmt.execute(sql2);
                
			System.out.println("Tabela Funcionario criada!!!");
		}
		catch(Exception e)
		{
			System.out.println("Erro na criacao da tabela Funcionario");
			System.out.println(e);
		}
             
    }

    public static void createNewTableLivro(Connection banco) {
        
        // SQL statement for creating a new table
        String sql3 = "CREATE TABLE IF NOT EXISTS livro (\n"
                + "	codigo varchar(10) NOT NULL ,\n"
                + "	titulo varchar(50) NOT NULL,\n"
                + "	categoria varchar(50) NOT NULL,\n"
                + "	preco varchar(50) NOT NULL\n"
                + ");";
        
        try {
			
        	Statement stmt = banco.createStatement();
            
        	//create a new table
            stmt.execute(sql3);
                
			System.out.println("Tabela Livro criada!!!");
		}
		catch(Exception e)
		{
			System.out.println("Erro na criacao da tabela Livro");
			System.out.println(e);
		}
             
    }

public static void readTableTest(Connection banco) {
    
    // SQL statement for creating a new table
    String sql = "select * from cliente;";
    
    PreparedStatement stmt = null;
	ResultSet rs = null;

	//Try tabela Cliente
	try{
		stmt = banco.prepareStatement(sql);
		rs = stmt.executeQuery();
		
		if (rs.next())
			System.out.println("Com registro de cliente");
		else
			System.out.println("Sem registro de cliente");
			
	}catch(SQLException e)
	{
		System.out.println("<DAO> Erro lendo banco (Cliente)");
	}
	finally {
		ConnectionFactory.closeConnection(banco, stmt);
	    }
    }

    public static void readTableTestFunc(Connection banco) {
    
        // SQL statement for creating a new table
        String sql2 = "select * from funcionario;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
    
        //Try tabela Funcionario
        try{
            stmt = banco.prepareStatement(sql2);
            rs = stmt.executeQuery();
            
            if (rs.next())
                System.out.println("Com registro de funcionario");
            else
                System.out.println("Sem registro de funcionario");
                
        }catch(SQLException e)
        {
            System.out.println("<DAO> Erro lendo banco (Funcionario)");
        }
        finally {
            ConnectionFactory.closeConnection(banco, stmt);
        }
    }

        public static void readTableTestLivro(Connection banco) {
    
            // SQL statement for creating a new table
            String sql3 = "select * from livro;";
            
            PreparedStatement stmt = null;
            ResultSet rs = null;
        
            //Try tabela Livro
            try{
                stmt = banco.prepareStatement(sql3);
                rs = stmt.executeQuery();
                
                if (rs.next())
                    System.out.println("Com registro de livro");
                else
                    System.out.println("Sem registro de livro");
                    
            }catch(SQLException e)
            {
                System.out.println("<DAO> Erro lendo banco (Livro)");
            }
            finally {
                ConnectionFactory.closeConnection(banco, stmt);
            }
	    }
}