package applications.polySolver;

import java.awt.Point;

import applications.IPolynomialSolver;
import ds.singleLinkedList.SLNode;
import ds.singleLinkedList.SingleLinkedList;

/**
 * @author Mohamed Mashaal.
 *
 */
public class PolynomialSolver implements IPolynomialSolver {
  /**
   * the constant used.
   */
  private static final int MAX_N = 10000;
  /**
   * the linked list representing A.
   */
  private SingleLinkedList listA = new SingleLinkedList();
  /**
   * the linked list representing B.
   */
  private SingleLinkedList listB = new SingleLinkedList();
  /**
   * the linked list representing C.
   */
  private SingleLinkedList listC = new SingleLinkedList();
  /**
   * the linked list representing R.
   */
  private SingleLinkedList listR = new SingleLinkedList();

  @Override
  public void setPolynomial(final char poly, final int[][] terms) {
    // TODO Auto-generated method
    // stub

    final int length = terms.length;

    if (poly != 'A' && poly != 'B'
        && poly != 'C'
        && poly != 'R'
        && poly != 'a'
        && poly != 'b'
        && poly != 'c'
        && poly != 'r') {
      throw new RuntimeException();
    }
    if (length == 0 || terms == null) {
      throw new RuntimeException("error");
    }
    final int maxTerm = terms[0][1];
    if (maxTerm < 0) {
      throw new RuntimeException("error");
    }

    int found = 0;
    for (int k = 1; k < length; k++) {
      if (terms[k][1] > maxTerm) {
        found = 1;
      }
      if (terms[k][1] < 0) {
        found = 1;
      }
    }

    if (found == 1) {
      throw new RuntimeException("wrong poly");
    }

    Point x;
    SingleLinkedList listX = null;
    if (poly == 'A' || poly == 'a') {
      listX = listA;
    }
    if (poly == 'B' || poly == 'b') {
      listX = listB;
    }
    if (poly == 'C' || poly == 'c') {
      listX = listC;
    }
    if (poly == 'R' || poly == 'r') {
      listX = listR;
    }
    if (listX != null) {
      for (int i = 0; i < terms.length; i++) {
        x = new Point(terms[i][0], terms[i][1]);
        listX.add(x);
      }
    }
  }

  @Override
  public String print(final char poly) {
    // TODO Auto-generated method
    // stub
    Point x;
    final StringBuffer st = new StringBuffer();
    SingleLinkedList listX = null;
    if (poly == 'A' || poly == 'a') {
      listX = listA;
    } else if (poly == 'B' || poly == 'b') {
      listX = listB;
    } else if (poly == 'C' || poly == 'c') {
      listX = listC;
    } else if (poly == 'R' || poly == 'r') {
      listX = listR;
    } else {
      throw new RuntimeException("error");
    }
    if (listX.size() == 0) {
      return null;
    }
    if (listX != null) {
      for (int i = 0; i < listX.size(); i++) {
        x = (Point) listX.get(i);
        if (x.getX() == 0) {
          continue;
        }
        if (st.length() == 0) {
          if (x.getX() < 0) {
            st.append('-');
            if (x.getX() < -1) {
              st.append((int) Math.abs(x.getX()));
            } else if (x.getX() == -1 && x.getY() == 0) {
              st.append((int) Math.abs(x.getX()));
            }
          } else {
            if (x.getX() > 1) {
              st.append((int) Math.abs(x.getX()));
            } else if (x.getX() == 1 && x.getY() == 0) {
              st.append((int) Math.abs(x.getX()));
            }
          }
          if (x.getY() > 0) {
            st.append('x');
            if (x.getY() > 1) {
              st.append('^');
              st.append((int) Math.abs(x.getY()));
            }
          }
        } else {
          if (x.getX() < 0) {
            st.append('-');
            if (x.getX() < -1) {
              st.append((int) Math.abs(x.getX()));
            }
            if (x.getX() == -1 && x.getY() == 0) {
              st.append((int) Math.abs(x.getX()));
            }
          } else {
            st.append('+');
            if (x.getX() > 1) {
              st.append((int) Math.abs(x.getX()));
            }
            if (x.getX() == 1 && x.getY() == 0) {
              st.append((int) Math.abs(x.getX()));
            }
          }
          if (x.getY() > 0) {
            st.append('x');
            if (x.getY() > 1) {
              st.append('^');
              st.append((int) Math.abs(x.getY()));
            }
          }
        }
      }
    }
    return st.toString();
  }

  @Override
  public void clearPolynomial(final char poly) {
    // TODO Auto-generated method
    // stub

    if (poly == 'A' || poly == 'a') {
      if (listA.isEmpty()) {
        throw new RuntimeException();
      }
    } else if (poly == 'B' || poly == 'b') {
      if (listB.isEmpty()) {
        throw new RuntimeException();
      }
    } else if (poly == 'C' || poly == 'c') {
      if (listC.isEmpty()) {
        throw new RuntimeException();
      }
    } else if (poly == 'R' || poly == 'r') {
      if (listR.isEmpty()) {
        throw new RuntimeException();
      }
    } else if (poly != 'A' && poly != 'B'
        && poly != 'C'
        && poly != 'R'
        && poly != 'a'
        && poly != 'b'
        && poly != 'c'
        && poly != 'r') {
      throw new RuntimeException();
    }

    if (poly == 'A' || poly == 'a') {
      listA = new SingleLinkedList();
    } else if (poly == 'B' || poly == 'b') {
      listB = new SingleLinkedList();
    } else if (poly == 'C' || poly == 'c') {
      listC = new SingleLinkedList();
    } else if (poly == 'R' || poly == 'r') {
      listR = new SingleLinkedList();
    } else {
      throw new RuntimeException("error");
    }
  }

  @Override
  public float evaluatePolynomial(final char poly, final float value) {
    // TODO Auto-generated method
    // stub

    Point p;
    float res = 0;
    SingleLinkedList listX = null;
    if ((poly == 'A' || poly == 'a') && !listA.isEmpty()) {
      listX = listA;
    }
    if ((poly == 'B' || poly == 'b') && !listB.isEmpty()) {
      listX = listB;
    }
    if ((poly == 'C' || poly == 'c') && !listC.isEmpty()) {
      listX = listC;
    }

    if (listX != null) {
      SLNode curr = listX.getHead();
      for (int i = 0; i < listX.size(); i++) {
        p = ((Point) curr.getElement());
        res += p.getX() * Math.pow(value, p.getY());
        curr = curr.getNext();
      }
    } else {
      throw new RuntimeException("error");
    }

    return res;
  }

  @Override
  public int[][] add(final char poly1, final char poly2) {
    // TODO Auto-generated method
    // stub
    listR.clear();
    SLNode first = null, second = null;
    if ((poly1 == 'A' || poly1 == 'a') && !listA.isEmpty()) {
      first = listA.getHead();
    }
    if ((poly1 == 'B' || poly1 == 'b') && !listB.isEmpty()) {
      first = listB.getHead();
    }
    if ((poly1 == 'C' || poly1 == 'c') && !listC.isEmpty()) {
      first = listC.getHead();
    }
    if ((poly2 == 'A' || poly2 == 'a') && !listA.isEmpty()) {
      second = listA.getHead();
    }
    if ((poly2 == 'B' || poly2 == 'b') && !listB.isEmpty()) {
      second = listB.getHead();
    }
    if ((poly2 == 'C' || poly2 == 'c') && !listC.isEmpty()) {
      second = listC.getHead();
    }

    if (first == null || second == null) {
      throw new RuntimeException("error");
    }

    final int[][] fr = new int[MAX_N][2], sc = new int[MAX_N][2];
    int i = 0, j = 0;
    while (first != null) {
      fr[i][0] = (int) ((Point) first.getElement()).getX();
      fr[i][1] = (int) ((Point) first.getElement()).getY();
      i++;
      first = first.getNext();
    }
    while (second != null) {
      sc[j][0] = (int) ((Point) second.getElement()).getX();
      sc[j][1] = (int) ((Point) second.getElement()).getY();
      j++;
      second = second.getNext();
    }

    int[][] res = new int[MAX_N][2];
    for (int n = 0; n < i; n++) {
      res[n][0] = fr[n][0];
      res[n][1] = fr[n][1];
    }
    for (int m = 0; m < j; m++) {
      boolean flag = false;
      int n = 0;
      for (; n < i; n++) {
        if (res[n][1] == sc[m][1]) {
          flag = true;
          break;
        }
      }
      if (flag) {
        res[n][0] += sc[m][0];
      } else {
        res[i][0] = sc[m][0];
        res[i++][1] = sc[m][1];
        if (res[i - 1][0] == 0) {
          i--;
        }
      }
    }

    res = sortPoly(res);
    for (int d = 0; d < i; d++) {
      listR.add(new Point(res[d][0], res[d][1]));
    }

    final int[][] ret = new int[i][2];
    for (int f = 0; f < i; f++) {
      ret[f][0] = res[f][0];
      ret[f][1] = res[f][1];
    }

    return ret;
  }

  @Override
  public int[][] subtract(final char poly1, final char poly2) {
    // TODO Auto-generated method
    // stub
    listR.clear();
    SLNode first = null, second = null;
    if (poly1 == 'A' || poly1 == 'a') {
      first = listA.getHead();
    }
    if (poly1 == 'B' || poly1 == 'b') {
      first = listB.getHead();
    }
    if (poly1 == 'C' || poly1 == 'c') {
      first = listC.getHead();
    }
    if (poly2 == 'A' || poly2 == 'a') {
      second = listA.getHead();
    }
    if (poly2 == 'B' || poly2 == 'b') {
      second = listB.getHead();
    }
    if (poly2 == 'C' || poly2 == 'c') {
      second = listC.getHead();
    }

    if (first == null || second == null) {
      throw new RuntimeException("error");
    }
    if (first == second) {
      int length = 0;
      if (poly1 == 'A' || poly1 == 'a') {
        length = listA.size();
      }
      if (poly1 == 'B' || poly1 == 'b') {
        length = listA.size();
      }
      if (poly1 == 'C' || poly1 == 'c') {
        length = listA.size();
      }
      final int[][] ress = new int[length][2];
      for (int i = 0; i < length; i++) {
        for (int j = 0; j < 2; j++) {
          ress[i][j] = 0;
        }
      }
      return ress;
    }
    final int[][] fr = new int[MAX_N][2], sc = new int[MAX_N][2];
    int i = 0, j = 0;
    while (first != null) {
      fr[i][0] = (int) ((Point) first.getElement()).getX();
      fr[i][1] = (int) ((Point) first.getElement()).getY();
      i++;
      first = first.getNext();
    }
    while (second != null) {
      sc[j][0] = (int) ((Point) second.getElement()).getX();
      sc[j][1] = (int) ((Point) second.getElement()).getY();
      j++;
      second = second.getNext();
    }

    int[][] res = new int[MAX_N][2];
    // add first
    for (int n = 0; n < i; n++) {
      res[n][0] = fr[n][0];
      res[n][1] = fr[n][1];
    }
    // subtract second
    for (int m = 0; m < j; m++) {
      boolean flag = false;
      int n = 0;
      for (; n < i; n++) {
        if (res[n][1] == sc[m][1]) {
          flag = true;
          break;
        }
      }
      if (flag) {
        res[n][0] -= sc[m][0];
      } else {
        res[i][0] -= sc[m][0];
        res[i++][1] = sc[m][1];
      }
    }

    res = sortPoly(res);
    for (int d = 0; d < i; d++) {
      if (res[d][0] != 0) {
        listR.add(new Point(res[d][0], res[d][1]));
      }
    }

    final int[][] ret = new int[i][2];
    for (int f = 0; f < i; f++) {
      ret[f][0] = res[f][0];
      ret[f][1] = res[f][1];
    }

    return ret;
  }

  @Override
  public int[][] multiply(final char poly1, final char poly2) {
    listR.clear();
    SLNode first = null, second = null;
    if (poly1 == 'A' || poly1 == 'a') {
      first = listA.getHead();
    }
    if (poly1 == 'B' || poly1 == 'b') {
      first = listB.getHead();
    }
    if (poly1 == 'C' || poly1 == 'c') {
      first = listC.getHead();
    }
    if (poly2 == 'A' || poly2 == 'a') {
      second = listA.getHead();
    }
    if (poly2 == 'B' || poly2 == 'b') {
      second = listB.getHead();
    }
    if (poly2 == 'C' || poly2 == 'c') {
      second = listC.getHead();
    }

    if (first == null || second == null) {
      throw new RuntimeException("error");
    }

    final int[][] fr = new int[MAX_N][2], sc = new int[MAX_N][2];
    int i = 0, j = 0;
    while (first != null) {
      fr[i][0] = (int) ((Point) first.getElement()).getX();
      fr[i][1] = (int) ((Point) first.getElement()).getY();
      i++;
      first = first.getNext();
    }
    while (second != null) {
      sc[j][0] = (int) ((Point) second.getElement()).getX();
      sc[j][1] = (int) ((Point) second.getElement()).getY();
      j++;
      second = second.getNext();
    }

    final int[][] res = new int[MAX_N][2];
    int itr = 0;
    for (int m = 0; m < i; m++) {
      for (int k = 0; k < j; k++) {
        final Point ans = new Point(fr[m][0] * sc[k][0],
            fr[m][1] + sc[k][1]);
        res[itr][0] = (int) ans.getX();
        res[itr][1] = (int) ans.getY();
        itr++;
      }
    }

    int[][] resFinal = new int[MAX_N][2];
    int c = 0;
    final boolean[] taken = new boolean[MAX_N];
    for (int m = 0; m < itr; m++) {
      if (!taken[m]) {
        taken[m] = true;
        resFinal[c][0] = res[m][0];
        resFinal[c][1] = res[m][1];
        for (int n = 0; n < itr; n++) {
          if (!taken[n] && resFinal[c][1] == res[n][1]) {
            resFinal[c][0] += res[n][0];
            taken[n] = true;
            if (resFinal[c][0] == 0) {
              c--;
            }
          }
        }
        c++;
      }
    }

    resFinal = sortPoly(resFinal);

    for (int d = 0; d < c; d++) {
      listR.add(new Point(resFinal[d][0], resFinal[d][1]));
    }

    final int[][] ret = new int[c][2];
    for (int f = 0; f < c; f++) {
      ret[f][0] = resFinal[f][0];
      ret[f][1] = resFinal[f][1];
    }

    return ret;
  }

  /**
   * @param poly the poly to be sorted.
   * @return that poly sorted .
   */
  private int[][] sortPoly(final int[][] poly) {
    for (int i = 0; i < poly.length; i++) {
      for (int j = i + 1; j < poly.length; j++) {
        if (poly[i][1] < poly[j][1]) {
          int tmp = poly[i][1];
          poly[i][1] = poly[j][1];
          poly[j][1] = tmp;

          tmp = poly[i][0];
          poly[i][0] = poly[j][0];
          poly[j][0] = tmp;
        }
      }
    }
    return poly;
  }

  /**
   * @return the head .
   */
  public SLNode getRFirst() {
    return listR.getHead();
  }

  /**
   * @param poly the poly char.
   * @return set status .
   */
  public boolean isSet(final char poly) {
    if (poly == 'a' || poly == 'A') {
      return !listA.isEmpty();
    }
    if (poly == 'b' || poly == 'B') {
      return !listB.isEmpty();
    }
    if (poly == 'c' || poly == 'C') {
      return !listC.isEmpty();
    }
    if (poly == 'r' || poly == 'R') {
      return !listR.isEmpty();
    }
    return false;
  }
}
