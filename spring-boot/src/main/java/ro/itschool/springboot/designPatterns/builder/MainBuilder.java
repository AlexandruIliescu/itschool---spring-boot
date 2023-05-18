package ro.itschool.springboot.designPatterns.builder;

public class MainBuilder {

    public static void main(String[] args) {
        PizzaBuilder pizzaBuilder = new PizzaBuilder();
        Pizza pizza = pizzaBuilder
                .withName("Capriciosa")
                .withDough("crispy")
                .withSauce("sweet")
                .build();
        System.out.println(pizza);

        User user = User.builder()
                .name("Marian")
                .age(25)
                .build();
        System.out.println(user);
    }
}
