package homework.bread;

public class Breeder {
    public void breedAnimal(Animal a)
    {
        a.drink();
        a.eat();
        if(a instanceof Dog)
        {
            ((Dog) a).swim();
        }
        if(a instanceof Frog)
            ((Frog) a).swim();
    }

}
