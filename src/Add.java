import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Add extends JFrame implements ActionListener {

	/**
	 * Creates new form add
	 */
	public Add() {

		jPanel1 = new javax.swing.JPanel();
		jPanel5 = new javax.swing.JPanel();
		nom1 = new javax.swing.JLabel();
		txt_nom1 = new javax.swing.JTextField();
		nom2 = new javax.swing.JLabel();
		txt_nom2 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jPanel1.setBackground(new java.awt.Color(204, 204, 255));
		// jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

		jPanel5.setBackground(new java.awt.Color(204, 204, 255));
		jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add question",
				javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION,
				new java.awt.Font("Tahoma", 0, 18), new java.awt.Color(204, 0, 204))); // NOI18N

		nom1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		nom1.setText("question :");

		txt_nom1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		

		nom2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
		nom2.setText("reponse :");

		txt_nom2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		
		jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("add.png"))); // NOI18N

		javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
		jPanel5.setLayout(jPanel5Layout);
		jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
						jPanel5Layout.createSequentialGroup().addContainerGap()
								.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(nom1, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, 97,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(txt_nom1, javax.swing.GroupLayout.PREFERRED_SIZE, 319,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_nom2, javax.swing.GroupLayout.PREFERRED_SIZE, 319,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGap(831, 831, 831)));
		jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(jPanel5Layout.createSequentialGroup().addGroup(jPanel5Layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
						.addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(jPanel5Layout.createSequentialGroup()
								.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(nom1, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_nom1, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(nom2, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(txt_nom2, javax.swing.GroupLayout.PREFERRED_SIZE, 64,
												javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addGap(0, 24, Short.MAX_VALUE)));
		jPanel5.setLocation(70, 70);
		jPanel5.setSize(600, 180);
		add(jPanel5);
		jPanel5.getAccessibleContext().setAccessibleName("");

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 843, Short.MAX_VALUE));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 411, Short.MAX_VALUE));
		b = new JButton("Add");
		b.addActionListener(this);
		b.setLocation(360, 320);
		b.setSize(120, 100);

		jPanel1.add(b);

		setBounds(0, 0, 700, 400);
		setVisible(true);
	}// </editor-fold>

	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b) {
			String q = txt_nom1.getText();
			String r = txt_nom2.getText();

			XPath xpath = XPathFactory.newInstance().newXPath();
			Document doc;
			try {
				File inputFile = new File(xmlFilePath);
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document document = dBuilder.parse(inputFile);
				NodeList nodeList = document.getDocumentElement().getChildNodes();
				// Element root = document.createElement("question");
				// document.appendChild(root);
				int n = nodeList.getLength() + 1;
				String id = Integer.toString(n);
				System.out.print("dfddfdf" + n);

				DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
				Document dd = documentBuilder.parse(xmlFilePath);
				Element root = dd.getDocumentElement();

				// server elements
				Element newServer = dd.createElement("question");
				Attr attr = dd.createAttribute("id");
			    attr.setValue(id);
			    newServer.setAttributeNode(attr);

				Element name = dd.createElement("quest");
				name.appendChild(dd.createTextNode(q));
				newServer.appendChild(name);

				Element port = dd.createElement("reponse");
				port.appendChild(dd.createTextNode(r));
				newServer.appendChild(port);

				root.appendChild(newServer);

				DOMSource source = new DOMSource(dd);

				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				StreamResult result = new StreamResult(xmlFilePath);
				transformer.transform(source, result);
				JOptionPane.showMessageDialog(null, "la question est ajoutée");
				txt_nom1.setText("");
				txt_nom2.setText("");
			} catch (SAXException | IOException | ParserConfigurationException | TransformerException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel5;
	private javax.swing.JLabel nom1;
	JButton b;
	public static final String xmlFilePath = "C:/Users/MSI/eclipse-workspace/projet java ds/xmlquestion.xml";
	private javax.swing.JLabel nom2;
	private javax.swing.JTextField txt_nom1;
	private javax.swing.JTextField txt_nom2;
	// End of variables declaration
}
