package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import javax.swing.text.MaskFormatter;
import javax.swing.text.PlainDocument;

import business.BDServices;
import ui.entities.Pets;
import ui.entities.Tutores;

public class CadastroCadastroPet extends JPanel {

	private static final long serialVersionUID = 1L;

	private static JFrame frame;

	private static JTextField campoNomeAnimal;
	private static JTextField campoRacaAnimal;
	private static JTextField campoDataNascimento;
	private static JTextField campoPesoAnimal;
	private static JTextField campoAlergiasAnimal;
	private static JTextField campoVacinasAnimal;

	/**
	 * Create the panel.
	 * 
	 * @wbp.parser.constructor
	 */

	public CadastroCadastroPet(Tutores tutor) {

		SimpleDateFormat fmtBr = new SimpleDateFormat("dd/MM/yyyy");

		MaskFormatter mfDataNascimento = null;
		MaskFormatter mfPeso = null;
		MaskFormatter mfNomeAnimal = null;

		try {
			mfDataNascimento = new MaskFormatter("##/##/####");
			mfPeso = new MaskFormatter("##.##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		setLayout(null);
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		// Cria um painel principal com um layout de BorderLayout
		JPanel panel = new JPanel();
		setBackground(new Color(222, 222, 222));
		panel.setBounds(0, 11, 715, 523);
		add(panel);
		panel.setLayout(null);

		// Cria o título
		JLabel titleLabel = new JLabel("Dados do Animal:", JLabel.CENTER);
		titleLabel.setBounds(-24, 10, 800, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		titleLabel.setPreferredSize(new Dimension(800, 50)); // Define o tamanho do título

		// Adiciona o título ao painel principal
		panel.add(titleLabel);

		campoNomeAnimal = new JTextField();
		campoNomeAnimal.setBounds(282, 74, 242, 26);
		campoNomeAnimal.setColumns(10);
		panel.add(campoNomeAnimal);

		PlainDocument docNomeAnimal = (PlainDocument) campoNomeAnimal.getDocument();
		docNomeAnimal.setDocumentFilter(new LengthLimitFilter(45));

		JLabel lblNewLabel = new JLabel("Nome do animal:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel.setBounds(185, 74, 100, 24);
		panel.add(lblNewLabel);

		campoRacaAnimal = new JTextField();
		campoRacaAnimal.setColumns(10);
		campoRacaAnimal.setBounds(225, 161, 273, 26);
		panel.add(campoRacaAnimal);

		JLabel lblNewLabel_1 = new JLabel("Espécie:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1.setBounds(185, 118, 49, 24);
		panel.add(lblNewLabel_1);

		String[] especies = { "Cachorro", "Gato" };
		JComboBox<String> selectEspecie = new JComboBox<String>(especies);
		selectEspecie.setForeground(new Color(0, 0, 0));
		selectEspecie.setFont(new Font("Dialog", Font.PLAIN, 14));
		selectEspecie.setBounds(244, 118, 108, 21);
		panel.add(selectEspecie);

		JLabel lblNewLabel_1_1 = new JLabel("Raça:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(185, 161, 49, 24);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Data de Nascimento: ");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1.setBounds(185, 205, 108, 24);
		panel.add(lblNewLabel_1_1_1);

		campoDataNascimento = new JFormattedTextField(mfDataNascimento);
		campoDataNascimento.setColumns(10);
		campoDataNascimento.setBounds(296, 205, 103, 26);
		panel.add(campoDataNascimento);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Sexo:");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1_1.setBounds(185, 255, 49, 24);
		panel.add(lblNewLabel_1_1_1_1);

		String[] sexos = { "Macho", "Fêmea" };
		JComboBox<String> selectSexo = new JComboBox<String>(sexos);
		selectSexo.setBackground(new Color(255, 255, 255));
		selectSexo.setFont(new Font("Dialog", Font.PLAIN, 14));
		selectSexo.setBounds(230, 255, 108, 21);
		panel.add(selectSexo);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Peso(kg):");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1_1_1.setBounds(185, 299, 49, 24);
		panel.add(lblNewLabel_1_1_1_1_1);

		campoPesoAnimal = new JFormattedTextField(mfPeso);
		campoPesoAnimal.setColumns(10);
		campoPesoAnimal.setBounds(250, 299, 100, 26);
		panel.add(campoPesoAnimal);

		JLabel lblNewLabel_1_1_2 = new JLabel("Alergia(s):");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_2.setBounds(185, 351, 58, 24);
		panel.add(lblNewLabel_1_1_2);

		campoAlergiasAnimal = new JTextField();
		campoAlergiasAnimal.setColumns(10);
		campoAlergiasAnimal.setBounds(251, 351, 273, 26);
		panel.add(campoAlergiasAnimal);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Vacinas:");
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_2_1.setBounds(185, 398, 58, 24);
		panel.add(lblNewLabel_1_1_2_1);

		campoVacinasAnimal = new JTextField();
		campoVacinasAnimal.setColumns(10);
		campoVacinasAnimal.setBounds(251, 398, 273, 26);
		panel.add(campoVacinasAnimal);

		JButton btnNewButton = new JButton("Avançar ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(159, 80, 0));
		btnNewButton.setBounds(416, 454, 108, 35);
		panel.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nome = campoNomeAnimal.getText();
				String especie = String.valueOf(selectEspecie.getSelectedItem()).toUpperCase();
				String raca = campoRacaAnimal.getText();
				String dataNascimento = campoDataNascimento.getText();
				Date dataFormatada = null;
				try {
					dataFormatada = new java.sql.Date(fmtBr.parse(dataNascimento).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				String sexo = String.valueOf(selectSexo.getSelectedItem()).toUpperCase();
				Double peso = Double.parseDouble(campoPesoAnimal.getText());
				String alergias = campoAlergiasAnimal.getText();
				String vacinas = campoVacinasAnimal.getText();

				int idTutor = BDServices.inserirTutor(tutor);
				Pets pet = new Pets(null, nome, especie, dataFormatada, sexo, raca, peso, alergias, vacinas, idTutor);
				BDServices.inserirPet(pet);
			}

		});

		JButton btnRetornar = new JButton("Retornar");
		btnRetornar.setForeground(new Color(255, 255, 255));
		btnRetornar.setBackground(new Color(159, 80, 0));
		btnRetornar.setBounds(262, 454, 108, 35);
		panel.add(btnRetornar);

		btnRetornar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(CadastroCadastroTutor.cadastroTutor);
				f.revalidate();
			}
		});

		setVisible(true);
	}

	public CadastroCadastroPet(int idTutor) {

		SimpleDateFormat fmtBr = new SimpleDateFormat("dd/MM/yyyy");

		MaskFormatter mfDataNascimento = null;
		MaskFormatter mfPeso = null;

		try {
			mfDataNascimento = new MaskFormatter("##/##/####");
			mfPeso = new MaskFormatter("##.##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		setLayout(null);
		SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
		// Cria um painel principal com um layout de BorderLayout
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 11, 715, 523);
		add(panel);
		panel.setLayout(null);

		// Cria o título
		JLabel titleLabel = new JLabel("Dados do Animal:", JLabel.CENTER);
		titleLabel.setBounds(-24, 10, 800, 50);
		titleLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 17));
		titleLabel.setPreferredSize(new Dimension(800, 50)); // Define o tamanho do título

		// Adiciona o título ao painel principal
		panel.add(titleLabel);

		campoNomeAnimal = new JTextField();
		campoNomeAnimal.setBounds(282, 74, 242, 26);
		campoNomeAnimal.setColumns(10);
		panel.add(campoNomeAnimal);

		PlainDocument docNomeAnimal = (PlainDocument) campoNomeAnimal.getDocument();
		// docNomeAnimal.setDocumentFilter(new CustomDocumentFilter());
		panel.add(campoNomeAnimal);

		JLabel lblNewLabel = new JLabel("Nome do animal:");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel.setBounds(185, 74, 100, 24);
		panel.add(lblNewLabel);

		campoRacaAnimal = new JTextField();
		campoRacaAnimal.setColumns(10);
		campoRacaAnimal.setBounds(225, 161, 273, 26);
		panel.add(campoRacaAnimal);

		JLabel lblNewLabel_1 = new JLabel("Espécie:");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1.setBounds(185, 118, 49, 24);
		panel.add(lblNewLabel_1);

		String[] especies = { "Cachorro", "Gato" };
		JComboBox<String> selectEspecie = new JComboBox<String>(especies);
		selectEspecie.setForeground(new Color(0, 0, 0));
		selectEspecie.setFont(new Font("Dialog", Font.PLAIN, 14));
		selectEspecie.setBounds(244, 118, 108, 21);
		panel.add(selectEspecie);

		JLabel lblNewLabel_1_1 = new JLabel("Raça:");
		lblNewLabel_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1.setBounds(185, 161, 49, 24);
		panel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Data de Nascimento: ");
		lblNewLabel_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1.setBounds(185, 205, 108, 24);
		panel.add(lblNewLabel_1_1_1);

		campoDataNascimento = new JFormattedTextField(mfDataNascimento);
		campoDataNascimento.setColumns(10);
		campoDataNascimento.setBounds(296, 205, 103, 26);
		panel.add(campoDataNascimento);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Sexo:");
		lblNewLabel_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1_1.setBounds(185, 255, 49, 24);
		panel.add(lblNewLabel_1_1_1_1);

		String[] sexos = { "Macho", "Fêmea" };
		JComboBox<String> selectSexo = new JComboBox<String>(sexos);
		selectSexo.setBackground(new Color(255, 255, 255));
		selectSexo.setFont(new Font("Dialog", Font.PLAIN, 14));
		selectSexo.setBounds(230, 255, 108, 21);
		panel.add(selectSexo);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Peso(kg):");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_1_1_1.setBounds(185, 299, 49, 24);
		panel.add(lblNewLabel_1_1_1_1_1);

		campoPesoAnimal = new JFormattedTextField(mfPeso);
		campoPesoAnimal.setColumns(10);
		campoPesoAnimal.setBounds(250, 299, 100, 26);
		panel.add(campoPesoAnimal);

		JLabel lblNewLabel_1_1_2 = new JLabel("Alergia(s):");
		lblNewLabel_1_1_2.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_2.setBounds(185, 351, 58, 24);
		panel.add(lblNewLabel_1_1_2);

		campoAlergiasAnimal = new JTextField();
		campoAlergiasAnimal.setColumns(10);
		campoAlergiasAnimal.setBounds(251, 351, 273, 26);
		panel.add(campoAlergiasAnimal);

		JLabel lblNewLabel_1_1_2_1 = new JLabel("Vacinas:");
		lblNewLabel_1_1_2_1.setFont(new Font("Arial", Font.BOLD, 10));
		lblNewLabel_1_1_2_1.setBounds(185, 398, 58, 24);
		panel.add(lblNewLabel_1_1_2_1);

		campoVacinasAnimal = new JTextField();
		campoVacinasAnimal.setColumns(10);
		campoVacinasAnimal.setBounds(251, 398, 273, 26);
		panel.add(campoVacinasAnimal);

		JButton btnNewButton = new JButton("Avançar ");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(159, 80, 0));
		btnNewButton.setBounds(416, 454, 108, 35);
		panel.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				String nome = campoNomeAnimal.getText();
				String especie = String.valueOf(selectEspecie.getSelectedItem()).toUpperCase();
				String raca = campoRacaAnimal.getText();
				String dataNascimento = campoDataNascimento.getText();
				Date dataFormatada = null;
				try {
					dataFormatada = new java.sql.Date(fmtBr.parse(dataNascimento).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				String sexo = String.valueOf(selectSexo.getSelectedItem()).toUpperCase();
				Double peso = Double.parseDouble(campoPesoAnimal.getText());
				String alergias = campoAlergiasAnimal.getText();
				String vacinas = campoVacinasAnimal.getText();
				Pets pet = new Pets(null, nome, especie, dataFormatada, sexo, raca, peso, alergias, vacinas, idTutor);
				int id = BDServices.inserirPet(pet);
				pet = BDServices.consultarPet(id);
				int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja visualizar o cadastro feito?",
						"Confirmar Remoção", JOptionPane.YES_NO_OPTION);
				if (confirmacao == JOptionPane.YES_OPTION) {
					JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
					f.setContentPane(new ConsultaPetsDadosPet(pet));
					f.revalidate();
				}
			}

		});

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(159, 80, 0));
		btnCancelar.setBounds(262, 454, 108, 35);
		panel.add(btnCancelar);

		btnCancelar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame f = (JFrame) SwingUtilities.getAncestorOfClass(JFrame.class, panel);
				f.setContentPane(new CadastroEscolha());
				f.revalidate();
			}

		});

		setVisible(true);
	}

	public class LengthLimitFilter extends DocumentFilter {
		private final int maxLength;

		public LengthLimitFilter(int maxLength) {
			this.maxLength = maxLength;
		}

		@Override
		public void insertString(FilterBypass fb, int offset, String string, javax.swing.text.AttributeSet attr)
				throws BadLocationException {
			if (string != null) {
				if ((fb.getDocument().getLength() + string.length()) <= maxLength) {
					super.insertString(fb, offset, string, attr);
				} else {
					JOptionPane.showMessageDialog(null, "Número máximo de caracteres é " + maxLength + ".", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		@Override
		public void replace(FilterBypass fb, int offset, int length, String text, javax.swing.text.AttributeSet attrs)
				throws BadLocationException {
			if (text != null) {
				if ((fb.getDocument().getLength() - length + text.length()) <= maxLength) {
					super.replace(fb, offset, length, text, attrs);
				} else {
					JOptionPane.showMessageDialog(null, "Número máximo de caracteres é " + maxLength + ".", "Erro",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
}