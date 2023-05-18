package ro.itschool.springboot.designPatterns.factory;

public class MainFactory {

    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();

        Shape circle = shapeFactory.createShape("circle");
        circle.draw();

        Shape triangle = shapeFactory.createShape("triangle");
        triangle.draw();
    }
}