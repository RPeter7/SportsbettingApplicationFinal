package com.example.presentation.controller;

import com.example.application.interfaces.SportsBettingService;
import com.example.domain.entities.Currency;
import com.example.domain.entities.Player;
import com.example.domain.entitybuilders.PlayerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;

@Controller
@RequestMapping(value = "/register")
public class RegisterController {

    private final Logger logger = LoggerFactory.getLogger(RegisterController.class);
    private final SportsBettingService sportsBettingService;

    public RegisterController(@Qualifier(value = "getSportsBettingService") SportsBettingService sportsBettingService) {
        this.sportsBettingService = sportsBettingService;
    }

    @GetMapping("/index")
    public String index() {
        return "register";
    }

    @RequestMapping(value = "/newPlayer", method = RequestMethod.POST)
    public RedirectView register(String name, String dateOfBirth, String email, String password) {
        var newPlayer = buildNewPlayer(name, dateOfBirth, email, password);
        sportsBettingService.savePlayer(newPlayer);
        logger.info(String.format("%s registered!", newPlayer.getName()));
        return new RedirectView("/login/index");
    }

    private Player buildNewPlayer(String name, String dateOfBirth, String email, String password) {
        return new PlayerBuilder()
                .setName(name)
                .setDateOfBirth(LocalDate.parse(dateOfBirth))
                .setEmail(email)
                .setPassword(password)
                .setCurrency(Currency.EUR)
                .build();
    }
}
