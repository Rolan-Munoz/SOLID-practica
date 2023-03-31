package com.kreitek.files;

import com.kreitek.files.error.InvalidFileFormatException;

public class ConvertedMp3toWav implements Converted {
    private FileSystemItem file;

    public void ConvertedWapToMP3(FileSystemItem file) {
        this.file = file;
    }

    public FileSystemItem convertMp3ToWav() {
        if (!"mp3".equalsIgnoreCase(file.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser mp3");
        }

        int indexOfLastDot = file.getName().lastIndexOf(".");
        String nameWithoutExtension = file.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = file.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".wav";
        FileSystemItem result = new File(file.getParent(), newFileName);
        result.open();
        // Lógica de conversión de mp3 a wav. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }

    @Override
    public FileSystemItem convertWavToMP3() {
        return null;
    }

    public FileSystemItem convertWavToMp3() {
        throw new UnsupportedOperationException("Este conversor no admite la conversión de WAV a MP3");
    }
}
