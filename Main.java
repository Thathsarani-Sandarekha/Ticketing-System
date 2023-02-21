package TicketSystem;

import java.util.Scanner;

public class Main {
    private static final Queue TicketQueue = new Queue();
    private static final Queue TicketQueueD1 = new Queue();
    private static final Queue TicketQueueD2 = new Queue();
    private static final Queue TicketQueueD3 = new Queue();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            System.out.println("--------------------------------------------------------");
            System.out.println("                   **************                       ");
            System.out.println("WELCOME TO THE CON EXPO-CON/AGG CONSTRUCTION TRADE SHOW.");
            System.out.println("                 San Diego, California.                 ");
            System.out.println("                   **************                       ");
            System.out.println("--------------------------------------------------------");
            System.out.println("1 - Enter to the Ticket Queue");
            System.out.println("2 - Buy and Issue Ticket");
            System.out.println("0 - Exit");
            System.out.println("Choose an Option:  ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addToEntry();
                    break;
                case 2:
                    buyTicket();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } while (option != 0);
    }

    public static void addToEntry() {

        if (TicketQueue.size == TicketQueue.maxSize) {
            System.out.println("--------------------------------------------------------");
            System.out.println("         Really Sorry! All tickets are sold out.        ");
            System.out.println("--------------------------------------------------------");
        } else {
            System.out.println("---------------------------------");
            System.out.println("      One Ticket Price: $20      ");
            System.out.println("---------------------------------");

            Scanner scanner = new Scanner(System.in);
            System.out.print("No of Tickets : ");
            int noOfTickets = scanner.nextInt();

            if (noOfTickets == 0) {
                System.out.println("Number of tickets can not be 0.");
            } else if (noOfTickets > 3) {
                System.out.println("You can buy 1 ticket or 2 tickets or maximum 3 tickets.");
            } else {

                if (noOfTickets == 1) {
                    if (TicketQueueD1.sizeD1 == TicketQueueD1.maxSizeD1) {
                        if (TicketQueueD2.sizeD2 == TicketQueueD2.maxSizeD2) {
                            System.out.println("All tickets of Day 1 and Day 2 are sold out.");
                            System.out.println("You can buy one ticket for Day 3");
                            System.out.println("Do you want to proceed?  (Yes / No)");
                            String response = scanner.next();
                            switch (response) {
                                case "yes" -> OneDayTickets(3);
                                case "no" -> System.out.println("Thank you! See you again.");
                                default -> System.out.println("Invalid input");
                            }
                        } else {
                            if (TicketQueueD3.sizeD3 == TicketQueueD3.maxSizeD3) {
                                System.out.println("All tickets of Day 1 and Day 3 are sold out.");
                                System.out.println("You can buy one ticket for Day 2");
                                System.out.println("Do you want to proceed?  (Yes / No)");
                                String response = scanner.next();
                                switch (response) {
                                    case "yes" -> OneDayTickets(2);
                                    case "no" -> System.out.println("Thank you! See you again.");
                                    default -> System.out.println("Invalid input");
                                }
                            } else {
                                System.out.println("All tickets of Day 1 are sold out.");
                                System.out.println("You can buy tickets for Day 2 and Day 3");
                                System.out.println("Do you want to proceed?  (Yes / No)");
                                String response = scanner.next();
                                switch (response) {
                                    case "yes" -> TwoDayTickets(2, 3, noOfTickets);
                                    case "no" -> System.out.println("Thank you! See you again.");
                                    default -> System.out.println("Invalid input");
                                }
                            }
                        }
                    } else {
                        if (TicketQueueD2.sizeD2 == TicketQueueD2.maxSizeD2) {
                            if (TicketQueueD3.sizeD3 == TicketQueueD3.maxSizeD3) {
                                System.out.println("All tickets of Day 2 and Day 3 are sold out.");
                                System.out.println("You can buy one ticket for Day 1");
                                System.out.println("Do you want to proceed?  (Yes / No)");
                                String response = scanner.next();
                                switch (response) {
                                    case "yes" -> OneDayTickets(1);
                                    case "no" -> System.out.println("Thank you! See you again.");
                                    default -> System.out.println("Invalid input");
                                }
                            } else {
                                System.out.println("All tickets of Day 2 are sold out.");
                                System.out.println("You can buy tickets for Day 1 and Day 3");
                                System.out.println("Do you want to proceed?  (Yes / No)");
                                String response = scanner.next();
                                switch (response) {
                                    case "yes" -> TwoDayTickets(1, 3, noOfTickets);
                                    case "no" -> System.out.println("Thank you! See you again.");
                                    default -> System.out.println("Invalid input");
                                }
                            }
                        } else {
                            if (TicketQueueD3.sizeD3 == TicketQueueD3.maxSizeD3) {
                                System.out.println("All tickets of Day 3 are sold out.");
                                System.out.println("You can buy tickets for Day 1 and Day 2");
                                System.out.println("Do you want to proceed?  (Yes / No)");
                                String response = scanner.next();
                                switch (response) {
                                    case "yes" -> TwoDayTickets(1, 2, noOfTickets);
                                    case "no" -> System.out.println("Thank you! See you again.");
                                    default -> System.out.println("Invalid input");
                                }
                            } else {
                                System.out.println("1 - Day 1");
                                System.out.println("2 - Day 2");
                                System.out.println("3 - Day 3");

                                System.out.println("Choose the relevant number : ");
                                int days = scanner.nextInt();

                                if (days == 0) {
                                    System.out.println("Days can not be 0");
                                } else if (days > 3) {
                                    System.out.println("Invalid Input. Please select 1, 2 or 3");
                                } else {
                                    OneDayTickets(days);
                                }
                            }
                        }
                    }
                }

                 else if (noOfTickets == 2) {
                    if (TicketQueueD1.sizeD1 == TicketQueueD1.maxSizeD1) {
                        if (TicketQueueD2.sizeD2 == TicketQueueD2.maxSizeD2) {
                            System.out.println("All tickets of Day 1 and Day 2 are sold out.");
                            System.out.println("You can buy one ticket for Day 3");
                            System.out.println("Do you want to proceed?  (Yes / No)");
                            String response = scanner.next();
                            switch (response) {
                                case "yes" -> OneDayTickets(3);
                                case "no" -> System.out.println("Thank you! See you again.");
                                default -> System.out.println("Invalid input");
                            }
                        } else {
                            if (TicketQueueD3.sizeD3 == TicketQueueD3.maxSizeD3) {
                                System.out.println("All tickets of Day 1 and Day 3 are sold out.");
                                System.out.println("You can buy one ticket for Day 2");
                                System.out.println("Do you want to proceed?  (Yes / No)");
                                String response = scanner.next();
                                switch (response) {
                                    case "yes" -> OneDayTickets(2);
                                    case "no" -> System.out.println("Thank you! See you again.");
                                    default -> System.out.println("Invalid input");
                                }
                            } else {
                                System.out.println("All tickets of Day 1 are sold out.");
                                System.out.println("You can buy tickets for Day 2 and Day 3");
                                System.out.println("Do you want to proceed?  (Yes / No)");
                                String response = scanner.next();
                                switch (response) {
                                    case "yes" -> TwoDayTickets(2, 3, noOfTickets);
                                    case "no" -> System.out.println("Thank you! See you again.");
                                    default -> System.out.println("Invalid input");
                                }
                            }

                        }
                    } else {
                        if (TicketQueueD2.sizeD2 == TicketQueueD2.maxSizeD2) {
                            if (TicketQueueD3.sizeD3 == TicketQueueD3.maxSizeD3) {
                                System.out.println("All tickets of Day 2 and Day 3 are sold out.");
                                System.out.println("You can buy one ticket for Day 1");
                                System.out.println("Do you want to proceed?  (Yes / No)");
                                String response = scanner.next();
                                switch (response) {
                                    case "yes" -> OneDayTickets(1);
                                    case "no" -> System.out.println("Thank you! See you again.");
                                    default -> System.out.println("Invalid input");
                                }
                            } else {
                                System.out.println("All tickets of Day 2 are sold out.");
                                System.out.println("You can buy tickets for Day 1 and Day 3");
                                System.out.println("Do you want to proceed?  (Yes / No)");
                                String response = scanner.next();
                                switch (response) {
                                    case "yes" -> TwoDayTickets(1, 3, noOfTickets);
                                    case "no" -> System.out.println("Thank you! See you again.");
                                    default -> System.out.println("Invalid input");
                                }
                            }
                        } else {
                            if (TicketQueueD3.sizeD3 == TicketQueueD3.maxSizeD3) {
                                System.out.println("All tickets of Day 3 are sold out.");
                                System.out.println("You can buy tickets for Day 1 and Day 2");
                                System.out.println("Do you want to proceed?  (Yes / No)");
                                String response = scanner.next();
                                switch (response) {
                                    case "yes" -> TwoDayTickets(1, 2, noOfTickets);
                                    case "no" -> System.out.println("Thank you! See you again.");
                                    default -> System.out.println("Invalid input");
                                }
                            } else {
                                System.out.println("4 - Day 1 and Day 2");
                                System.out.println("5 - Day 1 and Day 3");
                                System.out.println("6 - Day 2 and Day 3");

                                System.out.println("Choose the relevant number : ");
                                int days = scanner.nextInt();

                                if (days == 4) {
                                    TwoDayTickets(1, 2, noOfTickets);
                                } else if (days == 5) {
                                    TwoDayTickets(1, 3, noOfTickets);
                                } else if (days == 6) {
                                    TwoDayTickets(2, 3, noOfTickets);
                                } else {
                                    System.out.println("Invalid Input. Please select 4, 5 or 6.");
                                }
                            }
                        }
                    }
                }

                 else if (noOfTickets == 3) {
                    System.out.println("Participation Dates: All 3 Days (Day 1, Day 2, and Day 3)");
                    System.out.print("Name : ");
                    String name = scanner.next();

                    TicketQueueD1.enqueue(1, 20*3, 3, "Day 1, Day 2, and Day 3", name);
                    TicketQueueD1.sizeD1 = TicketQueueD1.sizeD1 + 1;

                    TicketQueueD2.enqueue(1, 20*3,3,"Day 1, Day 2, and Day 3", name);
                    TicketQueueD2.sizeD2 = TicketQueueD2.sizeD2 + 1;

                    TicketQueueD3.enqueue(1, 20*3,3, "Day 1, Day 2, and Day 3", name);
                    TicketQueueD3.sizeD3 = TicketQueueD3.sizeD3 + 1;

                    TicketQueue.enqueue(noOfTickets, 20*3, 3, "Day 1, Day 2, Day 3", name);
                    System.out.println("-------------------------------------------------------------------");
                    System.out.println("You have successfully Entered to the queue. Now You can purchase your Tickets.");
                    System.out.println("Your Queue Number is: ----- " + TicketQueue.queueNumber + "\n\n");
                }
            }
        }
    }


    public static void OneDayTickets(int day) {

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Number of tickets: 1");
        System.out.println("Participation Day: Day " + day);

        System.out.print("Name : ");
        String name = scanner1.next();

        if (day == 1) {
            TicketQueueD1.enqueue(1, 20, day, "Day 1", name);
            TicketQueueD1.sizeD1 = TicketQueueD1.sizeD1 + 1;
        } else if (day == 2) {
            TicketQueueD2.enqueue(1, 20, day, "Day 2", name);
            TicketQueueD2.sizeD2 = TicketQueueD2.sizeD2 + 1;
        } else if (day == 3) {
            TicketQueueD3.enqueue(1, 20, day, "Day 3", name);
            TicketQueueD3.sizeD3 = TicketQueueD3.sizeD3 + 1;
        }

        TicketQueue.enqueue(1, 20, day, "Day " + day, name);

        System.out.println("-------------------------------------------------------------------");
        System.out.println("You have successfully Entered to the queue. Now You can purchase your Tickets.");
        System.out.println("Your Queue Number: ----- " + TicketQueue.queueNumber + "\n\n");

    }


    public static void TwoDayTickets(int day1, int day2, int tickets) {
        Scanner scanner2 = new Scanner(System.in);

        if (tickets == 0)
        {
            System.out.println("Number of tickets can not be 0.");
        }
        else if (tickets > 2) {
            System.out.println("You can buy one ticket or maximum two tickets.");
        }
        else
        {
            System.out.println("Participation Days: ");

            if (tickets == 1) {
                System.out.println("1 - Day " + day1);
                System.out.println("2 - Day " + day2);

                System.out.println("Choose the relevant number : ");
                int days = scanner2.nextInt();
                switch (days) {
                    case 1 -> OneDayTickets(day1);
                    case 2 -> OneDayTickets(day2);
                    default -> System.out.println("Invalid Input.");
                }
            } else {
                System.out.println("Day " + day1 + " and Day " + day2);


                System.out.print("Name : ");
                String name = scanner2.next();

                if (day1 == 1) {
                    TicketQueueD1.enqueue(1, 20, 1, "Day 1", name);
                    TicketQueueD1.sizeD1 = TicketQueueD1.sizeD1 + 1;
                }
                if (day1 == 2) {
                    TicketQueueD2.enqueue(1, 20, 1, "Day 2", name);
                    TicketQueueD2.sizeD2 = TicketQueueD2.sizeD2 + 1;
                }
                if (day1 == 3) {
                    TicketQueueD3.enqueue(1, 20, 1, "Day 3", name);
                    TicketQueueD3.sizeD3 = TicketQueueD3.sizeD3 + 1;
                }
                if (day2 == 1) {
                    TicketQueueD1.enqueue(1, 20, 1, "Day 1", name);
                    TicketQueueD1.sizeD1 = TicketQueueD1.sizeD1 + 1;
                }
                if (day2 == 2) {
                    TicketQueueD2.enqueue(1, 20, 1, "Day 2", name);
                    TicketQueueD2.sizeD2 = TicketQueueD2.sizeD2 + 1;
                }
                if (day2 == 3) {
                    TicketQueueD3.enqueue(1, 20, 1, "Day 3", name);
                    TicketQueueD3.sizeD3 = TicketQueueD3.sizeD3 + 1;
                }

                TicketQueue.enqueue(tickets, 20*2, tickets, "Day " + day1 + " , " + "Day " + day2, name);
                System.out.println("-------------------------------------------------------------------");
                System.out.println("You have successfully Entered to the queue. Now You can purchase your Tickets.");
                System.out.println("Your Queue Number: ----- " + TicketQueue.queueNumber + "\n\n");
            }
        }
    }


    public static void buyTicket() {
        if (TicketQueue.front == null) {
            System.out.println("------ No Tickets requested. Please request. ------");
        } else {

            TicketQueue.ticketDetails();

            System.out.println("Conform your payment: ");
            Scanner scanner = new Scanner(System.in);
            String response = scanner.next();

            if (response.equals("yes")) {
                TicketQueue.dequeue();
                displayTicket(TicketQueue.date());
                System.out.println("You have successfully purchase your Tickets. Enjoy the show.");
                System.out.println("                 ********************                  \n\n");
            } else if (response.equals("no")) {
                System.out.println("You must pay for the tickets.");
                buyTicket();
            } else {
                System.out.print("Invalid input");
            }
        }
    }

    public static void displayTicket(int noOfDays) {
        for (int i = 0; i < noOfDays; i++) {
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
            System.out.println("*   -------------------                     --------    *");
            TicketQueue.day();
            System.out.println("*   -------------------                     --------    *");
            for (int j = 0; j < 1; j++) {
                System.out.println("*                                                       *");
            }
            System.out.println("*   ------------------------------------------------    *");
            System.out.println("*     The Con Expo-Con/AGG Construction Trade Show.     *");
            System.out.println("*                San Diego, California.                 *");
            System.out.println("*   ------------------------------------------------    *");

            for (int j = 0; j < 1; j++) {
                System.out.println("*                                                       *");
            }
            System.out.println("*              --------------------------               *");
            TicketQueue.name();
            System.out.println("*              --------------------------               *");
            System.out.println("* * * * * * * * * * * * * * * * * * * * * * * * * * * * *\n");
        }
    }
}
