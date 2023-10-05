package lambda_demo;

@FunctionalInterface
public interface StringTransformer {
    String transform(String string);
}
