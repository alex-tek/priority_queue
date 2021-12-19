package store;

import java.util.Random;

/**
 *
 * @author Alexander Tekleab
 */
public class Driver {

    public static void main(String[] args) {

        PriorityQueue queue = new PriorityQueue(); //creates  priority queue

        int customerServiced = 0; //keeps track of total customerServcied
        int max = 0; //holds the max the line gets
        Random r = new Random();

        System.out.println("\n*************************************************************"
                + "\n            *60 minutes of activity at the store* "
                + "\n*************************************************************\n");

        for (int i = 0; i < 60; i++) { //loop through 60 min

            if (r.nextInt(4) + 1 == 1) { //25% chance of a new customer added

                queue.addCustomer(new PriorityCustomer()); //add new customer

                System.out.println("|New Customer added! Queue length is now| = " + queue.getSize());

            }

            if (!queue.isEmpty()) //if queue is not empty 
            {
                queue.findMax().decServiceTime();// makes service time minus one

                if (queue.findMax().getServiceTime() == 0) { //if the service time is 0
                    queue.removeCustomer(); // removes first object from the list

                    System.out.println("|Customer serviced and removed from queue! In queue length is now| = " + queue.getSize());
                    customerServiced++; //keeps track of number of customers serviced
                }
                if (queue.getSize() > max) //gets the max size of the line
                {
                    max = queue.getSize();
                }

            }

            System.out.println("---------------------------------------------------"); // the passing of time
        }

        //printing customer serviced and the max in line and total number of customers
        System.out.println("\n**********************************************"
                + "\n              *Output Results*"
                + "\n**********************************************"
                + "\n|Total number of customers serviced| = " + customerServiced
                + "\n|Maximum number of customers in queue| = " + max
                + "\n|Total number of customers| = " + queue.getTotalNumOfCustomers()
                + "\n**********************************************");
    }

}
