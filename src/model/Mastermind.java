package model;

/**
 * Mastermind-Spiel.
 * 
 * @author ich
 *
 */
public class Mastermind {

	/**
	 * Minimale Codel&auml;nge.
	 */
	public static final int MIN_CODELAENGE = 1;

	/**
	 * Standard Codel&auml;nge.
	 */
	public static final int STD_CODELAENGE = 4;

	/**
	 * Maximale Codel&auml;nge.
	 */
	public static final int MAX_CODELAENGE = 9;

	/**
	 * Minimale Farbanzahl.
	 */
	public static final int MIN_FARBANZAHL = 1;

	/**
	 * Standard farbanzahl.
	 */
	public static final int STD_FARBANZAHL = 6;

	/**
	 * Maximale Farbanzahl.
	 */
	public static final int MAX_FARBANZAHL = 9;

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
	 * Die maximale Anzahl an Versuchen.
	 */
	private int maxVersuche;

	/**
	 * Unzul&auml;ssige Angaben werden kommentarlos durch die Standardwerte des
	 * Originalspiels {@link #Mastermind()} ersetzt.
	 * 
	 * @param codeLaenge
	 *            gew&uuml;nschte Codel&auml;nge
	 * @param farbAnzahl
	 *            gew&uuml;nschte Farbanzahl
	 */
	public Mastermind(int codeLaenge, int farbAnzahl) {
		this.codeLaenge = korrigiereCodeLaenge(codeLaenge);
		this.farbAnzahl = korrigiereFarbAnzahl(farbAnzahl);
		this.loesung = generiereLoesung();
		this.aktuellerVersuch = 0;
		this.maxVersuche = berechneMaxVersuche();
		this.versuche = new int[maxVersuche];
	}

	/**
	 * Liefert die Codel&auml;nge korrigiert zur&uuml;ck, falls n&ouml;tig.
	 * 
	 * @param codeLaenge
	 *            Codel&auml;nge, welche korrigiert werden soll
	 * @return
	 * 		<ul>
	 *         <li>codeLaenge, falls codeLaenge g&uuml;ltig</li>
	 *         <li>{@link #STD_CODELAENGE}, falls codeLaenge {@code <}
	 *         {@link #MIN_CODELAENGE}</li>
	 *         <li>{@link #STD_CODELAENGE}, falls codeLaenge {@code >}
	 *         {@link #MAX_CODELAENGE}</li>
	 *         </ul>
	 */
	private int korrigiereCodeLaenge(int codeLaenge) {
		if (codeLaenge < MIN_CODELAENGE || codeLaenge > MAX_CODELAENGE) {
			return STD_CODELAENGE;
		}
		return codeLaenge;
	}

	/**
	 * Liefert die Farbanzahl korrigiert zur&uuml;ck, falls n&ouml;tig.
	 * 
	 * @param farbAnzahl
	 *            Farbanzahl, welche korrigiert werden soll.
	 * @return
	 * 		<ul>
	 *         <li>farbAnzahl, falls farbAnzahl g&uuml;ltig</li>
	 *         <li>{@link #STD_FARBANZAHL}, falls farbAnzahl {@code <}
	 *         {@link #MIN_FARBANZAHL}</li>
	 *         <li>{@link #STD_FARBANZAHL}, falls farbAnzahl {@code >}
	 *         {@link #MAX_FARBANZAHL}</li>
	 *         </ul>
	 */
	private int korrigiereFarbAnzahl(int farbAnzahl) {
		if (farbAnzahl < MIN_FARBANZAHL || farbAnzahl > MAX_FARBANZAHL) {
			return STD_FARBANZAHL;
		}
		return farbAnzahl;
	}

	/**
	 * Berechnet die maximalen Anzahl an Versuchen, die dem Spieler zur
	 * Verf&uuml;gung stehen.
	 * 
	 * @return maximale Anzahl an Versuchen
	 */
	private int berechneMaxVersuche() {
		return codeLaenge * farbAnzahl / 4 + 2;
	}

	/**
	 * Verwendet {@link #STD_CODELAENGE} und {@link #STD_FARBANZAHL}.
	 */
	public Mastermind() {
		this(STD_CODELAENGE, STD_FARBANZAHL);
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
		if (!istVersuchGueltig(versuch) || spielVerloren()) {
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
	 * @return {@code true}, falls Veruch in Ordnung
	 */
	private boolean istVersuchGueltig(int versuch) {

		// ueberpruefe codelaenge
		boolean gueltig = versuch < Math.pow(10, codeLaenge + 1);

		// ueberpruefe farben
		for (int i = 0; i < codeLaenge; i++) {
			int ziffer = versuch % 10;
			gueltig &= (ziffer > 0) && (ziffer <= farbAnzahl);
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
		return istIndexGueltig(index) ? versuche[index - 1] : -1;
	}

	/**
	 * Liefert die Codelaenge.
	 * 
	 * @return Codelaenge
	 */
	public int rufeCodeLaengeAb() {
		return codeLaenge;
	}

	/**
	 * Liefert die Farbanzahl.
	 * 
	 * @return Farbanzahl
	 */
	public int rufeFarbAnzahlAb() {
		return farbAnzahl;
	}

	/**
	 * Liefert die maximale Anzahl an Versuchen.
	 * 
	 * @return maximale Anzahl an Versuchen
	 */
	public int rufeMaxVersucheAb() {
		return maxVersuche;
	}

	/**
	 * Gibt an, ob ein Index g&uuml;ltig ist.
	 * 
	 * @param index
	 *            Index, welche &uuml;berpr&uuml;ft werden soll.
	 * @return {@code true}, falls Index g&uuml;ltig
	 */
	private boolean istIndexGueltig(int index) {
		return (index > 0) && (index <= aktuellerVersuch);
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
		int[] ziffern = new int[10];
		boolean[] richtig = new boolean[codeLaenge];
		for (int i = 0; i < codeLaenge; i++) {
			int zifferVersuch = versuch % 10;
			int zifferLoesung = loesungKopie % 10;
			if (zifferVersuch == zifferLoesung) {
				richtig[i] = true;
				bewertung += 10;
			} else {
				ziffern[zifferVersuch]++;
			}
			versuch = versuch / 10;
			loesungKopie = loesungKopie / 10;
		}
		loesungKopie = loesung;
		for (int i = 0; i < codeLaenge; i++) {
			int zifferLoesung = loesungKopie % 10;
			if (!richtig[i] && ziffern[zifferLoesung] > 0) {
				ziffern[zifferLoesung]--;
				bewertung++;
			}
			loesungKopie = loesungKopie / 10;
		}
		return bewertung;
	}

	/**
	 * Pr&uuml;ft, ob der zuletzt abgegebene Versuch erfolgreich war.
	 * 
	 * @return
	 * 		<ul>
	 *         <li>{@code true}, falls der zuletzt abgegebene Versuch
	 *         erfolgreich war</li>
	 *         <li>{@code false}, falls der zuletzt abgegebene Versuche nicht
	 *         erfolgreich war</li>
	 *         <li>{@code false}, falls noch gar keine Versuche gab, weil das
	 *         Spiel soeben erst gestartet wurde</li>
	 *         </ul>
	 */
	public boolean spielGewonnen() {
		return (aktuellerVersuch > 0) && (versuche[aktuellerVersuch - 1] == loesung);
	}

	/**
	 * Pr&uuml;ft, ob die maximale Anzahl an Versuchen erreicht wurde und der
	 * letzte Versuch nicht korrekt war..
	 * 
	 * @return {@code true}, falls das Spiel verloren ist
	 */
	public boolean spielVerloren() {
		return (aktuellerVersuch == maxVersuche) && !spielGewonnen();
	}

	/**
	 * L&auml;sst sich jederzeit wieder von vorn beginnen, d.h. alle Versuche
	 * werden gel&ouml;scht und es wird ein neuer Zufallscode erzeugt.
	 */
	public void spielZuruecksetzen() {
		versuche = new int[maxVersuche];
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
			loesung += Math.pow(10, i) * zufallsZahl(farbAnzahl);
		}
		return loesung;
	}

	/**
	 * Liefert eine Zufallszahl im Intervall {@code [1 ; max]}.
	 * 
	 * @param max
	 *            obere Grenze (inklusiv)
	 * @return Zufallszahl
	 */
	private int zufallsZahl(int max) {
		return (int) (Math.random() * max) + 1;
	}

}
