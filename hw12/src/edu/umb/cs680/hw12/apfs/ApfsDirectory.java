package edu.umb.cs680.hw12.apfs;

import edu.umb.cs680.hw12.apfs.comparator.AlphabeticalComparator;
import edu.umb.cs680.hw12.filesystem.FSElement;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ApfsDirectory extends ApfsElement {

    private LinkedList<ApfsElement> children;
    private LinkedList<ApfsDirectory> directories;
    private LinkedList<ApfsFile> files;

    public ApfsDirectory(ApfsDirectory parent, String name, int size, LocalDateTime creationTime, String ownerName,
            LocalDateTime lastModifiedTime) {
        super(parent, name, size, creationTime, ownerName, lastModifiedTime);

        children = new LinkedList<>();
        directories = new LinkedList<>();
        files = new LinkedList<>();

        if (parent != null) {
            parent.addChild(this);
        }
    }

    @Override
    public void accept(ApfsFSVisitor visitor) {
        visitor.visit(this);
        for (ApfsElement fsElement : children)
            fsElement.accept(visitor);
    }

    @Override
    public boolean isDirectory() {
        return true;
    }

    public LinkedList<ApfsElement> getChildren() {
        Collections.sort(this.children, new AlphabeticalComparator());
        return this.children;
    }

    public void appendChild(ApfsElement file) {
        children.add(file);
    }

    public int countChildren() {
        return children.size();
    }

    public void addChild(ApfsElement child) {
        children.add(child);
    }

    public LinkedList<ApfsDirectory> getSubDirectories() {
        LinkedList<ApfsDirectory> subDir = new LinkedList<>();

        for (FSElement fsEle : children) {
            if (fsEle instanceof ApfsDirectory)
                subDir.add((ApfsDirectory) fsEle);
        }
        Collections.sort(subDir, new AlphabeticalComparator());
        return subDir;
    }

    public LinkedList<ApfsFile> getFiles() {
        LinkedList<ApfsFile> files = new LinkedList<>();
        for (FSElement fsEle : children) {
            if (fsEle instanceof ApfsFile)
                files.add((ApfsFile) fsEle);
        }
        Collections.sort(files, new AlphabeticalComparator());
        return files;
    }

    public int getTotalSize() {
        int totalSize = 0;
        for (FSElement fsEle : children)
            if (fsEle instanceof ApfsDirectory)
                totalSize += ((ApfsDirectory) fsEle).getTotalSize();
            else
                totalSize += fsEle.getSize();
        return totalSize;
    }

    public LinkedList<ApfsLink> getLinks() {
        LinkedList<ApfsLink> links = new LinkedList<>();
        for (FSElement fsEle : children) {
            if (fsEle instanceof ApfsLink) {
                links.add((ApfsLink) fsEle);
            }
        }
        return links;
    }

    public ApfsDirectory findDirectoryByName(String name) {
        for (ApfsElement apfsEle : children)
            if (apfsEle instanceof ApfsDirectory)
                if (apfsEle.getName().equals(name))
                    return (ApfsDirectory) apfsEle;
        return null;
    }

    public ApfsFile findFileByName(String name) {
        ApfsFile file = null;
        for (ApfsFile f : getFiles())
            if (name.equals(f.getName()))
                file = f;

        if (file == null)
            for (ApfsDirectory dir : getSubDirectories()) {
                file = dir.findFileByName(name);
                if (file != null)
                    break;
            }

        return file;
    }

    public ApfsLink findLinkByName(String name) {
        ApfsLink link = null;
        for (ApfsLink l : getLinks())
            if (name.equals(l.getName()))
                link = l;

        if (link == null)
            for (ApfsDirectory dir : getSubDirectories()) {
                link = dir.findLinkByName(name);
                if (link != null)
                    break;
            }

        return link;
    }

    public LinkedList<ApfsElement> getChildren(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsElement> f = getChildren();
        Collections.sort(f, comparator);
        return f;
    }

    public LinkedList<ApfsDirectory> getSubDirectories(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsDirectory> dir = getSubDirectories();
        Collections.sort(dir, comparator);
        return dir;
    }

    public LinkedList<ApfsFile> getFiles(Comparator<ApfsElement> comparator) {
        LinkedList<ApfsFile> f = getFiles();
        Collections.sort(f, comparator);
        return f;
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
