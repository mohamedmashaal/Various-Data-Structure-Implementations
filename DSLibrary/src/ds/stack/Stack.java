package ds.stack;

import ds.IStack;
import ds.doubleLinkedList.DoubleLinkedList;

/**
 * @author Mohamed Mashaal.
 *
 */
public class Stack implements IStack {
  /**
   * the DLL Used .
   */
  private final DoubleLinkedList list = new DoubleLinkedList();

  @Override
  public void add(final int index, final Object element) {
    // TODO Auto-generated method
    // stub
    list.add(index, element);
  }

  @Override
  public Object pop() {
    // TODO Auto-generated method
    // stub
    final Object x = list.get(list.size() - 1);
    list.remove(list.size() - 1);
    return x;
  }

  @Override
  public Object peek() {
    // TODO Auto-generated method
    // stub
    return list.get(list.size() - 1);
  }

  @Override
  public void push(final Object element) {
    // TODO Auto-generated method
    // stub
    list.add(element);
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method
    // stub
    if (list.size() == 0) {
      return true;
    }
    return false;
  }

  @Override
  public int size() {
    // TODO Auto-generated method
    // stub
    return list.size();
  }

}
