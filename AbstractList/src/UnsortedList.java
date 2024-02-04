/**
 * The class represents for the circular unsorted linked list
 * @author Varik Hoang <varikmp@uw.edu>
 * @author Zichen Men
 * @param <Type> the generic data type
 */
public class UnsortedList<Type>
        extends AbstractList<Type>
        implements List<Type>
{
    /**
     * The constructor for the circular unsorted linked list.
     */
    public UnsortedList()
    {
        super();
    }

    @Override
    public boolean contains(Type value)
    {
        return getIndex(value) >= 0;
    }

    /**
     * Inserts the specified value in sorted order in the list
     * @param theValue the value to be inserted
     * @throws NullPointerException if theValue is null
     */
    @Override
    public void insert(final Type theValue) {
        // TODO Auto-generated method stub
        if (theValue == null)
            throw new NullPointerException("The value cannot be null");

        if (tail == null) {
            tail = new ListNode<>(theValue);
            tail.next = tail;
        } else {
            tail.next = new ListNode<>(theValue, tail.next);
            tail = tail.next;
        }
        size++;
    }

    /**
     * Clear the list
     */
    @Override
    public void clear() {
        // TODO Auto-generated method stub
        tail = null;
        size = 0;
    }

    /**
     * Find the item in the list. If the item is found
     * @param theValue the value is assigned
     * @return we remove it from the list and return that item
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
     * Remove the item at the given index.
     * @param theIndex the index must be in range of 0 and size
     * @return We remove the item from the list and return that item
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
     * Set the item at the given index.
     * @param theIndex the index must be in range of 0 and size
     * @param theValue the value is assigned
     */
    @Override
    public void set(final int theIndex, final Type theValue) {
        // TODO Auto-generated method stub
        if (theValue == null)
            throw new NullPointerException("Value cannot be null");

        if (theIndex < 0 || theIndex >= size)
            throw new IndexOutOfBoundsException("Index is out of bounds");

        ListNode<Type> myNewNode = new ListNode<>(theValue);

        // Special case for head node
        if (theIndex == 0) {
            if (size == 1) {
                tail = myNewNode;
            } else {
                myNewNode.next = tail.next.next;
            }
            tail.next = myNewNode;
        } else {
            ListNode<Type> myPrevious = tail.next; // head
            for (int i = 0; i < theIndex - 1; i++) {
                myPrevious = myPrevious.next;
            }

            myNewNode.next = myPrevious.next.next;
            if (theIndex == size - 1) {
                // Update tail if we're setting the last element
                tail = myNewNode;
            }

            myPrevious.next = myNewNode;
        }}

    /**
     * Get the item at the given index by returning the value.
     * @param theIndex the index must be in range of 0 and size
     * @return returning the value.
     */
    @Override
    public Type get(final int theIndex) {
        // TODO Auto-generated method stub
        if (theIndex < 0 || theIndex >= size)
            throw new IndexOutOfBoundsException();

        ListNode<Type> current = tail.next;
        for (int i = 0; i < theIndex; i++) {
            current = current.next;
        }
        return current.data;
    }

}