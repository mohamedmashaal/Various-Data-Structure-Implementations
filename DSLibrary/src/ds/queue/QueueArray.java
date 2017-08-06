package ds.queue;


import ds.IArrayBased;
import ds.IQueue;

/**
 * @author Mohamed Mashaal.
 *
 */
public class QueueArray implements IQueue, IArrayBased {
  /**
   * the array used.
   */
  private Object[] theArray;
  /**
   * the data used.
   */
  private int size, max, lastIdx;
  /**
   * the constant.
   */
  private static final int NUM10 = 10;

  /**
   * @param n constructor for the class.
   */
  QueueArray(final int n) {
    theArray = new Object[NUM10 * n];
    size = 0;
    max = n;
  }

  @Override
  public void enqueue(final Object item) {
    // TODO Auto-generated method
    // stub
    if (item == null || size == max) {
      throw new RuntimeException("Error");
    }
    if (size == 0) {
      lastIdx = 0;
      theArray[lastIdx] = item;
      size++;
      return;
    }
    theArray[lastIdx + size] = item;
    size++;
  }

  @Override
  public Object dequeue() {
    // TODO Auto-generated method
    // stub
    if (size == 0) {
      throw new RuntimeException("Error");
    }
    final Object x = theArray[lastIdx];
    theArray[lastIdx] = null;
    lastIdx++;
    size--;
    return x;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method
    // stub
    if (size == 0) {
      return true;
    }
    return false;
  }

  @Override
  public int size() {
    // TODO Auto-generated method
    // stub
    return size;
  }

}
