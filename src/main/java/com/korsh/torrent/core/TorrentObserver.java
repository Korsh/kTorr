package com.korsh.torrent.core;

import java.util.Observable;

/**
 * Created by arzhanov on 23.01.17.
 */
public class TorrentObserver extends Observable {
    private String data;
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
        //mark the observable as changed
        setChanged();
    }
}
