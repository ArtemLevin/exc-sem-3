package task_2;

import java.io.File;

//Задача 2: Файловый менеджер (ООП, исключения)
//
//        Создайте класс FileManager. Этот класс должен иметь методы для выполнения основных операций с файлами: чтение,
//        запись и копирование. Каждый из этих методов должен выбрасывать соответствующее исключение,
//        если в процессе выполнения операции произошла ошибка (например, FileNotFoundException, если файл не найден).
public class Main {

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        fileManager.setDirectoryFiles();
        fileManager.getDirectoryFiles();
        fileManager.addingFile();
        fileManager.getDirectoryFiles();
        fileManager.copyFile();
        fileManager.getDirectoryFiles();
        fileManager.readingFile();
        fileManager.getDirectoryFiles();
    }
}
