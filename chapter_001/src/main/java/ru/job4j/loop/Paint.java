package ru.job4j.loop;

/**
* Class Loop - Циклы.
* @author alekseev
* @since 1.0
*/

public class Paint {
	/**
	* Формирование псевдографического изображения пирамиды.
	* @param h высота пирамиды
	* @return рисунок пирамиды высотой h
	*/
	public String piramid(int h) {
		int base = 2 * h - 1;
		StringBuilder stringbuilder = new StringBuilder();

		for (int i = 0; i < h; i++) {
			for (int j = 0; j < base; j++) {
				int symbolNumber = 2 * i + 1;
				int startSymb = (base - symbolNumber) / 2;
				int endSymb = (base + symbolNumber) / 2 - 1;

				if ((startSymb <= j) && (j <= endSymb)) {
					stringbuilder.append('^');
				} else {
					stringbuilder.append(' ');
					}
			}
			stringbuilder.append(System.getProperty("line.separator"));
		}
		return stringbuilder.toString();
	}
}
