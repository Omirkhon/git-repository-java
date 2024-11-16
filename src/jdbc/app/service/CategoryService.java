package jdbc.app.service;

import jdbc.app.dao.CategoryDao;
import jdbc.app.model.Category;

import java.util.Scanner;

public class CategoryService {
    private final CategoryDao categoryDao;
    private final Scanner scanner;

    public CategoryService(Scanner scanner) {
        this.scanner = scanner;
        this.categoryDao = new CategoryDao();
    }

    public void findAll() {
        categoryDao.findAll().forEach(System.out::println);
    }

    public void findById() {
        System.out.print("Введите идентификатор категорий: ");
        int id = Integer.parseInt(scanner.nextLine());

        Category category = categoryDao.findById(id);
        if (category == null) {
            System.out.println("Категория не найдена");
        } else {
            System.out.println(category);
        }
    }

    public void createCategory() {
        System.out.print("Введите название категории: ");
        String name = scanner.nextLine();

        System.out.println(categoryDao.createCategory(new Category(0, name)));
    }
}
