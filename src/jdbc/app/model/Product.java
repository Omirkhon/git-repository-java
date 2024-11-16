package jdbc.app.model;

public class Product {
    long id;
    String name;
    long price;
    Category category;

    public Product (long id, String name, long price, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString () {
        return this.id + " " + this.name + " "
                + this.price + "$ " + this.category.id + " " + this.category.name;
    }
}
