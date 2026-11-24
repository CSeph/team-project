package entity.account;

import entity.TriggerProfile;

/**
 * A simple entity representing a user. Users have a username and password..
 */
public class User {

    private final String name;
    private final String password;
    private final TriggerProfile accountInfo;

    /**
     * Creates a new user with the given non-empty name and non-empty password.
     *
     * @param name     the username
     * @param password the password
     * @throws IllegalArgumentException if the password or name are empty
     */
    public User(String name, String password) {
        if ("".equals(name) || name == null) {
            throw new IllegalArgumentException("Username is invalid. It cannot be empty");
        }
        if ("".equals(password) || password == null) {
            throw new IllegalArgumentException("Password is invalid. It cannot be empty");
        }
        this.name = name;
        this.password = password;
        this.accountInfo = new TriggerProfile();
    }

    public String getName() {
        return name;
    }
    public String getPassword() {
        return password;
    }
    public TriggerProfile getAccountInfo() {
        return accountInfo;
    }
}