package classes;

import java.awt.Color;
import java.awt.Font;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class Tela extends JFrame {
	public JComboBox cbPais = new JComboBox();
	public JComboBox cbModalidade = new JComboBox();
	public JTable tableMedalha;
	
	public Tela() throws SQLException {
		super("Tela de Cadastro de medalhas");
		setSize(483, 680);
		setLayout(null);
		getContentPane().setBackground(new Color(255,230,100));
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JLabel jlTitulo = new JLabel("Olimpiadas 2024 - Quadro de Medalhas");
		jlTitulo.setBounds(5, 0, 850, 60);
		jlTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		add(jlTitulo);
		JLabel jbPais = new JLabel("Pais");
		jbPais.setBounds(10, 70, 850, 60);
		add(jbPais);
		BDUtil bdPais = new BDUtil();
		bdPais.executaBDSelect("SELECT * FROm PAIS", "NOME");
		cbPais.setModel(new DefaultComboBoxModel(new Vector(bdPais.getLista())));
		cbPais.setBounds(70, 90, 200, 20);
		add (cbPais);
		JLabel jlModalidade = new JLabel("Modalidade :");
		jlModalidade.setBounds(10,110,850,60);
		add(jlModalidade);
		BDUtil bdModalidade = new BDUtil();
		bdModalidade.executaBDSelect("SELECT modalidade.id ,modalidade.NOME ,categoria.nome, categoria.sexo, CONCAT(modalidade.nome, ' - ', categoria.nome, ' - ', categoria.sexo) as modalidade from modalidade, categoria where categoria.id = modalidade.id_categoria", "modalidade");
		cbModalidade.setModel(new DefaultComboBoxModel(new Vector(bdModalidade.getLista())));
		cbModalidade.setBounds(90, 130, 250, 20);
		add(cbModalidade);
		JLabel jlMedalha = new JLabel("Medalha:");
		jlMedalha.setBounds(10,150,850,60);
		add(jlMedalha);
		JRadioButton jRadioButton1 = new JRadioButton();
		JRadioButton jRadioButton2 = new JRadioButton();
		JRadioButton jRadioButton3 = new JRadioButton();
		ButtonGroup g1 = new ButtonGroup();		
		jRadioButton1.setText("Ouro");
		jRadioButton1.setBackground(new Color(255, 215, 0));
		jRadioButton2.setText("Prata");
		jRadioButton2.setBackground(new Color(192, 192, 192));
		jRadioButton3.setText("Bronze");
		jRadioButton3.setBackground(new Color(210, 105, 30));
		jRadioButton1.setBounds(200, 170,70, 20);
		jRadioButton2.setBounds(120, 190,70, 20);
		jRadioButton3.setBounds(280, 200,80, 20);
		add(jRadioButton1);
		add(jRadioButton2);
		add(jRadioButton3);
		g1.add(jRadioButton1);
		g1.add(jRadioButton2);
		g1.add(jRadioButton3);
		JLabel jlAros = new JLabel();
		jlAros.setVisible(true);
		jlAros.setBounds(295, 40, 300, 100);
		jlAros.setIcon(new ImageIcon(getClass().getResource("arosolimpiadas.png")));
		add(jlAros);
		JLabel jlPodium = new JLabel();
		jlPodium.setVisible(true);
		jlPodium.setBounds(100, 180, 300, 100);
		jlPodium.setIcon(new ImageIcon(getClass().getResource("podium.png")));
		add(jlPodium);
		JButton jbCadastro = new JButton("Cadastrar");
		jbCadastro.setBounds(190, 300, 100, 20);
		jbCadastro.setVisible(true);
		add(jbCadastro);
		setVisible(true);
		Object rowDataMedalhas[][] = new Object[25][25];
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < rowDataMedalhas[1].length; j++) {
				rowDataMedalhas[i][j] = null;
			}
		}
		Object columnNamesMedalhas[]={"pos","pais","ouro","prata","bronze","total"};
		JTable tableMedalha = new JTable(rowDataMedalhas, columnNamesMedalhas);
		JScrollPane scrollMedalha = new JScrollPane (tableMedalha);
		scrollMedalha.setBounds(10, 340, 450, 300);
		tableMedalha.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableMedalha.getColumnModel().getColumn(1).setPreferredWidth(130);
		tableMedalha.getColumnModel().getColumn(2).setPreferredWidth(60);
		tableMedalha.getColumnModel().getColumn(3).setPreferredWidth(60);
		tableMedalha.getColumnModel().getColumn(4).setPreferredWidth(60);
		tableMedalha.getColumnModel().getColumn(5).setPreferredWidth(70);
		for(int i = 0; i < 6; i++) {
			tableMedalha.getColumnModel().getColumn(i).setResizable(false);
		}
		tableMedalha.getTableHeader().setReorderingAllowed(false);
		tableMedalha.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tableMedalha.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableMedalha.setEnabled(true);
		add(scrollMedalha);
	}
}
