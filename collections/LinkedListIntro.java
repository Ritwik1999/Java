package collections;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListIntro {
    public static void main(String[] args) {
        LinkedList<String> s = new LinkedList<>();
        s.add("Ritwik");
        s.add("Sam");
        s.add("Tom");

        ListIterator<String> litr = s.listIterator();
        while (litr.hasNext()) {
            String j = (String) litr.next();
            System.out.println(j);
        }

        ListIterator<String> rlitr = s.listIterator(s.size());
        while (rlitr.hasPrevious()) {
            String j = (String) rlitr.previous();
            System.out.println(j);
        }

        // Linked List as Stack
        LinkedList<Integer> l = new LinkedList<>();
        l.push(3);
        l.push(5);
        l.push(29);
        System.out.println(l.pop());
    }
}
