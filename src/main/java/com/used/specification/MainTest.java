package com.used.specification;

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

        System.out.println("产品名称需要满足2个条件 名称 Dvb 或者 dab");
        for (Product product : products) {
            if (new Specification4Or<String>(ne1, ne2).isSatisfiedBy(product.getName())) {
                System.out.println(product);
            }
        }
        System.out.println("产品名称需要满足2个条件 名称 Dvb 或者 dab");
        for (Product product : products) {
            if (ne1.or(ne2).isSatisfiedBy(product.getName())) {
                System.out.println(product);
            }
        }

        //这种方式发现组合不好用
        //new CodeEqualSpecification("1001").and(new NameEqualSpecification("DVB")).isSatisfiedBy(product)
        //修改ISpecification2
        System.out.println("产品名称需要满足2个条件 编码 1001 或者 IPTV");
        for (Product product : products) {
            //1成立 或者 2成立
            if (new EqualSpecification2("1001", product.getCode())
                    .or(new EqualSpecification2("IPTV", product.getName())).isSatisfiedBy()) {
                System.out.println(product);
            }
        }
    }

}
