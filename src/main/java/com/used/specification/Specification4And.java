package com.used.specification;

public class Specification4And<T> extends CompositeSpecification<T> {

    private ISpecification<T> left;
    private ISpecification<T> right;

    public Specification4And(ISpecification left, ISpecification right) {
        this.left = left;
        this.right = right;
    }

    public boolean isSatisfiedBy(T candidate) {
        return this.left.isSatisfiedBy(candidate) && this.right.isSatisfiedBy(candidate);
    }

}
