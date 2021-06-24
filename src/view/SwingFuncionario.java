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

public class SwingFuncionario implements ActionListener  {

    private JFrame telaInicial;
    private JPanel painel;
    private JLabel crudJ;  			//Ação do crud
	private JLabel txtCriar;
	private JLabel txtConsultar;
	private JLabel txtEditar;
	private JLabel txtDeletar;
    private JLabel label; 
    private JTextField txtCodigoAcess; 	//Entrar com o valor para acessar o BD
    private JButton b1;         
    private String AcessC = "c";	//Para acessar criar
	private String AcessU = "u";	//Para acessar Editar
	private String AcessD = "d";	//Para acessar Deletar
	private String AcessR = "r";	//Para acessar Consultar

    public SwingFuncionario(){

        telaInicial = new JFrame();
        painel = new JPanel();

        painel.setBorder(BorderFactory.createEmptyBorder(50, 50,80, 100));
        painel.setLayout(new GridLayout(0,1));

        crudJ = new JLabel("Ação da CRUD em Funcionario:"); //Entrar com a CRUD
		txtCriar = new JLabel("Criar(c)");
		txtConsultar = new JLabel("Consultar(r)");
		txtEditar = new JLabel("Editar(u)");
		txtDeletar = new JLabel("Deletar(d)");
        painel.add(crudJ);
		painel.add(txtCriar);
		painel.add(txtConsultar);
		painel.add(txtEditar);
		painel.add(txtDeletar);

        txtCodigoAcess = new JTextField();
        painel.add(txtCodigoAcess);

        label = new JLabel();
        painel.add(label); 

        b1 = new JButton("Acessar"); //Botão
        b1.addActionListener((ActionListener) this);
        painel.add(b1);

        telaInicial.add(painel, BorderLayout.CENTER);
        telaInicial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        telaInicial.setTitle("AcessarBD");
        telaInicial.setSize(600,500);
        telaInicial.pack();
        telaInicial.setVisible(true);

    }

	@Override
    public void actionPerformed(ActionEvent e){
		
		LivrariaView crudSwing = new LivrariaView();

    	if(txtCodigoAcess.getText().equals(AcessC))
		{
			crudSwing.createFunc();
        
   		}else if(txtCodigoAcess.getText().equals(AcessU))
    	{
			crudSwing.updateFunc();

		}else if(txtCodigoAcess.getText().equals(AcessD))
    	{
			crudSwing.deleteFunc();

		}else if(txtCodigoAcess.getText().equals(AcessR))
    	{
			crudSwing.readFunc();
		}

			System.exit(0);


    }
    
}