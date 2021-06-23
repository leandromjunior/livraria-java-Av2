package controller;

import java.util.ArrayList;
import java.util.List;

import bo.Funcionario;
import model.FuncionarioDAO;

public class FuncionarioController {
    
    public void create(Funcionario func){

        FuncionarioDAO model = new FuncionarioDAO();
        model.create(func);
    }

    public List<Funcionario> read(){

        List<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();

        try{
            FuncionarioDAO model = new FuncionarioDAO();
            listaFuncionarios = model.read();
        }
        catch(Exception e){
            System.out.println("Erro no controller read funcionarios.");
        }
        
        return listaFuncionarios;
    }

    public void update(Funcionario func){

        FuncionarioDAO model = new FuncionarioDAO();
        model.update(func);
    }

    public void delete(Funcionario func){
        FuncionarioDAO model = new FuncionarioDAO();
        model.delete(func);
    }
}
