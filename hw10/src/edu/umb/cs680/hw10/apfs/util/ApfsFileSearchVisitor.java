package edu.umb.cs680.hw10.apfs.util;

import edu.umb.cs680.hw10.apfs.ApfsDirectory;
import edu.umb.cs680.hw10.apfs.ApfsFSVisitor;
import edu.umb.cs680.hw10.apfs.ApfsFile;
import edu.umb.cs680.hw10.apfs.ApfsLink;

import java.util.LinkedList;

public class ApfsFileSearchVisitor implements ApfsFSVisitor {

    String fileName;
    LinkedList<ApfsFile> foundFiles = new LinkedList<>();

    @Override
    public void visit(ApfsDirectory directory) {
        return;
    }

    @Override
    public void visit(ApfsFile file) {
        if (file.getName().equals(fileName))
            foundFiles.add(file);
    }

    @Override
    public void visit(ApfsLink link) {
        return;
    }

    public String getFileName() {
        return fileName;
    }

    public LinkedList<ApfsFile> getFoundFiles() {
        return foundFiles;
    }
}
