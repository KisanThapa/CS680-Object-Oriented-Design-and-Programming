package edu.umb.cs680.hw09.apfs;

import edu.umb.cs680.hw09.filesystem.FSElement;

import java.time.LocalDateTime;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {

    LinkedList<FSElement> children;

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName, LocalDateTime lastModifiedTime) {
        super(parent, name, size, creationTime, ownerName, lastModifiedTime);

        children = new LinkedList<>();

        if (parent != null) {
            parent.appendChild(this);
        }
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public LinkedList<FSElement> getChildren() {
        return this.children;
    }

    public void appendChild(FSElement file) {
        children.add(file);
    }

    public int countChildren() {
        int countChild = 0;
        for (FSElement f : this.children)
            countChild += 1;
        return countChild;
    }

    public LinkedList<ApfsDirectory> getSubDirectories() {
        LinkedList<ApfsDirectory> directories = new LinkedList<>();
        for (FSElement fsElement : children) {
            if (fsElement instanceof ApfsDirectory) directories.add((ApfsDirectory) fsElement);
        }
        return directories;
    }

    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<>();
        for (FSElement fsElement : children) {
            if (fsElement instanceof ApfsFile) files.add((ApfsFile) fsElement);
        }
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement f : getChildren())
            if (f instanceof ApfsDirectory) totalSize += ((ApfsDirectory) f).getTotalSize();
            else totalSize += f.getSize();
        return totalSize;
    }

    @Override
    public String toString() {
        return "ApfsDirectory{" +
                "children=" + children +
                ", ownerName='" + ownerName + '\'' +
                ", lastModifiedTime=" + lastModifiedTime +
                ", parent=" + parent +
                ", name='" + name + '\'' +
                ", size=" + size +
                ", creationTime=" + creationTime +
                '}';
    }
}
