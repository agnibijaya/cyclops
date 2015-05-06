package com.aol.cyclops.comprehensions.comprehenders;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.LongStream;

public class LongStreamComprehender implements Comprehender<LongStream> {

	@Override
	public Object filter(LongStream t, Predicate p) {
		return t.filter(test->p.test(test));
	}

	@Override
	public Object map(LongStream t, Function fn) {
		return t.map(i->(long)fn.apply(i));
	}

	@Override
	public LongStream flatMap(LongStream t, Function fn) {
		return t.flatMap( i-> (LongStream)fn.apply(i));
	}

	@Override
	public boolean instanceOfT(Object apply) {
		return apply instanceof LongStream;
	}

	@Override
	public LongStream of(Object o) {
		return LongStream.of((long)o);
	}

}
