package jdbc.app.service;

import jdbc.app.dao.CategoryDao;
import jdbc.app.dao.ProductDao;
import jdbc.app.model.Product;

import java.util.Scanner;

public class ProductService {
    private final ProductDao productDao;
    private final Scanner scanner;
    private final CategoryDao categoryDao = new CategoryDao();
    public ProductService(Scanner scanner) {
        this.scanner = scanner;
        this.productDao = new ProductDao();
    }

    public void findAll() {
        productDao.findAll().forEach(System.out::println);
    }

    public void findById() {
        System.out.print("Введите идентификатор товара: ");
        int id = Integer.parseInt(scanner.nextLine());

        Product product = productDao.findById(id);
        if (product == null) {
            System.out.println("Товар не найден");
        } else {
            System.out.println(product);
        }
    }

    public void createProduct() {
        System.out.print("Введите название товара: ");
        String name = scanner.nextLine();
        System.out.print("Введите цену товара: ");
        long price = scanner.nextLong();
        System.out.print("Введите ID категории: ");
        long categoryID = scanner.nextInt();

        System.out.println(productDao.createProduct(new Product(0, name, price, categoryDao.findById(categoryID))));
    }

    public void updateProduct() {
        System.out.print("Введите идентификатор товара: ");
        long id = scanner.nextLong();
        System.out.print("Введите название товара: ");
        String name = scanner.nextLine();
        System.out.print("Введите цену товара: ");
        long price = scanner.nextLong();
        System.out.print("Введите ID категории: ");
        long categoryID = scanner.nextInt();

        System.out.println(productDao.updateProduct(new Product(id, name, price, categoryDao.findById(categoryID))));
    }

    public void deleteProduct() {
        System.out.print("Введите идентификатор товара: ");
        long id = scanner.nextLong();
        productDao.deleteProduct(id);
    }
}
