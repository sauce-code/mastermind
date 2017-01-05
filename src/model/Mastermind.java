package model;

/**
 * Mastermind-Spiel.
 * 
 * @author ich
 *
 */
public class Mastermind {

	/**
	 * Standard codel&auml;nge.
	 */
	public static final int STANDARD_CODE_LAENGE = 4;

	/**
	 * Standard farbanzahl.
	 */
	public static final int STANDARD_FARB_ANZAHL = 6;

	/**
	 * Maximale Anzahl Versuche pro Partie.
	 */
	public static final int MAX_VERSUCHE = 1000;

	/**
	 * Speichert alle Versuche ab.
	 */
	private int[] versuche;

	/**
	 * Speichert die Nummer des aktuellen Versuchs ab.
	 */
	private int aktuellerVersuch;

	/**
	 * Die L&ouml;sung des Spiels.
	 */
	private int loesung;

	/**
	 * Die CodeL&auml;nge jedes Versuchs.
	 */
	private int codeLaenge;

	/**
	 * Die Anzahl der zugelassenen Farben.
	 */
	private int farbAnzahl;

	/**
	 * Unzul&auml;ssige Angaben werden kommentarlos durch die Standardwerte des
	 * Originalspiels {@link #Mastermind()} ersetzt.
	 * 
	 * @param codeLaenge
	 * @param farbAnzahl
	 */
	public Mastermind(int codeLaenge, int farbAnzahl) {
		this.codeLaenge = codeLaenge;
		this.farbAnzahl = farbAnzahl;
		this.versuche = new int[MAX_VERSUCHE];
		this.loesung = generiereLoesung();
		this.aktuellerVersuch = 0;
	}

	/**
	 * Verwendet {@link #STANDARD_CODE_LAENGE} und {@link #STANDARD_FARB_ANZAHL}
	 * .
	 */
	public Mastermind() {
		this(STANDARD_CODE_LAENGE, STANDARD_FARB_ANZAHL);
	}

	/**
	 * Nimmt einen Versuch entgegen und speichert ihn ab, so dass er jederzeit
	 * sp&auml;ter wieder aufgerufen werden kann (siehe
	 * {@link #rufeVersuchAb(int)}). Die Speicherung darf nur bei einem
	 * g&uuml;ltigen Versuch erfolgen (es treten also keine unerlaubten Ziffern
	 * auf und auch die Codel&auml;nge muss stimmen).
	 * 
	 * @param versuch
	 *            wievielter versuch?
	 * @return {@code true}, falls Versuch g&uuml;ltig
	 */
	public boolean speichereNaechstenVersuch(int versuch) {
		if (!istVersuchGueltig(versuch)) {
			return false;
		}
		versuche[aktuellerVersuch++] = versuch;
		return true;
	}

	/**
	 * Gibt an, ob ein Versuch in Ordnung ist.<br>
	 * Er ist genau dann in Ordnung, wenn seine Codel&auml;nge und Farbanzahl
	 * keine Limits &uuml;berschreiten.
	 * 
	 * @param versuch
	 *            Versuch, welcher &uuml;berpr&uuml;ft werden soll
	 * @return {@code true}, falls Veruch in ordnung
	 */
	private boolean istVersuchGueltig(int versuch) {

		// ueberpruefe codelaenge
		boolean gueltig = versuch < Math.pow(10, codeLaenge + 1);

		// ueberpruefe farben
		for (int i = 0; i < codeLaenge; i++) {
			int ziffer = versuch % 10;
			gueltig &= (ziffer > 0) && (ziffer < farbAnzahl);
			versuch = versuch / 10;
		}

		// liefere ergebnis
		return gueltig;
	}

	/**
	 * Gibt die Anzahl der bisherigen Versuche zur&uuml;ck.
	 * 
	 * @return bisherige Anzahl der Versuche
	 */
	public int rufeAnzahlVersucheAb() {
		return aktuellerVersuch;
	}

	/**
	 * Gibt den {@code index}-ten Versuch zur&uuml;ck. Diese sind ab 1
	 * durchnummeriert, d.h. bei bislang z.B. 7 Versuchen gibt es die Versuche
	 * mit den Nummern 1 bis 7.
	 * 
	 * @param index
	 *            Index des Versuchs, welcher abgerufen werden soll
	 * @return
	 * 		<ul>
	 *         <li>{@code -1}, falls Index ung&uuml;ltig</li>
	 *         <li>{@code index}-te Versuch, sonst</li>
	 *         </ul>
	 */
	public int rufeVersuchAb(int index) {
		return istIndexGueltig(index) ? versuche[index] : -1;
	}

	/**
	 * Gibt an, ob ein Index g&uuml;ltig ist.
	 * 
	 * @param index
	 *            Index, welche &uuml;berpr&uuml;ft werden soll.
	 * @return {@code true}, falls Index g&uuml;ltig
	 */
	private boolean istIndexGueltig(int index) {
		return (index >= 0) && (index < aktuellerVersuch);
	}

	/**
	 * Ermittelt die Anzahl {@code s} der schwarzen und die Anzahl {@code w} der
	 * wei&szlig;en Stifte f&uuml;r den &uuml;bergebenen Versuch und gibt diese
	 * als die Zahl {@code 10 s + w} zur&uuml;ck.<br>
	 * Der Aufruf {@code bewerteVersuch(491472)} f&uuml;hrt bei dem Geheimcode
	 * {@code 711574} also zu dem Ergebnis {@code 2 · 10 + 1 = 21}. Ein
	 * ung&uuml;ltiger Versuch (siehe {@link #rufeVersuchAb(int)}) wird mit dem
	 * R&uuml;ckgabewert {@code -1} zur&uuml;ckgewiesen.
	 * 
	 * @param versuch
	 *            welcher Versuch?
	 * @return
	 * 		<ul>
	 *         <li>{@code -1}, falls Versuch ung&uuml;ltig</li>
	 *         <li>Anzahl {@code s} der schwarzen und die Anzahl {@code w} der
	 *         wei&szlig;en Stifte f&uuml;r den &uuml;bergebenen Versuch als
	 *         Zahl {@code 10 s + w}, sonst</li>
	 *         </ul>
	 */
	public int bewerteVersuch(int versuch) {
		if (!istVersuchGueltig(versuch)) {
			return -1;
		}
		int bewertung = 0;
		int loesungKopie = loesung;
		for (int i = 0; i < codeLaenge; i++) {
			int zifferVersuch = versuch % 10;
			int zifferLoesung = loesungKopie % 10;

			bewertung += 0;
			versuch = versuch / 10;
		}
		return bewertung;
	}

	/**
	 * Pr&uuml;ft, ob der zuletzt abgegebene Versuch er- folgreich war.
	 * 
	 * @return
	 * 		<ul>
	 *         <li>{@ode true}, falls der zuletzt abgegebene Versuch erfolgreich
	 *         war</li>
	 *         <li>{@code false}, falls der zuletzt abgegebene Versuche nicht
	 *         erfolgreich war</li>
	 *         <li>{@code false}, falls noch gar keine Versuche gab, weil das
	 *         Spiel soeben erst gestartet wurde</li>
	 *         </ul>
	 */
	public boolean spielGewonnen() {
		return (aktuellerVersuch > 0) && (versuche[aktuellerVersuch] == loesung);
	}

	/**
	 * L&auml;sst sich jederzeit wieder von vorn beginnen, d.h. alle Versuche
	 * werden gel&ouml;scht und es wird ein neuer Zufallscode erzeugt.
	 */
	public void spielZuruecksetzen() {
		versuche = new int[MAX_VERSUCHE];
		loesung = generiereLoesung();
		aktuellerVersuch = 0;
	}

	/**
	 * Generiert eine neue zuf&auml;llige L&ouml;sung.
	 * 
	 * @return neue zuf&auml;llige L&ouml;sung
	 */
	private int generiereLoesung() {
		int loesung = 0;
		for (int i = 0; i < codeLaenge; i++) {
			loesung += Math.pow(10, i * zufallsZahl(1, farbAnzahl));
		}
		return loesung;
	}

	/**
	 * Liefert eine Zufallszahl.
	 * 
	 * @param min
	 *            untere Grenze
	 * @param max
	 *            obere Grenze
	 * @return Zufallszahl
	 */
	private int zufallsZahl(int min, int max) {
		return min + (int) (Math.random() * ((max - min) + 1));
	}

}
