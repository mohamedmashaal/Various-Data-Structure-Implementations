package applications.iceHockeyPlayerFinder;

import java.awt.Point;

import applications.IPlayersFinder;

/**
 * @author Mohamed Mashaal.
 *
 */
public class IceHockey implements IPlayersFinder {
  /**
   * the constants used.
   */
  private static final int CHAR_C = 48, NUM4 = 4, MAX_N = 100;
  /**
   * the counters used.
   */
  private int counter = 0, xR = 0, xL = 0, yU = 0, yD = 0;
  /**
   * the array visited used.
   */
  private int[][] visited;

  @Override
  public Point[] findPlayers(final String[] photo,
      final int team,
      final int threshold) {
    // TODO Auto-generated method
    // stub
    int pCounter = 0;
    final int m = photo.length, n = photo[0].length();
    final char[][] theArray = new char[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        theArray[i][j] = photo[i].charAt(j);
      }
    }
    visited = new int[m][n];
    arrayInitiliaze(visited, m, n);
    final Point[] points = new Point[MAX_N];
    for (int index = 0; index < points.length; index++) {
      points[index] = new Point(0, 0);
    }
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (visited[i][j] == 1) {
          continue;
        }
        if (theArray[i][j] != (char) (team + CHAR_C)) {
          continue;
        }
        counter++;
        visited[i][j] = 1;
        xR = j;
        xL = j;
        yU = i;
        yD = i;
        checkSpot(i, j, team, theArray, m, n);
        if (((counter * NUM4) / threshold) >= 1) {
          points[pCounter].x = xR + xL + 1;
          points[pCounter].y = yU + yD + 1;
          pCounter++;
        }
        resetCounters();

      }
    }
    final Point[] finals = new Point[pCounter];
    for (int i = 0; i < finals.length; i++) {
      finals[i] = new Point(0, 0);
    }

    for (int i = 0; i < pCounter; i++) {
      finals[i] = points[i];
    }
    sort(finals);
    return finals;
  }

  /**
   * @param finals
   *          "the sorted one ".
   */
  public void sort(final Point[] finals) {
    Point temp = new Point();
    for (int i = 0; i < finals.length; i++) {
      for (int j = 0; j < finals.length - 1 - i; j++) {
        if (finals[j].x >= finals[j + 1].x) {
          if (finals[j].x == finals[j + 1].x) {
            if (finals[j].y > finals[j + 1].y) {
              temp = finals[j + 1];
              finals[j + 1] = finals[j];
              finals[j] = temp;
            }
          } else {
            temp = finals[j + 1];
            finals[j + 1] = finals[j];
            finals[j] = temp;
          }
        }
      }
    }
  }

  /**
   * @param array
   *          the array to initialize.
   * @param m
   *          the first dim.
   * @param n
   *          the second dim.
   */
  public void arrayInitiliaze(final int[][] array,
      final int m,
      final int n) {
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        array[i][j] = 0;
      }
    }
  }

  /**
   * resetingCounter.
   */
  public void resetCounters() {
    counter = 0;
    xR = 0;
    xL = 0;
    yU = 0;
    yD = 0;
  }

  /**
   * @param x
   *          the coordinate.
   * @param y
   *          the coordinate.
   * @param team
   *          the team number.
   * @param thearray
   *          the array working on.
   * @param m
   *          the dim.
   * @param n
   *          the dim.
   */
  public void checkSpot(final int x,
      final int y,
      final int team,
      final char[][] thearray,
      final int m,
      final int n) {
    for (int i = x - 1; i <= x + 1; i++) {
      for (int j = y - 1; j <= y + 1; j++) {
        if (i < 0 | j < 0 | i >= m | j >= n) {
          continue;
        }
        if ((i == x - 1) & (j == y - 1)) {
          continue;
        }
        if ((i == x - 1) & (j == y + 1)) {
          continue;
        }
        if ((i == x + 1) & (j == y - 1)) {
          continue;
        }
        if ((i == x + 1) & (j == y + 1)) {
          continue;
        }
        if (visited[i][j] == 1) {
          continue;
        }
        if (thearray[i][j] == (char) (team + CHAR_C)) {
          counter++;
          visited[i][j] = 1;
          if (j < xR) {
            xR = j;
          }
          if (j > xL) {
            xL = j;
          }
          if (i > yU) {
            yU = i;
          }
          if (i < yD) {
            yD = i;
          }
          checkSpot(i, j, team, thearray, m, n);
        }
      }
    }
  }
}
