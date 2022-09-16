package com.kenzie.app;

// import necessary libraries

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kenzie.app.data.CluesDTO;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Write main execution code here
        try {
            final String GET_URL = "https://jservice.kenzie.academy/api/clues";

            String customHttpClient;
            customHttpClient = CustomHttpClient.sendGET(GET_URL);
            //System.out.println(customHttpClient);

            //Instantiate ObjectMapper
            ObjectMapper objectMapper = new ObjectMapper();

            //Declare DTO object and read data
            CluesDTO cluesObj = objectMapper.readValue(customHttpClient, CluesDTO.class);

            //Loop and print the list of Clues and then randomize
            Random rand = new Random();

            int i = rand.nextInt(100);
            String question = String.valueOf(cluesObj.getClues().get(i).getQuestion());
            String answer = String.valueOf(cluesObj.getClues().get(i).getAnswer());
            String category = String.valueOf(cluesObj.getClues().get(i).getCategory());

            for (i = 0; i < cluesObj.getClues().size(); i++) {


//                if (cluesObj.getClues().size() > 1) {
//
//
//
//                    System.out.println("Question:" + cluesObj.getClues().get(i).getQuestion());
//                    System.out.println("Answer:" + cluesObj.getClues().get(i).getAnswer());
//                    System.out.println(cluesObj.getClues().get(i).getCategory());
//
//                }

            }


            //Declare variables
            Scanner scan = new Scanner(System.in);

            String inputResponse;
            int totalScore = 0;
            int counter = 0;
            boolean needInput = true;


            //Read in user input - while looping through 10 random questions
            while (needInput) {
                System.out.println(category + "Question: " + question);
                inputResponse = scan.nextLine();
                if (inputResponse.equalsIgnoreCase(answer)) {
                    totalScore++;
                    counter++;
                    System.out.println("Correct! Your new total score is:" + totalScore);
                } else if (inputResponse != answer) {
                    counter++;
                    System.out.println("Incorrect. The answer was:" + answer);
                }


                if (counter > 9) {
                    needInput = false;
                    System.out.println();
                    System.out.println("Your total score is:" + totalScore);
                }
            }


        } catch (Exception e) {
            System.out.println("Unexpected exception:" + e);
        }


    }
}

