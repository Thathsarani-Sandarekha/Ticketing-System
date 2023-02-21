package TicketSystem;

public class Node {
    int noOfTickets;
    int price;
    String day;
    int days;
    String name;
    Node next;

    public Node(int noOfTickets, int price, int days, String day, String name) {
        this.noOfTickets = noOfTickets;
        this.price = price;
        this.days = days;
        this.day = day;
        this.name = name;
        this.next = null;
    }
}
