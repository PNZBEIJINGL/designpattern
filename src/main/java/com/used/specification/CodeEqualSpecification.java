package com.used.specification;

public class CodeEqualSpecification extends CompositeSpecification {
    private String code;

    public CodeEqualSpecification(String code) {

        this.code = code;
    }

    public boolean isSatisfiedBy(Object candidate) {

        return code.equals(candidate);
    }
}
