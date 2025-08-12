package javaaa;

import org.apache.commons.lang3.StringUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input,captel ;
        input=scanner.nextLine();
        captel = StringUtils.capitalize(input.toLowerCase());
        System.out.println(captel);
    }
}