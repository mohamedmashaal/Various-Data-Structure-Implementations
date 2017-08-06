package applications.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import applications.IHangman;

/**
 * @author Mohamed Mashaal
 *
 */
public class Hangman implements IHangman {
  /**
   * THE string container for the dic.
   */
  private String[] word;
  /**
   * the random one.
   */
  private final Random secretWord = new Random();
  /**
   * the word shown.
   */
  public String thehWord;
  /**
   * the secret one .
   */
  public String thesWord;
  /**
   * the max num of gusses.
   */
  private int maxN = 0;
  /**
   * the num of guesses done .
   */
  private int numofG = 0;
  /**
   * the buffer used to build the string.
   */
  public StringBuffer temp;

  @Override
  public void setDictionary(final String[] words) {
    word = words;
  }

  @Override
  public String selectRandomSecretWord() {
    // TODO Auto-generated method
    // stub
    if (word != null) {
      thehWord = word[secretWord.nextInt(word.length)];
      temp = new StringBuffer(thehWord);
      for (int i = 0; i < thehWord.length(); i++) {
        temp.setCharAt(i, '-');
      }
      return (thehWord);
    }
    return null;
  }

  @Override
  public String guess(final Character c) {
    // TODO Auto-generated method
    // stub
    int flag = -1;
    if (numofG == maxN) {
      return null;
    }
    thesWord = temp.toString();
    for (int i = 0; i < thehWord.length(); i++) {
      if (Character.toLowerCase(c) == thehWord.toLowerCase().charAt(i)) {
        temp.setCharAt(i, thehWord.charAt(i));
        flag = 1;
      }
    }
    if (flag == 1) {
      thesWord = temp.toString();
      return thesWord;
    }
    numofG++;
    if (numofG == maxN) {
      return null;
    }
    return thesWord;
  }

  @Override
  public void setMaxWrongGuesses(final Integer max) {
    // TODO Auto-generated method
    // stub
    maxN = max;

  }

  /**
   * @return "a file with the table of words .
   * @throws FileNotFoundException
   *           in case of file not found.
   */
  public String[] readFile() throws FileNotFoundException {
    final Scanner sc = new Scanner(new File("Dic.txt"));
    final List<String> lines = new ArrayList<String>();
    while (sc.hasNextLine()) {
      lines.add(sc.nextLine());
    }

    final String[] dicTable = lines.toArray(new String[0]);
    sc.close();
    return dicTable;
  }
}
