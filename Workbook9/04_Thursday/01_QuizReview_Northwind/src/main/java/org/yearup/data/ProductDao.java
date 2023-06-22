package org.yearup.data;

import org.yearup.models.Product;

import java.util.List;

public interface ProductDao
{
    // R - Read
    List<Product> listByCategory(int categoryId);
    List<Product> searchByName(String name);
    Product getById(int productId);

}
