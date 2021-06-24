package view;

//Import JavaSwing
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.*;
import javax.swing.BorderFactory;
import java.awt.*;

public class Logado implements ActionListener {

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

    public Logado(){

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
