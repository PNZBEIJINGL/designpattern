package com.thread.future.pattern;

import java.util.Random;

/**
 * 处理类:真正操作数据的类
 */
public class OrderManager implements IOrder {

    private Product product = null;

    public OrderManager(String request) {
        doPrepare();
        this.product = createProduct(request);
    }

    public Product getProduct() {
        return product;
    }

    private void doPrepare() {
        try {
            Thread.sleep((new Random()).nextInt(5) * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private Product createProduct(String request) {
        Product product = null;
        if ("IMac".equals(request)) {
            product = new ProductIMac();
            product.setName("IMac");
        } else {
            product = new ProductIPhone();
            product.setName("IPhone");
        }
        return product;
    }
}
