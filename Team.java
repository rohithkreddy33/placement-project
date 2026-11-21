import java.util.ArrayList;

public class Team {

    private String id;
    private String name;
    private double purse;
    private ArrayList<Player> squad;

    private static final int MAX_SQUAD_SIZE = 25;

    public Team(String id, String name, double purse) {
        this.id = id;
        this.name = name;
        this.purse = purse;
        squad = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPurse() {
        return purse;
    }

    public ArrayList<Player> getSquad() {
        return squad;
    }

    public boolean canAfford(double amount) {
        return amount <= purse;
    }

    public boolean buyPlayer(Player player, double amount) {

        if (squad.size() >= MAX_SQUAD_SIZE) {
            System.out.println("Team squad is full!");
            return false;
        }

        if (!canAfford(amount)) {
            System.out.println("Insufficient purse!");
            return false;
        }

        purse -= amount;
        squad.add(player);
        player.setSold(true);

        return true;
    }

    public void display() {

        System.out.println("\nTeam: " + name);
        System.out.println("Team ID: " + id);
        System.out.println("Remaining Purse: " + purse);
        System.out.println("Squad Size: " + squad.size());

        System.out.println("Players:");

        for (Player player : squad) {
            System.out.println("- " + player.getName()
                    + " (" + player.getRole() + ")");
        }
    }
}