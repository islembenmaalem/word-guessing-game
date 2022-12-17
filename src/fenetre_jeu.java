
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;

import org.xml.sax.SAXException;

final class fenetre_jeu extends JFrame implements ActionListener {
	private int k = 0;
	private int p = 0;
	private javax.swing.JButton b;
	public static ArrayList<JTextField> l1 = new ArrayList<JTextField>(1);
	private static ArrayList<Object> l;
	private String reponseChiffree;
	private static int i;
	private HashMap<String, Integer> liste;
	static int q = 0;
	Timer timer;
	int counter = 20;
	String reponse;
	int paire;

	public fenetre_jeu(String titre, HashMap<String, Integer> liste, int pa) {

		paire = pa;
		counter = 15;
		timer = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				label_temps.setText("temps restant :" + String.valueOf(counter));
				counter--;
				if (counter == 0) {
					// timer.removeActionListener(this); timer.stop(); setVisible(false);
					JOptionPane.showMessageDialog(null, "temps passé");
					if (paire % 2 == 0) {
						setVisible(false);

						fenetre_jeu qq = new fenetre_jeu("j2 turn", liste, 1);
					} else {
						setVisible(false);

						fenetre_jeu qq = new fenetre_jeu("j1 turn", liste, 2);
					}
				}
			}
		});
		timer.start();

		jPanel3 = new JPanel();
		pan_titre = new JPanel();
		label_titre = new JLabel();
		pan_question = new JPanel();
		jPanel6 = new JPanel();
		label_const = new JLabel();
		PANQUES = new JPanel();
		label_question = new JLabel();
		pan_buttons = new JPanel();
		pan_submit = new JPanel();
		jPanel1 = new JPanel();
		jPanel5 = new JPanel();
		jPanel4 = new JPanel();
		Ok = new JButton("Ok");
		give_up = new JButton("Give up");
		jButton1 = new JButton();
		jPanel2 = new JPanel();
		jPanel7 = new JPanel();
		jPanel77 = new JPanel();
		jLabel1 = new JLabel();
		jLabel11 = new JLabel();
		jPanel8 = new JPanel();
		label_temps = new JLabel();
		label_temps.setForeground(new Color(255, 114, 146));
		jMenuBar1 = new JMenuBar();
		fichier = new JMenu();
		edit = new JMenu();
		l1 = new ArrayList<JTextField>(1);
		this.liste = liste;
		this.setTitle(titre); // definir un titre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Jeu jeu = new Jeu();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setFocusCycleRoot(false);
		getContentPane().setLayout(new BorderLayout(5, 5));

		jPanel3.setLayout(new GridLayout(4, 1));
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));

		pan_titre.setBackground(new Color(204, 204, 255));

		label_titre.setBackground(new Color(255, 102, 102));
		label_titre.setFont(new Font("Andalus", 3, 48)); // NOI18N
		label_titre.setForeground(new Color(255, 114, 146));
		label_titre.setText("turn joueur " + titre);
		pan_titre.add(label_titre);

		jPanel3.add(pan_titre);
		l = new ArrayList<Object>();
		try {
			String question = jeu.question_aleatoire();
			reponse = jeu.getReponse(question);
			System.out.println(" reponse : " + reponse);
			this.reponseChiffree = jeu.getReponseChiffree(question);
			// pan_buttons.setLayout(new GridLayout(1, reponseChiffree.length()+2));
			for (int i = 0; i < reponseChiffree.length(); i++) {
				if ((reponseChiffree.charAt(i) == '_')) {
					JTextField t = new JTextField(1);
					l.add(t);
				} else {
					l.add(reponseChiffree.charAt(i));
				}
			}
			int j = 0;
			for (int i = 0; i < l.size(); i++) {
				if (reponseChiffree.charAt(i) == '_') {
					k++;
					JTextField txt = new JTextField();
					pan_buttons.add(txt);
					txt.setBackground(new Color(255, 204, 255));
					txt.setColumns(1);
					txt.setFont(new java.awt.Font("Tahoma", 1, 20));
					txt.setForeground(new Color(0, 153, 255));
					txt.setHorizontalAlignment(javax.swing.JTextField.CENTER);
					txt.setMargin(new java.awt.Insets(5, 20, 20, 35));
					txt.setMinimumSize(new java.awt.Dimension(53, 43));

					l1.add(txt);
					pan_buttons.add(l1.get(j));
					j++;
				} else {
					String s = new String(String.valueOf((char) l.get(i)));
					JLabel l3 = new JLabel(s);
					pan_buttons.add(l3);
				}
			}
			int mpl = l1.size();
			// System.out.println("mpl : " + mpl);
			l1.get(0).requestFocus();
			pan_question.setAlignmentX(2.0F);
			pan_question.setLayout(new java.awt.GridLayout(2, 1));

			jPanel6.setBackground(new java.awt.Color(204, 255, 204));
			jPanel6.setLayout(new java.awt.CardLayout(40, 0));

			label_const.setBackground(new java.awt.Color(204, 255, 204));
			label_const.setFont(new java.awt.Font("Traditional Arabic", 1, 18));
			label_const.setText("your question is :");
			jPanel6.add(label_const, "card2");

			pan_question.add(jPanel6);

			PANQUES.setBackground(new java.awt.Color(204, 255, 204));

			label_question.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24));
			label_question.setText("- " + question);
			PANQUES.add(label_question);

			pan_question.add(PANQUES);

			jPanel3.add(pan_question);

			pan_buttons.setBackground(new java.awt.Color(204, 255, 204));

			//// battouna.setText("battouna");
			// pan_buttons.setLayout(new GridLayout(1, reponseChiffree.length()+2));

			// pan_buttons.add(battouna);

			l1.get(0).requestFocus();
			for (i = 0; i < l1.size() - 1; i++) {
				l1.get(i).addKeyListener(new KeyAdapter() {
					public void keyTyped(KeyEvent EVT) {
						if ((EVT.getKeyChar() >= 'a' && EVT.getKeyChar() <= 'z')
								|| (EVT.getKeyChar() >= '0' && EVT.getKeyChar() <= '9')) {

							if (l1.get(i).getText() == "") {
								l1.get(i).requestFocus();
							} else {
								l1.get(++p).requestFocus();
							}
						} else {
							l1.get(i).requestFocus();
							l1.get(i).setEditable(false);
						}
					}
				});
			}

			jPanel3.add(pan_buttons);

			pan_submit.setLayout(new java.awt.GridLayout(1, 2));

			jPanel1.setLayout(new java.awt.GridLayout(2, 1));

			jPanel5.setBackground(new java.awt.Color(204, 255, 204));
			jPanel1.add(jPanel5);

			jPanel4.setBackground(new java.awt.Color(204, 255, 204));

			Ok.setFont(new java.awt.Font("Tahoma", 0, 18));
			Ok.setForeground(new java.awt.Color(51, 153, 255));
			jPanel4.add(Ok);

			give_up.setFont(new java.awt.Font("Tahoma", 0, 18));
			give_up.setForeground(new java.awt.Color(0, 153, 255));
			give_up.setIcon(new javax.swing.ImageIcon(getClass().getResource("giveup.png")));

			jPanel4.add(give_up);

			jButton1.setFont(new java.awt.Font("Tahoma", 0, 18));
			jButton1.setForeground(new java.awt.Color(0, 153, 255));
			jButton1.setText("Skip question");
			jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("skip.png")));

			jPanel4.add(jButton1);

			jPanel1.add(jPanel4);

			pan_submit.add(jPanel1);

			jPanel2.setBackground(new java.awt.Color(204, 255, 204));
			jPanel2.setLayout(new java.awt.GridLayout(3, 1));

			jPanel7.setBackground(new java.awt.Color(204, 255, 204));
			jPanel77.setBackground(new java.awt.Color(204, 255, 204));

			jLabel1.setText("Score 1: " + liste.get("j1"));
			jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
			jPanel7.add(jLabel1);
			jLabel11.setText("Score 2: " + liste.get("j2"));
			jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18));
			label_temps.setFont(new java.awt.Font("Tahoma", 0, 18));
			jPanel77.add(jLabel11);

			jPanel2.add(jPanel7);
			jPanel2.add(jPanel77);

			jPanel8.setBackground(new java.awt.Color(204, 255, 204));

			label_temps.setText("timer");
			jPanel8.add(label_temps);

			jPanel2.add(jPanel8);

			pan_submit.add(jPanel2);

			jPanel3.add(pan_submit);

			getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

			fichier.setText("fichier");
			JMenu regle = new JMenu("regles");
			JMenuItem show = new JMenuItem("show");
			JMenuItem quit = new JMenuItem("quit");
			JMenuItem restart = new JMenuItem("restart");
			JMenuItem add = new JMenuItem("Add question");
			add.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					counter = -1;
					// setVisible(false);
					Add aad = new Add();
				}
			});
			restart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					counter = -1;
					setVisible(false);
					fenetre_name fi = new fenetre_name();

				}
			});
			quit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			show.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// setVisible(false);
					Regle regle = new Regle();
					counter = -1;
				}
			});
			fichier.add(restart);
			fichier.add(quit);
			regle.add(show);
			edit.add(add);
			jMenuBar1.add(fichier);
			jMenuBar1.add(regle);
			edit.setText("Edit");
			jMenuBar1.add(edit);

			setJMenuBar(jMenuBar1);

			setBounds(300, 100, 900, 600);
			l1.get(0).requestFocus();
			addWindowListener(new WindowAdapter() {
				@Override
				public void windowActivated(WindowEvent e) {
					if (isVisible()) {
						try {
							l1.get(0).requestFocus();
						} catch (Exception e1) {
						}
					}
				}
			});
		} catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		Ok.addActionListener(this);
		Ok.setIcon(new ImageIcon(getClass().getResource("ssp.png")));
		jButton1.addActionListener(this);
		give_up.addActionListener(this);

		this.liste = liste;
		this.setVisible(true);
	}

	private String s_concat;

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jButton1) {
			if (paire % 2 == 0) {
				fenetre_jeu qq = new fenetre_jeu("j2 turn", liste, 1);

			} else {
				fenetre_jeu qq = new fenetre_jeu("j1 turn", liste, 2);

			}
		}
		if (e.getSource() == give_up) {
			if (paire % 2 == 0) {
				JOptionPane.showMessageDialog(null, "j2 win !!!!!!");
				this.setVisible(false);

			} else {

				JOptionPane.showMessageDialog(null, "j1 win !!!!!!");
				this.setVisible(false);

			}
		}

		if (e.getSource() == Ok) {
			for (int i = 0; i < l1.size(); i++) {
				if (l1.get(i).getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Veillez remplir les cases vides");
					break;
				}
			}
		}
		if (e.getSource() == Ok) {
			counter = -1;
			s_concat = "";
			String s = "";
			for (int i = 0; i < l1.size(); i++) {
				s += ((JTextField) l1.get(i)).getText();
			}
			// String s_concat = "";
			int p = 0;
			for (int i = 0; i < reponseChiffree.length(); i++)
				if (reponseChiffree.charAt(i) != '_')
					s_concat += String.valueOf((char) l.get(i));
				else {
					s_concat += l1.get(p).getText();
					p++;
				}
			System.out.println("count paire  : " + paire);
			if (s_concat.equals(reponse)) {
				JOptionPane.showMessageDialog(null, "Correct");
				if (paire % 2 == 0) {
					liste.put("j1", liste.get("j1") + 1);
					fenetre_jeu qq = new fenetre_jeu("j2 turn", liste, 1);
					System.out.println("count paire j1 : " + paire);
				} else {
					if (paire % 2 != 0) {
						liste.put("j2", liste.get("j2") + 1);
						System.out.println("count paire j2 : " + paire);
						fenetre_jeu qq = new fenetre_jeu("j1 turn", liste, 2);
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "Non");
				System.out.println("listee : " + liste + "  " + liste.get("j2"));
				if (paire % 2 == 0) {
					fenetre_jeu qq = new fenetre_jeu("j2 turn", liste, 1);
				} else {
					if (paire % 2 != 0) {
						fenetre_jeu qq = new fenetre_jeu("j1 turn", liste, 2);
					}
				}
			}
			System.out.println("listee : " + liste + liste.get("j2"));
			s = "";
		}
		if (liste.get("j2") >= 10) {
			setVisible(false);
			JOptionPane.showMessageDialog(null, "j2 win");
		}
		if (liste.get("j1") >= 10) {
			setVisible(false);
			JOptionPane.showMessageDialog(null, "j1 win");
		}
		setVisible(false);
	}

	private JMenu edit, fichier;
	private JButton give_up, jButton1, Ok;
	private JMenuBar jMenuBar1;
	private JLabel jLabel11, jLabel1, label_const, label_temps, label_titre, label_question;
	private JPanel PANQUES, jPanel1, jPanel2, jPanel3, jPanel4, jPanel5, jPanel6, jPanel7, jPanel77,
			jPanel8, pan_buttons, pan_question, pan_submit, pan_titre;
}
