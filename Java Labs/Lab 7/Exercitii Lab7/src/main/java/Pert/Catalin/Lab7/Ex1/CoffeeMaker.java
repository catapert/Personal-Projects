package Pert.Catalin.Lab7.Ex1;

public class CoffeeMaker {
    private final int limitOfCoffees;

    public CoffeeMaker(int limitOfCoffees) {
        this.limitOfCoffees = limitOfCoffees;
    }

    Coffee makeCoffee() throws Exception {
        System.out.println("Make a coffee");
        int t = (int)(Math.random()*100);
        int c = (int)(Math.random()*100);
        if (Coffee.getCountCoffees() == limitOfCoffees){
            throw new Exception("Too much caffeine");
        }
        Coffee coffee = new Coffee(t,c);
        return coffee;
    }

}//.class