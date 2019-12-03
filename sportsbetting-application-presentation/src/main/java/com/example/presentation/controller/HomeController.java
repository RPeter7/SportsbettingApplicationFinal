package com.example.presentation.controller;

import com.example.application.interfaces.SportsBettingService;
import com.example.domain.entities.Player;
import com.example.presentation.common.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping(value = "/home")
public class HomeController {

    private final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private final SportsBettingService sportsBettingService;

    public HomeController(@Qualifier(value = "getSportsBettingService") SportsBettingService sportsBettingService) {
        this.sportsBettingService = sportsBettingService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String home(ModelMap model) {
        model.addAttribute("currentPlayer", sportsBettingService.findPlayerById(ApplicationContext.getLoggedInUserId()));
        model.addAttribute("wagers", sportsBettingService.findAllWagers());
        return "home";
    }

    @RequestMapping(value ="/logout", method = RequestMethod.GET)
    public RedirectView logout() {
        logger.info(String.format("%s logged out!", sportsBettingService.findPlayerById(ApplicationContext.getLoggedInUserId()).getName()));
        return new RedirectView("/login/index");
    }

    @RequestMapping(value ="/updatePlayer", method = RequestMethod.POST)
    public RedirectView updatePlayer(Player currentPlayer) {
        sportsBettingService.updatePlayer(currentPlayer);
        logger.info(String.format("%s's details updated!", currentPlayer.getName()));
        return new RedirectView("/home");
    }

    @RequestMapping(value ="/delete", method = RequestMethod.POST)
    public RedirectView delete(int id) {
        sportsBettingService.deleteWagerById(id);
        logger.info(sportsBettingService.findPlayerById(ApplicationContext.getLoggedInUserId()).getName() + " deleted a Wager!");
        return new RedirectView("/home");
    }
}
