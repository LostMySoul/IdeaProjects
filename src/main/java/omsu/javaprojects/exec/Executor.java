package omsu.javaprojects.exec;

public class Executor implements Executable {
    @Override
    public void execute() {
        System.out.println("Executed from " + this.getClass().getName());
    }
}
