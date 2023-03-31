package com.kreitek;

import com.kreitek.files.interfaces.FileSystemItem;
import com.kreitek.utils.FileSystemBuilder;
import com.kreitek.utils.FileSystemPrinter;

public class Main {

    public static void main(String[] args) {
        FileSystemItem root = buildTestFileSystem();
        printResult(root);
    }

    private static void printResult(FileSystemItem root) {
        System.out.println(
                "**********************\n" +
                "* Resultado esperado *\n" +
                "**********************\n" +
                "/ = 382 bytes\n" +
                "\t/readme.txt = 42 bytes\n" +
                "\t/src = 190 bytes\n" +
                "\t\t/src/main.java = 10 bytes\n" +
                "\t\t/src/hello.txt = 50 bytes\n" +
                "\t\t/src/resources = 130 bytes\n" +
                "\t\t\t/src/resources/icon.ico = 30 bytes\n" +
                "\t\t\t/src/resources/index.html = 100 bytes\n" +
                "\t/doc = 150 bytes\n" +
                "\t\t/doc/manual.md = 150 bytes\n\n" +
                "---------------------------------------------------\n\n" +
                "**********************\n" +
                "* Tu resultado       *\n" +
                "**********************");
        FileSystemPrinter.print(root, 0);
    }

    private static FileSystemItem buildTestFileSystem() {
        return FileSystemBuilder.getBuilder()
                .addFile("readme.txt", 42)
                .addDirectory("src")
                    .addFile("main.java", 10)
                    .addFile("hello.txt", 50)
                    .addDirectory("resources")
                        .addFile("icon.ico", 30)
                        .addFile("index.html", 100)
                    .upOneDirectory()
                .upOneDirectory()
                .addDirectory("doc")
                   .addFile("manual.md", 150)
                .build();
    }
}
