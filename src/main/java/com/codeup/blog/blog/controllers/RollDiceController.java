package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

@Controller
public class RollDiceController {
    @GetMapping("/roll-dice")
    public String index() {
        return "roll-dice";
    }


    @GetMapping("/roll-dice/{n}")
    public String guessNumber(@PathVariable (name = "n") int n,Model viewModel) {
        Random rand = new Random();
        int rand_int = rand.nextInt(6)+1;
            viewModel.addAttribute("answer",n == rand_int);
            viewModel.addAttribute("random",rand_int);
            return "roll-dice";
    }


}
