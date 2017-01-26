package com.korsh.torrent.core;

import com.turn.ttorrent.tracker.TrackedTorrent;
import com.turn.ttorrent.tracker.Tracker;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.security.NoSuchAlgorithmException;

/**
 * Created by arzhanov on 18.01.17.
 */
public class TrackerCore {

    public void TrackerCore () throws IOException, NoSuchAlgorithmException {
        Tracker tracker = new Tracker(new InetSocketAddress(6969));

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.endsWith(".torrent");
            }
        };

        for (File f : new File("torrentFiles/").listFiles(filter)) {
            tracker.announce(TrackedTorrent.load(f));
        }

        tracker.start();

    }
}
