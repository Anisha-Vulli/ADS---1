import java.util.Scanner;
import java.util.Arrays;
class Node {
	int data;
	Node next;

	Node() {

	}

	Node(int data) {
		this.data = data;
	}
}

class Queue {
	private Node head;
	private Node tail;
	public int size;

	Queue() {
		head = new Node();
		tail = new Node();
		size = 0;
	}

	void enqueue (int item) {
		Node obj = new Node(item);
		if (head == null) {
			head = obj;
			tail = obj;
			size++;
			return;
		}

		tail.next = obj;
		tail = obj;
		size++;
	}

	int dequeue() {
		int data = head.data;
		head = head.next;
		size--;
		return data;
	}

	boolean isEmpty() {
		return size == 0;
	}

	int size() {
		return size;
	}
}

class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		while (sc.hasNext()) {
			String[] input = sc.nextLine().split(" ");
			int m = Integer.parseInt(input[0]);
			int n = Integer.parseInt(input[1]);
			Queue q = new Queue();
			String str = "";
			for (int i = 0; i < m; i++) {
				q.enqueue(i);
			}

			while (!q.isEmpty()) {
                for (int k = 0; k < n - 1; k++) {
                    q.enqueue(q.dequeue());
                }
                str += q.dequeue() + " ";
            }
            System.out.println(str.substring(0, str.length() - 1));
		}
	}
}