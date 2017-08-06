package ds.singleLinkedList;

import ds.ILinkedList;

/**
 * @author Mohamed Mashaal.
 *
 */
public class SingleLinkedList implements ILinkedList {
  /**
   * the head node.
   */
  private SLNode head;
  /**
   * the size .
   */
  private int size;

  /**
   * the class constructor.
   */
  public SingleLinkedList() {
    head = null;
    size = 0;
  }

  @Override
  public void add(final int index, final Object element) {
    // TODO Auto-generated method
    // stub
    final SLNode node = new SLNode(element, null);
    if (index > size || index < 0) {
      throw new RuntimeException("Error");
    }
    if (size == 0) {
      head = node;
      size++;
      return;
    }
    if (index == 0) {
      final SLNode current = head;
      head = node;
      node.setNext(current);
      size++;
      return;
    }
    SLNode current = head;
    for (int i = 0; i < index - 1; i++) {
      current = current.getNext();
    }
    node.setNext(current.getNext());
    current.setNext(node);
    size++;
  }

  @Override
  public void add(final Object element) {
    // TODO Auto-generated method
    // stub
    final SLNode node = new SLNode(element, null);
    if (size == 0) {
      head = node;
      size++;
      return;
    }
    SLNode current = head;
    while (current.getNext() != null) {
      current = current.getNext();
    }
    current.setNext(node);
    size++;
  }

  @Override
  public Object get(final int index) {
    // TODO Auto-generated method
    // stub
    if (index >= size || index < 0) {
      throw new RuntimeException("Error");
    }
    if (size == 0) {
      throw new RuntimeException("Error");
    }
    SLNode current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getElement();
  }

  @Override
  public void set(final int index, final Object element) {
    // TODO Auto-generated method
    // stub
    if (index >= size || index < 0) {
      throw new RuntimeException("Error");
    }
    if (head == null) {
      throw new RuntimeException("Error");
    }
    SLNode current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    current.setElement(element);
  }

  @Override
  public void clear() {
    // TODO Auto-generated method
    // stub
    head = null;
    size = 0;
  }

  @Override
  public boolean isEmpty() {
    // TODO Auto-generated method
    // stub
    if (head == null) {
      return true;
    }
    return false;
  }

  @Override
  public void remove(final int index) {
    // TODO Auto-generated method
    // stub
    if (index >= size || index < 0) {
      throw new RuntimeException("Error");
    }
    if (size == 0) {
      throw new RuntimeException("Error");
    }
    SLNode current = head;
    if (index == 0) {
      head = current.getNext();
      size--;
      return;
    }
    for (int i = 0; i < index - 1; i++) {
      current = current.getNext();
    }
    final SLNode current2 = current.getNext();
    current.setNext(current2.getNext());
    current2.setNext(null);
    size--;
  }

  @Override
  public int size() {
    // TODO Auto-generated method
    // stub
    return size;
  }

  @Override
  public ILinkedList sublist(final int fromIndex, final int toIndex) {
    // TODO Auto-generated method
    // stub
    if (fromIndex > size || toIndex > size) {
      throw new RuntimeException("Error");
    }
    if (fromIndex < 0 || toIndex < 0 || fromIndex > toIndex) {
      throw new RuntimeException("Error");
    }
    if (size == 0) {
      throw new RuntimeException("Error");
    }
    SLNode current = head;
    for (int i = 0; i < fromIndex; i++) {
      current = current.getNext();
    }
    final SingleLinkedList list = new SingleLinkedList();
    list.add(current.getElement());
    for (int i = fromIndex; i < toIndex; i++) {
      current = current.getNext();
      list.add(current.getElement());
    }
    return list;
  }

  @Override
  public boolean contains(final Object o) {
    // TODO Auto-generated method
    // stub
    if (o == null) {
      throw new RuntimeException("Error");
    }
    if (size == 0) {
      return false;
    }
    SLNode current = head;
    for (int i = 0; i < size; i++) {
      if (o.equals(current.getElement())) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  /**
   * @return the head.
   */
  public SLNode getHead() {
    return head;
  }
}
