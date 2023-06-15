package org.yearup.data;

import org.yearup.models.Product;

import java.util.List;

public interface ProductDao
{
    // R - Read
    List<Product> listByCategory(int categoryId);
    Product getById(int productId);

    // C - Create
    Product create(Product product);

    // U - Update
    void update(int productId, Product product);

    // D - Delete
    void delete(int productId);
}
