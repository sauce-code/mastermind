package view;

import model.Mastermind;

/**
 * Ausgabe-Klasse.
 * 
 * @see model.Mastermind
 * 
 * @author ich
 *
 */
public class Ausgabe {

	/**
	 * Mastermind-Spiel, welches ausgegeben werden soll.
	 */
	private Mastermind spiel;

	/**
	 * Erzeugt neue Oberfl&auml;che.
	 * 
	 * @param spiel
	 *            Mastermind-Spiel, welches ausgegeben werden soll
	 */
	public Ausgabe(Mastermind spiel) {
		this.spiel = spiel;
	}

	/**
	 * F&uuml;hrt zu einer freundlichen Willkommensmeldung, die dem Spieler zu
	 * Anfang pr&auml;sentiert werden kann.
	 */
	public void denSpielerBegruessen() {
		System.out.println("Willkommen zu Mastermind!");
		System.out.println("Codelaenge: " + spiel.rufeCodeLaengeAb());
		System.out.println("Farbanzahl: " + spiel.rufeFarbAnzahlAb());
		System.out.println("Maximale Versuche: " + spiel.rufeMaxVersucheAb());
		System.out.println("Und los geht’s!");
		leerzeile();
	}

	/**
	 * Erzeugt auf dem Bildschirm eine Darstellung aller bislang erfolgten
	 * Versuche (in der richtigen Reihenfolge) zusammen mit den zugeh&ouml;rigen
	 * Bewertungen, damit der Spieler alle Informationen f&uuml;r seinen
	 * n&auml;chsten Versuch zur Hand hat.
	 */
	public void druckeSpielverlauf() {
		if (spiel.rufeAnzahlVersucheAb() == 0) {
			// System.out.println("Bisher kein Spielverlauf.");
		} else {
			System.out.println("Bislang hast Du so gespielt:");
			for (int i = spiel.rufeAnzahlVersucheAb(); i > 0; i--) {
				int versuch = spiel.rufeVersuchAb(i);
				int s = spiel.bewerteVersuch(versuch) / 10;
				int w = spiel.bewerteVersuch(versuch) % 10;
				System.out.println("Dein Versuch #" + (i) + ": " + versuch + " Bewertung: " + s + "-" + w);
			}
			leerzeile();
		}
	}

	/**
	 * Zeigt auf dem Bildschirm einen Eingabehinweis an und informiert ihn
	 * zugleich dar&uuml;ber, um den wievielten Versuch es sich handelt.
	 */
	public void spielerZumVersuchAuffordern() {
		System.out.print("Gib bitte Deinen Versuch #" + (spiel.rufeAnzahlVersucheAb() + 1) + " ein: ");
	}

	/**
	 * Dient zur Ausgabe einer abschlie&szlig;enden Meldung, wenn der Spieler
	 * zuvor bereits den Geheimcode geknackt hat.
	 */
	public void demSpielerGratulieren() {
		System.out.println("Glueckwunsch! - Du hast gewonnen!");
	}

	/**
	 * Dient zur Ausgabe einer abschlie&szlig;enden Meldung, wenn der Spieler
	 * die maximale Anzahl an Versuchen verbraucht hat.
	 */
	public void denSpielerBedauern() {
		System.out.println("Keine weiteren Versuche! - Du hast leider verloren!");
	}

	/**
	 * Druckt eine leere Zeile. Wow.
	 */
	public void leerzeile() {
		System.out.println();
	}

}
