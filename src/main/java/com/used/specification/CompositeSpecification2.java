package com.used.specification;

public abstract class CompositeSpecification2<T> implements ISpecification2<T> {


    public abstract boolean isSatisfiedBy();

    public ISpecification2<T> and(ISpecification2<T> specification) {
        return null;
    }

    public ISpecification2<T> or(ISpecification2<T> specification) {
        return new Specification4Or2<T>(this, specification);
    }

    public ISpecification2<T> not(ISpecification2<T> specification) {
        return null;
    }


}
