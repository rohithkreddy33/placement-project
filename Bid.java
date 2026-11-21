public class Bid {
    private Team team;
    private double amount;

    public Bid(Team team, double amount) {
        this.team = team;
        this.amount = amount;
    }

    public Team getTeam() {
        return team;
    }

    public double getAmount() {
        return amount;
    }

    public void display() {
        System.out.println(
            team.getName() + " bid: " + amount
        );
    }
}