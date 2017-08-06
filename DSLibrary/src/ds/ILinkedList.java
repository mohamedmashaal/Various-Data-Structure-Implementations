package ds;

/**
 * @author Mohamed Mashaal.
 *
 */
public interface ILinkedList {
  /**
   * Inserts a specified element at the specified sposition in the
   * list.
   */
  public void add(int index, Object element);

  /**
   * Inserts the specified element at the end of the list.
   */
  public void add(Object element);

  /**
   * Returns the element at the specified position in this list.
   */
  public Object get(int index);

  /**
   * Replaces the element at the specified position in this list
   * with the specified element.
   */
  public void set(int index, Object element);

  /**
   * Removes all of the elements from this list.
   */
  public void clear();

  /**
   * Returns true if this list contains no elements.
   */
  public boolean isEmpty();

  /**
   * Removes the element at the specified position in this list.
   */
  public void remove(int index);

  /**
   * Returns the number of elements in this list.
   */
  public int size();

  /**
   * Returns a view of the portion of this list between the
   * specified fromIndex and toIndex, inclusively.
   */
  public ILinkedList sublist(int fromIndex, int toIndex);

  /**
   * Returns true if this list contains an element with the same
   * value as the specified element.
   */
  public boolean contains(Object o);
}
