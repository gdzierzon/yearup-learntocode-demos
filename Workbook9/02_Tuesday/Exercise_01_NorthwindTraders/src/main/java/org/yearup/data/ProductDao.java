package org.yearup.data;

import org.yearup.models.Product;

import java.util.List;

public interface ProductDao
{
    Product add(Product product);
    List<Product> getAll();
}
