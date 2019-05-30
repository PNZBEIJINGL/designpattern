package com.used.specification;

import java.util.List;

public interface IProductRespository {

    Product getByCode(String code);

    Product getByName(String name);

    List<Product> getNewProducts();
}
