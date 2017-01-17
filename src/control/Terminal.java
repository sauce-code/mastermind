package control;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Hilfs-Klasse zum Einlesen von Zahlen von der Konsole.
 * 
 * @author ich
 *
 */
public class Terminal {

	/**
	 * Liest eine Zahl aus der Konsole ein und liefert sie.
	 * 
	 * @return eingelesene Zahl aus der Konsole
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
