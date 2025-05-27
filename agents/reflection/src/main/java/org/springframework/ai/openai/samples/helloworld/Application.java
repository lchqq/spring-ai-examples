package org.springframework.ai.openai.samples.helloworld;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.text.SimpleDateFormat;

import java.util.Scanner;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    
    @Bean
    CommandLineRunner cli(ReflectionAgent reflectionAgent) {
        return args -> {
            var scanner = new Scanner(System.in);
            System.out.println("\nLet's chat!");
            System.out.println("Date time:" + sdf.format(new Date()));
            // Generate a Java implementation of the Merge Sort algorithm
            while (true) {
                System.out.print("\nUSER: ");
                System.out.println("AGENT: " +
                        reflectionAgent.run(scanner.nextLine(), 2));
            }
        };
    }
}
