package store;

/**
 *
 * @author Alexander Tekleab
 */
public class PriorityQueue {

    // creating variables and heap array
    private PriorityCustomer[] heap;
    private int size;
    private int totalNumOfCustomers;

    // constructor
    public PriorityQueue() {
        heap = new PriorityCustomer[60];
        size = 0;
    }

    // add customer method
    public void addCustomer(PriorityCustomer c) {
        size++;
        totalNumOfCustomers++;

        // the index  of the new object
        int index = size;
        int priority = c.getPriority();

        // putting the customer in the next open position in the heap
        heap[index] = c;

        //checking for swaps with parents 
        while (index > 1) {

            int parentIndex = index / 2;
            int parentPriority = heap[parentIndex].getPriority();

            // checking for swap with the parent
            if (priority > parentPriority) {

                // swap customer with parent
                PriorityCustomer temp = heap[parentIndex];
                heap[parentIndex] = c;
                heap[index] = temp;

                // update the index after the swap
                index = parentIndex;

            } else {
                //customer is in it's proper position  -> exit
                break;
            }

        }

    }

    // remove customer method
    public PriorityCustomer removeCustomer() {

        //checking if heap isn't empty
        if (size == 0) {
            System.out.println("The heap is already empty");
            return null;
        }

        //storing temporary reference to root object
        PriorityCustomer temporary = heap[1];

        //moving object in the last position to the root
        heap[1] = heap[size];
        heap[size] = null;
        size--;

        //storing the index of the object 
        int index = 1;

        //comparing index to its children as long as there are children
        while (index <= size / 2) {

            //storing index and values of children
            int leftChildIndex = index * 2;
            int rightChildIndex = leftChildIndex + 1;

            int leftChildValue = heap[leftChildIndex].getPriority();
            int rightChildValue = Integer.MIN_VALUE;

            if (rightChildIndex <= size) {
                rightChildValue = heap[rightChildIndex].getPriority();
            }

            //determining the larger of the two children
            int largerValue;
            int largerIndex;

            if (rightChildValue > leftChildValue) {
                largerValue = rightChildValue;
                largerIndex = rightChildIndex;
            } else {
                largerValue = leftChildValue;
                largerIndex = leftChildIndex;
            }

            //determining if a swap should be made with the parent and the larger child
            if (heap[index].getPriority() < largerValue) {

                //swap
                PriorityCustomer swap = heap[index];
                heap[index] = heap[largerIndex];
                heap[largerIndex] = swap;

                //updating the index since we moved it to a child position
                index = largerIndex;
            } else {
                //parent value is larger no swap needed...exit
                break;
            }

        }

        //return the original root
        return temporary;

    }

    public boolean isEmpty() { // checks if heap is empty
        return heap[1] == null;
    }

    public int getSize() { //gets the size of the line.
        return size;
    }

    public int getTotalNumOfCustomers() { //gets total number of customers
        return totalNumOfCustomers;
    }

    public PriorityCustomer findMax() { //gets the first customer in line
        PriorityCustomer customer = heap[1]; //first customer 

        return customer; //returns the first customer in line.
    }

}
