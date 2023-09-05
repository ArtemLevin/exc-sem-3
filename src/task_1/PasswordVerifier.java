package task_1;

public class PasswordVerifier {
    private String password;

    PasswordVerifier(String password) {
        this.password = password;
    }

    public void Verifier(String password) throws InvalidPasswordException {
        try {
            if (this.password.length() < 8) {
                throw new InvalidPasswordException("Password length is less than 8 symbols");
            }
        } catch (InvalidPasswordException e1) {
            System.out.println("Entered incorrect number");

            int counter = 0;
            for (char c : this.password.toCharArray())
                if (Character.isDigit(c)) {
                    counter++;
                }

            try {
                if (counter == 0) {
                    throw new InvalidPasswordException("There is no any digit in the password");
                }
            } catch (InvalidPasswordException e2) {
                System.out.println("Entered incorrect number");
            }

            int counterUpper = 0;
            for (int i = 0; i < this.password.length(); i++) {
                if (Character.isUpperCase(this.password.charAt(i))) {
                    counterUpper++;
                    break;
                }
            }
            try {
                if (counterUpper == 0) {
                    throw new InvalidPasswordException("There is no any uppercase letter in the password");
                }
            } catch (InvalidPasswordException e3) {
                System.out.println("There is no any uppercase letter in the password");
            }
        }
    }
}
