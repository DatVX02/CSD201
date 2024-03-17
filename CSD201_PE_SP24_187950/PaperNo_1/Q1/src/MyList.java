/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList {

    Node head, tail;

    MyList() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void clear() {
        head = tail = null;
    }

    void fvisit(Node p, RandomAccessFile f) throws Exception {
        if (p != null) {
            f.writeBytes(p.info + " ");
        }
    }

    void ftraverse(RandomAccessFile f) throws Exception {
        Node p = head;
        while (p != null) {
            fvisit(p, f); // You will use this statement to write information of the node p to the file
            p = p.next;
        }
        f.writeBytes("\r\n");
    }

    void loadData(int k) { //do not edit this function
        String[] a = Lib.readLineToStrArray("data.txt", k);
        int[] b = Lib.readLineToIntArray("data.txt", k + 1);
        int[] c = Lib.readLineToIntArray("data.txt", k + 2);
        int n = a.length;
        for (int i = 0; i < n; i++) {
            addLast(a[i], b[i], c[i]);
        }
    }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
/* 
   Khong su dung tieng Viet co dau de viet ghi chu.
   Neu dung khi chay truc tiep se bao loi va nhan 0 diem
     */
    void addLast(String xPlace, int xWeight, int xColor) { //f1
        //You should write here appropriate statements to complete this function.
        //--------------------------------------------------------

        if (xWeight > 0) {
            Bike newBike = new Bike(xPlace, xWeight, xColor);
            Node newNode = new Node(newBike); // Assuming a constructor Node(Bike) exists

            if (isEmpty()) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        //---------------------------------------------------------
    }
    //==================================================================
    //You do not need to edit this function. Your task is to complete 
    //the addLast function above only.
    void f1() throws Exception {
        clear();
        loadData(1);
        String fname = "f1.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f2() throws Exception {
        clear();
        loadData(5);
        String fname = "f2.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        if (head != null && head.next != null && head.next.next != null) {
            head = head.next.next.next;

            // After moving the head, if the list now starts with null, it means the list had exactly three nodes.
            if (head == null) {
                tail = null; // The list is now empty, so tail must also be null.
            }
        }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f3() throws Exception {
        clear();
        loadData(9);
        String fname = "f3.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        if (head != null && head.next != null && head.next.next != null) {
            Node second = head.next;       // Node before the one we want to move
            Node third = second.next;      // Node to move
            Node fourth = third.next;      // Node that will become the third

            // Check if the third node is not already the last node
            if (third != tail) {
                second.next = fourth;  // Remove the third node from its current position
                tail.next = third;     // Add the third node at the end
                third.next = null;     // Now the third node is the last node, so its next is null
                tail = third;          // Update the tail to be the third node
            }
            // If the third node is the tail, we don't need to do anything
        }

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

//==================================================================
    void f4() throws Exception {
        clear();
        loadData(13);
        String fname = "f4.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/

        int count = 0; // Initialize a counter for bikes with color > 0
        Node p = head; // Start from the head of the list

        // Traverse the list
        while (p != null) {

            if (p.info.color > 0) {
                count++; // Increment the count if condition is met
            }
            p = p.next; // Move to the next node
        }

        // After listing all bikes, write the count of those with color > 0
        f.writeBytes("\n" + count); // New line and then the count

        //------------------------------------------------------------------------------------
        f.close();
    }

//==================================================================
    void f5() throws Exception {
        clear();
        loadData(17);
        String fname = "f5.txt";
        File g123 = new File(fname);
        if (g123.exists()) {
            g123.delete();
        }
        RandomAccessFile f = new RandomAccessFile(fname, "rw");
        ftraverse(f);
        //------------------------------------------------------------------------------------
        /*You must keep statements pre-given in this function.
        Your task is to insert statements here, just after this comment,
        to complete the question in the exam paper.*/
        if (!isEmpty()) {
            head = head.next;
        }
        boolean wasChanged;
        do {
            Node current = head;
            Node previous = null;
            Node next = head.next;
            wasChanged = false;

            while (next != null) {
                if (current.info.weight < next.info.weight) {
                    wasChanged = true;

                    if (previous != null) {
                        Node temp = next.next;
                        previous.next = next;
                        next.next = current;
                        current.next = temp;
                    } else {
                        head = next;
                        Node temp = next.next;
                        head.next = current;
                        current.next = temp;
                    }

                    previous = next;
                    next = current.next;
                } else {
                    previous = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (wasChanged);

        //------------------------------------------------------------------------------------
        ftraverse(f);
        f.close();
    }

}
