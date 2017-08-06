package applications.mazeSolver;

import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import applications.IMazeSolver;
import ds.queue.QueueLL;
import ds.stack.Stack;

/**
 * @author Mohamed Mashaal.
 *
 */
public class MazeSolver implements IMazeSolver {
  /**
   * MAX_SIZE.
   */
  private static final int MAX_A_SIZE = 10000;
  /**
   * NUM_2.
   */
  private static final int NUM_2 = 2;

  /**
   * (non-Javadoc).
   * @see.
   * eg.edu.alexu.csd.datastructure.maze.IMazeSolver#solveBFS(java.io.File).
   */
  @Override
  public int[][] solveBFS(final File maze) {
    // TODO Auto-generated method
    // stub
    int n = 0, m = 0;
    char[][] theM = null;
    try {
      final Scanner sc = new Scanner(maze);
      n = sc.nextInt();
      m = sc.nextInt();
      theM = new char[n][m];
      for (int i = 0; i < n; i++) {
        final String temp = sc.next();
        for (int j = 0; j < m; j++) {
          theM[i][j] = temp.charAt(j);
        }
      }
      sc.close();
    } catch (final FileNotFoundException e) {
      // TODO Auto-generated catch
      // block
      e.printStackTrace();
    }
    final boolean[][] visited = new boolean[n][m];
    boolean endReached = false;
    boolean noExit = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (theM[i][j] == 'E') {
          noExit = true;
          break;
        }
      }
    }
    if (!noExit) {
      throw new RuntimeException("Error");
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        visited[i][j] = false;
      }
    }
    Object[] temp = null;
    Point t = null;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (theM[i][j] == 'S') {
          t = new Point(i, j);
          break;
        }
      }
    }
    temp = new Object[NUM_2];
    temp[0] = t;
    final QueueLL que = new QueueLL();
    que.enqueue(temp);
    while (!que.isEmpty()) {
      temp = (Object[]) que.dequeue();
      final Point p = (Point) temp[0];
      final int x = p.x;
      final int y = p.y;
      visited[x][y] = true;
      if (theM[x][y] == 'E') {
        endReached = true;
        break;
      }
      for (int j = y - 1; j <= y + 1; j++) {
        for (int i = x - 1; i <= x + 1; i++) {
          if (i < 0 | j < 0 | i >= n | j >= m) {
            continue;
          }
          if ((i == x - 1) & (j == y + 1)) {
            continue;
          }
          if ((i == x - 1) & (j == y - 1)) {
            continue;
          }
          if ((i == x + 1) & (j == y - 1)) {
            continue;
          }
          if ((i == x + 1) & (j == y + 1)) {
            continue;
          }
          if (visited[i][j]) {
            continue;
          }
          if (theM[i][j] == '#') {
            continue;
          }
          final Object[] te = new Object[NUM_2];
          te[0] = new Point(i, j);
          te[1] = temp;
          que.enqueue(te);
        }
      }
    }
    if (endReached) {
      final int[][] bresult = new int[MAX_A_SIZE][NUM_2];
      int rCounter = 0;
      while (temp[1] != null) {
        final Point p = (Point) temp[0];
        bresult[rCounter][0] = p.x;
        bresult[rCounter][1] = p.y;
        temp = (Object[]) temp[1];
        rCounter++;
      }
      final Point p = (Point) temp[0];
      bresult[rCounter][0] = p.x;
      bresult[rCounter][1] = p.y;
      final int[][] fResult = new int[rCounter + 1][NUM_2];
      for (int i = rCounter; i >= 0; i--) {
        fResult[rCounter - i][0] = bresult[i][0];
        fResult[rCounter - i][1] = bresult[i][1];
      }
      return fResult;
    }
    return null;
  }

  /**
   * (non-Javadoc).
   * @see eg.edu.alexu.csd.datastructure.
   *      maze.IMazeSolver#solveDFS(java.io .File).
   */
  @Override
  public int[][] solveDFS(final File maze) {
    // TODO Auto-generated method
    // stub
    int n = 0, m = 0;
    char[][] theM = null;
    try {
      final Scanner sc = new Scanner(maze);
      n = sc.nextInt();
      m = sc.nextInt();
      theM = new char[n][m];
      for (int i = 0; i < n; i++) {
        final String temp = sc.next();
        for (int j = 0; j < m; j++) {
          theM[i][j] = temp.charAt(j);
        }
      }
      sc.close();
    } catch (final FileNotFoundException e) {
      // TODO Auto-generated catch
      // block
      e.printStackTrace();
    }
    final boolean[][] visited = new boolean[n][m];
    boolean endReached = false;
    boolean noExit = false;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (theM[i][j] == 'E') {
          noExit = true;
          break;
        }
      }
    }
    if (!noExit) {
      throw new RuntimeException("Error");
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        visited[i][j] = false;
      }
    }
    Object[] temp = null;
    Point t = null;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (theM[i][j] == 'S') {
          t = new Point(i, j);
          break;
        }
      }
    }
    temp = new Object[NUM_2];
    temp[0] = t;
    final Stack stc = new Stack();
    stc.push(temp);
    while (!stc.isEmpty()) {
      temp = (Object[]) stc.pop();
      final Point p = (Point) temp[0];
      final int x = p.x;
      final int y = p.y;
      visited[x][y] = true;
      if (theM[x][y] == 'E') {
        endReached = true;
        break;
      }
      for (int j = y - 1; j <= y + 1; j++) {
        for (int i = x - 1; i <= x + 1; i++) {
          if (i < 0 | j < 0 | i >= n | j >= m) {
            continue;
          }
          if ((i == x - 1) & (j == y + 1)) {
            continue;
          }
          if ((i == x - 1) & (j == y - 1)) {
            continue;
          }
          if ((i == x + 1) & (j == y - 1)) {
            continue;
          }
          if ((i == x + 1) & (j == y + 1)) {
            continue;
          }
          if (visited[i][j]) {
            continue;
          }
          if (theM[i][j] == '#') {
            continue;
          }
          final Object[] te = new Object[NUM_2];
          te[0] = new Point(i, j);
          te[1] = temp;
          stc.push(te);
        }
      }
    }
    if (endReached) {
      final int[][] bresult = new int[MAX_A_SIZE][NUM_2];
      int rCounter = 0;
      while (temp[1] != null) {
        final Point p = (Point) temp[0];
        bresult[rCounter][0] = p.x;
        bresult[rCounter][1] = p.y;
        temp = (Object[]) temp[1];
        rCounter++;
      }
      final Point p = (Point) temp[0];
      bresult[rCounter][0] = p.x;
      bresult[rCounter][1] = p.y;
      final int[][] fResult = new int[rCounter + 1][NUM_2];
      for (int i = rCounter; i >= 0; i--) {
        fResult[rCounter - i][0] = bresult[i][0];
        fResult[rCounter - i][1] = bresult[i][1];
      }
      return fResult;
    }
    return null;
  }

}
