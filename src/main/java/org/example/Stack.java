package org.example;

public class Stack {
        private int top;
        private int arr[];
        private int capacity;

        Stack(int size){
            arr = new int[size];
            capacity = size;
            top = -1;
        }

        public void push(int x){
            if(isFull()){
                System.out.println("Stack is full");
                System.exit(1);
            }

            System.out.println("Pushing " + x);
            arr[++top] = x;
        }

        public int pop(){
            if(isEmpty()){
                System.out.println("Stack is empty");
                System.exit(1);
            }
            return arr[top--];
        }

        public int size(){
            return top + 1;
        }

        public Boolean isEmpty(){
            return top == -1;
        }

        public boolean isFull(){
            return top == capacity - 1;
        }

        public void printStack(){
            for(int i = top; i >= 0; i--){
                System.out.print(arr[i]);
            }
        }
}

