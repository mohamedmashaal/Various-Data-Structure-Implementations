package ds.singleLinkedList;

/**
 * @author Mohamed Mashaal
 *
 */
public class SLNode {
  /**
   * the element saved .
   */
  private Object elementt;
  /**
   * the next node .
   */
  private SLNode nextt;

  /**
   * @param element
   *          the element to be saved.
   * @param next
   *          the next node.
   */
  public SLNode(final Object element, final SLNode next) {
    // TODO Auto-generated
    // constructor stub
    elementt = element;
    nextt = next;
  }

  /**
   * @return the element.
   */
  public Object getElement() {
    return elementt;
  }

  /**
   * @return the next node .
   */
  public SLNode getNext() {
    return nextt;
  }

  /**
   * @param element
   *          setting the element.
   */
  public void setElement(final Object element) {
    elementt = element;
  }

  /**
   * @param next
   *          setting the next node.
   */
  public void setNext(final SLNode next) {
    nextt = next;
  }

}
