package com.codeup.blog.blog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {

    @GetMapping("/add/{num1}/and/{num2}")
    @ResponseBody
    public String addTwoNumbers(@PathVariable int num1, @PathVariable int num2){
        return "The number " + num1 + " added to " + num2 + " equals " + (num1 + num2);
    }

    @GetMapping("/subtract/{num1}/and/{num2}")
    @ResponseBody
    public String subtractTwoNumbers(@PathVariable int num1, @PathVariable int num2){
        return "The number " + num1 + " subtracted from " + num2 + " equals " + (num1 - num2);
    }

    @GetMapping("/multiply/{num1}/and/{num2}")
    @ResponseBody
    public String multiplyTwoNumbers(@PathVariable int num1, @PathVariable int num2){
        return "The number " + num1 + " multiplied by " + num2 + " equals " + (num1 * num2);
    }

    @GetMapping("/divide/{num1}/and/{num2}")
    @ResponseBody
    public String divideTwoNumbers(@PathVariable int num1, @PathVariable int num2){
        return "The number " + num1 + " divided by " + num2 + " equals " + (num1 / num2);
    }

}
