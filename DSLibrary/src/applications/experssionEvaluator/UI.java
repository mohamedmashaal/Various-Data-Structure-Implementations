package applications.experssionEvaluator;

import java.util.Scanner;

import ds.stack.Stack;

/**
 * @author Mohamed Mashaal.
 *
 */
public class UI {
  /**
   * the constants.
   */
  private static final int NUM1 = 1, NUM2 = 2, NUM3 = 3, NUM4 = 4;
  /**
   * the constants.
   */
  private final static int NUM5 = 5, NUM6 = 6, NUM7 = 7, NUM8 = 8;

  /**
   * @param args
   *          "the usual param for main" .
   */
  public static void main(final String[] args) {
    final Stack stc = new Stack();
    final ExpressionEvaluator exp = new ExpressionEvaluator();
    final Scanner sc = new Scanner(System.in);
    boolean flag = true;
    int tempInput = 0;
    Object temp;
    System.out.println("<<<<--------------->>>>");
    System.out.println("Please choose an action");
    System.out.println("-----------------------");
    System.out.println("1 - Stack Push");
    System.out.println("2 - Stack Pop");
    System.out.println("3 - Stack Peek");
    System.out.println("4 - Stack Get Size");
    System.out.println("5 - Stack Check is Empty");
    System.out.println("6 - Infix to Postfix Notations");
    System.out.println("7 - Evaluating Postfix Experessions");
    System.out.println("8 - Close the Program");
    System.out.println(
        "=====================================================");
    while (flag) {
      System.out.println("\nEnter A Command Number !!");
      tempInput = sc.nextInt();
      sc.nextLine();
      if (tempInput == NUM1) {
        System.out.println("Insert the Element");
        temp = sc.nextLine();
        stc.push(temp);
      } else if (tempInput == NUM2) {
        System.out.println("Element Poped : " + stc.pop().toString());
      } else if (tempInput == NUM3) {
        System.out.println("Element Peeked : " + stc.peek().toString());
      } else if (tempInput == NUM4) {
        System.out.println("Stack Size : " + stc.size());
      } else if (tempInput == NUM5) {
        System.out.println("Stack Empty Condition : " + stc.isEmpty());
      } else if (tempInput == NUM6) {
        System.out.println("Enter the Infix Expression : ");
        final String x = sc.nextLine();
        System.out.println("Postfix Expression  : " + exp.infixToPostfix(
            x));
      } else if (tempInput == NUM7) {
        System.out.println("Enter the Postfix Expression to Evalute : ");
        final String x = sc.nextLine();
        System.out.println("Value = " + exp.evaluate(x));
      } else if (tempInput == NUM8) {
        flag = false;
      } else {
        System.out.println("Wrong input .");
      }
    }
    sc.close();
    System.out.println("Bye Bye :D");
    System.out.println("<-------->");
  }
}
