package task_1;

import java.util.Scanner;

//
//Задача 1: Проверка пароля (Основы языка Java, операторы, ветвления)
//
//        Создайте класс PasswordVerifier. Этот класс должен содержать метод, который принимает строку пароля и проверяет его на соответствие следующим правилам:
//
//        Пароль должен быть не менее 8 символов.
//        Пароль должен содержать хотя бы одну цифру.
//        Пароль должен содержать хотя бы одну заглавную букву.
//        Метод должен выбрасывать исключение, если пароль не соответствует какому-либо из этих правил.
public class Main {
    public static void main(String[] args) throws InvalidPasswordException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your password: ");
        String password = input.next();
        System.out.println("Your password: " + password);

        PasswordVerifier passwordVerifier = new PasswordVerifier(password);
        passwordVerifier.Verifier(password);
        }
    }