package edu.umb.cs680.hw08;

import java.util.LinkedList;

public class FileSystem {
    private static FileSystem instance;
    LinkedList<Directory> rootDirs = new LinkedList<>();

    private FileSystem() {
    }

    public static FileSystem getFileSystem() {
        if (instance == null)
            instance = new FileSystem();
        return instance;
    }

    public LinkedList<Directory> getRootDir() {
        return this.rootDirs;
    }

    public void addRootDir(Directory root) {
        rootDirs.add(root);
    }

}
