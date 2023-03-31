package com.kreitek.service;

import com.kreitek.files.implement.Directory;
import com.kreitek.files.implement.File;
import com.kreitek.files.interfaces.FileSystemItem;

import java.util.List;

public class FileManager {

    public static int calculateSize(FileSystemItem fileSystemItem) {
        int totalSize = 0;

        if (fileSystemItem instanceof File) {
            totalSize = fileSystemItem.getSize();
        } else if (fileSystemItem instanceof Directory) {
            for (FileSystemItem item : fileSystemItem.listFiles()) {
                totalSize += calculateSize(item);
            }
        }

        return totalSize;
    }

    public static int calculateSize(List<FileSystemItem> files) {
        int totalSize = 0;

        for(FileSystemItem item : files) {
            if (item instanceof File) {
                totalSize += item.getSize();
            } else if (item instanceof Directory) {
                totalSize += calculateSize(item.listFiles());
            }
        }

        return totalSize;
    }

    // Aquí habría otros métodos para gestionar ficheros y directorios:
    // Crear ficheros, mover ficheros, eliminar ficheros, etc.
}
