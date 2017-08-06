package applications.hangman;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Mohamed Mashaal.
 *
 */
public class UI {
  /**
   * the constant.
   */
  private static final int MAX_GUESS = 10;

  /**
   * @param args
   *          the usual param for main.
   * @throws FileNotFoundException
   *           in case of file not found .
   */
  public static void main(final String[] args)
      throws FileNotFoundException {
    boolean flag = false, flag2 = false;
    final Hangman z = new Hangman();
    final String[] x = z.readFile();
    z.setDictionary(x);
    z.setMaxWrongGuesses(MAX_GUESS);
    z.selectRandomSecretWord();
    String fin;
    System.out.println(z.temp);
    final Scanner sc = new Scanner(System.in);
    while (true) {
      System.out.println("Enter Your guess");
      final char c = sc.nextLine().charAt(0);
      fin = z.guess(c);
      System.out.println(z.thesWord);
      if (fin == null) {
        flag = true;
        break;
      }
      if (fin.equals(z.thehWord)) {
        flag2 = true;
        break;
      }
    }
    sc.close();
    if (flag) {
      System.out.println(z.thesWord);
      System.out.println("You win");
    }
    if (flag2) {
      System.out.println("Exceeded Number ot Tries");
      System.out.println("You Lose");
    }

  }
}
