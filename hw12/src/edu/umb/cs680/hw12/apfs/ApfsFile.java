package edu.umb.cs680.hw12.apfs;

import java.time.LocalDateTime;

public class ApfsFile extends ApfsElement {

    public ApfsFile(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModifiedTime) {
        super(parent, name, size, creationTime, ownerName, lastModifiedTime);
        parent.appendChild(this);
    }

    @Override
    public void accept(ApfsFSVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isDirectory() {
        return false;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
