package control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Hilfsklasse zum Einlesen von Zahlen von der Konsole.
 * 
 * @author ich
 *
 */
public class Terminal {

	/**
	 * Liest eine Zahl aus der Konsole ein und liefert sie.
	 * 
	 * @return
	 * 		<ul>
	 *         <li>eingelesene Zahl aus der Konsole</li>
	 *         <li>{@code -1}, falls Eingabe ung&uuml;ltig oder sonstige Fehler
	 *         auftreten</li>
	 *         </ul>
	 */
	public static int readInt() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return Integer.parseInt(br.readLine());
		} catch (Exception e) {
			return -1;
		}
	}

}
