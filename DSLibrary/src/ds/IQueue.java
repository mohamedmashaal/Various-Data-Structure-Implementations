package ds;

public interface IQueue {
  /**
   * Inserts an item at the queue front.
   */
  public void enqueue(Object item);

  /**
   * Removes the object at the queue rear and returns it.
   */
  public Object dequeue();

  /**
   * Tests if this queue is empty.
   */
  public boolean isEmpty();

  /**
   * Returns the number of elements in the queue.
   */
  public int size();
}
