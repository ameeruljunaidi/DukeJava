package textgen;

import java.util.AbstractList;


/**
 * A class that implements a doubly linked list
 *
 * @param <E> The type of the elements stored in the list
 * @author UC San Diego Intermediate Programming MOOC team
 */
public class MyLinkedList<E> extends AbstractList<E> {
    LLNode<E> head;
    LLNode<E> tail;
    int size;

    /**
     * Create a new empty LinkedList
     */
    public MyLinkedList() {
        head = new LLNode<>(null);
        tail = new LLNode<>(null);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * Appends an element to the end of the list
     *
     * @param element The element to add
     */
    public boolean add(E element) {
        if (element == null) throw new NullPointerException();
        LLNode<E> toAdd = new LLNode<>(element);

        try {
            toAdd.prev = tail.prev;
            toAdd.next = tail;
            tail.prev.next = toAdd;
            tail.prev = toAdd;
            ++size;
        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    /**
     * Get the element at position index
     *
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (size == 0 && index == 0) throw new IndexOutOfBoundsException();
        return getNodeAtIndex(index).data;
    }

    /**
     * Add an element to the list at the specified index
     *
     * @param index   index where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element) {
        if (element == null) throw new NullPointerException();
        LLNode<E> current = getNodeAtIndex(index);

        LLNode<E> toAdd = new LLNode<>(element);
        toAdd.next = current;
        toAdd.prev = current.prev;
        current.prev.next = toAdd;
        current.prev = toAdd;
        ++size;
    }


    /**
     * Return the size of the list
     */
    public int size() {
        return size;
    }

    /**
     * Remove a node at the specified index and return its data element.
     *
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the list
     */
    public E remove(int index) {
        LLNode<E> current = getNodeAtIndex(index);

        current.prev.next = current.next;
        current.next.prev = current.prev;
        --size;

        return current.data;
    }

    /**
     * Set an index position in the list to a new element
     *
     * @param index   The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element) {
        if (element == null) throw new NullPointerException();
        LLNode<E> current = getNodeAtIndex(index);

        E oldElement = current.data;
        current.data = element;

        return oldElement;
    }

    private void checkIndexOutOfBound(int index) {
        if (size == 0 && index > 0) throw new IndexOutOfBoundsException();
        if (size != 0 && index >= size) throw new IndexOutOfBoundsException();
        if (index < 0) throw new IndexOutOfBoundsException();
    }

    public LLNode<E> getNodeAtIndex(int index) {
        checkIndexOutOfBound(index);
        LLNode<E> current = head;

        for (int i = 0; i < index + 1; ++i) {
            try {
                current = current.next;
            } catch (NullPointerException e) {
                throw new IndexOutOfBoundsException(e.getMessage());
            }
        }
        return current;
    }

}

class LLNode<E> {
    LLNode<E> prev;
    LLNode<E> next;
    E data;

    public LLNode(E e) {
        this.data = e;
        this.prev = null;
        this.next = null;
    }
}
