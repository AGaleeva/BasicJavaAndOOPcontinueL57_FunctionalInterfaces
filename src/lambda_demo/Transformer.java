package lambda_demo;

@FunctionalInterface
public interface Transformer<T> {
    T transform(T t);
}
