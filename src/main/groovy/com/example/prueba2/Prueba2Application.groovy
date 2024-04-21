package com.example.prueba2;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class Prueba2Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresa el código:");
        String javaCode = scanner.nextLine();

        while (!javaCode.equalsIgnoreCase("salir")) {
            try {
                String groovyCode = "new groovy.lang.GroovyShell().evaluate('" + javaCode + "')";

                Binding binding = new Binding();
                GroovyShell shell = new GroovyShell(binding);
                Object result = shell.evaluate(groovyCode);
                System.out.println("Resultado: " + result);
            } catch (Exception e) {
                System.out.println("Error al ejecutar " + e.getMessage());
            }

            System.out.println("Ingresa el código:");
            javaCode = scanner.nextLine();
        }

        scanner.close();
    }
}
