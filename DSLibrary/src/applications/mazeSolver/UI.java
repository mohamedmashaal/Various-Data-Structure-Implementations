package applications.mazeSolver;

import java.io.File;

/**
 * @author Mohamed Mashaal
 *
 */
public class UI {
  /**
   * @param args the usual.
   */
  public static void main(final String[] args) {
    final MazeSolver x = new MazeSolver();
    final File maze = new File("C:\\maze.txt");
    int[][] temp = x.solveBFS(maze);
    for (int i = 0; i < temp.length; i++) {
      System.out.println(temp[i][0] + " " + temp[i][1]);
    }
    System.out.println("------------");
    temp = x.solveDFS(maze);
    for (int i = 0; i < temp.length; i++) {
      System.out.println(temp[i][0] + " " + temp[i][1]);
      }
  }
}
