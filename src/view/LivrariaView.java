package view;

import java.util.Scanner;

import bo.Cliente;
import bo.Funcionario;
import bo.Livro;
import controller.ClienteController;
import controller.FuncionarioController;
import controller.LivroController;

//Import JavaSwing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.BorderFactory;
import java.awt.*;

public class LivrariaView implements ActionListener {
    
// Funções do cliente

    public void createCli(){
        Scanner in = new Scanner(System.in);

        Cliente cliente = new Cliente();

        System.out.println("Entre com o ID do cliente: ");
        cliente.setId(in.next());

        System.out.println("Entre com o nome do cliente: ");
        cliente.setNome(in.next());

        System.out.println("Entre com o estado que o cliente reside:");
        cliente.setEstado(in.next());

        ClienteController controllerCli = new ClienteController();
        controllerCli.create(cliente);

        in.close();
    }

    public void readCli(){

        ClienteController controller = new ClienteController();

        System.out.println(">>Clientes<<");
        System.out.println("-------------");

        for (Cliente cliente:controller.read()){

            System.out.println("ID do cliente: " +cliente.getId());
            System.out.println("Nome do cliente: " +cliente.getNome());
            System.out.println("Estado do cliente: " +cliente.getEstado());

            System.out.println("-------------");
        }
    }

    public void updateCli(){
        Scanner in = new Scanner(System.in);

        Cliente cliente = new Cliente();

        System.out.println("Informe o ID do cliente para atualizar:");
        cliente.setId(in.next());

        System.out.println("Informe o nome:");
        cliente.setNome(in.next());

        System.out.println("Informe o estado:");
        cliente.setEstado(in.next());

        ClienteController controllerCli = new ClienteController();
        controllerCli.update(cliente);

        in.close();
    }

    public void deleteCli(){

        Scanner in = new Scanner(System.in);

        Cliente cliente = new Cliente();

        System.out.println("---Deletar cliente---");

        System.out.println("Entre com o id do cliente que deseja excluir:");
        cliente.setId(in.next());

        in.close();

        ClienteController controllerCli = new ClienteController();
        controllerCli.delete(cliente);

    }

    //Funções do Funcionário

    public void createFunc(){
        Scanner in = new Scanner(System.in);

        Funcionario func = new Funcionario();

        System.out.println("Informe o codigo do funcionario:");
        func.setCodigoFunc(in.next());

        System.out.println("Informe o nome do funcionario:");
        func.setNome(in.next());

        System.out.println("Informe o cargo que o funcionario ocupa:");
        func.setCargo(in.next());

        System.out.println("Informe a data de nascimento:");
        func.setNascimento(in.next());

        in.close();

        FuncionarioController controllerFunc = new FuncionarioController();
        controllerFunc.create(func);
    }

    public void readFunc(){

        FuncionarioController controllerFunc = new FuncionarioController();

        System.out.println(">>Funcionarios<<");
        System.out.println("-----------------");

        for (Funcionario func:controllerFunc.read()){

            System.out.println("Codigo do funcionario: " + func.getCodigoFunc());
            System.out.println("Nome do funcionário: " + func.getNome());
            System.out.println("Cargo: " + func.getCargo());
            System.out.println("Nascimento: " + func.getNascimento());

            System.out.println("-------------");
        }
    }

    public void updateFunc(){

        Scanner in = new Scanner(System.in);

        Funcionario func = new Funcionario();

        System.out.println("Informe o codigo do Funcionario:");
        func.setCodigoFunc(in.next());

        System.out.println("Informe o nome do funcionario:");
        func.setNome(in.next());

        System.out.println("Informe o cargo:");
        func.setCargo(in.next());

        System.out.println("Informe a data de Nascimento");
        func.setNascimento(in.next());

        in.close();

        FuncionarioController controllerFunc = new FuncionarioController();
        controllerFunc.update(func);
    }

    public void deleteFunc(){
        Scanner in = new Scanner(System.in);

        Funcionario func = new Funcionario();

        System.out.println("---Deletar Funcionario---");

        System.out.println("Entre com o codigo do funcionario que deseja excluir:");
        func.setCodigoFunc(in.next());

        in.close();

        FuncionarioController controllerFunc = new FuncionarioController();
        controllerFunc.delete(func);
    }

    // Funções do Livro

    public void createLivro(){

        Scanner in = new Scanner(System.in);

        Livro livro = new Livro();

        System.out.println("Entre com o codigo do livro:");
        livro.setCodigo(in.next());

        System.out.println("Entre com o titulo do livro:");
        livro.setTitulo(in.next());

        System.out.println("Entre com a categoria do livro:");
        livro.setCategoria(in.next());

        System.out.println("Entre com o valor do livro:");
        livro.setPreco(in.next());

        in.close();

        LivroController controllerLivro = new LivroController();
        controllerLivro.create(livro);
    }

    public void readLivro(){
        LivroController controllerLivro = new LivroController();

        System.out.println(">>Livros<<");
        System.out.println("------------");

        for (Livro livro:controllerLivro.read()){

            System.out.println("Codigo do livro: " +livro.getCodigo());
            System.out.println("Titulo: " +livro.getTitulo());
            System.out.println("Categoria: " +livro.getCategoria());
            System.out.println("Preco: " +livro.getPreco());

            System.out.println("-------------");

        }
    }

    public void updateLivro(){

        Scanner in = new Scanner(System.in);

        Livro livro = new Livro();

        System.out.println("Informe o codigo do livro:");
        livro.setCodigo(in.next());

        System.out.println("Informe o titulo:");
        livro.setTitulo(in.next());

        System.out.println("Informe a categoria:");
        livro.setCategoria(in.next());

        System.out.println("Informe o valor:");
        livro.setPreco(in.next());

        in.close();

        LivroController controllerLivro = new LivroController();
        controllerLivro.update(livro);
    }

    public void deleteLivro(){

        Scanner in = new Scanner(System.in);

        Livro livro = new Livro();

        System.out.println("---Deletar Livro---");
        System.out.println("Informe o codigo do livro a ser deletado:");
        livro.setCodigo(in.next());

        in.close();

        LivroController controllerLivro = new LivroController();
        controllerLivro.delete(livro);
    }

    public static void main(String[] args) {
        
        new LivrariaView();
/**         
        LivrariaView crud = new LivrariaView();

        System.out.println("Informe [C] para cliente, [F] para funcionario e [L] para livro");
        Scanner in = new Scanner(System.in);

        String cfl = in.next();
        String resp = "";

        if (cfl.equalsIgnoreCase("C")){
            System.out.println("Informe a ação desejada para o CRUD de cliente:");
        
            resp = in.next();

            if (resp.equalsIgnoreCase("c")){
                crud.createCli();
            }
            else if (resp.equalsIgnoreCase("r")){
                crud.readCli();
            }
            else if (resp.equalsIgnoreCase("u")){
                crud.updateCli();
            }
            else if (resp.equalsIgnoreCase("d")){
                crud.deleteCli();
            }
            else{
                System.out.println("Opcao Invalida");
            }
        } //Condição para acessar funcionario
        else if (cfl.equalsIgnoreCase("F")){
            System.out.println("Informe a ação desejada para o CRUD de Funcionario:");
        
            resp = in.next();

            if (resp.equalsIgnoreCase("c")){
                crud.createFunc();
            }
            else if (resp.equalsIgnoreCase("r")){
                crud.readFunc();
            }
            else if (resp.equalsIgnoreCase("u")){
                crud.updateFunc();
            }
            else if (resp.equalsIgnoreCase("d")){
                crud.deleteFunc();
            }
            else{
                System.out.println("Opcao Invalida");
            }
        } // condicao para acessar livro
        else if (cfl.equalsIgnoreCase("L")){
            System.out.println("Informe a ação desejada para o CRUD de Livro:");
        
            resp = in.next();

            if (resp.equalsIgnoreCase("c")){
                crud.createLivro();
            }
            else if (resp.equalsIgnoreCase("r")){
                crud.readLivro();
            }
            else if (resp.equalsIgnoreCase("u")){
                crud.updateLivro();
            }
            else if (resp.equalsIgnoreCase("d")){
                crud.deleteLivro();
            }
            else{
                System.out.println("Opcao Invalida");
            }
        }
        else{
            System.out.println("Certifique-se de ter digitado a letra maiuscula ou a letra correta !");
        }

        in.close();
*/    
    }

    private JFrame telaInicial;
    private JPanel painel;
    private JLabel EscolherTabela;  	//Selecionar Cliente/Funcionario/Livro
	private JLabel ClienteTxt;
	private JLabel FuncionarioTxt;
	private JLabel LivroTxt;
    private JLabel label;
    private JTextField opcao; 	//Entrar com o valor para acessar o BD
    private JButton botao1;
    private String AcessC = "C";	//Para acessar CLIENTE
	private String AcessF = "F";	//Para acessar FUNCIONARIO
	private String AcessL = "L";	//Para acessar LIVRO
	private String exit = "x";

    public LivrariaView(){

        telaInicial = new JFrame();
        painel = new JPanel();

        painel.setBorder(BorderFactory.createEmptyBorder(50, 50,80, 100));
        painel.setLayout(new GridLayout(0,1));

        EscolherTabela = new JLabel("Selecionar Entidade"); //Entrar com a CRUD
		ClienteTxt = new JLabel("Cliente(C)");
		FuncionarioTxt = new JLabel("Funcionario(F)");
		LivroTxt = new JLabel("Livro(L)");
        painel.add(EscolherTabela);
		painel.add(ClienteTxt);
		painel.add(FuncionarioTxt);
		painel.add(LivroTxt);

        opcao = new JTextField();
        painel.add(opcao);

        label = new JLabel();
        painel.add(label); 

        botao1 = new JButton("Acessar"); //Botão
        botao1.addActionListener((ActionListener) this);
        painel.add(botao1);

        telaInicial.add(painel, BorderLayout.CENTER);
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicial.setTitle("AcessarBD");
        telaInicial.setSize(600,500);
        telaInicial.pack();
        telaInicial.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){

    	if(opcao.getText().equals(AcessC))
		{
            new SwingCliente();
        
   		}else if(opcao.getText().equals(AcessF))
    	{
            new SwingFuncionario();

		}else if(opcao.getText().equals(AcessL))
    	{
            new SwingLivro();
		}
        else if(opcao.getText().equals(exit))
    	{
            System.exit(0);
		}

    }

}