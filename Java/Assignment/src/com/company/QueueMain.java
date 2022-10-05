package com.company;
import java.util.*;
class Queue{
    int i;
    int front,rear;
    int[] queue = new int[100];
    Queue(int f,int r){
        this.front = f;
        this.rear = r;
    }
    Queue(){
        front = -1;
        rear = -1;
    }
    void enqueue(int size)
    {
        Scanner in = new Scanner(System.in);
        if (rear == size - 1)
            System.out.print(" QUEUE is Full. ");
        else
        {
            System.out.print(" Enter the element to INSERT: ");
            rear++;
            queue[rear] = in.nextInt();
            if (front == -1)
                front = 0;
        }
    }
    void dequeue()
    {
        if (front == -1)
        {
            System.out.print(" QUEUE is Empty. ");
        }
        else
        {
            System.out.printf(" DELETED element is %d. ", queue[front]);
            front++;
            if (front > rear)
            {
                front = -1;
                rear = -1;
            }
        }
    }
    void display()
    {

        if (front == -1 && rear == -1)
            System.out.println(" Queue is Empty. ");
        else
        {
            System.out.print(" Queue Elements are: \n");
            for (i = front; i <= rear; i++)
            {
                System.out.print(" "+queue[i]);
            }
        }
    }
}
public class QueueMain {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue q1 = new Queue(-1,-1);
        Queue q2 = new Queue();
        int ch;
        System.out.print("\n\t\t QUEUE OPERATIONS USING PARAMETERISED CONSTRUCTOR ");
        System.out.print("\n\t\t ------------------------------------------------ \n");
        System.out.print("\n\t\t 1.ENQUEUE\n\t\t 2.DEQUEUE\n\t\t 3.DISPLAY\n\t\t 4.EXIT ");
        System.out.print("\nEnter the size of the queue: ");
        int size = in.nextInt();
        do
        {
            System.out.print("\n\n Enter the Choice: ");
            ch = in.nextInt();
            switch (ch) {
                case 1 -> {
                    q1.enqueue(size);
                }
                case 2 -> {
                    q1.dequeue();
                }
                case 3 -> {
                    q1.display();
                }
                case 4 -> {
                    System.out.println("Exited!!!");
                }
                default -> {
                    System.out.print(" Please Enter a Valid Choice. ");
                }
            }
        }while (ch != 4);
        System.out.print("\n\t\t QUEUE OPERATIONS USING DEFAULT CONSTRUCTOR ");
        System.out.print("\n\t\t ------------------------------------------ \n");
        System.out.print("\n\t\t 1.ENQUEUE\n\t\t 2.DEQUEUE\n\t\t 3.DISPLAY\n\t\t 4.EXIT ");
        System.out.print("\nEnter the size of the queue: ");
        size = in.nextInt();
        do
        {
            System.out.print("\n\n Enter the Choice: ");
            ch = in.nextInt();
            switch (ch) {
                case 1 -> q2.enqueue(size);
                case 2 -> q2.dequeue();
                case 3 -> q2.display();
                case 4 -> System.out.println("Exited!!!");
                default -> System.out.print(" Please Enter a Valid Choice. ");
            }
        }while (ch != 4);
    }
}

