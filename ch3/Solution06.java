package codingbootcamp;

import java.util.*;

class Animal {
    static int CAT = 1;
    static int DOG = 2;
    public int type;
    public String name;
    Animal (String name, int type) {
        this.type = type;
        this.name = name;
    }
}

class AnimalShelter {
    private LinkedList<Animal> any = new LinkedList<Animal>();
    private LinkedList<Animal> dog = new LinkedList<Animal>();
    private LinkedList<Animal> cat = new LinkedList<Animal>();

    public boolean enqueue(Animal animal){ 
        if (animal == null) return false;
        any.addLast(animal);
        if (animal.type == Animal.DOG)
            dog.addLast(animal);
        else
            cat.addLast(animal);
        return true;
    }

    public Animal dequeueAny(){
        Animal animal = any.pollFirst();
        if (animal == null) return null;
        if (animal.type == Animal.DOG)
            dog.pollFirst();
        else
            cat.pollFirst();
        return animal;
    }

    public Animal dequeueCat(){
        Animal animal = cat.pollFirst();
        if (animal != null)
            any.remove(animal);
        return animal;
    }

    public Animal dequeueDog(){
        Animal animal = dog.pollFirst();
        if (animal != null)
            any.remove(animal);
        return animal;
    }
}
public class codingbootcamp {
	public static void main(String[] args) {
        AnimalShelter shelter = new AnimalShelter();
        shelter.enqueue(new Animal("dogge 1", Animal.DOG));
        shelter.enqueue(new Animal("dogge 2", Animal.DOG));
        shelter.enqueue(new Animal("dogge 3", Animal.DOG));
        shelter.enqueue(new Animal("kitty 1", Animal.CAT));
        shelter.enqueue(new Animal("kitty 2", Animal.CAT));
        System.out.println(shelter.dequeueAny().name);
        System.out.println(shelter.dequeueCat().name);
        System.out.println(shelter.dequeueDog().name);
        System.out.println(shelter.dequeueAny().name);
        System.out.println(shelter.dequeueAny().name);
        System.out.println(shelter.dequeueAny());
    }
}