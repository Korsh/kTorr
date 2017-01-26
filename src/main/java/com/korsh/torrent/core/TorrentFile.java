package com.korsh.torrent.core;

import com.korsh.torrent.web.controllers.model.TorrentModel;
import com.turn.ttorrent.client.Client;
import com.turn.ttorrent.client.SharedTorrent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.security.NoSuchAlgorithmException;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by arzhanov on 06.01.17.
 */
public class TorrentFile {
    private final Logger logger = LoggerFactory.getLogger(TorrentFile.class);

    protected Client client = null;
    Double maxDownloadRate = 50., maxUploadRate = 50.;
    public TorrentFile(TorrentModel torrentModel) throws IOException, NoSuchAlgorithmException {
        client = new Client(Inet4Address.getLocalHost(), SharedTorrent.fromFile(new File(torrentModel.getTorrentFilePath()), new File(torrentModel.getOutputFilePath())));

        client.setMaxDownloadRate(maxDownloadRate);
        client.setMaxUploadRate(maxUploadRate);

        client.download();
        if(!client.getTorrent().isFinished()) {
            client.waitForCompletion();
            client.addObserver(new Observer() {
                @Override
                public void update(Observable observable, Object data) {
                    Client client = (Client) observable;
                    float progress = client.getTorrent().getCompletion();
                    logger.info("Progress: {}", progress);
                }
            });
        }

    }

    public Client getClient() {
        return client;
    }

    public boolean isExist() {
        if(client != null) {
            if(client.getTorrent() != null) {
                return true;
            }
            logger.info("Torrent not exist");
            return false;
        }
        logger.info("Client not exist");
        return false;
    }


}
