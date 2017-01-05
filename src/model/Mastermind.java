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
	public static final int MAX_VERSUCHE = 10;

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
		this.farbAnzahl = farbAnzahl;
		this.versuche = new int[MAX_VERSUCHE];
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
		if (!versuchInOrdnung(versuch)) {
			return false;
		}
		versuche[aktuellerVersuch] = versuch;
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
	private boolean versuchInOrdnung(int versuch) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Gibt die Anzahl der bisherigen Versuche zur&uuml;ck.
	 * 
	 * @return bisherige Anzahl der Versuche
	 */
	public int rufeAnzahlVersucheAb() {
		return 0;
	}

	/**
	 * Gibt den {@code index}–ten Versuch zur&uuml;ck. Diese sind ab 1
	 * durchnummeriert, d.h. bei bislang z.B. 7 Versuchen gibt es die Versuche
	 * mit den Nummern 1 bis 7.
	 * 
	 * @param index
	 * @return
	 * 		<ul>
	 *         <li>{@code -1}, falls Index ung&uuml;ltig</li>
	 *         <li>{@code index}–te Versuch, sonst</li>
	 *         </ul>
	 */
	public int rufeVersuchAb(int index) {
		return 0;
	}

	/**
	 * Ermittelt die Anzahl {@code s} der schwarzen und die Anzahl {@code w} der
	 * wei&szlig;en Stifte f&uuml;r den &uuml;bergebenen Versuch und gibt diese
	 * als die Zahl {@code 10 s + w} zur&uuml;ck. Der Aufruf
	 * {@code bewerteVersuch(491472)} f&uuml;hrt bei dem Geheimcode
	 * {@code 711574} also zu dem Ergebnis {@code 2 · 10 + 1 = 21}. Ein
	 * ung&uuml;ltiger Versuch (siehe {@link #rufeVersuchAb(int)}) wird mit dem
	 * R&uuml;ckgabewert {@code −1} zur&uuml;ckgewiesen.
	 * 
	 * @param versuch
	 *            welcher Versuch?
	 * @return
	 * 		<ul>
	 *         <li>{@code -1}, falls Index ung&uuml;ltig</li>
	 *         <li>Anzahl {@code s} der schwarzen und die Anzahl {@code w} der
	 *         wei&szlig;en Stifte f&uuml;r den &uuml;bergebenen Versuch als
	 *         Zahl {@code 10 s + w}, sonst</li>
	 *         </ul>
	 */
	public int bewerteVersuch(int versuch) {
		return 0;
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
		return false;
	}

	/**
	 * L&auml;sst sich jederzeit wieder von vorn beginnen, d.h. alle Versuche
	 * werden gel&ouml;scht und es wird ein neuer Zufallscode erzeugt.
	 */
	public void spielZuruecksetzen() {

	}

}
