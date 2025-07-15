
class LinkedList {
    Node head;
    Node tail;
    int size;

    public void addLast(int val) {
        Node newNode = new Node(val);

        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }

        size++;
        // T.C => O(1)
    }

    public void addFirst(int val) {
        Node newNode = new Node(val);

        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }

        size++;
        // T.C => O(1)
    }

    public void addAt(int idx, int val) {
        if (idx < 0 || idx > size) {
            System.out.println("Invalid arguments");
            return;
        }

        Node newNode = new Node();
        newNode.data = val;

        if (idx == 0) {
            // addfirst
            newNode.next = head;
            head = newNode;
        }

        else if (idx == size) {
            // addlast
            tail.next = newNode;
            tail = newNode;
        }

        else {
            // get element at idx - 1
            Node prev = getNodeAt(idx - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;

        // T.C => O(N) 
    }

    public int getFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return head.data;
        // T.C => O(1)
    }

    public int getLast() {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }
        return tail.data;
        // T.C => O(1)
    }

    public int getAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return -1;
        }

        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return -1;
        }

        if (idx == 0) {
            return getFirst();
        }
        if (idx == size - 1) {
            return getLast();
        }

        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp.data;
        // T.C => O(N)
    }

    public Node getNodeAt(int idx) {
        Node temp = head;
        for (int i = 0; i < idx; i++) {
            temp = temp.next;
        }
        return temp;
        // T.C => O(N)
    }

    public void removeFirst() {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }

        head = head.next;
        size--;
        // T.C => O(1)
    }

    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (size == 1) {
            head = tail = null;
            size = 0;
            return;
        }

        Node secondLast = head;
        // second last node
        while (secondLast.next != tail) {
            secondLast = secondLast.next;
        }

        size--;
        tail = secondLast;
        tail.next = null;
        // T.C => O(N)
    }

    public void removeAt(int idx) {
        if (size == 0) {
            System.out.println("List is empty");
            return;
        }

        if (idx < 0 || idx >= size) {
            System.out.println("Invalid arguments");
            return;
        }

        if (idx == 0) {
            // removeFirst
            removeFirst();
        } else if (idx == size - 1) {
            // removeLast
            removeLast();
        } else {
            Node prev = getNodeAt(idx - 1);
            prev.next = prev.next.next;
            size--;
        }
        // T.C => O(N)
    }

    public void display() {
        Node temp = head;

        while (temp.next != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
        // T.C => O(N)
    }
    // Recursion
    public void displayReverse(Node curr){
      // base case
      if(curr == null) return;
      
      // faith
      displayReverse(curr.next);
      
      // meeting expectation
      System.out.print(curr.data + " ");

      // T.C => O(N), S.C => O(N) (Recursion Stack Space)
    }
}

class Node {
    int data;
    Node next;

    Node(){};

    Node(int data) {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}


/*

** My Observations:

 1) Standard compile & run flow (works always):
-----------------------------------------------
javac PrintLinkedList.java
java PrintLinkedList


 2) This works on Java 11+ only:
---------------------------------
java PrintLinkedList.java

- Surprisingly this runs fine on my system.
- Turns out from Java 11 onwards, you can run `.java` files directly (no need for javac first).

BUT... I noticed something strange 👇

 3) If I move the Node class above the PrintLinkedList class (i.e., Node comes first),
and then run: `java PrintLinkedList.java`, it gives an error:

   error: can't find main(String[]) method in class: Node

Why?? Because:
-----------------
When Java reads the file top-down, it sees `Node` first and thinks it's the main class (which doesn't have main()).
So it crashes.

✅ But if PrintLinkedList is written first (as I’ve done here), then the command works fine.

My Rule:
-------------------------
- Always keep the class with `main()` at the top if I want to use `java FileName.java` directly.
- Still better to stick with proper compile+run format:

    javac PrintLinkedList.java  
    java PrintLinkedList

- `javac PrintLinkedList` =>  Error: File extension required.
- `java PrintLinkedList.java` =>  only works on Java 11+ with limitations.
*/
