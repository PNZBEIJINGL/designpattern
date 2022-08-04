package com.thread.future.pattern;

/**
 * 接受请求方,为每一请求创建一个FutureOrder对象，该对象用于提取货物
 */
public class AppleStore {

    public IOrder createOrder(final String request) {
        //创建客户订单
        final FutureOrder order = new FutureOrder();
        new Thread() {
            public void run() {
                OrderManager realOrder = new OrderManager(request);
                order.setRealdata(realOrder);
            }
        }.start();
        return order;
    }
}
