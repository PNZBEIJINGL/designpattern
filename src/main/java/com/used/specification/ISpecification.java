package com.used.specification;

/**
 * 规约定义接口
 *
 * @param <T>
 */
public interface ISpecification<T> {

    boolean isSatisfiedBy(T candidate);

    ISpecification<T> and(ISpecification<T> specification);

    ISpecification<T> or(ISpecification<T> specification);

    ISpecification<T> not(ISpecification<T> specification);
}
