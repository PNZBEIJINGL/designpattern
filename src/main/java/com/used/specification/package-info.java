package com.used.specification;
/*

规约模式就是一个约束条件，我们在使用仓储进行查询的时候，这时候就会牵涉到很多查询条件，
例如名字包含C#的书名等条件。这样就自然需要引入规约模式了。规约模式的作用可以自由组装业务逻辑元素。
Specification类有一个IsSatisifiedBy函数，用于校验某个对象是否满足该Specification所表达的条件。
多个Specification对象可以组装起来，生成新的Specification对象，这样可以通过组装的方式来定制新的条件。
简单地说，规约模式就是对查询条件表达式用类的形式进行封装


 */
