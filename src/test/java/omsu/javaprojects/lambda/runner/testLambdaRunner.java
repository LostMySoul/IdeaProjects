package omsu.javaprojects.lambda.runner;

import omsu.javaprojects.lambda.demo.LambdaDemo;
import omsu.javaprojects.lambda.models.Gender;
import omsu.javaprojects.lambda.models.Human;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class testLambdaRunner {
    private final Human[] arr = {
            new Human("AAA", "AAA", "AAA", Gender.MALE, 35),
            new Human("BBB", "BBB", "BBB", Gender.FEMALE, 23),
            new Human("CCC", "CCC", "CCC", Gender.MALE, 13),
            new Human("CCC", "CCC", "CCC", Gender.FEMALE, 44)
    };

    @Test
    public void testLambdaRunLength() {
        assertEquals(LambdaRunner.applyLambda(LambdaDemo.lengthPredicate::apply, "test"), 4);
    }

    @Test
    public void testLambdaRunSymbol() {
        assertEquals(LambdaRunner.applyLambda(LambdaDemo.symbolPredicate::apply, "test"), 't');
    }

    @Test
    public void testLambdaRunWord() {
        assertEquals(LambdaRunner.applyLambda(LambdaDemo.wordPredicate::apply, "test"), 1);
        assertEquals(LambdaRunner.applyLambda(LambdaDemo.wordPredicate::apply, "test, test"), 2);
        assertNull(LambdaRunner.applyLambda(LambdaDemo.wordPredicate::apply, ""));
    }

    @Test
    public void testLambdaRunAge() {
        assertEquals(44, LambdaRunner.applyLambda(LambdaDemo.agePredicate::apply, arr[3]));
    }

    @Test
    public void testLambdaRunSurname() {
        assertEquals(true, LambdaRunner.applyLambda(LambdaDemo.surnamePredicate::apply, arr[2], arr[3]));
        assertEquals(false, LambdaRunner.applyLambda(LambdaDemo.surnamePredicate::apply, arr[0], arr[3]));
    }

    @Test
    public void testLambdaRunFullName() {
        assertEquals(LambdaRunner.applyLambda(LambdaDemo.fullNamePredicate::apply, arr[0]), "AAA AAA AAA");
    }

    @Test
    public void testLambdaRunAgeGrow() {
        assertEquals(14, ((Human) LambdaRunner.applyLambda(LambdaDemo.ageGrowPredicate::apply, arr[2])).getAge());
    }

    @Test
    public void testLambdaRunYoung() {
        assertEquals(true, LambdaRunner.applyLambda(LambdaDemo.youngPredicate::apply, arr[0], arr[1], arr[2], 36));
        assertEquals(false, LambdaRunner.applyLambda(LambdaDemo.youngPredicate::apply, arr[0], arr[1], arr[2], 13));
    }
}
