package com.used.specification;

public class Specification4Not2<T> extends CompositeSpecification2<T> {

    private ISpecification2<T> specification;

    public Specification4Not2(ISpecification2 specification) {

        this.specification = specification;
    }

    public boolean isSatisfiedBy() {

        return !specification.isSatisfiedBy();
    }

}
