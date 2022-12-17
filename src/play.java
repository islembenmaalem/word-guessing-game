import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


import javax.swing.border.EtchedBorder;

class play extends JWindow {

	static JProgressBar progressBar = new JProgressBar();
	static int count = 1, TIMER_PAUSE = 25, PROGBAR_MAX = 100;
	static Timer progressBarTimer;
	ActionListener al = new ActionListener() {
		public void actionPerformed(java.awt.event.ActionEvent evt) {
			progressBar.setValue(count);
			if (PROGBAR_MAX == count) {
				progressBarTimer.stop();
				play.this.setVisible(false);
				new fenetre_name();
			}
			count++;
		}

	};

	public play() {
		Container container = getContentPane();
		container.setBackground(new java.awt.Color(153, 204, 255));

		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder());
		container.add(panel, BorderLayout.CENTER);
		panel.setBackground(new java.awt.Color(153, 204, 255));

		JLabel label = new JLabel("welcome to our game !!");
		label.setFont(new java.awt.Font("Tempus Sans ITC", 1, 48));
		panel.add(label);

		progressBar.setMaximum(PROGBAR_MAX);
		container.add(progressBar, BorderLayout.SOUTH);
		setBounds(500, 200, 500, 300);
		setVisible(true);
		startProgressBar();
	}

	private void startProgressBar() {
		progressBarTimer = new Timer(TIMER_PAUSE, al);
		progressBarTimer.start();
	}

}
