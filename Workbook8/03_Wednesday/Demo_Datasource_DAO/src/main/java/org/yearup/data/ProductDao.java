package org.yearup.data;

import org.yearup.models.Product;

import java.util.List;

public interface ProductDao
{
    List<Product> listByCategory(int categoryId);
    Product getById(int productId);
}
