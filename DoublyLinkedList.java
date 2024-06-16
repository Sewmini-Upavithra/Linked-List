package LinkedList;

class Node { 
    Node prev; 
    int data; 
    Node next; 

    Node(int value) { 
        prev = null; 
        data = value; 
        next = null; 
    } 
} 

class DoublyLinkedList { 
    static Node head = null; 
    static Node tail = null; 

    static void insertAtBeginning(int data) { 
        Node temp = new Node(data); 
        if (head == null) { 
            head = temp; 
            tail = temp; 
        } else { 
            temp.next = head; 
            head.prev = temp; 
            head = temp; 
        } 
    } 

    static void insertAtEnd(int data) { 
        Node temp = new Node(data); 
        if (tail == null) { 
            head = temp; 
            tail = temp; 
        } else { 
            tail.next = temp; 
            temp.prev = tail; 
            tail = temp; 
        } 
    } 

    static void insertAtPosition(int data, int position) { 
        Node temp = new Node(data); 
        if (position == 1) { 
            insertAtBeginning(data); 
        } else { 
            Node current = head; 
            int currPosition = 1; 
            while (current != null && currPosition < position) { 
                current = current.next; 
                currPosition++; 
            } 
            if (current == null) { 
                insertAtEnd(data); 
            } else { 
                temp.next = current; 
                temp.prev = current.prev; 
                current.prev.next = temp; 
                current.prev = temp; 
            } 
        } 
    } 

    static void deleteAtBeginning() { 
        if (head == null) { 
            return; 
        } 
        if (head == tail) { 
            head = null; 
            tail = null; 
            return; 
        } 
        Node temp = head; 
        head = head.next; 
        head.prev = null; 
        temp.next = null; 
    } 

    static void deleteAtEnd() { 
        if (tail == null) { 
            return; 
        } 
        if (head == tail) { 
            head = null; 
            tail = null; 
            return; 
        } 
        Node temp = tail; 
        tail = tail.prev; 
        tail.next = null; 
        temp.prev = null; 
    } 

    static void deleteAtSpecificPosition(int pos) { 
        if (head == null) { 
            return; 
        } 
        if (pos == 1) { 
            deleteAtBeginning(); 
            return; 
        } 
        Node current = head; 
        int count = 1; 
        while (current != null && count != pos) { 
            current = current.next; 
            count++; 
        } 
        if (current == null) { 
            System.out.println("Position wrong"); 
            return; 
        } 
        if (current == tail) { 
            deleteAtEnd(); 
            return; 
        } 
        current.prev.next = current.next; 
        current.next.prev = current.prev; 
        current.prev = null; 
        current.next = null; 
    } 

    static void display(Node head) { 
        Node temp = head; 
        while (temp != null) { 
            System.out.print(temp.data + " --> "); 
            temp = temp.next; 
        } 
        System.out.println("NULL"); 
    } 

    public static void main(String[] args) { 
        insertAtEnd(10); 
        insertAtEnd(20); 
        insertAtEnd(30); 
        insertAtEnd(40); 
        insertAtEnd(50); 

        System.out.print("After insertion at tail: "); 
        display(head); 

        insertAtBeginning(5); 
        System.out.print("After insertion at head: "); 
        display(head); 

        insertAtPosition(15, 3); 
        System.out.print("After insertion at 3rd position: "); 
        display(head); 

        deleteAtBeginning(); 
        System.out.print("After deletion at the beginning: "); 
        display(head); 

        deleteAtEnd(); 
        System.out.print("After deletion at the end: "); 
        display(head); 

        deleteAtSpecificPosition(3); 
        System.out.print("After deletion at 3rd position: "); 
        display(head); 
    } 
}
