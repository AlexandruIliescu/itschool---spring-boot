package ro.itschool.springboot.designPatterns.factory;

public class Triangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Drawing a triangle.");
    }
}