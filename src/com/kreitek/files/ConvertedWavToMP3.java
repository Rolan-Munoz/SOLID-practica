package com.kreitek.files;


import com.kreitek.files.error.InvalidFileFormatException;

public class ConvertedWavToMP3 implements Converted {
    private FileSystemItem file;

    public void ConvertedWavToMP3(FileSystemItem file) {
        this.file = file;
    }



    public FileSystemItem convertWavToMp3() {
        if (!"wav".equalsIgnoreCase(file.getExtension())) {
            throw new InvalidFileFormatException("El fichero debe ser wav");
        }

        int indexOfLastDot = file.getName().lastIndexOf(".");
        String nameWithoutExtension = file.getName();
        if (indexOfLastDot > 0) {
            nameWithoutExtension = file.getName().substring(0, indexOfLastDot);
        }
        String newFileName = nameWithoutExtension + ".mp3";
        FileSystemItem result = new File(file.getParent(), newFileName);
        result.open();
        // Lógica de conversión de wav a mp3. Se lee de este fichero y se escribe en result
        result.close();
        return result;
    }
    public FileSystemItem convertMp3ToWav() {
        throw new UnsupportedOperationException("Este conversor no admite la conversión de MP3 a WAV");
    }
}
