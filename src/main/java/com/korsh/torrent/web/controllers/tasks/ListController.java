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
@RequestMapping("/list")
public class ListController{
    private final Logger logger = LoggerFactory.getLogger(ListController.class);
//
//    private Float[] getProgress() {
//        final Float[] progress = new Float[1];
//        client.addObserver(new Observer() {
//            @Override
//            public void update(Observable observable, Object data) {
//                Client client = (Client) observable;
//                progress[0] = client.getTorrent().getCompletion();
//
//
//            }
//        });
//        return progress;
//    }
    @RequestMapping(method = RequestMethod.GET)
    public String torrentslistPage(Model model) {
        //getProgress();
        model.addAttribute("pageTitle", "Torrents list");
        return "tasks/list";
    }
}
