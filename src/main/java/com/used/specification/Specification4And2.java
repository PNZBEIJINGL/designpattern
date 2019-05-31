package com.used.specification;

public class Specification4And2<T> extends CompositeSpecification2<T> {

    private ISpecification2<T> left;
    private ISpecification2<T> right;

    public Specification4And2(ISpecification2 left, ISpecification2 right) {
        this.left = left;
        this.right = right;
    }

    public boolean isSatisfiedBy() {
        return this.left.isSatisfiedBy() && this.right.isSatisfiedBy();
    }

}
