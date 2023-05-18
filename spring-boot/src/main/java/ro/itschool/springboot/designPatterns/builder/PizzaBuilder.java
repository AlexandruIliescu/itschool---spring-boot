package ro.itschool.springboot.designPatterns.builder;

public class PizzaBuilder {

    private Pizza pizza;

    public PizzaBuilder() {
        this.pizza = new Pizza();
    }

    public PizzaBuilder withName(String name) {
        pizza.setName(name);
        return this;
    }

    public PizzaBuilder withDough(String dough) {
        pizza.setDough(dough);
        return this;
    }

    public PizzaBuilder withSauce(String sauce) {
        pizza.setSauce(sauce);
        return this;
    }

    public Pizza build() {
        return pizza;
    }
}