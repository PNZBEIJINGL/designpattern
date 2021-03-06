package com.used.specification;

public class Specification4Or2<T> extends CompositeSpecification2<T> {

    private ISpecification2<T> left;
    private ISpecification2<T> right;

    public Specification4Or2(ISpecification2 left, ISpecification2 right) {
        this.left = left;
        this.right = right;
    }


    public boolean isSatisfiedBy() {
        return left.isSatisfiedBy() || right.isSatisfiedBy();
    }
}
