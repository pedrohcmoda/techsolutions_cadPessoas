package com.cp.util;

import java.util.Locale;
import java.util.Random;


import net.datafaker.Faker;

public class GenId {


    public int getIdPrimo(){
        Random random = new Random();
        int id;
        do {
            id = random.nextInt();
        } while (!isPrime(id));
        AppLog.getInstance().info("Numero gerado com sucesso!");
        return id;
    }

    public String getNome(){
        Faker faker = new Faker(new Locale("pt_BR"));
        String nome = faker.name().fullName();
        return nome;
    }

    private static boolean isPrime(int inputNum){
        if (inputNum <= 3 || inputNum % 2 == 0)
            return inputNum == 2 || inputNum == 3; //this returns false if number is <=1 & true if number = 2 or 3
        int divisor = 3;
        while ((divisor <= Math.sqrt(inputNum)) && (inputNum % divisor != 0))
            divisor += 2; //iterates through all possible divisors
        return inputNum % divisor != 0; //returns true/false
    }

}
