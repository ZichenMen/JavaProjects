/**
 * The class represents for the circular sorted linked list
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Zichen Men
 * @param <Type> the generic data type
 */
public class SortedList<Type extends Comparable<? super Type>>
        extends AbstractList<Type>
        implements List<Type>
{
    /**
     * The constructor for the circular sorted linked list.
     */
    public SortedList()
    {
        super();
    }

    @Override
    public boolean contains(Type value)
    {
        return getIndex(value) >= 0;
    }

    /**
     * Inserts the specified value in sorted order in the list.
     * @param theValue the value to be inserted.
     * @throws NullPointerException if theValue is null.
     */
    @Override
    public void insert(final Type theValue)
    {
        if (theValue == null)
            throw new NullPointerException("Value cannot be null");

        ListNode<Type> myNewNode = new ListNode<>(theValue);

        // empty list case
        if (tail == null) {
            tail = myNewNode;
            tail.next = myNewNode;
        } else if (theValue.compareTo(tail.data) >= 0) { // add to end
            myNewNode.next = tail.next;
            tail.next = myNewNode;
            tail = myNewNode;
        } else { // add in between or at start
            ListNode<Type> current = tail.next;
            if (theValue.compareTo(current.data) < 0) { // add at start
                myNewNode.next = current;
                tail.next = myNewNode;
            } else { // add in between
                while (theValue.compareTo(current.next.data) >= 0) {
                    current = current.next;
                }
                myNewNode.next = current.next;
                current.next = myNewNode;
            }
        }
        size++;
    }

    /**
     * Clears the list.
     */
    @Override
    public void clear()
    {
        tail = null;
        size = 0;
    }

    /**
     * Removes a value from the list.
     * @param theValue the value to be removed.
     * @throws NullPointerException if theValue is null.
     * @return the removed value if found, else null.
     */
    @Override
    public Type remove(final Type theValue) {
        // TODO Auto-generated method stub
        if (theValue == null)
            throw new NullPointerException("The value cannot be null");

        if (tail == null)
            return null;

        ListNode<Type> current = tail.next;
        ListNode<Type> prev = tail;
        do {
            if (current.data.equals(theValue)) {
                if (current == tail) tail = prev;
                prev.next = current.next;
                size--;
                return current.data;
            }
            prev = current;
            current = current.next;
        } while (current != tail.next);

        return null;
    }

    /**
     * Removes a value at the specified index from the list.
     * @param theIndex the index at which the value is to be removed.
     * @throws IndexOutOfBoundsException if theIndex is out of range.
     * @return the removed value.
     */
    @Override
    public Type removeAtIndex(final int theIndex) {
        // TODO Auto-generated method stub
        if (theIndex < 0 || theIndex >= size)
            throw new IndexOutOfBoundsException();

        ListNode<Type> current = tail.next;
        ListNode<Type> prev = tail;
        for (int i = 0; i < theIndex; i++) {
            prev = current;
            current = current.next;
        }
        if (current == tail) tail = prev;
        prev.next = current.next;
        size--;
        return current.data;
    }

    /**
     * Throws UnsupportedOperationException as the SortedList does not support set method.
     * @throws UnsupportedOperationException always.
     */
    @Override
    public void set(int index, Type value)
    {
        throw new UnsupportedOperationException("The SortedList does not support set method");
    }

    /**
     * Retrieves a value at the specified index from the list.
     * @param theIndex the index at which the value is to be retrieved.
     * @throws IndexOutOfBoundsException if theIndex is out of range.
     * @return the value at theIndex.
     */
    @Override
    public Type get(final int theIndex)
    {
        if (theIndex < 0 || theIndex >= size)
            throw new IndexOutOfBoundsException("Index out of bound");

        ListNode<Type> myCurrent = tail.next;
        for (int i = 0; i < theIndex; i++)
            myCurrent = myCurrent.next;

        return myCurrent.data;
    }

}