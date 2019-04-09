package machine;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CoffeeMachine {
    private int milk;
    private int water;
    private int coffee;
    private int disposableCups;
    private int money;
    private boolean running;

    private CoffeeMachine(int water, int milk, int coffee, int cups, int money) {
        this.milk = milk;
        this.disposableCups = cups;
        this.water = water;
        this.coffee = coffee;
        this.money = money;
        this.running = true;
    }

    private String getState() {
        return String.format("The coffee machine has: \n%d of water\n%d of milk\n%d of coffee beans" +
                "\n%d of disposable cups\n%d of money", water, milk, coffee, disposableCups, money);
    }

    private void addDisposals(int water, int milk, int coffee, int disposableCups) {
        this.water += water;
        this.milk += milk;
        this.coffee += coffee;
        this.disposableCups += disposableCups;
    }

    public static void main(String[] args) {
        CoffeeMachine myMachine = new CoffeeMachine(400, 540, 120, 9, 550);
        Scanner scanner = new Scanner(System.in);
        OperationalBuilder operationalBuilder = myMachine.new OperationalBuilder(scanner);

        while (myMachine.running) {
            System.out.print("\nWrite action (buy, fill, take, remaining, exit): ");
            String action = scanner.next().trim();
            operationalBuilder.getOperational(action).perform();
            System.out.println();
        }
    }

    interface Operational {
        void perform();
    }

    abstract class CoffeeMaker implements Operational {

        int waterForOneCup;
        int milkForOneCup;
        int coffeeForOneCup;
        int cost;

        private CoffeeMaker(int waterForOneCup, int coffeeForOneCup, int milkForOneCup, int cost) {
            this.waterForOneCup = waterForOneCup;
            this.milkForOneCup = milkForOneCup;
            this.coffeeForOneCup = coffeeForOneCup;
            this.cost = cost;
        }

        @Override
        public void perform() {
            int newWater = water - waterForOneCup;
            int newMilk = milk - milkForOneCup;
            int newCoffee = coffee - coffeeForOneCup;
            int newCups = disposableCups - 1;

            String missing = "";
            if (newWater < 0)
                missing = "water";
            else if (newMilk < 0)
                missing = "milk";
            else if (newCoffee < 0)
                missing = "coffee";
            else if (newCups < 0)
                missing = "cups";

            if (!missing.isEmpty())
                System.out.print(String.format("Sorry, not enough %s!", missing));
            else {
                System.out.print("I have enough resources, making you a coffee!");
                water = newWater;
                milk = newMilk;
                coffee = newCoffee;
                disposableCups = newCups;
                money += cost;
            }
        }
    }

    private class EspressoMaker extends CoffeeMaker {

        private EspressoMaker() { super(250, 16, 0, 4); }
    }

    private class LatteMaker extends CoffeeMaker {

        private LatteMaker() { super(350, 20, 75, 7); }
    }

    private class CappuccinoMaker extends CoffeeMaker {

        private CappuccinoMaker() { super(200, 12, 100, 6); }
    }


    class MoneyGiver implements Operational {

        @Override
        public void perform() {
            System.out.println(String.format("I gave you $%d", money));
            money = 0;
        }
    }

    class Filler implements Operational {
        Scanner scanner;

        Filler(Scanner scanner) {
            this.scanner = scanner;
        }

        @Override
        public void perform() {
            System.out.print("Write how many ml of water do you want to add: ");
            int water = scanner.nextInt();
            System.out.print("Write how many ml of milk do you want to add: ");
            int milk = scanner.nextInt();
            System.out.print("Write how many grams of coffee beans do you want to add: ");
            int coffee = scanner.nextInt();
            System.out.print("Write how many disposable cups of coffee do you want to add: ");
            int cups = scanner.nextInt();
            addDisposals(water, milk, coffee, cups);
        }
    }

    class StateScanner implements Operational {

        @Override
        public void perform() {
            System.out.println(CoffeeMachine.this.getState());
        }
    }

    class Quitter implements Operational {

        @Override
        public void perform() {
            CoffeeMachine.this.running = false;
        }
    }

    class CoffeeMakerBuilder implements Operational {
        Map<Integer, CoffeeMaker> makers;
        Scanner scanner;

        private CoffeeMakerBuilder(Scanner scanner) {
            this.scanner = scanner;
            this.makers = new HashMap<>(){{
                put(1, new EspressoMaker());
                put(2, new LatteMaker());
                put(3, new CappuccinoMaker());
            }};
        }

        CoffeeMaker getCoffeeMaker(int ordinal) {
            return makers.get(ordinal);
        }

        @Override
        public void perform() {
            System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
            String input = scanner.next().trim();
            if (input.length() == 1) {
                CoffeeMaker coffeeMaker = getCoffeeMaker(Integer.parseInt(input));
                coffeeMaker.perform();
            }
        }
    }

    class OperationalBuilder {
        Map<String, Operational> operationalMap;

        private OperationalBuilder(Scanner scanner) {
            this.operationalMap = new HashMap<>(){{
                put("fill", new Filler(scanner));
                put("take", new MoneyGiver());
                put("buy", new CoffeeMakerBuilder(scanner));
                put("remaining", new StateScanner());
                put("exit", new Quitter());
            }};
        }

        Operational getOperational(String operation) {
            return operationalMap.get(operation);
        }
    }
}
