public class AuctionResult {

    private Player player;
    private Team winner;
    private double soldPrice;
    private boolean sold;

    public AuctionResult(Player player, Team winner,
                         double soldPrice, boolean sold) {
        this.player = player;
        this.winner = winner;
        this.soldPrice = soldPrice;
        this.sold = sold;
    }

    public Player getPlayer() {
        return player;
    }

    public Team getWinner() {
        return winner;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public boolean isSold() {
        return sold;
    }

    public void display() {
        if (sold) {
            System.out.println(player.getName() +
                    " SOLD to " + winner.getName() +
                    " for " + soldPrice);
        } else {
            System.out.println(player.getName() + " UNSOLD");
        }
    }
}