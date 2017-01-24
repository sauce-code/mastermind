package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hilfeklasse zum Einlesen von Zeichenketten und Zahlen von der Konsole.
 * 
 * @author pape
 */
public class Eingabe {

	/**
	 * Reader, wird zum Einlesen aus der Systemkonsole verwendet.
	 */
	private BufferedReader konsole = new BufferedReader(new InputStreamReader(System.in));

	/**
	 * Gibt die n&auml;chste Eingabezeile als String zur&uuml;ck.
	 * 
	 * @return
	 * 		<ul>
	 *         <li>eingelesener String</li>
	 *         <li>{@code "\n"}, falls ein Fehler auftrat</li>
	 *         </ul>
	 */
	public String leseZeile() {
		try {
			return konsole.readLine();
		} catch (IOException e) {
			return "\n";
		}
	}

	/**
	 * Gibt die n&auml;chste Eingabezeile als int-Wert zur&uuml;ck. Es werden
	 * nur die ersten Ziffern inklusive Vorzeichen ber&uuml;cksichtigt.
	 * 
	 * @return
	 * 		<ul>
	 *         <li>n&auml;chste Eingabezeile als int-Wert</li>
	 *         <li>{@code 0}, falls Eingabe ung&uuml;tig oder sonstiger Fehler
	 *         </li>
	 *         </ul>
	 */
	public int leseInt() {
		return konvertiereInt(leseZeile());
	}

	/**
	 * Konvertiert {@code zahl} in einen int-Wert.
	 * 
	 * @param zahl
	 *            Zahl, welche gewandelt werden soll
	 * @return
	 * 		<ul>
	 *         <li>{@code zahl} als int-Wert</li>
	 *         <li>{@code 0}, falls {@code zahl} nicht wandelbar</li>
	 *         </ul>
	 */
	private int konvertiereInt(String zahl) {
		try {
			return Integer.parseInt(zahl);
		} catch (NumberFormatException e) {
			return 0;
		}
	}

}
