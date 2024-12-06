package StacksAndQueues;

import java.util.LinkedList;

public class Q6 {

    public static void main(String[] args) {
        AnimalQueue shelter = new AnimalQueue();

        // إضافة حيوانات
        shelter.enqueue(new Dog("Dog1"));
        shelter.enqueue(new Cat("Cat1"));
        shelter.enqueue(new Dog("Dog2"));
        shelter.enqueue(new Cat("Cat2"));

        // طباعة القوائم بعد الإدخال
        System.out.println("After enqueue:");
        shelter.printQueues();

        // إخراج أقدم حيوان
        System.out.println("\nDequeueAny: " + shelter.dequeueAny().getName());

        // إخراج أقدم قطة
        System.out.println("DequeueCat: " + shelter.dequeueCats().getName());

        // إخراج أقدم كلب
        System.out.println("DequeueDog: " + shelter.dequeueDogs().getName());

        // طباعة القوائم بعد الإخراج
        System.out.println("\nAfter dequeues:");
        shelter.printQueues();
    }
}

// تعريف الكلاس الأساسي Animal
abstract class Animal {
    private int order; // الترتيب الزمني (Timestamp)
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public int getOrder() {
        return order;
    }

    // مقارنة ترتيب حيوانين لمعرفة الأقدم
    public boolean isOlderThan(Animal other) {
        return this.order < other.getOrder();
    }

    public String getName() {
        return name;
    }
}

// تعريف الكلاس Dog المشتق من Animal
class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }
}

// تعريف الكلاس Cat المشتق من Animal
class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }
}

// إدارة الحيوانات باستخدام كلاس AnimalQueue
class AnimalQueue {
    private LinkedList<Dog> dogs = new LinkedList<>();
    private LinkedList<Cat> cats = new LinkedList<>();
    private int order = 0; // رقم زمني فريد

    // إدخال حيوان جديد
    public void enqueue(Animal animal) {
        animal.setOrder(order); // تعيين رقم زمني للحيوان
        order++;

        if (animal instanceof Dog) {
            dogs.addLast((Dog) animal);
        } else if (animal instanceof Cat) {
            cats.addLast((Cat) animal);
        }
    }

    // إخراج الحيوان الأقدم
    public Animal dequeueAny() {
        if (dogs.isEmpty()) {
            return dequeueCats();
        } else if (cats.isEmpty()) {
            return dequeueDogs();
        }

        Dog oldestDog = dogs.peek();
        Cat oldestCat = cats.peek();

        if (oldestDog.isOlderThan(oldestCat)) {
            return dequeueDogs();
        } else {
            return dequeueCats();
        }
    }

    // إخراج أقدم كلب
    public Dog dequeueDogs() {
        return dogs.poll(); // إزالة أول عنصر من قائمة الكلاب
    }

    // إخراج أقدم قطة
    public Cat dequeueCats() {
        return cats.poll(); // إزالة أول عنصر من قائمة القطط
    }

    // طباعة الحيوانات المتبقية (للتوضيح فقط)
    public void printQueues() {
        System.out.println("Dogs Queue:");
        for (Dog dog : dogs) {
            System.out.println("- " + dog.getName() + " (Order: " + dog.getOrder() + ")");
        }

        System.out.println("Cats Queue:");
        for (Cat cat : cats) {
            System.out.println("- " + cat.getName() + " (Order: " + cat.getOrder() + ")");
        }
    }
}
