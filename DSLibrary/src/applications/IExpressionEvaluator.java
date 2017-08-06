package applications;

public interface IExpressionEvaluator {
  /**
   * Takes a symbolic/numeric infix expression as input and converts
   * it to postfix notation. There is no assumption on spaces
   * between terms or the length of the term (e.g., two digits
   * symbolic or numeric term)
   *
   * @param expression
   *          infix expression
   * @return postfix expression
   */
  public String infixToPostfix(String expression);

  /**
   * Evaluate a postfix numeric expression, with a single space
   * separator.
   *
   * @param expression
   *          postfix expression
   * @return the expression evaluated value
   */
  public int evaluate(String expression);
}