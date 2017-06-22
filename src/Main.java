import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Main  {

	public static void main(String[] args) throws FileNotFoundException, FontFormatException, IOException {

		Date data = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	
		
		Object[] colunas = new String[] {"Código","Descrição", "Preço"};
		Object[][] dados = new Object[][]{
			{"001", "Maconha", "1000.00"},
			{"001", "Maconha", "1000.00"},
		};
		
		DefaultTableModel model = new DefaultTableModel(dados, colunas);
		
		JTable tabela = new JTable();
		tabela.setModel(model);
		tabela.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 12));
				
		JFrame Janela = new JFrame();
		Janela.setTitle("Trabalho Modular");
		Janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JMenuItem eMS = new JMenuItem("Sair");
		eMS.setToolTipText("Sair do Aplicativo");
		eMS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		
		JMenuItem eMSb = TelaSobre();

		JMenuItem eMCi = TelaCadastroItem();
		
		JMenuItem eMI = TelaIndicadores();
		
		JMenuBar menubar = Menu(eMS, eMSb, eMCi, eMI);
		
		
		JButton btnAdd = new JButton(new ImageIcon(Main.class.getResource("img/add.png")));
		JButton btnModify = new JButton(new ImageIcon(Main.class.getResource("img/modify.png")));
		JButton btnDelete = new JButton(new ImageIcon(Main.class.getResource("img/delete.png")));
		
		btnAdd.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame cadastro = new JFrame("Cadastro");
				cadastro.setVisible(true);
				cadastro.setSize(550,500);
			
				JPanel filho2 = new JPanel();
				filho2.setLayout(new FlowLayout(FlowLayout.CENTER));
				filho2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				filho2.setBorder(BorderFactory.createTitledBorder("  ::: INFORMAÇÕES :::  "));
				//NUMERO DA NOTA
				filho2.add(new JLabel("Nº da nota:" ));
				JTextField codigo = new JTextField(14);
				filho2.add(codigo);
				//MODELO
				filho2.add((new JLabel("Modelo: ")));
				JTextField desc = new JTextField(14);
				filho2.add(desc);
				//NATUREZA
				filho2.add((new JLabel("Natureza: ")));
				JTextField natu = new JTextField(10);
				filho2.add(natu);
				//DATA OPERAÇÃO
				filho2.add((new JLabel("Data Operação: ")));
				JTextField dataOp = new JTextField(10);
				filho2.add(dataOp);
				//DATA EMISSÃO
				filho2.add((new JLabel("Data Emissão: ")));
				JTextField dataEm = new JTextField(10);
				filho2.add(dataEm);
				
				JPanel filho3 = new JPanel();
				filho3.setLayout(new FlowLayout(FlowLayout.CENTER));
				filho3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				filho3.setBorder(BorderFactory.createTitledBorder("  ::: DESTINATÁRIO / EMITENTE :::  "));
				//CNPJ / CPF
				filho3.add(new JLabel("CNPJ/CPF:" ));
				JTextField CnpjCpf = new JTextField(14);
				filho3.add(CnpjCpf);
				//RAZÃO SOCIAL
				filho3.add((new JLabel("Razão social/Nome: ")));
				JTextField nome = new JTextField(14);
				filho3.add(nome);
				//INSC. ESTADUAL
				filho3.add((new JLabel("Inscrição Estadual: ")));
				JTextField inscri = new JTextField(10);
				filho3.add(inscri);
				//ESTADO
				filho3.add((new JLabel("Estado: ")));
				JTextField estado = new JTextField(10);
				filho3.add(estado);
				//QNT ITENS
				filho3.add((new JLabel("Qnt. Itens: ")));
				JTextField qnt = new JTextField(10);
				filho3.add(qnt);
				//VALOR
				filho3.add((new JLabel("Valor: ")));
				JTextField valor = new JTextField(10);
				filho3.add(valor);
				//BOTÃO ADD
				filho3.add(new JButton("Adicionar"));
				//CRIAR FUNÇÃO PARA BOTÃO
				
				JPanel painel = new JPanel();
				painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
				painel.add(filho2);
				painel.add(filho3);
				JButton salvar = new JButton("Salvar");
				painel.add(salvar);
				salvar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						DefaultTableModel model = (DefaultTableModel) tabela.getModel();
								model.addRow(new Object[]{codigo.getText(), desc.getText(), valor.getText()});
						}
								
				});
				
				cadastro.add(painel);
				Janela.setVisible(true);			
			}
		});
		
		btnModify.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectRow = tabela.getSelectedRow();
				
			String codigo1 = model.getValueAt(selectRow, 0).toString();
	        String descricao1 = model.getValueAt(selectRow, 1).toString();
	        String valor1 = model.getValueAt(selectRow, 2).toString();
	        
				JFrame cadastro = new JFrame("Editar");
				cadastro.setVisible(true);
				cadastro.pack();
				
				JPanel filho2 = new JPanel();
				filho2.add(new JLabel("Código:"));
				JTextField codigo = new JTextField(14);
				codigo.setText(codigo1);
				filho2.add(codigo);
				filho2.add((new JLabel("Descrição: ")));
				JTextField desc = new JTextField(14);
				desc.setText(descricao1);
				filho2.add(desc);
				filho2.add((new JLabel("Valor: ")));
				JTextField valor = new JTextField(10);
				valor.setText(valor1);
				filho2.add(valor);
				
				JPanel painel = new JPanel();
				painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
				painel.add(filho2);
				JButton salvar = new JButton("Atualizar");
				painel.add(salvar);
				salvar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
								model.setValueAt(codigo.getText(), selectRow, 0);
								model.setValueAt(desc.getText(), selectRow, 1);
								model.setValueAt(valor.getText(), selectRow, 2);
						}
								
				});
				
				cadastro.add(painel);
				Janela.setVisible(true);		
				
			}
		});
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int n = JOptionPane.showConfirmDialog(btnDelete, "Tem certeza que deseja deletar esta nota fiscal?","Aten��o", JOptionPane.YES_NO_OPTION);
				
				if(n == JOptionPane.YES_OPTION){
					if(tabela.getSelectedRow() != -1){
						model.removeRow(tabela.getSelectedRow());
					}
				}	
			}
		});
		
		JToolBar toolbar = new JToolBar("Applications");
		toolbar.add(btnAdd);
		toolbar.add(btnModify);
		toolbar.add(btnDelete);
		
		
		JScrollPane jsp = new JScrollPane();
		jsp.setViewportView(tabela);
		
		Janela.add(jsp, BorderLayout.CENTER);
		Janela.setSize(800,300);
		Janela.setVisible(true);
		Janela.setJMenuBar(menubar);
		Janela.getContentPane().add(toolbar, BorderLayout.PAGE_START);
		

	}

	private static JMenuBar Menu(JMenuItem eMS, JMenuItem eMSb, JMenuItem eMCi, JMenuItem eMI) {
		JMenu arquivo = new JMenu("Arquivo");
		arquivo.setMnemonic(KeyEvent.VK_A);
		arquivo.add(eMS);
		
		JMenu cadastro = new JMenu("Cadastro");
		cadastro.setMnemonic(KeyEvent.VK_C);
		cadastro.add(eMCi);
		cadastro.add(eMI);
		
		JMenu sobre = new JMenu("Sobre");
		sobre.setMnemonic(KeyEvent.VK_S);
		sobre.add(eMSb);
		
		JMenuBar menubar = new JMenuBar();
		menubar.add(arquivo);
		menubar.add(cadastro);
		menubar.add(sobre);
		return menubar;
	}

	private static JMenuItem TelaCadastroItem() {
		JMenuItem  eMCi= new JMenuItem("Cadastro Item");
		eMCi.setMnemonic(KeyEvent.VK_C);
		eMCi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JPanel painel = new JPanel();
				painel.setLayout(new BoxLayout(painel, BoxLayout.Y_AXIS));
				JTextField codigo = new JTextField();
			
				JFrame Produtos = new JFrame("Cadastro de Produtos");
				Produtos.setVisible(true);
				Produtos.setSize(500,500);
				
			}
		});
		return eMCi;
	}
	
	private static JMenuItem TelaIndicadores(){
		JMenuItem eMI = new JMenuItem("Tela de Indicadores");
		eMI.setMnemonic(KeyEvent.VK_I);
		eMI.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame Indicadores = new JFrame("Indicadores");
				Indicadores.setVisible(true);
				Indicadores.setSize(300,400);
				
				Object[] colunasIndicadores = new String[] {"Indicadores", "Valor"};
				Object[][] valorIndicadores = new Object[][]{
					{"Gabriel",1000.00},
					{"Gabriel",1000.00},
					{"Gabriel",1000.00},
					{"Gabriel",1000.00},
					{"Gabriel",1000.00},
					{"Gabriel",1000.00},
				};
				
				DefaultTableModel modelIndicadores = new DefaultTableModel(valorIndicadores, colunasIndicadores);
				JTable tabelaIndicadores = new JTable();
				tabelaIndicadores.setModel(modelIndicadores);
				tabelaIndicadores.getTableHeader().setFont(new Font("Roboto", Font.BOLD, 12));
				
				Indicadores.add(tabelaIndicadores);
			}
		});
		return eMI;
	}

	private static JMenuItem TelaSobre() {
		JMenuItem eMSb = new JMenuItem("Sobre");
		eMSb.setMnemonic(KeyEvent.VK_S);
		eMSb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				JPanel pai = new JPanel();
				pai.setLayout(new BoxLayout(pai, BoxLayout.Y_AXIS));
				
				JPanel tres = new JPanel();
				tres.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel eq = new JLabel();
				eq.setText(" Equipe: Gabriel de Oliveira - Luis Felipe");
				tres.add(eq);
				
				JPanel um = new JPanel();
				um.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel d = new JLabel();
				d.setText("Disciplina:"
						+ " Desenvolvimento Orientado a Objeto + Persistência de Dados");
				um.add(d);
				
				JPanel dois = new JPanel();
				dois.setLayout(new FlowLayout(FlowLayout.CENTER));
				JLabel i = new JLabel();
				i.setText("<HTML>Informações sobre o Trabalho: "+
						"Trabalho desenvolvido com o intuito de, demostrar <BR>todo o conhecimento adquirido "
						+ "neste 5 Período. Utilizando o SQL Server <BR> como o Banco de Dados, todos os detalhes "
						+ "foram feitos com a orientação do <BR> professor Wellington.</HTML>");
				dois.add(i);
				
				pai.add(tres);
				pai.add(um);
				pai.add(dois);
				
				JFrame about = new JFrame("Sobre");
				about.setVisible(true);
				about.setSize(490, 200);
				about.add(pai);
				
			}
		});
		return eMSb;
	}
	
	
}