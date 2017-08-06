package ds.doubleLinkedList;

/**
 * @author Mohamed Mashaal.
 *
 */

public class DLNode {
  /**
   * the element saved .
   */
  private Object elementt;
  /**
   *  the next node.
   */
  private DLNode nextt;
  /**
   * the prev node.
   */
  private DLNode prevv;

  /**
   * @param element the element to be added.
   * @param next the next node.
   * @param prev the prev one.
   */
  public DLNode(final Object element,
      final DLNode next,
      final DLNode prev) {
    // TODO Auto-generated
    // constructor stub
    elementt = element;
    nextt = next;
    prevv = prev;
  }

  /**
   * @return the element.
   */
  public Object getElement() {
    return elementt;
  }

  /**
   * @return the next node.
   */
  public DLNode getNext() {
    return nextt;
  }

  /**
   * @return the prev node .
   */
  public DLNode getPrev() {
    return prevv;
  }

  /**
   * @param element setting the element.
   */
  public void setElement(final Object element) {
    elementt = element;
  }

  /**
   * @param next setting the next.
   */
  public void setNext(final DLNode next) {
    nextt = next;
  }

  /**
   * @param prev setting the prev.
   */
  public void setPrev(final DLNode prev) {
    prevv = prev;
  }
}
