package controller;

import java.util.ArrayList;
import java.util.List;

import bo.Livro;
import model.LivroDAO;

public class LivroController {
    
    public void create(Livro livro){

        LivroDAO model = new LivroDAO();
        model.create(livro);
    }

    public List<Livro> read(){
        
        List<Livro> listaLivros = new ArrayList<Livro>();

        try{
            LivroDAO model = new LivroDAO();
            listaLivros = model.read();
        }
        catch(Exception e){
            System.out.println("Erro no controller read livros.");
        }

        return listaLivros;
    }

    public void update(Livro livro){

        LivroDAO model = new LivroDAO();
        model.update(livro);
    }

    public void delete(Livro livro){

        LivroDAO model = new LivroDAO();
        model.delete(livro);
    }
}
