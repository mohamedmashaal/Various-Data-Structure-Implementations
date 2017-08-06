package applications.iceHockeyPlayerFinder;

import java.awt.Point;

/**
 * @author Mohamed Mashaal.
 *
 */
public class UI {
  /**
   * @param args the usual param for main.
   */
  public static void main(final String[] args) {
    final IceHockey test = new IceHockey();
    final String[] array = {"11111", "1AAA1", "1A1A1", "1AAA1", "11111" };
    final Point[] m = test.findPlayers(array, 1, 3);
    for (int i = 0; i < m.length; i++) {
      System.out.print(m[i].getLocation());
      System.out.println();
    }
  }
}
