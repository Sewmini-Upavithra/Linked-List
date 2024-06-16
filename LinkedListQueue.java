package LinkedList;

class QNode {
	    int key;
	    QNode next;

	    public QNode(int key) {
	        this.key = key;
	        this.next = null;
	    }
	}

	class Queue {
	    QNode front, rear;

	    public Queue() {
	        this.front = this.rear = null;
	    }

	    void enqueue(int key) {
	        QNode temp = new QNode(key);

	        if (this.rear == null) {
	            this.front = this.rear = temp;
	            return;
	        }

	        this.rear.next = temp;
	        this.rear = temp;
	    }

	    void dequeue() {
	        if (this.front == null)
	            return;

	        QNode temp = this.front;
	        this.front = this.front.next;

	        if (this.front == null)
	            this.rear = null;
	    }

	    void display() {
	        if (front == null) {
	            System.out.println("Queue is empty");
	            return;
	        }
	        QNode temp = front;
	        while (temp != null) {
	            System.out.print(temp.key + " ");
	            temp = temp.next;
	        }
	        System.out.println();
	    }
	}

	public class Test {
	    public static void main(String[] args) {
	        Queue q = new Queue();
	        q.enqueue(15);
	        q.enqueue(25);
	        q.display();
	        q.dequeue();
	        q.display();
	        q.dequeue();
	        q.display();
	        q.enqueue(35);
	        q.enqueue(45);
	        q.enqueue(55);
	        q.display();
	        q.dequeue();
	        q.display();
	        System.out.println("Queue Front : " + ((q.front != null) ? (q.front).key : -1));
	        System.out.println("Queue Rear : " + ((q.rear != null) ? (q.rear).key : -1));
	    }
	}
