package control;

import view.Ausgabe;
import model.Mastermind;

/**
 * Stererungs-Klasse.
 * 
 * @see control.Eingabe
 * @see model.Mastermind
 * @see view.Ausgabe
 * 
 * @author ich
 *
 */
public class Steuerung {

	/**
	 * Mastermind-Spiel, welches verwendet werden soll.
	 */
	private Mastermind spiel;

	/**
	 * Ausgabe, die verwendet werden soll.
	 */
	private Ausgabe ausgabe;
	
	/**
	 * Eingabe, die verwendet werden soll.
	 */
	private Eingabe eingabe;

	/**
	 * Erzeugt eine neue Steuerung.
	 * 
	 * @param spiel
	 *            Mastermind-Spiel, welches verwendet werden soll
	 * @param ausgabe
	 *            Ausgabe, die verwendet werden soll
	 */
	public Steuerung(Mastermind spiel, Ausgabe ausgabe) {
		this.spiel = spiel;
		this.ausgabe = ausgabe;
		this.eingabe = new Eingabe();
	}

	/**
	 * Hier wird gesamte Spielverlauf abgewickelt. Nach der R&uuml;ckkehr ist
	 * das Spiel beendet.
	 */
	public void starteSpiel() {
		ausgabe.denSpielerBegruessen();
		do {
			ausgabe.druckeSpielverlauf();
			ausgabe.spielerZumVersuchAuffordern();
			int versuch = eingabe.leseInt();
			ausgabe.leerzeile();
			spiel.speichereNaechstenVersuch(versuch);
		} while (!spiel.spielGewonnen() && !spiel.spielVerloren());
		if (spiel.spielGewonnen()) {
			ausgabe.demSpielerGratulieren();
		}
		if (spiel.spielVerloren()) {
			ausgabe.denSpielerBedauern();
		}
	}

	/**
	 * Main Methode zum Ausf&uuml;hren des Mastermind-Spiels.
	 * 
	 * @param args
	 *            Parameter, ungenutzt
	 */
	public static void main(String args[]) {
		System.out.println("Bitte Codelaenge eingeben (zwischen " + Mastermind.MIN_CODELAENGE + " und "
				+ Mastermind.MAX_CODELAENGE + "):");
		int codeLaenge = new Eingabe().leseInt();
		System.out.println("Bitte Farbanzahl eingeben (zwischen " + Mastermind.MIN_FARBANZAHL + " und "
				+ Mastermind.MAX_FARBANZAHL + "):");
		int farbAnzahl = new Eingabe().leseInt();
		System.out.println();
		Mastermind m = new Mastermind(codeLaenge, farbAnzahl);
		Ausgabe a = new Ausgabe(m);
		Steuerung s = new Steuerung(m, a);
		s.starteSpiel();
	}

}
