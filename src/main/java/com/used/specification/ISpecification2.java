package com.used.specification;

/**
 * 规约定义接口
 *
 * @param <T>
 */
public interface ISpecification2<T> {

    //boolean isSatisfiedBy(T candidate);
    //替换
    boolean isSatisfiedBy();

    ISpecification2<T> and(ISpecification2<T> specification);

    ISpecification2<T> or(ISpecification2<T> specification);

    ISpecification2<T> not(ISpecification2<T> specification);
}
