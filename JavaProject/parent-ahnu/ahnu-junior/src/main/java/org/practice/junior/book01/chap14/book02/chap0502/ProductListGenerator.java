package org.practice.junior.book01.chap14.book02.chap0502;

import java.util.ArrayList;
import java.util.List;

public class ProductListGenerator {

    public List<Product> generate(int size) {
        List<Product> ret = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Product product = new Product();
            product.setName("Product " + i);
            product.setPrice(10);
            ret.add(product);
        }
        return ret;
    }
}
