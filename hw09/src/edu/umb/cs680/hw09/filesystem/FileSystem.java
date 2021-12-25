package edu.umb.cs680.hw09.filesystem;

import java.time.LocalDateTime;
import java.util.LinkedList;

public abstract class FileSystem {

    LinkedList<FSElement> rootDirs = new LinkedList<>();
    private FSElement root;
    private int id;
    private String name;
    private int capacity;
    private LocalDateTime createdOn;

    public FSElement initFileSystem(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        root = createDefaultRoot();

        if (root.isDirectory() && capacity >= root.getSize()) {
            setRoot(root);
            this.id = root.hashCode();
            return root;
        } else {
            return null;
        }
    }

    protected abstract FSElement createDefaultRoot();

    public LinkedList<FSElement> getRootDir() {
        return rootDirs;
    }

    public void addRootDir(FSElement root) {
        rootDirs.add(root);
    }

    public FSElement getRoot() {
        return root;
    }

    public void setRoot(FSElement root) {
        rootDirs.add(root);
        this.root = root;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
