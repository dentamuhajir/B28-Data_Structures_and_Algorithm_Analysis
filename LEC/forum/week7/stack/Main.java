import java.util.Arrays;

class Stack {

  private int maxSize;
  private Object[] stackArray;
  private int top;

  public Stack(int size) {
    maxSize = size;
    stackArray = new Object[maxSize];
    top = -1;
  }

  public void push(Object value) {
    if (isFull()) {
      System.out.println("Stack is full. Cannot push element.");
      return;
    }
    top++;
    stackArray[top] = value;
  }

  public Object pop() {
    if (isEmpty()) {
      System.out.println("Stack is empty. Cannot pop element.");
      return -1;
    }
    int oldTop = top;
    top--;
    stackArray[oldTop] = null;
    return stackArray[oldTop];
  }

  public Object peek() {
    if (isEmpty()) {
      System.out.println("Stack is empty. Cannot peek element.");
      return -1;
    }
    return stackArray[top];
  }

  public boolean isEmpty() {
    return (top == -1);
  }

  public boolean isFull() {
    return (top == maxSize - 1);
  }

  @Override
  public String toString() {
    return "Stack: " + Arrays.toString(stackArray);
  }
}

public class Main {
    public static void main(String[] args) {
        Stack myStack = new Stack(5);  

        myStack.push("A");
        myStack.push("B");
        myStack.push("C");
        System.out.println(myStack); 

        System.out.println("Top element is: " + myStack.peek());

        myStack.pop(); 
        System.out.println("After pop: " + myStack); 

        myStack.push("D");
        System.out.println("After push D: " + myStack);
    }
}
