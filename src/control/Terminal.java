package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Hilfs-Klasse zum Einlesen von zahlen von der Konsole.
 * 
 * @author ich
 *
 */
public class Terminal {

	/**
	 * Liest eine Zahl aus der Konsole ein und liefert sie.
	 * 
	 * @return eingelesene zahl aus der Konsole
	 */
	public static int readInt() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			return Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			return -1;
		} catch (IOException e) {
			e.printStackTrace();
			return -1;
		}
	}
}