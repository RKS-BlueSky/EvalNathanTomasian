package com.eval.EvalJunit.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.Random;

@RestController
@RequestMapping("/game")
public class ChifoumiController {
    private int wins = 0;
    private int losses = 0;
    private int ties = 0;

    @GetMapping("/play/{action}")
    public String play(@PathVariable String action) {
        String[] actions = {"rock", "paper", "scissors"};
        String computerAction = actions[new Random().nextInt(actions.length)];
        String result;
        if (action.equals(computerAction)) {
            result = "tied";
            ties++;
        } else if ((action.equals("rock") && computerAction.equals("scissors")) ||
                (action.equals("paper") && computerAction.equals("rock")) ||
                (action.equals("scissors") && computerAction.equals("paper"))) {
            result = "won";
            wins++;
        } else {
            result = "lost";
            losses++;
        }
        return "You played " + action + ", the computer played " + computerAction + ", you " + result + "!";
    }

    @PostMapping("/restart")
    public void restart() {
        wins = 0;
        losses = 0;
        ties = 0;
    }

    @GetMapping("/score")
    public String score() {
        return "Wins: " + wins + ", Losses: " + losses + ", Ties: " + ties;
    }

    @PutMapping("/score/{wins}/{losses}/{ties}")
    public void setScore(@PathVariable int wins, @PathVariable int losses, @PathVariable int ties) {
        this.wins = wins;
        this.losses = losses;
        this.ties = ties;
    }
}
