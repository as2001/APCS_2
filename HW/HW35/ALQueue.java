//	Andrew Shao
//	APCS2 pd2
//	HW35 -- ...Nor Do Aussies
//	2018-04-17T

import java.util.ArrayList;

public class ALQueue<T> {

    private ArrayList<T> _queue;
    private int _size;
    private int _front, _end;
    
    public ALQueue() {
		_queue = new ArrayList<T>();
		_size = 0;
		_front = _end = 0;
    }
    
    public T dequeue() {
		T temp = _queue.get(_front);
		_front = _front + 1;
		_size--;
		return temp;
	}

    public void enqueue(T x) {
		_queue.add(x);
		_end += 1;
		_size++;
    }

    public T peekfront() { return _queue.get(_front); }

    public boolean isEmpty() { return _size == 0; }

    public static void main(String[] args) {
		ALQueue joe = new ALQueue<Integer>();
		for (int i= 0; i < 10; i ++)
			joe.enqueue(i);
		System.out.println("front of joe after enqueuing: " + joe.peekfront() + "\n");
		for (int i = 0; i < 10; i++)
			System.out.println("result for dequeuing: " + joe.dequeue());	
    }
	
}

	

    
    
	
    
