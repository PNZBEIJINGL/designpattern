package com.used.specification;

import java.util.ArrayList;
import java.util.List;

public class MainTest {


    public static void main(String[] args) {

        NameEqualSpecification ne1=new NameEqualSpecification("DVB");
        NameEqualSpecification ne2=new NameEqualSpecification("Dab");
        CodeEqualSpecification ce=new CodeEqualSpecification("1001");

        Product product=new Product();
        product.setCode("1001");
        product.setName("DVB");
        boolean s=new Specification4Or<String>(ne1,ne2).isSatisfiedBy(product.getName());
        System.out.println(s);


    }

}
