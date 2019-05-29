package com.used.specification;

public abstract class CompositeSpecification<T> implements ISpecification<T> {


    public abstract boolean isSatisfiedBy(T candidate);

    /**
     * @param specification
     * @return
     */
    public ISpecification<T> and(ISpecification<T> specification) {
        return new Specification4And<T>(this, specification);
    }

    /**
     * @param specification
     * @return
     */
    public ISpecification<T> or(ISpecification<T> specification) {
        return new Specification4Or<T>(this, specification);
    }

    /**
     * @param specification
     * @return
     */
    public ISpecification<T> not(ISpecification<T> specification) {
        return new Specification4Not<T>(specification);
    }
}
