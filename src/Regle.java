import java.awt.Toolkit;
import java.awt.*;
import javax.swing.*;

public class Regle extends javax.swing.JFrame {
	public Regle() {
		jPanel1 = new JPanel();
		jLabel1 = new JLabel();
		jLabel3 = new JLabel();
		jLabel4 = new JLabel();
		jLabel5 = new JLabel();
		jLabel6 = new JLabel();
		jLabel7 = new JLabel();
		jLabel2 = new JLabel();
		jLabel8 = new JLabel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("logo.png")));
		setTitle("regles");

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(new java.awt.Color(240, 239, 234));

		jPanel1.setBackground(new Color(240, 239, 234));

		jLabel1.setText("- Si la réponse est correcte il aura +1");
		jLabel1.setLocation(90, 200);
		jLabel1.setSize(240, 20);

		jLabel3.setText("- Le joueur qui atteint 10 le premier sera ");
		jLabel3.setLocation(90, 160);
		jLabel3.setSize(240, 20);

		jLabel4.setText(" gagnant.");
		jLabel4.setLocation(90, 180);
		jLabel4.setSize(240, 20);

		jLabel5.setText("- Chaque joueur aura à son tour à ");
		jLabel5.setSize(280, 20);
		jLabel5.setLocation(90, 120);

		jLabel6.setText(" sinon un 0.");
		jLabel6.setSize(280, 20);
		jLabel6.setLocation(90, 220);
		jLabel2.add(jLabel1);
		jLabel2.add(jLabel4);
		jLabel2.add(jLabel3);
		jLabel2.add(jLabel5);
		jLabel2.add(jLabel6);
		jLabel2.add(jLabel7);

		jLabel7.setText(" répondre.");
		jLabel7.setSize(280, 20);
		jLabel7.setLocation(90, 140);

		jLabel2.setIcon(new ImageIcon(getClass().getResource("reg.jpg")));
		jLabel2.setLocation(220, 0);
		jLabel2.setSize(390, -1);

		jLabel8.setIcon(new ImageIcon(getClass().getResource("think.png")));
		jLabel8.setLocation(0, 197);
		jLabel8.setSize(170, 310);
		jPanel1.add(jLabel8);
		jPanel1.add(jLabel2);

		setSize(580, 510);
		setBounds(100, 100, 700, 550);

		jPanel1.setLocation(0, 0);
		jPanel1.setSize(580, 510);
		getContentPane().add(jPanel1);
		setVisible(true);
	}

	private JLabel jLabel1, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8;
	JPanel jPanel1;

}
