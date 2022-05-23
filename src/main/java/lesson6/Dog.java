package lesson6;

public class Dog extends Animal {

    final int MAX_RUN_DISTANCE = 500;
    final int MAX_SWIM_DISTANCE = 10;

    @Override
    public boolean run(int distance) {
        return (distance <= MAX_RUN_DISTANCE) ;
    }

    @Override
    public boolean swim(int distance) {
        return (distance <= MAX_SWIM_DISTANCE) ;
    }
}
