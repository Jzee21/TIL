package porb;

public class MyStack {
	private int[] stack;
	private int index = 0;
	private int size = 10;
	
	public MyStack() {
		this.stack = new int[10];
	}

	public MyStack(int size) {
		if(size<=0)
			stack = new int[10];
		else {
			this.size = size;
			stack = new int[this.size];
		}
	}
	
//	public void push(int num) {
//		if(this.index < this.size) {
//			this.stack[this.index++] = num;
//		}
//	}
	public void push(int num) {
		if(isFull()) {
			int[] temp = new int[this.size*2];
			System.arraycopy(stack, 0, temp, 0, this.size);
			this.stack = temp;
			temp = null;
			this.size = this.size*2;
//			return;
		}
		this.stack[this.index++] = num;
	}
	
	public int pop() {							 
		if(this.index != 0)						//	return !isEmpty() ? return this.stack[--this.index] : return -1;
			return this.stack[--this.index];
		return -1;
	}
	
	public boolean isEmpty() {
		if(this.index == 0)						//	return this.index == 0 ? return true : return false;
			return true;
		else
			return false;
	}
	
	public boolean isFull() {
		if(this.index == this.size)				//	return this.index==this.size ? true : false;
			return true;
		else
			return false;
	}
	
	public int top() {
		if(this.index != 0)						// 	return isEmpty() ? return -1 : return this.stack[this.index-1];
			return this.stack[this.index-1];
		return -1;
	}
	
	public int length() {
		return this.size;
	}
	
	public int isIndex() {
		return this.index;
	}
	
	public void print() {
		System.out.print("[");
		for (int i = 0; i < this.index-1; i++) {
			System.out.print(this.stack[i]);
			System.out.print(", ");
		}
		System.out.printf("%d]\n",this.stack[this.index-1]);
	}
	
}