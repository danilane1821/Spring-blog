package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.processing.Generated;
import java.util.Random;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String index() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    public String guessNumber(@PathVariable (name = "n") int n, Model viewModel) {
        Random rand = new Random();
        int rand_int = rand.nextInt(6)+1;
        if(n == rand_int){
            viewModel.addAttribute("correct", "You guessed correct! The dice rolled " + rand_int + " and you guessed " + n);
        }else {
            viewModel.addAttribute("wrong", "Sorry! You guessed wrong.. The dice rolled " + rand_int + " and you guessed " + n);
        }
        return "roll-dice";
    }




}
