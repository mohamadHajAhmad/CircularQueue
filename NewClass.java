/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mohamadhajahmed;

import java.lang.reflect.Array;
import java.util.LinkedList;

/**
 *
 * @author Mohamad Hilal
 */
class Employee implements Comparable{
    public int id;
    public String name;
    public Employee(int Id , String Name){
        id = Id;
        name = Name;
    }

    @Override
    public int compareTo(Object item) {
        Employee emp = (Employee) item;
        if(this.name.length()>emp.name.length()){
            return 1;
        } else if (this.name.length() < emp.name.length()) {
            return -1;
        }else{
            return 0;
        }
    }
}


class ProiortyQueue<T extends Comparable>{
    private LinkedList<T> queue;
    private int  size = 0;
    public ProiortyQueue(){//,T[] data
        size= 0;
        queue  = new LinkedList<>();
//        maxSize = size;
//        data = (T[]) Array.newInstance(type , size);
        //this.data =data;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    
    public void enQueue(T item){
        int sizeQueue  = queue.size();
        int i = sizeQueue;
        for(; i >= 0 ; i--){
            T element = queue.get(i);
            if(item.compareTo(element) == 1){
                queue.set(i + 1,element );
            }else 
                break;
        }
        
        queue.set(i + 1,item );
        size++;
    }
    
    public T deQueue() throws Exception{
        if(isEmpty()){
            throw new Exception("the queue is empty"); 
        }
        T item = queue.get(0);
        queue.removeFirst();
        size--;
        return item;
    }
}

        
//        int i = rear ;
//        for(;i>=front;i--){
//            if(item.compareTo(data[i]) == 1){
//                data[i+1]=data[i];
//            }else {
//                break;
//            }
//        }
//        rear++;
//        data[i+1] = item;
//        currentSize++;

//    public T deQueue(){
//        if(isEmpty()){
//            return null;
//        }
//        T item = data[front];
//        data[front] = null;
//        currentSize--;
//        front++;
//        return item;
//    }
