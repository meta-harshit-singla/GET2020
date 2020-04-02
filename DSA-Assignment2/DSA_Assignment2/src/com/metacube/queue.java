package com.metacube;

public class queue
{
    
    int   front   = 0;
    int   rear    = 0;
    int   size    = 0;
    int   element = 0;
    int[] queueArray;
    
    /**
     * This is used to initialize array
     * 
     * @param sizeofArray
     */
    public queue(int sizeofArray)
    {
        
        this.queueArray = new int[sizeofArray];
        this.element = sizeofArray;
    }
    
    /**
     * This is used to add the element to queue
     * 
     * @param data
     */
    public String enque(int data)
    {
        String result;
        if (!isFull())
        {
            queueArray[rear] = data;
            rear = (rear + 1) % (element);
            size++;
            result = "--------added sucessfully---------";
        }
        else
        {
            result = "-------Queue is full--------";
            
        }
        return result;
    }
    
    /**
     * This is used to delete from queue
     */
    public String deque()
    {
        String result;
        int data = queueArray[front];
        if (!isEmpty())
        {
            front = (front + 1) % (queueArray.length);
            size--;
            result = "-------Deleted Sucessfully--------";
        }
        else
        {
            result = "--------Queue is empty------------";
        }
        return result;
    }
    
    /**
     * This is used to check whether queue is empty
     * 
     * @return
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    /**
     * This is used to check whether queue is full
     * 
     * @return
     */
    public boolean isFull()
    {
        return size == element;
        
    }
    
    /**
     * This is used to print size of queue
     */
    public int sizeofQueue()
    {
        return size;
    }
    
    /**
     * This is used to show queue
     */
    public int[] show()
    {
        System.out.println("list after operation");
        int[] arr = new int[element];
        for (int index = 0; index < size; index++)
        {
            
            arr[index] = queueArray[(front + index) % (queueArray.length)];
        }
        return arr;
    }
}