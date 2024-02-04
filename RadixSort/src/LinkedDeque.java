/**
 * The class defines the node-based queue
 * @author Zichen Men <zichen.men@bellevuecollege.edu>
 * @param <Type> the generic data type
 */
public class LinkedDeque<Type>
        extends LinkedQueue<Type>
        implements Deque<Type>
{
    /**
     * The constructor initializes an empty queue.
     */
    public LinkedDeque()
    {
        // TODO IMPLEMENT CODE HERE
        super();
    }

    @Override
    public void addRear(Type data)
    {
        // TODO IMPLEMENT CODE HERE
        if (data == null) {
            throw new NullPointerException("Cannot add null value to the deque.");
        }
        Node newNode = new Node(data);
        if (size == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;

    }

    @Override
    public void addFront(Type theElement)
    {
        // TODO IMPLEMENT CODE HERE
        if (theElement == null) {
            throw new NullPointerException("Cannot add null value to the deque.");
        }
        Node newNode = new Node(theElement);

        if (isEmpty()) {
            // If deque is empty, set the new node as both head and tail
            head = newNode;
        } else {
            // Insert the new node at the front of the deque
            newNode.next = head;
            head = newNode;
        }

        size++;
    }

    @Override
    public Type removeRear()
    {
        // TODO IMPLEMENT CODE HERE
        if (isEmpty()) {
            throw new EmptyCollectionException("deque");
        }

        // If deque has only one element, remove it and update head as well
        if (size == 1) {
            Type returnValue = head.data;
            head = null;
            size--;
            return returnValue;
        }

        // Traverse the deque until the second-to-last node
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        // Remove the last node and update tail reference
        Type returnValue = current.next.data;
        current.next = null;
        size--;

        return returnValue;
    }

    @Override
    public Type removeFront()
    {
        // TODO IMPLEMENT CODE HERE
        if (isEmpty()) {
            throw new EmptyCollectionException("deque");
        }

        // Remove element from the front of the deque
        return remove();
    }

    @Override
    public Type peekRear()
    {
        // TODO IMPLEMENT CODE HERE
        if (isEmpty()) {
            throw new EmptyCollectionException("deque");
        }

        // Return the element at the back of the deque
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current.data;
    }

    @Override
    public Type peekFront()
    {
        // TODO IMPLEMENT CODE HERE
        if (isEmpty()) {
            throw new EmptyCollectionException("deque");
        }

        // Return the element at the front of the deque
        return head.data;
    }

}