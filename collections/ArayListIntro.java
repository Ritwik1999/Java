package collections;

import java.util.*;

public class ArayListIntro {
    public static void main(String[] args) {
        ArrayList<String> s = new ArrayList<>();
        s.add("Ritwik");
        s.add("Sam");
        s.add("Tom");
        s.add("Sam");
        s.add(1, "Chris");
        s.remove(1);

        System.out.println(s.size());
        for (int i = 0; i < s.size(); i++) {
            String k = (String) s.get(i);
            System.out.println(k);
        }

        // s.clear();
        System.out.println(s.isEmpty());
        System.out.println(s.contains("Ritwik"));
        System.out.println(s.indexOf("Sam"));
        System.out.println(s.indexOf("Random"));
        System.out.println(s.lastIndexOf("Sam"));

        @SuppressWarnings("unchecked")
        ArrayList<String> s1 = (ArrayList<String>) s.clone();

        // Traversal using for loop
        for (int i = 0; i < s1.size(); i++) {
            String k = (String) s1.get(i);
            System.out.println(k);
        }

        // Traversal using an enhance-for loop
        for (String string : s1) {
            System.out.println(string);
        }

        // This takes care of taking you to the next element in the collection, even if
        // the elements are not in contiguous memory blocks
        Iterator<String> itr = s.iterator();
        while (itr.hasNext()) {
            String j = (String) itr.next();
            System.out.println(j);
        }

        // Traversal using ListIterator, specific for collections of type List (has got
        // some specific methods, like reverse traversal)
        ListIterator<String> litr = s.listIterator(s.size());
        while (litr.hasPrevious()) {
            String k = (String) litr.previous();
            System.out.println(k);
        }

        // Create an ArrayList using another Collection
        ArrayList<String> names = new ArrayList<String>(s);
        System.out.println(names.get(0));

        ArrayList<String> names2 = new ArrayList<String>();
        names2.add("Test 1");
        names2.add("Test 2");
        names2.addAll(s);
        System.out.println(names2.size());
        names2.removeAll(s);
        System.out.println(names2.size());
        names2.addAll(s);
        names2.retainAll(s);
        System.out.println(names2.size());
    }
}