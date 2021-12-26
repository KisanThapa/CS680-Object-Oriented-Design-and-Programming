package edu.umb.cs680.hw14.apfs.util;

import edu.umb.cs680.hw14.apfs.ApfsDirectory;
import edu.umb.cs680.hw14.apfs.ApfsFSVisitor;
import edu.umb.cs680.hw14.apfs.ApfsFile;
import edu.umb.cs680.hw14.apfs.ApfsLink;

import java.util.LinkedList;

public class ApfsFileCrawlingVisitor implements ApfsFSVisitor {

    private LinkedList<ApfsFile> files = new LinkedList<>();

    @Override
    public void visit(ApfsDirectory directory) {
        return;
    }

    @Override
    public void visit(ApfsFile file) {
        files.add(file);
    }

    @Override
    public void visit(ApfsLink link) {
        return;
    }

    public LinkedList<ApfsFile> getFiles() {
        return files;
    }
}
