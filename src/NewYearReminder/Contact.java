package NewYearReminder;

public abstract class Contact {
    String name;
    public Contact(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public abstract void sendMessage();
    public abstract void print();
}