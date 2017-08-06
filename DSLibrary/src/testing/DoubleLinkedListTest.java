package testing;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.awt.Point;

import org.junit.Test;

import ds.doubleLinkedList.DoubleLinkedList;

/**
 * @author Mohamed Mashaal.
 *
 */
public class DoubleLinkedListTest {
  /**
   * the constants used.
   */
  private static final int NUM3 = 3, NUM100 = 100;
  /**
   * the constants used.
   */
  private static final int NUM66 = 66, NUM63 = 63;
  /**
   * the constants used.
   */
  private static final int NUM78 = 78, NUM45 = 45;
  /**
   * the constants used.
   */
  private static final int NUM2114 = 2114, NUM8541 = 8541;
  /**
   * testing the implementation.
   */
  @Test
  public void test() {
    final DoubleLinkedList n = new DoubleLinkedList();
    final Point[] myPoints = {new Point(5, 3),
        new Point(1, 4),
        new Point(6, 4),
        new Point(3, 3),
        new Point(200, 54),
        new Point(4, 5) };
    for (int i = 0; i < myPoints.length; i++) {
      n.add(myPoints[i]);
    }
    for (int i = 0; i < myPoints.length; i++) {
      assertEquals("Missed element at index " + i, myPoints[i], n.get(i));
    }
    System.out.println("Tested correct insertion");
    try {
      n.add(NUM100, myPoints[0]);
    } catch (final RuntimeException e) {
      final String msg = "Error";
      assertEquals(msg, e.getMessage());
    }
    System.out.println("Tested Wrong Adding");
    Point x = new Point(NUM63, NUM78);
    n.add(NUM3, x);
    assertEquals("Wrong element at index " + NUM3, x, n.get(NUM3));
    System.out.println("Tested correct insertion at middle");
    x = new Point(NUM2114, NUM8541);
    n.set(NUM3 + 1, x);
    assertEquals("Wrong element at index " + NUM3, x, n.get(NUM3 + 1));
    System.out.println("Tested correct element setting");
    final DoubleLinkedList tList = (DoubleLinkedList) n.sublist(3, 6);
    assertEquals("Size isn't right", NUM3 + 1, tList.size());
    System.out.println("Sublist size");
    final Point[] pointTest = {new Point(63, 78),
        new Point(2114, 8541),
        new Point(200, 54),
        new Point(4, 5) };
    for (int i = 0; i < NUM3 + 1; i++) {
      assertEquals("Missed element at index " + i,
          pointTest[i],
          tList.get(i));
    }
    System.out.println("Tested SubList items");
    n.remove(0);
    assertEquals("Size isn't right", 2 * NUM3, n.size());
    System.out.println("Tested Correct size after removal");
    final Point[] pointTest2 = {new Point(1, 4),
        new Point(6, 4),
        new Point(63, 78),
        new Point(2114, 8541),
        new Point(200, 54),
        new Point(4, 5) };
    for (int i = 0; i < 2 * NUM3; i++) {
      assertEquals("Missed element at index " + i,
          pointTest2[i],
          n.get(i));
    }
    System.out.println("Tested List after removal");
    x = new Point(NUM2114, NUM8541);
    assertTrue(n.contains(x));
    System.out.println("Tested element existance");
    x = new Point(NUM66, NUM45);
    assertFalse(n.contains(x));
    System.out.println("Tested element non existance");
    n.clear();
    assertTrue(n.isEmpty());
    System.out.println("Tested List clearance");
  }

}
