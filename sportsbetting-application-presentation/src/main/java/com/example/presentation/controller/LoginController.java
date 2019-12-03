package com.example.presentation.controller;

import com.example.application.interfaces.SportsBettingService;
import com.example.application.repository.SportEventRepository;
import com.example.application.utilities.SportEventFactory;
import com.example.presentation.common.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    private final SportsBettingService sportsBettingService;
    private final SportEventRepository sportEventRepository;
    private final SportEventFactory sportEventFactory;

    public LoginController(@Qualifier(value = "getSportsBettingService") SportsBettingService sportsBettingService, SportEventRepository sportEventRepository, SportEventFactory sportEventFactory) {
        this.sportsBettingService = sportsBettingService;
        this.sportEventRepository = sportEventRepository;
        this.sportEventFactory = sportEventFactory;
    }

    @RequestMapping(value = "/doLogin", method = RequestMethod.POST)
    public ModelAndView login(String email, String password) {
        var model = new ModelMap();
        var player = sportsBettingService.findPlayerByEmail(email);

        if (player != null && player.getPassword().equals(password)) {
            logger.info(String.format("%s logged in!", player.getName()));
            ApplicationContext.setLoggedInUserId(player.getId());

            model.addAttribute("currentPlayer", player);
            model.addAttribute("wagers", sportsBettingService.findAllWagers());
            return new ModelAndView("/home", model);
        }

        model.addAttribute("loginFailed", true);
        return new ModelAndView("index", model);
    }

    @GetMapping(value = "/")
    public String openApplication() {
        loadBaseData();
        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(ModelMap modelMap) {
        return "index";
    }

    private void loadBaseData() {
        logger.info("Bade data loaded!");
        sportEventRepository.save(sportEventFactory.get());
    }
}