package jdbc.app;

import jdbc.app.service.CategoryService;
import jdbc.app.service.ProductService;

import java.util.Scanner;

public class App {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        CategoryService categoryService = new CategoryService(scanner);
        ProductService productService = new ProductService(scanner);

        while (true) {
            switch (menu()) {
                case 1 -> categoryService.findAll();
                case 2 -> categoryService.findById();
                case 3 -> productService.findAll();
                case 4 -> productService.findById();
                case 5 -> categoryService.createCategory();
                case 6 -> productService.createProduct();
                case 7 -> productService.updateProduct();
                case 8 -> productService.deleteProduct();
                default -> {
                    scanner.close();
                    return;
                }
            }
        }
    }

    static int menu() {
        System.out.println("""
                1. Получить список категорий
                2. Получить категорию по идентификатору
                3. Получить список товаров
                4. Получить товар по идентификатору
                5. Создать категорию
                6. Создать товар
                7. Обновление товара
                8. Удаление товара""");
        return Integer.parseInt(scanner.nextLine());
    }
}

