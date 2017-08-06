package applications.experssionEvaluator;

import java.util.Scanner;

import applications.IExpressionEvaluator;
import ds.stack.Stack;

/**
 * @author Mohamed Mashaal.
 *
 */
public class ExpressionEvaluator implements IExpressionEvaluator {
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
  @Override
  public String infixToPostfix(final String expression) {
    final StringBuffer t = new StringBuffer();
    if (expression == null || expression.length() == 0) {
      throw new RuntimeException("Error");
    }
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) == ' ') {
        continue;
      }
      t.append(expression.charAt(i));
    }
    if (t.charAt(0) == ')' || t.charAt(0) == '-'
        || t.charAt(0) == '+'
        || t.charAt(0) == '*'
        || t.charAt(0) == '/'
        || t.charAt(0) == '!') {
      throw new RuntimeException("Error");
    }
    for (int i = 0; i < t.length() - 1; i++) {
      if ((t.charAt(i) == '+' || t.charAt(i) == '*'
          || t.charAt(i) == '/'
          || t.charAt(i) == '-') && (t.charAt(i + 1) == '+' || t.charAt(i
              + 1) == '/'
              || t.charAt(i + 1) == '*'
              || t.charAt(i + 1) == '-')) {
        throw new RuntimeException("Error");
      }
    }
    if (t.charAt(t.length() - 1) == '+' || t.charAt(t.length() - 1) == '-'
        || t.charAt(t.length() - 1) == '*'
        || t.charAt(t.length() - 1) == '/') {
      throw new RuntimeException("Error");
    }
    int counter1 = 0, counter2 = 0;
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) == ')') {
        counter1++;
      }
      if (expression.charAt(i) == '(') {
        counter2++;
      }
    }
    if (counter1 != counter2) {
      throw new RuntimeException("Error");
    }
    final Stack operators = new Stack();
    final StringBuffer infix = new StringBuffer();
    char[] x = null, temp = null, temp2 = null;
    for (int i = 0; i < expression.length(); i++) {
      if (expression.charAt(i) == ' ') {
        continue;
      }
      if (expression.charAt(i) != '+' && expression.charAt(i) != '-'
          && expression.charAt(i) != '*'
          && expression.charAt(i) != '/'
          && expression.charAt(i) != '('
          && expression.charAt(i) != ')') {
        infix.append(expression.charAt(i));
        infix.append(' ');
        continue;
      }
      if (expression.charAt(i) == '+') {
        x = new char[2]; x[0] = '+'; x[1] = '1';
      }
      if (expression.charAt(i) == '-') {
        x = new char[2]; x[0] = '-'; x[1] = '1';
      }
      if (expression.charAt(i) == '*') {
        x = new char[2]; x[0] = '*'; x[1] = '2';
      }
      if (expression.charAt(i) == '/') {
        x = new char[2]; x[0] = '/'; x[1] = '2';
      }
      if (expression.charAt(i) == '(') {
        x = new char[2]; x[0] = '('; x[1] = '3';
      }
      if (expression.charAt(i) == ')') {
        x = new char[2]; x[0] = ')'; x[1] = '3';
      }
      if (operators.size() == 0) {
        operators.push(x);
      } else {
        temp = (char[]) operators.peek();
        if (x[1] > temp[1] || temp[0] == '(' || x[0] == '(') {
          if (x[0] == ')') {
            while (true) {
              temp2 = (char[]) operators.peek();
              if (temp2[0] == '(') {
                operators.pop(); break;
              }
              if (temp2[0] != ')') {
                infix.append(temp2[0]); infix.append(' ');
              }
              operators.pop();
            }
          }
          operators.push(x);
        } else if (x[1] <= temp[1]) {
          if (x[0] == ')') {
            while (true) {
              temp2 = (char[]) operators.peek();
              if (temp2[0] == '(') {
                operators.pop(); break;
              }
              if (temp2[0] != ')') {
                infix.append(temp2[0]); infix.append(' ');
              }
              operators.pop();
            }
          } else {
            while (true) {
              if (operators.size() == 0) {
                break;
              }
              temp2 = (char[]) operators.peek();
              if (temp2[0] == '(') {
                operators.push(x); break;
              }
              if (x[1] <= temp2[1]) {
                if (temp2[0] != ')') {
                  infix.append(temp2[0]); infix.append(' ');
                }
                operators.pop();
                if (operators.size() == 0) {
                  operators.push(x); break;
                }
              } else {
                operators.push(x);
              }
            }
          }
        }
      }
    }
    final int counter = operators.size();
    for (int i = 0; i < counter; i++) {
      temp2 = (char[]) operators.pop();
      infix.append(temp2[0]);
      infix.append(' ');
    }
    infix.deleteCharAt(infix.length() - 1);
    return infix.toString();
  }

  /*
   * (non-Javadoc)
   *
   * @see eg.edu.alexu.csd.datastructure.
   * stack.IExpressionEvaluator# evaluate(java. lang.String)
   */
  @Override
  public int evaluate(final String expression) {
    if (expression == null || expression.length() == 0) {
      throw new RuntimeException("Error");
    }
    if (expression.charAt(0) == '-' || expression.charAt(0) == '+'
        || expression.charAt(0) == '/'
        || expression.charAt(0) == '*') {
      throw new RuntimeException("Error");
    }
    final Scanner sc = new Scanner(expression);
    String temp;
    final Stack z = new Stack();
    while (sc.hasNext()) {
      int a, b, c;
      temp = sc.next();
      if (temp.equals("+")) {
        if (z.size() == 0) {
          throw new RuntimeException("Error");
        }
        a = (int) z.pop();
        if (z.size() == 0) {
          throw new RuntimeException("Error");
        }
        b = (int) z.pop();
        c = a + b;
        z.push(c);
      } else if (temp.equals("*")) {
        if (z.size() == 0) {
          throw new RuntimeException("Error");
        }
        a = (int) z.pop();
        if (z.size() == 0) {
          throw new RuntimeException("Error");
        }
        b = (int) z.pop();
        c = a * b;
        z.push(c);
      } else if (temp.equals("/")) {
        if (z.size() == 0) {
          throw new RuntimeException("Error");
        }
        a = (int) z.pop();
        if (z.size() == 0) {
          throw new RuntimeException("Error");
        }
        b = (int) z.pop();
        c = b / a;
        z.push(c);
      } else if (temp.equals("-")) {
        if (z.size() == 0) {
          throw new RuntimeException("Error");
        }
        a = (int) z.pop();
        if (z.size() == 0) {
          throw new RuntimeException("Error");
        }
        b = (int) z.pop();
        c = b - a;
        z.push(c);
      } else {
        z.push(Integer.parseInt(temp));
      }
    }
    if (z.size() > 1) {
      return 0;
    }
    return (int) z.peek();
  }
}
