import java.util.ArrayList;

public class Auction {

    private Player player;
    private ArrayList<Bid> bids;
    private double highestBid;
    private Team highestBidder;
    private boolean closed;

    public Auction(Player player) {
        this.player = player;
        bids = new ArrayList<>();
        highestBid = player.getBasePrice();
        highestBidder = null;
        closed = false;
    }

    public Player getPlayer() {
        return player;
    }

    public double getHighestBid() {
        return highestBid;
    }

    public Team getHighestBidder() {
        return highestBidder;
    }

    public boolean isClosed() {
        return closed;
    }

    public ArrayList<Bid> getBids() {
        return bids;
    }

    public boolean placeBid(Team team, double amount) {

        if (closed) {
            System.out.println("Auction is already closed!");
            return false;
        }

        if (team == null) {
            System.out.println("Invalid team!");
            return false;
        }

        if (amount < highestBid + 10) {
            System.out.println("Bid must be at least 10 more than current bid!");
            return false;
        }

        if (!team.canAfford(amount)) {
            System.out.println("Insufficient team purse!");
            return false;
        }

        if (highestBidder == team) {
            System.out.println("This team already holds the highest bid!");
            return false;
        }

        Bid bid = new Bid(team, amount);

        bids.add(bid);
        highestBid = amount;
        highestBidder = team;

        System.out.println("Bid accepted!");
        System.out.println("Highest Bid: " + highestBid);
        System.out.println("Highest Bidder: " + team.getName());

        return true;
    }

    public AuctionResult closeAuction() {

        if (closed) {
            System.out.println("Auction already closed!");
            return null;
        }

        closed = true;

        if (highestBidder != null) {

            highestBidder.buyPlayer(player, highestBid);

            System.out.println("\nPLAYER SOLD!");
            System.out.println("Player: " + player.getName());
            System.out.println("Team: " + highestBidder.getName());
            System.out.println("Price: " + highestBid);

            return new AuctionResult(
                    player, highestBidder, highestBid, true);
        }

        System.out.println("\nPLAYER UNSOLD: " + player.getName());

        return new AuctionResult(player, null, 0, false);
    }

    public void displayBids() {

        System.out.println("\n===== BID HISTORY =====");

        if (bids.isEmpty()) {
            System.out.println("No bids placed.");
        }

        for (Bid bid : bids) {
            bid.display();
        }
    }
}