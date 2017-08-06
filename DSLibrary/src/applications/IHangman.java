package applications;

/**
 * @author Mohamed Mashaal.
 *
 */
public interface IHangman {
  /**
   * Set dictinary words to pick. secret words from
   *
   * @param words
   *          an array of words
   */
  void setDictionary(String[] words);

  /**
   * Pick a random secret word from. dictionary and reutns it
   *
   * @return secret word
   */
  String selectRandomSecretWord();

  /**
   * Receive a new user guess, and verify it against the secret
   * word.
   *
   * @param c
   *          case insensitive user guess. If c is NULL then
   *          ignore it and do no change
   * @return secret word with hidden characters (use ’-’ instead
   *         unsolved characters), or return NULL if user reached
   *         max wrong guesses
   */
  String guess(Character c);

  /**
   * Set the maximum number of wrong guesses
   *
   * @param max
   *          maximum number of wrong guesses, If is NULL, then
   *          assume it 0
   */
  void setMaxWrongGuesses(Integer max);
}
