package view;

import model.Mastermind;

/**
 * Ausgabe-Klasse.
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
		System.out.println("Willkommen zu Mastermind - und los geht�s!");
	}

	/**
	 * Erzeugt auf dem Bildschirm eine Darstellung aller bislang erfolgten
	 * Versuche (in der richtigen Reihenfolge) zusammen mit den zugeh&ouml;rigen
	 * Bewertungen, damit der Spieler alle Informationen f&uuml;r seinen
	 * n&auml;chsten Versuch zur Hand hat.
	 */
	// TODO Überlegen Sie sich auch eine passende Ausgabe für den Fall, dass
	// noch gar keine Versuche vorliegen.
	public void druckeSpielverlauf() {

	}

	/**
	 * Zeigt auf dem Bildschirm einen Eingabehinweis an und informiert ihn
	 * zugleich dar&uuml;ber, um den wievielten Versuch es sich handelt.
	 */
	public void spielerZumVersuchAuffordern() {

	}

	/**
	 * Dient zur Ausgabe einer abschlie&szlig;enden Meldung, wenn der Spieler
	 * zuvor bereits den Geheimcode geknackt hat.
	 */
	public void demSpielerGratulieren() {

	}

}
