import java.util.ArrayList;

public class AuctionService {

    private ArrayList<Player> players;
    private ArrayList<Team> teams;
    private ArrayList<AuctionResult> results;

    public AuctionService() {
        players = new ArrayList<>();
        teams = new ArrayList<>();
        results = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public Player findPlayer(String id) {
        for (Player p : players) {
            if (p.getId().equalsIgnoreCase(id)) {
                return p;
            }
        }
        return null;
    }

    public Team findTeam(String id) {
        for (Team t : teams) {
            if (t.getId().equalsIgnoreCase(id)) {
                return t;
            }
        }
        return null;
    }

    public void showPlayers() {
        System.out.println("\n===== PLAYER LIST =====");

        for (Player p : players) {
            p.display();
        }
    }

    public void showTeams() {
        System.out.println("\n===== TEAM LIST =====");

        for (Team t : teams) {
            t.display();
        }
    }

    public Auction startAuction(String playerId) {

        Player player = findPlayer(playerId);

        if (player == null) {
            System.out.println("Player not found!");
            return null;
        }

        if (player.isSold()) {
            System.out.println("Player already sold!");
            return null;
        }

        System.out.println("\nAuction started for " + player.getName());
        System.out.println("Base Price: " + player.getBasePrice());

        return new Auction(player);
    }

    public void saveResult(AuctionResult result) {

        if (result != null) {
            results.add(result);
        }
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public ArrayList<AuctionResult> getResults() {
        return results;
    }

    public void showAuctionResults() {

        System.out.println("\n===== AUCTION RESULTS =====");

        for (AuctionResult result : results) {
            result.display();
        }
    }
}