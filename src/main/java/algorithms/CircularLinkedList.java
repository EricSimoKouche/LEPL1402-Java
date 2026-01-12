package algorithms;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * In this exercise, you will implement some methods for a circular linked-list.
 * A circular linked-list is a linked-list for which the last element has a successor: the
 * first element.
 * For example, if the list is 4 -> 5 -> 2, then 4 is the first element, and 2 points towards 4.
 *                             ^         |
 *                             |         |
 *                             -----------
 * 
 * We ask you to implement two methods; enqueue and remove which, respectively, add an element at the end of the queue, and
 * removes an element at a given index. The time complexity of each method is note in their specifications.
 */
public class CircularLinkedList {

    public static class Node {
        public int value;
        public Optional<Node> next;

        public Node(int value) {
            this.value = value;
            this.next = Optional.empty();
        }
        
        public void setNext(Node next) {
            this.next = Optional.of(next);
        }
        
        public boolean hasNext() {
            return this.next.isPresent();
        }
    }
    
    public Optional<Node> first;
    public Optional<Node> last;
    public int size;

    public CircularLinkedList() {
        this.first = Optional.empty();
        this.last = Optional.empty();
        this.size = 0;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public Optional<Node> getFirst() {
        return this.first;
    }

    public Optional<Node> getLast() {
        return this.last;
    }
    
    public void enqueue(int value) {

        Node node = new Node(value);

        if (isEmpty()) {
            node.setNext(node);
            first = Optional.of(node);
            last = Optional.of(node);
        } else {
            node.setNext(first.get());
            last.get().setNext(node);
            last = Optional.of(node);
        }

        size++;
        
    }
    
    public int remove(int index) {

        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        int removed;

        if (size == 1) {
            removed = first.get().value;
            first = Optional.empty();
            last = Optional.empty();
        } else if (index == 0) {
            removed = first.get().value;
            Node nextNode = first.get().next.get();
            last.get().setNext(nextNode);
            first = Optional.of(nextNode);
        } else {
            Node prev = first.get();

            for (int i = 1; i < index - 1; i++) {
                prev = prev.next.get();
            }

            Node current = prev.next.get();
            removed = current.value;

            prev.setNext(current.next.get());

            if (index == size - 1) {
                last = Optional.of(prev);
            }
        }

        size--;
        return removed;
    }
}
