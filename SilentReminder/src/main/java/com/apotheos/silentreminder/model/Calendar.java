package com.apotheos.silentreminder.model;

public class Calendar {
    public long id;
    public String accountName;
    public String displayName;
    public int color;
    public boolean deleted;
    public boolean visible;

    @Override
    public String toString() {
        return String.format("<%d:%s:%s:%b:%b>", id, accountName, displayName, deleted, visible);
    }
}
