package com.used.specification;

public class NameEqualSpecification extends CompositeSpecification {
    private String name;

    public NameEqualSpecification(String name) {
        this.name = name;
    }

    public boolean isSatisfiedBy(Object candidate) {
        return name.equals(candidate);
    }
}
