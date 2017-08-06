package ds.doubleLinkedList;

import ds.ILinkedList;

/**
 * @author Mohamed Mashaal.
 *
 */

public class DoubleLinkedList implements ILinkedList {
  /**
   * the head node.
   */
  private final DLNode head;
  /**
   * the tail node .
   */
  private final DLNode tail;
  /**
   * the size node .
   */
  private int size;

  /**
   * DoubleLinkedList Constructor.
   */
  public DoubleLinkedList() {
    head = new DLNode(null, null, null);
    tail = new DLNode(null, null, head);
    head.setNext(tail);
    size = 0;
  }

  @Override
  public void add(final int index, final Object element) {
    // TODO Auto-generated method
    // stub
    if (index > size || index < 0) {
      throw new RuntimeException("Error");
    }
    DLNode current = head;
    if (size == 0) {
      final DLNode node = new DLNode(element, tail, head);
      head.setNext(node);
      tail.setPrev(node);
      size++;
      return;
    }
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    final DLNode node = new DLNode(element, current.getNext(), current);
    current.getNext().setPrev(node);
    current.setNext(node);
    size++;
  }

  @Override
  public void add(final Object element) {
    // TODO Auto-generated method
    // stub
    final DLNode node = new DLNode(element, tail, tail.getPrev());
    final DLNode current = tail.getPrev();
    current.setNext(node);
    tail.setPrev(node);
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
    DLNode current = head;
    if (index == size - 1) {
      return tail.getPrev().getElement();
    }
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getNext().getElement();
  }

  @Override
  public void set(final int index, final Object element) {
    // TODO Auto-generated method
    // stub
    if (index >= size || index < 0) {
      throw new RuntimeException("Error");
    }
    if (size == 0) {
      throw new RuntimeException("Error");
    }
    DLNode current = head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    current.getNext().setElement(element);
  }

  @Override
  public void clear() {
    // TODO Auto-generated method
    // stub
    head.setNext(tail);
    tail.setPrev(head);
    size = 0;
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
  public void remove(final int index) {
    // TODO Auto-generated method
    // stub
    if (index >= size || index < 0) {
      throw new RuntimeException("Error");
    }
    if (size == 0) {
      throw new RuntimeException("Error");
    }
    DLNode current = head;
    if (index == size - 1) {
      final DLNode current2 = tail.getPrev().getPrev();
      current2.setNext(tail);
      tail.setPrev(current2);
      size--;
      return;
    }
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    final DLNode current2 = current.getNext().getNext();
    current.setNext(current2);
    current2.setPrev(current);
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
    if (fromIndex >= size || toIndex >= size
        || fromIndex < 0
        || toIndex < 0
        || fromIndex > toIndex) {
      throw new RuntimeException("Error");
    }
    if (size == 0) {
      throw new RuntimeException("Error");
    }
    DLNode current = head;
    for (int i = 0; i <= fromIndex; i++) {
      current = current.getNext();
    }
    final DoubleLinkedList list = new DoubleLinkedList();
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
    DLNode current = head;
    for (int i = 0; i < size; i++) {
      current = current.getNext();
      if (o.equals(current.getElement())) {
        return true;
      }
    }
    return false;
  }

}
