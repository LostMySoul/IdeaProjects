package omsu.javaprojects.lambda.runner;

import omsu.javaprojects.lambda.models.Human;
import omsu.javaprojects.lambda.runner.func.FourFunction;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaRunner {

    public static Object applyLambda(Function<String, Object> fn, String ctx) {
        return fn.apply(ctx);
    }
    public static Object applyLambda(Function<Human, Object> fn, Human ctx) {
        return fn.apply(ctx);
    }
    public static Object applyLambda(BiFunction<Human, Human, Object> fn, Human ctx1, Human ctx2) {
        return fn.apply(ctx1, ctx2);
    }
    public static Object applyLambda(FourFunction<Human, Human, Human, Integer, Object> fn, Human ctx1, Human ctx2,
                                     Human ctx3, Integer ctx4) {
        return fn.apply(ctx1, ctx2, ctx3, ctx4);
    }

}
