package com.korsh.torrent.web.controllers;

import com.korsh.torrent.core.TorrentFile;
import com.korsh.torrent.web.controllers.model.TorrentModel;
import com.turn.ttorrent.client.SharedTorrent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.BitSet;

/**
 * Created by arzhanov on 18.01.17.
 */
@Controller
@RequestMapping("/torrent")
public class TorrentController extends MainController{
    public final Logger logger = LoggerFactory.getLogger(TorrentController.class);
    private TorrentModel torrentModel;
    TorrentFile torrentFile;
    public String progress;
    public BitSet piecesProcessed;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTorrent(Model model) throws IOException, NoSuchAlgorithmException {
        String torrentFilePath = "example(pes).torrent";
        String outputFilePath = "/tmp";
        torrentModel = new TorrentModel(workingDirectory+torrentFilePath, outputFilePath);
        torrentFile = new TorrentFile(torrentModel);
        torrentFile.getClient().addObserver();
        if(torrentFile.isExist()) {
            return "redirect:/torrent/view/1";
        } else {
            return "redirect:/torrent/error";
        }
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String errorTorrent(Model model) {
        model.addAttribute("pageTitle", "Adding torrent");
        model.addAttribute("errorMessage", "Torrent not initialized");
        return "torrents/error";
    }


    @RequestMapping(value = "/view/{torrentId}", method = RequestMethod.GET)
    public String viewTorrent(@PathVariable("torrentId") long torrentId, Model model) throws InterruptedException {
        if(torrentFile != null && torrentFile.isExist()) {
            progress = torrentFile.getClient().getTorrent().getFilenames().toString();
            logger.info("Progress: {} - {}", torrentFile.getClient().getState(), torrentFile.getClient().getTorrent().getCompletion());
            SharedTorrent torrent = torrentFile.getClient().getTorrent();
            model.addAttribute("progress", torrentFile.getClient().getState()+": "+torrentFile.getClient().getTorrent().isInitialized());
        } else {
            logger.info("TorrentFile not exist");
            progress = null;
        }
        model.addAttribute("pageTitle", "Adding torrent");
        return "torrents/view";
    }
//
//    @RequestMapping(value = "/remove/{torrentId}", method = RequestMethod.GET)
//    public void removeTorrent() {
//
//    }
}
