import java.util.Collections;
import java.util.Random;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class Jeu {
	private ArrayList liste = new ArrayList<Integer>();

	public int get_nombre_aleatoire(int n) {
		Random random = new Random();
		int nb;
		nb = random.nextInt(n) + 1;
		return nb;
	}

	public String affiche_lettre_aleatoire(String word, int nb) {
		/// int nb = get_nombre_aleatoire(3); // nombre du lettres à afficher
		String reponsechiffre = "";
		if (nb == 1) {
			int n = get_nombre_aleatoire(word.length());
			// System.out.println("_".repeat(n)+word.charAt(n)+"_".repeat(word.length()-1));
			int p = word.length() - n - 1;
			System.out.println("nb = " + nb);
			System.out.println("n = " + n);
			reponsechiffre = (String.join("", Collections.nCopies(n - 1, "_")) + word.charAt(n - 1)
					+ String.join("", Collections.nCopies(p + 1, "_")));

		}

		if (nb == 2) {
			int n1 = get_nombre_aleatoire(word.length() - 1); // position du caractere 1
			int n2 = get_nombre_aleatoire(word.length()); // position du caractere 2
			int n = n1;
			if (n1 > n2) {
				n1 = n2;
				n2 = n;
			} else if (n1 == n2) {
				n2++;
			}
			int p = word.length() - n2 - 1;
			System.out.println("nb = " + nb);
			System.out.println("n1 = " + n1);
			System.out.println("n2 = " + n2);
			System.out.println(String.join("", Collections.nCopies(n1 - 1, "_")));
			reponsechiffre = (word.charAt(n1 - 1) + String.join("", Collections.nCopies(n2 - n1 - 1, "_"))

					+ word.charAt(n2 - 1) + String.join("", Collections.nCopies(p + 1, "_")));
		}
		if (nb == 3) {
			int n1 = get_nombre_aleatoire(word.length() - 2); // position aleatoire du caractere 1
			int n2 = get_nombre_aleatoire(word.length() - 1); // position aleatoire du caractere 2
			int n3 = get_nombre_aleatoire(word.length()); // position du aleatoire caractere 3
			int array[] = { n1, n2, n3 };
			Arrays.sort(array);
			n1 = array[0];
			n2 = array[1];
			n3 = array[2];
			if (n1 == n2) {
				n2++;
			}
			if (n1 == n3) {
				n3++;
			}
			if (n2 == n3) {
				n3++; //pour ne pas etre chavecher/ confondus
			}

			// System.out.println("_".repeat(n)+word.charAt(n)+"_".repeat(word.length()-1));
			int p = word.length() - n3 - 1;
			System.out.println("nb = " + nb);
			System.out.println("n1 = " + n1);
			System.out.println("n2 = " + n2);
			System.out.println("n3 = " + n3);
			reponsechiffre = (String.join("", Collections.nCopies(n1 - 1, "_")) + word.charAt(n1 - 1)
					+ String.join("", Collections.nCopies(n2 - n1 - 1, "_"))

					+ word.charAt(n2 - 1) + String.join("", Collections.nCopies(n3 - n2 - 1, "_")) + word.charAt(n3 - 1)
					+ String.join("", Collections.nCopies(p + 1, "_")));
		}
		return reponsechiffre;

	}

	public boolean reponse_true(String word1) // wahda mel interface w wahda mel xml
			throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		XPath xpath = XPathFactory.newInstance().newXPath();
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse("C:/Users/MSI/eclipse-workspace/projet java ds/xmlquestion.xml");
		String question = question_aleatoire();
		String word2 = xpath.evaluate("//question[quest = " + "'" + question + "'" + "]/reponse", doc);
		System.out.println("word2 = " + word2);
		return word1.equals(word2);
	}

	public String getReponse(String question)
			throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		XPath xpath = XPathFactory.newInstance().newXPath();
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse("C:/Users/MSI/eclipse-workspace/projet java ds/xmlquestion.xml");
		String reponse = xpath.evaluate("//question[quest = " + "'" + question + "'" + "]/reponse", doc);
		return reponse;

	}

	public String getReponseChiffree(String question) {
		String reponse = "";
		String reponseChiffree = "";

		try {
			String reponse1 = getReponse(question);
			reponse = reponse1;

		} catch (XPathExpressionException | SAXException | IOException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		int len = reponse.length();
		if (len > 12) {
			reponseChiffree = affiche_lettre_aleatoire(reponse, 3);
		} else if (len > 9) {
			reponseChiffree = affiche_lettre_aleatoire(reponse, 2);

		} else {
			reponseChiffree = affiche_lettre_aleatoire(reponse, 1);

		}
		return reponseChiffree;

	}

	public String question_aleatoire()
			throws SAXException, IOException, ParserConfigurationException, XPathExpressionException {
		XPath xpath = XPathFactory.newInstance().newXPath();
		Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder()
				.parse("C:/Users/MSI/eclipse-workspace/projet java ds/xmlquestion.xml");
		String n = xpath.evaluate("//question[last()]/@id", doc);
		int nb = get_nombre_aleatoire(Integer.parseInt(n));

		while (liste.contains(nb)) {
			nb = get_nombre_aleatoire(Integer.parseInt(n));
		}
		if (!liste.contains(nb)) {
			liste.add(nb);
		}
		System.out.println("liste : " + liste);
		if (liste.size() == Integer.parseInt(n)) {
			liste.clear();
		}

		// XPath xpath1 = XPathFactory.newInstance().newXPath();
		String question = xpath.evaluate("//question[@id=" + "'" + nb + "'" + "]/quest", doc);

		System.out.println("question = " + question);
		return question;

	}
}
