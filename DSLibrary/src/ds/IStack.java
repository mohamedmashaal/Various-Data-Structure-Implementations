package ds;

public interface IStack {
  /**
   * Inserts a specified element at the specified position in the
   * list.
   *
   * @param index
   *          zero-based index
   * @param element
   *          object to insert
   */
  public void add(int index, Object element);

  /**
   * Removes the element at the top of stack and returns that
   * element.
   *
   * @return top of stack element, or through exception if empty
   */
  public Object pop();

  /**
   * Get the element at the top of stack without removing it from
   * stack.
   *
   * @return top of stack element, or through exception if empty
   */
  public Object peek();

  /**
   * Pushes an item onto the top of this stack.
   *
   * @param object
   *          to insert
   */
  public void push(Object element);

  /**
   * Tests if this stack is empty.
   *
   * @return true if stack empty
   */
  public boolean isEmpty();

  /**
   * Returns the number of elements in the stack.
   *
   * @return number of elements in the stack
   */
  public int size();
}
