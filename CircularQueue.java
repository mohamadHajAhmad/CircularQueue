/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mohamadhajahmed;

/**
 *
 * @author Mohamad Hilal
 */
class CircularQueue<T>{
        private Object[] data;
    private int rear = -1;
    private int front = 0;
    private int maxSize = 0;
    private int currentSize = 0;

    public CircularQueue(int maxSize){
        this.maxSize = maxSize;
        data = new Object[maxSize];
    }
    public int size (){
        return currentSize;
    }

    
    public boolean isEmpty(){
        return currentSize == 0;
    }
    public boolean isFull(){
        return currentSize == maxSize - 1 ;
    }

    public void enQueue(T item) throws FullException {
        if(isFull()){
            throw new FullException();
        }
        rear=(rear+1)%maxSize;

        data[rear] = item;
        currentSize ++;
    }
    public T deQueue() throws EmptyException {
        if(isEmpty()){
            throw new EmptyException();
        }
        T item =(T) data[front];
        data[front] =null;
        front ++ ;
        if(front >= maxSize) {
            front = 0;
        }
        currentSize --;
        return item;
    }

}

class FullException extends Exception{


}
class EmptyException extends Exception{


}
