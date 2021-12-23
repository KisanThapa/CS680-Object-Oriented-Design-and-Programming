package edu.umb.cs680.hw08;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws Exception {
        LocalDateTime date = LocalDateTime.now();

        Directory dr1 = new Directory(null, "Root", 0, date);
        Directory dr2 = new Directory(dr1, "Home", 0, date);
        Directory dr3 = new Directory(dr2, "SubDir", 0, date);

        File f1 = new File(dr2, "Main.java", 5, date);

        Link l1 = new Link(dr2, "Test.link", 3, date, f1);
        Link l2 = new Link(dr3, "Test2.link", 4, date, dr3);

        System.out.println("l1 is the link of :" + l1.getTarget().getName());
        System.out.println("l2 is the link of :" + l2.getTarget().getName());

        System.out.println("f1 full name: " + f1.getName());
        System.out.println("File size of dir1: " + dr1.getTotalSize());
        System.out.println("File size of dir2: " + dr2.getTotalSize());
        System.out.println("File size of dir3: " + dr3.getTotalSize());
        
        System.out.println(f1.getParent().getParent().countChildren());

    }
}
