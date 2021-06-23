package controller;

import java.util.ArrayList;
import java.util.List;

import bo.Cliente;
import model.ClienteDAO;

public class ClienteController {
    
    public void create(Cliente cliente){
        
        ClienteDAO model = new ClienteDAO();

        model.create(cliente);
    }

    public List<Cliente> read(){

        List<Cliente> listaClientes = new ArrayList<Cliente>();

        try{
            ClienteDAO model = new ClienteDAO();
            listaClientes = model.read();
        }
        catch(Exception e){
            System.out.println("Erro no controller read clientes.");
        }
            return listaClientes;
    }

    public void update(Cliente cliente){

        ClienteDAO model = new ClienteDAO();
        model.update(cliente);
    }

    public void delete(Cliente cliente){
        ClienteDAO model = new ClienteDAO();
        model.delete(cliente);
    }
}
