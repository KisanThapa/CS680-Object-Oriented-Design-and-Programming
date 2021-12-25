package edu.umb.cs680.hw10.apfs;

import edu.umb.cs680.hw10.filesystem.FSElement;

import java.time.LocalDateTime;

public abstract class ApfsElement extends FSElement {

    protected final String ownerName;
    protected final LocalDateTime lastModifiedTime;

    protected ApfsElement(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModifiedTime) {
        super(parent, name, size, creationTime);
        this.ownerName = ownerName;
        this.lastModifiedTime = lastModifiedTime;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public LocalDateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    public abstract void accept(ApfsFSVisitor visitor);
}
