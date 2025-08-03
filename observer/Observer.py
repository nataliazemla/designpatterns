from abc import ABC, abstractmethod

class Observer(ABC):
    @abstractmethod
    def update(self, message):
        pass

class Subscriber(Observer):
    def __init__(self, name):
        self.name = name

    def update(self, message):
        print(f"[{self.name}] Received update: {message}")

class Publisher:
    def __init__(self):
        self.observers = []

    def subscribe(self, observer):
        self.observers.append(observer)

    def unsubscribe(self, observer):
        self.observers.remove(observer)

    def notify_observers(self, message):
        for observer in self.observers:
            observer.update(message)

    def publish(self, message):
        print(f"Publisher sends: {message}")
        self.notify_observers(message)

# Example usage
alice = Subscriber("Alice")
bob = Subscriber("Bob")
publisher = Publisher()

publisher.subscribe(alice)
publisher.subscribe(bob)

publisher.publish("New Python tips released!")