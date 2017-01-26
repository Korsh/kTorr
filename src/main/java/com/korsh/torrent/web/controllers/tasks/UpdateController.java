package com.korsh.torrent.web.controllers.tasks;

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
@RequestMapping("/update")
public class UpdateController {
    private final Logger logger = LoggerFactory.getLogger(UpdateController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String torrentslistPage(Model model) {
        model.addAttribute("pageTitle", "Torrent Modify");
        return "tasks/update";
    }
}