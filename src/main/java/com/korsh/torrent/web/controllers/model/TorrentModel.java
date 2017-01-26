package com.korsh.torrent.web.controllers.model;

/**
 * Created by arzhanov on 18.01.17.
 * Will store torrent information such as progress, files, path etc.
 */
public class TorrentModel {
    private String torrentFilePath, outputFilePath;

    public TorrentModel(String torrentFilePath, String outputFilePath) {
        if(torrentFilePath.endsWith(".torrent")) {
            setTorrentFilePath(torrentFilePath);
            setOutputFilePath(outputFilePath);
        } else {
            return;
        }
    }

    public void setTorrentFilePath(String torrentFilePath) {
        this.torrentFilePath = torrentFilePath;
    }

    public void setOutputFilePath(String outputFilePath) {
        this.outputFilePath = outputFilePath;
    }

    public String getTorrentFilePath() {
        return this.torrentFilePath;
    }

    public String getOutputFilePath() {
        return this.outputFilePath;
    }
}
