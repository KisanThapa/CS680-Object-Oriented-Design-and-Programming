package edu.umb.cs680.hw12.filesystem;

import edu.umb.cs680.hw12.apfs.ApfsDirectory;

import java.time.LocalDateTime;

public abstract class FSElement {

    protected final ApfsDirectory parent;
    protected final String name;
    protected final int size;
    protected final LocalDateTime creationTime;

    protected FSElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime) {
        this.parent = parent;
        this.name = name;
        this.size = size;
        this.creationTime = creationTime;
    }

    public ApfsDirectory getParent() {
        return this.parent;
    }

    public String getName() {
        return this.name;
    }

    public int getSize() {
        return this.size;
    }

    public LocalDateTime getCreationTime() {
        return this.creationTime;
    }

    public abstract boolean isDirectory();

}
