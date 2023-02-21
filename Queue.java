package TicketSystem;

class Queue {
        Node  front, rear;
        int size;
        int price;
        int maxSize;
        int sizeD1;
        int sizeD2;
        int sizeD3;
        int maxSizeD1;
        int maxSizeD2;
        int maxSizeD3;
        int queueNumber;

        public Queue() {
               front = null;
               rear = null;
               size = 0;
               price = 20;
               sizeD1 = sizeD2 = sizeD3 = 0;
               maxSizeD1 = maxSizeD2 = maxSizeD3 = 1000;
               maxSize = maxSizeD1 + maxSizeD2 + maxSizeD3;
               queueNumber = 0;
        }

        public void enqueue(int noOfTickets, int price, int days, String day, String name)
        {
                Node temp= new Node(noOfTickets, price, days, day, name);
                if (size == 0) {
                        front = rear = temp;
                }
                this.rear.next = temp;
                this.rear = temp;

                size = size + noOfTickets;
                queueNumber = queueNumber + 1;
        }

        void dequeue() {
                if (this.front == null)
                        return;

                this.front = this.front.next;

                if (this.front == null)
                        this.rear = null;
        }

        void ticketDetails() {
                if (this.front != null) {
                        System.out.println("--------------------------------------------------------");
                        System.out.println("          Number of Tickets: ----- " + this.front.noOfTickets);
                        System.out.println("          Total Price: ---------- $" + this.front.price);
                        System.out.println("          Number of Days: -------- " + this.front.days + " Days");
                        System.out.println("          Participation Days: ---- " + this.front.day);
                        System.out.println("          Name: ------------------ " + this.front.name);
                        System.out.println("--------------------------------------------------------");
                }
        }

        void day() {
                if (this.front != null) {
                        System.out.print("*   " + this.front.day);
                        int n = 42 - this.front.day.length();
                        for (int i = 0; i < n; i++) {
                                System.out.print(" ");
                        }
                        System.out.print("$20");
                        int m = 7;
                        for (int i = 0; i < m; i++) {
                                System.out.print(" ");
                        }
                        System.out.println("*");
                }
        }

        int date() {
                return this.front.days;
        }

        void name() {
                if (this.front != null) {
                        System.out.print("*                     " + this.front.name);
                        int n = 34 - this.front.name.length();
                        for (int i = 0; i < n; i++) {
                                System.out.print(" ");
                        }
                        System.out.println("*");
                }
        }
}
