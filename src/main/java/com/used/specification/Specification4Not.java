package com.used.specification;

public class Specification4Not<T> extends CompositeSpecification<T> {

    private ISpecification<T> specification;

    public Specification4Not(ISpecification specification) {
        this.specification = specification;
    }

    public boolean isSatisfiedBy(T candidate) {

        return !specification.isSatisfiedBy(candidate);
    }

}
