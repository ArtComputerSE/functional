package se.artcomputer.fn;

@FunctionalInterface
public interface Function<From, To> {
    To apply(From okValue);
}