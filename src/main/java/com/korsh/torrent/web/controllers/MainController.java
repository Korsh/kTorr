package com.korsh.torrent.web.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by arzhanov on 06.01.17.
 */

@Controller
@RequestMapping("/")
public class MainController {
    private final Logger logger = LoggerFactory.getLogger(MainController.class);
    protected String workingDirectory = "/mnt/disk2/IdeaProjects/kTorr/src/main/resources/";

    @RequestMapping(method = RequestMethod.GET)
    public String torrentslistPage(Model model) {
        model.addAttribute("pageTitle", "Welcome!");
        return "main";
    }
}
