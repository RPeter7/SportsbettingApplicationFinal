package com.example.presentation.controller;

import com.example.application.interfaces.SportsBettingService;
import com.example.domain.exceptions.OutcomeNotFoundException;
import com.example.presentation.common.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

@Controller
@RequestMapping(value = "/event")
public class EventController {

    private final Logger logger = LoggerFactory.getLogger(EventController.class);
    private final SportsBettingService sportsBettingService;

    public EventController(@Qualifier(value = "getSportsBettingService") SportsBettingService sportsBettingService) {
        this.sportsBettingService = sportsBettingService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String events(ModelMap model) {
        model.addAttribute("events", sportsBettingService.findAllSportEvents());
        return "events";
    }

    @RequestMapping(value = "/addEvent", method = RequestMethod.POST)
    public ModelAndView addEvent(int numberOfEvent, double wagerAmount) {
        var modelMap = new ModelMap();
        modelMap.addAttribute("events", sportsBettingService.findAllSportEvents());

        if (hasPlayerEnoughMoney(BigDecimal.valueOf(wagerAmount))) {
            try {
                sportsBettingService.addChosenOutComeToPlayer(numberOfEvent, wagerAmount, ApplicationContext.getLoggedInUserId());
                logger.info(sportsBettingService.findPlayerById(ApplicationContext.getLoggedInUserId()).getName() + " added a Wager!");
                modelMap.addAttribute("eventAddFailed", false);
                return new ModelAndView("/events", modelMap);
            } catch (OutcomeNotFoundException e) {
                modelMap.addAttribute("eventAddFailed", true);
                modelMap.addAttribute("failedMessage", e.getMessage());
                return new ModelAndView("/events", modelMap);
            }
        }

        modelMap.addAttribute("eventAddFailed", true);
        modelMap.addAttribute("failedMessage", "You dont have enough balance!");
        return new ModelAndView("/events", modelMap);
    }

    private boolean hasPlayerEnoughMoney(BigDecimal wageAmount) {
        return sportsBettingService.findPlayerById(ApplicationContext.getLoggedInUserId()).getBalance().subtract(wageAmount).compareTo(BigDecimal.ZERO) > 0;
    }
}
