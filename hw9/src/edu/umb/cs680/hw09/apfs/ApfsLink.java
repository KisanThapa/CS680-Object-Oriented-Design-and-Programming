package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.filesystem.FSElement;

import java.time.LocalDateTime;

public class ApfsLink extends ApfsElement {

    private final FSElement target;

    public ApfsLink(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, FSElement target, String ownerName, LocalDateTime lastModifiedTime) {
        super(parent, name, size, creationTime, ownerName, lastModifiedTime);
        parent.appendChild(this);

        this.target = target;
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    public FSElement getTarget() {
        return target;
    }

    @Override
    public String toString() {
        return "ApfsLink{" +
                "ownerName='" + ownerName + '\'' +
                ", lastModifiedTime=" + lastModifiedTime +
                ", target=" + target +
                ", parent=" + parent +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", creationTime=" + creationTime +
                '}';
    }
}