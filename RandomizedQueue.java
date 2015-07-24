/**
 * Auto Generated Java Class.
 */
import java.util.Iterator;
public class RandomizedQueue<Item> implements Iterable<Item> {
     private int N;
      private Item[] a;
    
    public RandomizedQueue() { 
         a = (Item[]) new Object[2];
    }
    
    public boolean isEmpty() {
        return N == 0;
    }
    
    private void resize(int capacity) {
    
        Item[] temp = (Item[]) new Object[capacity];
        for (int i =0; i < N; i++) {
            temp[i] = a[i];
        }
        a = temp;
    }
   
    public int size() {
        return N;
    }
    
    public void enqueue(Item item) {
        if (item == null) {
            throw new java.lang.NullPointerException("The item you want to add is null");
        }
        if(N == a.length) {
            resize(2*a.length);
        }
        a[N++] = item;
    }
    
    public Item dequeue() {
        if(isEmpty()){
            throw new java.util.NoSuchElementException("The list is empty");
        }
        int n = StdRandom.uniform(N);
        Item item = a[n];
        a[n] = null;
        if(n != N - 1) {
        reorder(n);
        }
        N--;
        if (N > 0 && N == a.length/4) {
            resize(a.length/2);
         
        }
        return item;
    }
    
    public Item sample() {
         if(isEmpty()){
            throw new java.util.NoSuchElementException("The list is empty");
        }
        int n = StdRandom.uniform(N);
        Item item = a[n];
        return item;
    }
    
    private void reorder(int n) {
        for (int i = n; i < N - 1; i++) {
            a[i] = a[i + 1];
        }
    
    }
        
    
    public Iterator<Item> iterator() {
        resize(N);
       
        return new RandomizedQueueIterator();
    }
    private class RandomizedQueueIterator implements Iterator<Item> {
        private int i;
        private Item[] c;
        
        public RandomizedQueueIterator() {
            i = N - 1;
            c = a.clone();
            StdRandom.shuffle(c);
        }
        public boolean hasNext() {
            return i >= 0;
        }
        public void remove() {
            throw new java.lang.UnsupportedOperationException ("This method is not supported");
        }
        public Item next() {
            if (!hasNext()) {
                throw new java.util.NoSuchElementException("There are no more items left");
            }
            return c[i--];
        }
        
    }
    
    
    public static void main(String[] args) { 
        RandomizedQueue<String> s = new RandomizedQueue<String>();
        s.enqueue("A");
        s.enqueue("B");
        s.enqueue("C");
        s.enqueue("D");
        StdOut.println(s.size());
        Iterator<String> t = s.iterator();
        StdOut.println(t.next());
        StdOut.println(t.next());
        StdOut.println(t.next());
         StdOut.println(t.next());
        StdOut.println(s.dequeue());
        t = s.iterator();
        StdOut.println(t.next());
        StdOut.println(t.next());
        StdOut.println(t.next());
        
        
       
     
        
    }
    
    /* ADD YOUR CODE HERE */
    
}
