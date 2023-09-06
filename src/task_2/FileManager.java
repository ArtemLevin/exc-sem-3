package task_2;

import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    Scanner input = new Scanner(System.in);
    ArrayList<String> directoryFiles = new ArrayList<String>(); // прообразом директории будет обыкновенный массив,
    // в который мы будем записывать имена файлов

    public void addingFile() { // метод для добавления файла в директорию
        System.out.println("Enter filename: ");
        try {
            String filename = input.next();
            if (directoryFiles.contains(filename)) { // если файл с введнным нами именем существует,
                // то выбрасываем исключение
                throw new TheSameNameExistsException("");
            }
            this.directoryFiles.add(filename); // если ранее файла с таким именем не существовало,
            // то создаем его в директории
        } catch (TheSameNameExistsException e) {
            System.out.println("The filename is already exists");
        }

    }

    public void copyFile() { //метод для копирования файла
        System.out.print("Enter the filename to copy: ");
        try {
            input.nextLine();
            String filename = input.nextLine();
            if (filename.isEmpty()) { //если имя файла не было введено, то выбрасываем исключение
                throw new NoFileNameException("No filename entered");
            }
            try {
                if (!directoryFiles.contains(filename)) { //если директория уже содержит файл с введенным нами именем,
                    // то выбрасываем исключение
                    throw new NoSuchFileInTheDirectory("There is no such file in current directory");
                }
                String copiedFileName = filename + "Copied"; //если все в порядке создаем файл в директории
                directoryFiles.add(copiedFileName);
            } catch (NoSuchFileInTheDirectory e) {
                System.out.println("There is no such file in current directory");
            }

        } catch (NoFileNameException e) {
            System.out.println("No filename was entered");
        }

    }

    public void readingFile() { // метод для чтения файла
        System.out.println("Enter the filename to read");
        String filename = input.nextLine();
        try {
            if (filename.length() == 0) {//если имя файла не было введено, то выбрасываем исключение
                throw new NoFileNameException("No filename entered");
            }

        } catch (NoFileNameException e) {
            System.out.println("Enter the filename to read");
        }
        try {
            if (!directoryFiles.contains(filename)) {// если файла с введенным нами именем не существует в директории,
                // то выбрасываем исключение
                throw new NoSuchFileInTheDirectory("There is no such file in current directory");
            }
        } catch (NoSuchFileInTheDirectory e) {
            System.out.println("There is no such file in current directory");
        }

        System.out.println("Reading file: " + filename); //если все в порядке, то читаем файл
    }


    public void getDirectoryFiles() {   //метод для вывода файлов, находящихся в директории
        try {
            if (directoryFiles.size() == 0) {   //если  директория пуста, выбрасываем исключение
                throw new NoFilesInDirectory("");
            }
            System.out.println(directoryFiles);
        } catch (NoFilesInDirectory e) {
            System.out.println("There are no files in the directory ");
        }
    }

    public void setDirectoryFiles() { // метод для заполнения директории файлами
        boolean flag = true;
        while (flag) {
            System.out.println("Enter filename: ");
            String filename = input.nextLine();
            try {
                if (filename.length() == 0) { //если пользователь не ввел имя файла, выбрасываем исключение
                    throw new NoFileNameException("Enter filename!");
                }
            } catch (NoFileNameException e) {
                System.out.println("Enter filename!");
            }

            directoryFiles.add(filename); // если все в порядке, то добавляем файл  в директорию


            boolean answerFlag = true;
            while (answerFlag == true)
                try {
                    System.out.println("Would you like to continue adding files in your directory? ");
                    String answer = input.next();
                    if (answer.equals("yes")) {
                        flag = true;
                        answerFlag = false;
                    } else if (answer.equals("no")) {
                        flag = false;
                        answerFlag = false;
                    } else {
                        throw new WrongAnswerException("Enter correct answer");
                    }
                } catch (WrongAnswerException e) {
                    System.out.println("Enter correct answer");

                }

        }

    }
}
