interface Observer {
    fun update(message: String)
}

class Subscriber(private val name: String) : Observer {
    override fun update(message: String) {
        println("Subscriber $name received message: $message")
    }
}

class Publisher {
    private val observers = mutableListOf<Observer>()

    fun subscribe(observer: Observer) {
        observers.add(observer)
    }

    fun unsubscribe(observer: Observer) {
        observers.remove(observer)
    }

    fun notifyObservers(message: String) {
        for (observer in observers) {
            observer.update(message)
        }
    }

    fun publish(message: String) {
        println("Publishing message: $message")
        notifyObservers(message)
    }
}

fun main() {
    val publisher = Publisher()

    val subscriber1 = Subscriber("Alice")
    val subscriber2 = Subscriber("Bob")

    publisher.subscribe(subscriber1)
    publisher.subscribe(subscriber2)

    publisher.publish("The world will end in 2000!")
}

