package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class DiceController {

    @GetMapping("/roll-dice")
    public String rollDice(){
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{n}")
    @ResponseBody
    public String userNumber(@PathVariable int n, Model model){
        int randomNum = (int) (Math.floor(Math.random() * 6) + 1);

        model.addAttribute("n", n);
        model.addAttribute("randomNum", randomNum);

        if(n == randomNum){
            return "<p>Correct! The number was " + randomNum+ "</p>";
        }
        return "<p>Wrong number! You guessed " + n + "The correct number was " + randomNum + "</p>";

    }
}
