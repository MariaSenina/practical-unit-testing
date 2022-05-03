package chapter4;

public class PasswordValidator {
    private String password;

    public PasswordValidator(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be " + password);
        }
        this.password = password;
    }

    public String getPassword() {
        return password;
    }
}
