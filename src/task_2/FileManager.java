package task_2;

import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {

    Scanner input = new Scanner(System.in);
    ArrayList<String> directoryFiles = new ArrayList<String>();

    public void addingFile() {
        System.out.println("Enter filename: ");
        try {
            String filename = input.next();
            if (directoryFiles.contains(filename)) {
                throw new TheSameNameExistsException("");
            }
            this.directoryFiles.add(filename);
        } catch (TheSameNameExistsException e) {
            System.out.println("The filename is already exists");
        }
    }

    public void copyFile() {
        System.out.println("Enter the filename to copy");
        String filename = input.next();
        try {
            if (filename.length() == 0) {
                throw new NoFileNameException("No filename entered");
            }

        } catch (NoFileNameException e) {
            System.out.println("Enter the filename to copy");
        }
        try {
            if (!directoryFiles.contains(filename)) {
                throw new NoSuchFileInTheDirectory("There is no such file in current directory");
            }
        } catch (NoSuchFileInTheDirectory e) {
            System.out.println("There is no such file in current directory");
        }
        String copiedFileName = filename + "Copied";
        directoryFiles.add(copiedFileName);
    }

    public void readingFile() {
        System.out.println("Enter the filename to read");
        String filename = input.next();
        try {
            if (filename.length() == 0) {
                throw new NoFileNameException("No filename entered");
            }

        } catch (NoFileNameException e) {
            System.out.println("Enter the filename to read");
        }
        try {
            if (!directoryFiles.contains(filename)) {
                throw new NoSuchFileInTheDirectory("There is no such file in current directory");
            }
        } catch (NoSuchFileInTheDirectory e) {
            System.out.println("There is no such file in current directory");
        }

        System.out.println("Reading file: " + filename);
    }


    public void getDirectoryFiles() {
        try {
            if (directoryFiles.size() == 0) {
                throw new NoFilesInDirectory("");
            }
            System.out.println(directoryFiles);
        } catch (NoFilesInDirectory e) {
            System.out.println("There are no files in the directory ");
        }
    }

    public void setDirectoryFiles() {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter filename: ");
            String filename = input.next();
            try {
                if (filename.length() == 0) {
                    throw new NoFileNameException("Enter filename!");
                }
            } catch (NoFileNameException e) {
                System.out.println("Enter filename!");
            }

            directoryFiles.add(filename);


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
