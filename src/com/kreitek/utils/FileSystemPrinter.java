package com.kreitek.utils;

import com.kreitek.files.implement.Directory;
import com.kreitek.files.interfaces.FileSystemItem;
import com.kreitek.service.FileManager;

public class FileSystemPrinter {

    private final FileManager fileManager;

    public FileSystemPrinter() {
        this.fileManager = new FileManager();
    }

    public static void print(FileSystemItem item, int nivel) {
        String indentation = "\t".repeat(nivel);
        String message = String.format("%s%s = %d bytes", indentation, item.getFullPath(), FileManager.calculateSize(item));
        System.out.println(message);

        if (item instanceof Directory) {
            for (FileSystemItem subitem: item.listFiles()) {
                FileSystemPrinter.print(subitem, nivel + 1);
            }
        }

    }

}
