import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Philosopher extends Thread {
    private final Object leftFork;
    private final Object rightFork;
    private final Label statusLabel;
    private final Circle visualRepresentation;

    public Philosopher(String name, Object leftFork, Object rightFork, Label statusLabel, Circle visualRepresentation) {
        super(name);
        this.leftFork = leftFork;
        this.rightFork = rightFork;
        this.statusLabel = statusLabel;
        this.visualRepresentation = visualRepresentation;
    }

    private void doAction(String action) throws InterruptedException {
        statusLabel.setText(action);
        if (action.contains("Eating")) {
            visualRepresentation.setFill(Color.GREEN);
        } else if (action.contains("Thinking")) {
            visualRepresentation.setFill(Color.BLUE);
        } else {
            visualRepresentation.setFill(Color.YELLOW);
        }
        Thread.sleep((int) (Math.random() * 100));
    }

    @Override
    public void run() {
        try {
            while (true) {
                doAction("Thinking");
                synchronized (leftFork) {
                    doAction("Picked up left fork");
                    synchronized (rightFork) {
                        doAction("Picked up right fork - eating");
                        doAction("Put down right fork");
                    }
                    doAction("Put down left fork");
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
