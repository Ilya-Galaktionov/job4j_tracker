package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        User result = null;
        for (User user : users) {
            if (login.equals(user.getUsername())) {
                result = user;
            }
        }
        if (result == null) {
            throw new UserNotFoundException("Could not find user: " + login);
        }
        return result;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() < 3) {
            throw new UserInvalidException("User is not valid and his name is less than 3 letters!");
        }
        return true;
    }

    public static void main(String[] args) {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        try {
            User user = findUser(users, "Petr Arsentev");
            if (validate(user)) {
                System.out.println("This user has an access");
            }
        } catch (UserInvalidException eu) {
            System.out.println("User is not valid");
            eu.printStackTrace();
        } catch (UserNotFoundException e) {
            System.out.println("User not found");
            e.printStackTrace();
        }
    }
}
