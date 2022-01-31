package ru.netology.repository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.NotFoundException;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
  private ProductRepository repository = new ProductRepository();
  private Book coreJava = new Book();

  Book book1 = new Book(1, "Harry Potter and Half-Blood Prince", 500, "Joanne Rowling", 565, 2005);
  Book book2 = new Book(2, "Harry Potter and the Deathly Hallows", 600, "Joanne Rowling", 774, 2007);
  Book book3 = new Book(3, "Harry Potter and Order of the Phoenix", 500, "Joanne Rowling", 589, 2003);

  TShirt tShirt1 = new TShirt(5, "t-shirt1", 500, "blue", "m");
  TShirt tShirt2 = new TShirt(6, "t-shirt2", 500, "black", "m");

  @BeforeEach
  public void addProduct() {
    repository.save(book1);
    repository.save(book2);
    repository.save(book3);
    repository.save(tShirt1);
    repository.save(tShirt2);
    }

  @Test
  public void removeByExistingId() {
    repository.removeById(2);
    Product product = repository.findById(2);
    assertEquals(null, product);
  }

  @Test
  public void removeByNoExistingId() {
    assertThrows(NotFoundException.class, () -> repository.removeById(7));
    Product product = repository.findById(7);
    assertEquals(null, product);
  }
}
