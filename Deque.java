/**
 * Auto Generated Java Class.
 */
import java.util.Iterator;
public class Deque<Item> implements Iterable<Item> {
    
    private int N;
    private Node first, last;
    
    private class Node {
    
        private Item item;
        private Node next;
        private Node previous;
    }
    
    
    public Deque() { 
        first = null;
        last = null;
        N = 0;
    }
    
    public boolean isEmpty() {
        
        return N == 0;
    }
    
    public int size() {
        
        return N;
    }
    
    public void addFirst(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("This item you add is null");
        }
        
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        
        if (N == 1 && last == null) {
           last = oldFirst;
           
        }
        if (oldFirst != null) {
            oldFirst.previous = first;
            first.next = oldFirst;
        }
        N++;
        
    }
    
    public void addLast(Item item) {
         if (item == null) {
            throw new java.lang.NullPointerException("This item you add is null");
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        
        if (N == 1 && first == null) {
     
        first = oldLast;
        }
        if (oldLast != null) {
            last.previous = oldLast;
            oldLast.next = last;
        
        }
        N++;
    }
    
    public Item removeFirst() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("The stack is empty");
        }
        if (first != null) {
        Item item = first.item;
        first = first.next;
        N--;
        return item;
        }
        else {
            return removeLast();
        }
    }
    
    public Item removeLast() {
         if (isEmpty()) {
            throw new java.util.NoSuchElementException("The stack is empty");
        }
         if (last != null) {
        Item item = last.item;
        last = last.previous;
        
        N--;
        return item;
         }
         else {
             return removeFirst();
         }
        
    }
    
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }
    private class DequeIterator implements Iterator<Item> {
        private Node current = first;
        public boolean hasNext() {
            return current != null;
        }
        public void remove() {
            throw new java.lang.UnsupportedOperationException("The following method cannot be called");
        }
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("There no more items in the stack");
            }
            Item item = current.item;
            current = current.next;
            return item;
        }
    }
    
    
    public static void main(String[] args) { 
        Deque<String> s = new Deque<String>();
        s.addLast("A");
        
        //s.addFirst("C");
        //s.addFirst("D");
        //StdOut.println(s.size());
        //StdOut.println(s.first.item);
       // StdOut.println(s.last.item);
        //StdOut.println(s.first.next.item);
        //StdOut.println(s.last.previous.item);
        s.removeFirst();
        //s.removeLast();
        //s.removeLast();
        //s.removeLast();
        StdOut.println(s.size());
       
        
        
    }
    
    /* ADD YOUR CODE HERE */
    
}
