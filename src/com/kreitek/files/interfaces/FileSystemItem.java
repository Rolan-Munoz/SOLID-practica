package com.kreitek.files.interfaces;

import java.util.List;

public interface FileSystemItem {
    String getName();
    void setName(String name);
    FileSystemItem getParent();
    void setParent(FileSystemItem directory);
    String getFullPath();
    String getExtension();
    List<FileSystemItem> listFiles();
    void addFile(FileSystemItem file);
    void removeFile(FileSystemItem file);
    int getSize();
    void open();
    void close();
    void setPosition(int numberOfBytesFromBeginning);
    byte[] read(int numberOfBytesToRead);
    void write(byte[] buffer);


}
