import java.util.ArrayList;
import java.util.List;

interface Observer {
    void update(String message);
}

class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    public void update(String message) {
        System.out.println("[" + name + "] Received update: " + message);
    }
}

class Publisher {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer o) {
        observers.add(o);
    }

    public void unsubscribe(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }

    public void publish(String message) {
        System.out.println("Publisher sends: " + message);
        notifyObservers(message);
    }
}

public class Main {
    public static void main(String[] args) {
        Subscriber alice = new Subscriber("Alice");
        Subscriber bob = new Subscriber("Bob");

        Publisher publisher = new Publisher();
        publisher.subscribe(alice);
        publisher.subscribe(bob);

        publisher.publish("Java 21 Released!");
    }
}
