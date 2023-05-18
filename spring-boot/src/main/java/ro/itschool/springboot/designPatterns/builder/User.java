package ro.itschool.springboot.designPatterns.builder;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class User {

    private String name;
    private int age;
}