package org.yearup.data;

import org.yearup.models.Product;

import java.util.HashMap;
import java.util.List;

public class SimpleProductDao implements ProductDao
{
    private List<Product> products;
    private int counter = 1001;


    @Override
    public Product add(Product product)
    {
        product.setProductId(products.size() + 1);
        products.add(product.getProductId(), product);

        return product;
    }

    @Override
    public List<Product> getAll()
    {
        return products;
    }
}
