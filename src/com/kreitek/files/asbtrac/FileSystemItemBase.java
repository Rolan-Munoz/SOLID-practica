package com.kreitek.files.asbtrac;

import com.kreitek.files.implement.Directory;
import com.kreitek.files.interfaces.FileSystemItem;

import java.util.List;

public abstract class FileSystemItemBase implements FileSystemItem {
    protected static final String PATH_SEPARATOR = "/";
    protected String name;
    protected FileSystemItem parent;

    protected FileSystemItemBase(FileSystemItem parent, String name) {
        setName(name);
        setParent(parent);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("El nombre no puede ser nulo");
        }
       this.name = name;
    }

    @Override
    public FileSystemItem getParent() {
        return parent;
    }

    @Override
    public void setParent(FileSystemItem directory) {
        if (directory != null && !(directory instanceof Directory)) {
            throw new IllegalArgumentException("El padre solo puede ser un directorio");
        }
        if (this.parent != directory) {
            if (this.parent != null) this.parent.removeFile(this);
            this.parent = directory;
            if (directory != null) directory.addFile(this);
        }
    }

    @Override
    public String getFullPath() {
        String path = PATH_SEPARATOR;
        if (parent != null) {
            String parentFullPath = parent.getFullPath();
            path = parent.getFullPath() + (parentFullPath.length() > 1 ? PATH_SEPARATOR : "");
        }
        path = path + getName();
        return path;
    }

    @Override
    public abstract String getExtension();

    @Override
    public abstract List<FileSystemItem> listFiles();

    @Override
    public abstract int getSize();

    @Override
    public abstract void open();

    @Override
    public abstract void setPosition(int numberOfBytesFromBeginning);

    @Override
    public abstract byte[] read(int numberOfBytesToRead);

    @Override
    public abstract void write(byte[] buffer);

    public abstract void close();
}
