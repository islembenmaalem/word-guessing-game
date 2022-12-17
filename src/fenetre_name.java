import java.awt.Toolkit;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;

public class fenetre_name extends javax.swing.JFrame implements ActionListener {
	private JButton btt;
	private JLabel jLabel10, jLabel2;
	private JPanel jPanel5;
	private JLabel nom1, nom2;
	private JTextField txt_nom1, txt_nom2;

	public fenetre_name() {

		try {
			URL file = new URL("https://rb.gy/bzknuw");
			AudioInputStream ais = AudioSystem.getAudioInputStream(file);
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.setFramePosition(0);
			// clip.loop(Clip.LOOP_CONTINUOUSLY);
			clip.start();

		} catch (LineUnavailableException | IOException | UnsupportedAudioFileException e2) {
			e2.printStackTrace();
		}

		jPanel5 = new JPanel();
		nom1 = new JLabel();
		txt_nom1 = new JTextField();
		nom2 = new JLabel();
		txt_nom2 = new JTextField();
		jLabel2 = new JLabel();
		btt = new JButton();
		jLabel10 = new JLabel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel5.setBackground(new Color(204, 204, 255));
		jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Players Name",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 18), new Color(204, 0, 204)));

		nom1.setFont(new java.awt.Font("Tahoma", 1, 18));
		nom1.setText("Player 1 :");

		txt_nom1.setFont(new java.awt.Font("Tahoma", 0, 18));
		txt_nom1.addActionListener(this);

		nom2.setFont(new java.awt.Font("Tahoma", 1, 18));
		nom2.setText("Player 2 :");

		txt_nom2.setFont(new java.awt.Font("Tahoma", 0, 18));

		jLabel2.setIcon(new ImageIcon(getClass().getResource("z.png")));

		GroupLayout jPanel5Layout = new GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
				GroupLayout.Alignment.TRAILING,
				jPanel5Layout.createSequentialGroup().addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel2).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(nom1, GroupLayout.PREFERRED_SIZE, 97,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(nom2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(txt_nom1, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_nom2, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE))
						.addGap(831, 831, 831)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(jLabel2)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(jPanel5Layout.createSequentialGroup()
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(nom1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_nom1, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanel5Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(nom2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
								.addComponent(txt_nom2, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
						.addGap(0, 24, Short.MAX_VALUE)));

		getContentPane().add(jPanel5);

		btt.setBackground(new Color(204, 204, 255));
		btt.setFont(new Font("Tahoma", 0, 18));
		btt.setIcon(new ImageIcon(getClass().getResource("ss.png")));
		btt.setText("Start");
		btt.addActionListener(this);
		btt.setSize(130, 50);
		btt.setLocation(1000, 440);
		// getContentPane().add(btt);

		jLabel10.setIcon(new ImageIcon(getClass().getResource("a.jpg")));
		jLabel10.setSize(1310, 690);
		jLabel10.setLocation(0, -30);// NOI18N
		jLabel10.add(btt);
		getContentPane().add(jLabel10);
		jPanel5.setLocation(70, 380);
		jPanel5.setSize(680, 190);
		jLabel10.add(jPanel5);
		liste = new HashMap<String, Integer>();
		setResizable(false);

		setBounds(100, 80, 1325, 681);
		setVisible(true);
	}

	HashMap<String, Integer> liste;

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btt) {
			if (txt_nom1.getText().equals("") || txt_nom2.getText().equals(""))
				JOptionPane.showMessageDialog(null, "fill the name please");
			else {
				Joueur j1 = new Joueur(txt_nom1.getText());
				Joueur j2 = new Joueur(txt_nom2.getText());
				liste.put("j1", j1.getScore());
				liste.put("j2", j2.getScore());
				System.out.println(liste);
				String data = " Nom : " + txt_nom1.getText() + "\n" + " Prenom : " + txt_nom2.getText() + "\n";
				System.out.println(data);
				setVisible(false);
				new fenetre_jeu("j1 turn", liste, 0);
			}
		}
	}

	public String getNom1() {
		return txt_nom1.getText();
	}

	public String getNom2() {
		return txt_nom2.getText();
	}

	public HashMap getListe0() {
		Joueur j1 = new Joueur(txt_nom1.getText());
		Joueur j2 = new Joueur(txt_nom2.getText());
		HashMap<String, Integer> liste = new HashMap<String, Integer>();
		liste.put("j1", j1.getScore());
		liste.put("j2", j2.getScore());
		return liste;
	}

}
