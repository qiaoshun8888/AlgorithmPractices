package crackingTheCodingInterview.chapter3;

import java.util.LinkedList;
import java.util.Random;

public class AnimalShelter {

	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();
	
	private int order = 0;
	
	public void enqueue(Animal a) {
		a.setOrder(order++);
		if (a instanceof Dog) dogs.add((Dog) a);
		else if (a instanceof Cat) cats.add((Cat) a);
	}
	
	public Animal dequeueAny() throws Exception{
		if (dogs.size() == 0 && cats.size() != 0) return dequeueCat();
		else if (cats.size() == 0 && dogs.size() != 0) return dequeueDog();
		
		if (dogs.size() == 0 && cats.size() == 0) {
			throw new Exception("There is no animal left!");
		}
		
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		return dog.isOlderThan(cat) ? dequeueDog() : dequeueCat();
	}
	
	public Dog dequeueDog() {
		return dogs.poll();
	}
	
	public Cat dequeueCat() {
		return cats.poll();
	}
	
	public static void main(String [] args) throws Exception {
		AnimalShelter as = new AnimalShelter();
		Random rand = new Random();
		for (int i = 0; i < 10; i++) {
			if (rand.nextInt(2) == 0) {
				as.enqueue(new Dog("dog " + i));
			}
			else {
				as.enqueue(new Cat("cat " + i));
			}
		}
		
		for (int i = 0; i < 11; i++) {
			System.out.println("Dequeue animal: " + as.dequeueAny().getName());
		}
	}
}

abstract class Animal {
	private int order;
	protected String name;
	
	public Animal(String n) {
		name = n;
	}
	
	public void setOrder(int o) {
		order = o;
	}
	
	public int getOrder() {
		return order;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isOlderThan(Animal a) {
		return this.order < a.getOrder();
	}
}

class Dog extends Animal {
	
	public Dog(String n) {
		super(n);
	}
}

class Cat extends Animal {
	
	public Cat(String n) {
		super(n);
	}
}

