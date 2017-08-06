package applications.polySolver;

import java.util.Scanner;

/**
 * @author Mohamed Mashaal.
 *
 */
public class UI {
  /**
   * the constants used.
   */
  private static final int MAX_N = 1000;
  /**
   * the constants used.
   */
  private static final int NUM3 = 3, NUM4 = 4, NUM5 = 5;
  /**
   * the constants used.
   */
  private static final int NUM6 = 6, NUM7 = 7, NUM8 = 8;

  /**
   * @param args
   *          the usual param for main.
   */
  public static void main(final String[] args) {
    boolean f = true, f2 = true, f3 = true; int tInput = 0;
    int tCounter = 0, tVal = 0; char tC = 0, tC2 = 0; String temp = null;
    String rep = "Insert the variable name : A , B or C";
    final int[][] termsTemp = new int[MAX_N][2]; int[][] terms;
    final PolynomialSolver pS = new PolynomialSolver();
    final Scanner sc = new Scanner(System.in);
    System.out.println("Please choose an action\n1- Set a polynomial variable");
    System.out.println("2-Print value of poly variable\n3- Add 2 polynomials");
    System.out.println("4- Subtract 2 polynomials\n5- Multiply 2 polynomials");
    System.out.println("6- Evaluate a polynomial at some point");
    System.out.println("7- Clear a polynomial variable\n8- Close the Program");
    while (f) {
      if (f3) {
        System.out.println("Enter Command Number !!");
        tInput = sc.nextInt(); sc.nextLine();
      }
      f3 = true;
      if (tInput == 1) {
        while (f3) {
          System.out.println(rep); temp = sc.nextLine();
          if (temp.length() == 1
              && (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
              || temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
              || temp.charAt(0) == 'C' || temp.charAt(0) == 'c')) {
            tC = temp.charAt(0); f3 = false;
          }
        } f3 = true;
        if (pS.isSet(tC)) {
          pS.clearPolynomial(tC);
        }
        System.out.println("How many terms ?");
        final int num = sc.nextInt(); sc.nextLine();
        for (int c = 0; c < num; c++) {
          System.out.println("Enter term " + c + " Coefficient");
          final int coeff = sc.nextInt();
          System.out.println("Enter term " + c + " Exponent");
          final int power = sc.nextInt();
          termsTemp[tCounter][0] = coeff; termsTemp[tCounter++][1] = power;
        } sc.nextLine(); terms = new int[tCounter + 1][2];
        for (int i = 0; i <= tCounter; i++) {
          terms[i][0] = termsTemp[i][0]; terms[i][1] = termsTemp[i][1];
        } pS.setPolynomial(tC, terms);
      } else if (tInput == 2) {
        while (f3) {
          System.out.println(rep); temp = sc.nextLine();
          if (temp.length() == 1
              && (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
              || temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
              || temp.charAt(0) == 'C' || temp.charAt(0) == 'c')) {
            tC = temp.charAt(0); f3 = false;
          }
        } f3 = true; System.out.println(pS.print(tC));
      } else if (tInput == NUM3) {
        while (f3) {
          System.out.println(rep); temp = sc.nextLine();
          if (temp.length() == 1
              && (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
              || temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
              || temp.charAt(0) == 'C' || temp.charAt(0) == 'c')) {
            tC = temp.charAt(0); f3 = false;
          }
        }
        f3 = true;
        while (f3) {
          System.out.println(rep); temp = sc.nextLine();
          if (temp.length() == 1
              && (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
              || temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
              || temp.charAt(0) == 'C' || temp.charAt(0) == 'c')) {
            tC2 = temp.charAt(0); f3 = false;
          }
        } f3 = true; pS.add(tC, tC2);
        System.out.println(pS.print('R'));
      } else if (tInput == NUM4) {
        while (f3) {
          System.out.println(rep); temp = sc.nextLine();
          if (temp.length() == 1
              && (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
              || temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
              || temp.charAt(0) == 'C' || temp.charAt(0) == 'c')) {
            tC = temp.charAt(0); f3 = false;
          }
        } f3 = true;
        while (f3) {
          System.out.println(rep); temp = sc.nextLine();
          if (temp.length() == 1
              && (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
              || temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
              || temp.charAt(0) == 'C' || temp.charAt(0) == 'c')) {
            tC2 = temp.charAt(0); f3 = false;
          }
        } f3 = true; pS.subtract(tC, tC2); System.out.println(pS.print('R'));
      } else if (tInput == NUM5) {
        while (f3) {
          System.out.println(rep); temp = sc.nextLine();
          if (temp.length() == 1
              && (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
              || temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
              || temp.charAt(0) == 'C' || temp.charAt(0) == 'c')) {
            tC = temp.charAt(0); f3 = false;
          }
        }
        f3 = true;
        while (f3) {
          System.out.println(rep); temp = sc.nextLine();
          if (temp.length() == 1
              && (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
              || temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
              || temp.charAt(0) == 'C' || temp.charAt(0) == 'c')) {
            tC2 = temp.charAt(0); f3 = false;
          }
        } f3 = true; pS.multiply(tC, tC2); System.out.println(pS.print('R'));
      } else if (tInput == NUM6) {
        while (f3) {
        System.out.println(rep); temp = sc.next();
        if (temp.length() == 1
            && (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
            || temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
            || temp.charAt(0) == 'C' || temp.charAt(0) == 'c')) {
          tC = temp.charAt(0); f3 = false;
        }
        }
        f3 = true; System.out.println("Insert the value"); tVal = sc.nextInt();
        System.out.println(pS.evaluatePolynomial(tC, tVal));
      } else if (tInput == NUM7) {
        while (f3) {
          System.out.println(rep); temp = sc.next();
          if (temp.length() == 1
              && (temp.charAt(0) == 'A' || temp.charAt(0) == 'a'
              || temp.charAt(0) == 'B' || temp.charAt(0) == 'b'
              || temp.charAt(0) == 'C' || temp.charAt(0) == 'c')) {
            tC = temp.charAt(0); f3 = false;
        }
        } f3 = true; pS.clearPolynomial(tC);
      } else if (tInput == NUM8) {
        f = false;
      } else {
        while (f2) {
          System.out.println("Wrong , enter valid input : ");
          tInput = sc.nextInt(); sc.nextLine();
          if (tInput == 1 || tInput == 2 || tInput == NUM3
              || tInput == NUM4 || tInput == NUM5 || tInput == NUM6
              || tInput == NUM7 || tInput == NUM8) {
            f2 = false; f3 = false;
          }
        }
      }
    } sc.close(); System.out.println("Bye Bye :D");
  }
}
