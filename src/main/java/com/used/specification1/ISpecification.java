package com.used.specification1;

import java.util.Map;
import java.util.Set;

public interface ISpecification {

	boolean isSatisfied(Map<String, Object> data);

	Set<String> getSpecificationKey();
}
