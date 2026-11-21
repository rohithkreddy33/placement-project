public class Player {
    private String id;
    private String name;
    private String role;
    private double basePrice;
    private boolean sold;

    public Player(String id, String name, String role, double basePrice) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.basePrice = basePrice;
        this.sold = false;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public void display() {
        System.out.println(
            id + " | " + name + " | " + role +
            " | Base Price: " + basePrice
        );
    }
}