package com.used.specification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainTest {


    public static void main(String[] args) {

        NameEqualSpecification ne1 = new NameEqualSpecification("DVB");
        NameEqualSpecification ne2 = new NameEqualSpecification("Dab");
        CodeEqualSpecification ce = new CodeEqualSpecification("1001");

        Product product1 = new Product();
        product1.setCode("1001");
        product1.setName("DVB");
        Product product2 = new Product();
        product2.setCode("1002");
        product2.setName("Dab");
        Product product3 = new Product();
        product3.setCode("1003");
        product3.setName("IPTV");

        List<Product> products = Arrays.asList(product1, product2, product3);
        System.out.println("产品编码满足1001");
        for (Product product : products) {
            if (new CodeEqualSpecification("1001").isSatisfiedBy(product.getCode())) {
                System.out.println(product);
            }
        }

        System.out.println("产品名称需要满足2个条件 Dvb dab");
        for (Product product : products) {
            if (new Specification4Or<String>(ne1, ne2).isSatisfiedBy(product.getName())) {
                System.out.println(product);
            }
        }


    }

}
