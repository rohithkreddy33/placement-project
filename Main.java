import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AuctionService service = new AuctionService();
        ReportService report = new ReportService();

        service.addPlayer(new Player("P1", "Virat Kohli", "Batsman", 200));
        service.addPlayer(new Player("P2", "Jasprit Bumrah", "Bowler", 150));
        service.addPlayer(new Player("P3", "MS Dhoni", "Wicket Keeper", 100));
        service.addPlayer(new Player("P4", "Hardik Pandya", "All Rounder", 150));
        service.addPlayer(new Player("P5", "Rohit Sharma", "Batsman", 200));

        service.addTeam(new Team("T1", "RCB", 1000));
        service.addTeam(new Team("T2", "CSK", 1000));
        service.addTeam(new Team("T3", "MI", 1000));
        service.addTeam(new Team("T4", "KKR", 1000));

        int choice;

        do {
            System.out.println("\n===== IPL CRICKET AUCTION =====");
            System.out.println("1. View Players");
            System.out.println("2. View Teams");
            System.out.println("3. Start Auction");
            System.out.println("4. View Auction Results");
            System.out.println("5. Team Reports");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    service.showPlayers();
                    break;

                case 2:
                    service.showTeams();
                    break;

                case 3:

                    System.out.print("Enter Player ID: ");
                    String playerId = sc.next();

                    Auction auction = service.startAuction(playerId);

                    if (auction != null) {

                        int bidChoice;

                        do {
                            System.out.println("\n--- LIVE AUCTION ---");
                            System.out.println("Player: " +
                                    auction.getPlayer().getName());
                            System.out.println("Current Bid: " +
                                    auction.getHighestBid());

                            System.out.println("1. Place Bid");
                            System.out.println("2. View Bid History");
                            System.out.println("3. Close Auction");
                            System.out.print("Enter choice: ");

                            bidChoice = sc.nextInt();

                            if (bidChoice == 1) {

                                System.out.print("Enter Team ID: ");
                                String teamId = sc.next();

                                Team team = service.findTeam(teamId);

                                if (team == null) {
                                    System.out.println("Team not found!");
                                    continue;
                                }

                                System.out.print("Enter Bid Amount: ");
                                double amount = sc.nextDouble();

                                auction.placeBid(team, amount);
                            }

                            else if (bidChoice == 2) {
                                auction.displayBids();
                            }

                            else if (bidChoice == 3) {

                                AuctionResult result =
                                        auction.closeAuction();

                                service.saveResult(result);
                            }

                            else {
                                System.out.println("Invalid choice!");
                            }

                        } while (bidChoice != 3);
                    }

                    break;

                case 4:
                    service.showAuctionResults();
                    break;

                case 5:
                    report.showAllReports(service);
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}