package com.epam.rd.autotasks.max;

import java.util.Optional;
import java.util.OptionalInt;

public class MaxMethod {
    public static OptionalInt max(int[] values) {
    	Optional<int[]> array = Optional.ofNullable(values).filter(t -> t.length > 0);
    	if(array.isEmpty()) return OptionalInt.empty();    	
    	
    	int max = Integer.MIN_VALUE;
    	for (int i : values) {
			if(i > max) {
				max =  i;
			}
		}
    	
        return OptionalInt.of(max);
    }
}
