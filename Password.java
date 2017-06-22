import javax.swing.*;
import java.util.*;

/**
 * @author Bobby Gupta, Andrew Oppenheimer, & Matt Gleason
 * emails: gupta298@purdue.edu, aoppenh@purdue.edu, gleason2@purdue.edu
 * @version 9/11/2016
 */

public class Password {

    static int length = 0;
    static int numbers;
    static int letters;
    static int lengthLeft;
    static boolean button;
    static boolean range;
    static String numCon = "";
    static String letCon = "";
    static String specCon = "";
    static String password = "";
    static String numConRan = "";
    static String letConRan = "";
    static String specConRan = "";
    static Object special;
    static Object ranPass;


    // Changed checkLength to detect negative numbers & numbers that exceed the upper limit
    public static boolean checkLength(int num, int lengthLeft) {
        if (num > lengthLeft || num < 0 || num > lengthLeft) {
            return false;
        } else {
            return true;
        }
    }

    public void wordReplace() {
        String[] word = {"YES", "NO"};
        String[] pass = {"OK", "CANCEL"};
        String wordIn = "";

        Object hello = JOptionPane.showOptionDialog(null, "Your password is:\n" + password + "\nWould you" +
                        " like to input a word that will be in your password?", "Password Generator",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, word, word[1]);

        do {
            try {
                if (hello.equals(JOptionPane.YES_OPTION)) {
                    wordIn = JOptionPane.showInputDialog(null, "Enter a word \n You only have " + letters + " " +
                                    "remaining", "Password Generator", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    break;
                }
                if (letters != wordIn.length()) {
                    JOptionPane.showMessageDialog(null, "Please try again", "Password Generator",
                            JOptionPane.ERROR_MESSAGE);
                } else {
                    letCon = wordIn;
                    break;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Thank you from Bobby Gupta, Andrew Oppenheimer, & Matt Gleason " +
                        "for trying out our password generator, have a nice day");
                System.exit(0);
            }
        } while (true);
        try {
            JOptionPane.showOptionDialog(null, "Your password is:\n" + passBuilder(), "Password Generator",
                    JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, pass, pass[1]);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Thank you from Bobby Gupta, Andrew Oppenheimer, & Matt Gleason " +
                    "for trying out our password generator, have a nice day");
            System.exit(0);
        }
    }

    public String passBuilder() {
        password = letCon + numCon + specCon;
        return password;
    }

    public int randomNum() {
        Random r = new Random();
        int ran = r.nextInt(10);
        return ran;
    }

    public String randomLet() {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
        int ran = r.nextInt(26);
        return alph.charAt(ran) + "";
    }

    public String randomSpec() {
        String set = "!#$%&()*,./:;?@[]^_{}|~";
        Random r = new Random();
        int ran = r.nextInt(23);
        return set.charAt(ran) + "";
    }

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null, "Welcome to password generator\n\tBobby Gupta\n\tAndrew " +
                "Oppenheimer\n\tMatt Gleason", "Password Generator", JOptionPane.INFORMATION_MESSAGE);

        String[] specialButtons = {"SPECIAL CHARACTER", "NO SPECIAL CHARACTER"};
        String[] continueButtons = {"CONTINUE", "REDO"};
        String[] tryAgain = {"YES", "NO"};
        String[] randPassButts = {"ORDERED RANDOM", "FULLY RANDOM"};
        String[] randCheck = {"I'VE RECONSIDERED", "I'M SURE"};
        Password ps = new Password();
        Random r = new Random();

        do {
            length = 0;
            do {
                do {
                    do {
                        String lengths = JOptionPane.showInputDialog(null, "How long do you want your password to " +
                                        "be?\nYour password must be between 5 and 15 characters long.", "Password Generator",
                                JOptionPane.QUESTION_MESSAGE);
                        try {
                            if (lengths.length() > 0) {
                                try {
                                    length = Integer.parseInt(lengths);
                                } catch (NumberFormatException num) {
                                    JOptionPane.showMessageDialog(null, "Invalid password length!", "Password " +
                                            "Generator", JOptionPane.ERROR_MESSAGE);
                                    continue;
                                }
                            }
                            if (!(length >= 5 && length <= 15)) {
                                JOptionPane.showMessageDialog(null, "Invalid password length!", "Password Generator",
                                        JOptionPane.ERROR_MESSAGE);
                                range = false;
                            } else {
                                range = true;
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Thank you from Bobby Gupta, Andrew Oppenheimer, & " +
                                    "Matt Gleason for trying out our password generator, have a nice day");
                            System.exit(0);
                        }
                    } while (!range);
                    break;
                } while (true);

                special = JOptionPane.showOptionDialog(null, "Do you want to have a special character in your " +
                                "password?", null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
                        specialButtons, specialButtons[1]);

                if (special.equals(JOptionPane.YES_OPTION)) {
                    lengthLeft = length - 1;
                    button = true;
                } else {
                    lengthLeft = length;
                    button = false;
                }

                do {
                    String numNumbers;
                    while (true) {
                        numNumbers = JOptionPane.showInputDialog(null, "Length Left:  " + lengthLeft + "\nHow many numbers" +
                                        " do you want in your password?", "Password Generator",
                                JOptionPane.QUESTION_MESSAGE);
                        try {
                            if (numNumbers.length() >= 5 || numNumbers.length() <= 15) {
                                try {
                                    numbers = Integer.parseInt(numNumbers);
                                    if (checkLength(numbers, lengthLeft)) {
                                        lengthLeft = lengthLeft - numbers;
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null, "Your entry is invalid!", "Password " +
                                                "Generator", JOptionPane.ERROR_MESSAGE);
                                    }
                                } catch (NumberFormatException num) {
                                    JOptionPane.showMessageDialog(null, "Invalid number of numbers!", "Password " +
                                            "Generator", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Thank you from Bobby Gupta, Andrew Oppenheimer, & " +
                                    "Matt Gleason for trying out our password generator, have a nice day");
                            System.exit(0);
                        }
                    }
                    break;
                } while (true);

                letters = lengthLeft;

                Object con = JOptionPane.showOptionDialog(null, "Password Specifications:\n" + "Password Length:  " +
                                length + "\n# of " + "Numbers:  " + numbers + "\n# of Letters:  " + letters +
                                "\nSpecial Character:  " + button + "\n\nDo you want to continue or redo?", "Password" +
                        " Generator", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,continueButtons,
                        continueButtons[1]);

                if (con.equals(JOptionPane.YES_OPTION)) {
                    break;
                }
            } while (true);

            ranPass = JOptionPane.showOptionDialog(null, "Do you want to have an ordered random password or a " +
                    "fully random password", "Password Generator", JOptionPane.YES_NO_OPTION, JOptionPane
                    .QUESTION_MESSAGE, null, randPassButts, randPassButts[1]);

            if (ranPass.equals(JOptionPane.NO_OPTION)) {
                ranPass = JOptionPane.showOptionDialog(null, "WARNING: if you continue with a fully random password, " +
                        "you will not be able to replace the letters with a word as you can with an ordered random " +
                        "password", "Password Generator", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE,
                        null, randCheck, randCheck[1]);
            }

            // Ordered Random
            if (ranPass.equals(JOptionPane.YES_OPTION)) {
                for (int i = 0; i < numbers; i++) {
                    numCon = numCon + ps.randomNum();
                }
                for (int i = 0; i < letters; i++) {
                    letCon = letCon + ps.randomLet();
                }
                if (special.equals(JOptionPane.YES_OPTION)) {
                    specCon = specCon + ps.randomSpec();
                }
                ps.passBuilder();
            }

            int letCount = 0;
            int numCount = 0;
            boolean specCount = button;

            // Fully Random
            if (ranPass.equals(JOptionPane.NO_OPTION)) {
                while (true) {
                    int ran = r.nextInt(5) + 1;
                    if (letCount < letters) {
                        if (ran == 1 || ran == 4) {
                            password = password + ps.randomLet();
                            letCount++;
                        }
                    }
                    if (numCount < numbers) {
                        if (ran == 2 || ran == 5) {
                            password = password + ps.randomNum();
                            numCount++;
                        }
                    }
                    if (specCount) {
                        if (ran == 3 || ran == 6) {
                            password = password + ps.randomSpec();
                            specCount = false;
                        }
                    }
                    if (password.length() == length) {
                        break;
                    }
                }
            }

            if (ranPass.equals(JOptionPane.YES_OPTION)) {
                ps.wordReplace();
            }

            if (ranPass.equals(JOptionPane.NO_OPTION)) {
                JOptionPane.showMessageDialog(null, "Your password is:\n" + password, "Password Generator", JOptionPane
                        .INFORMATION_MESSAGE);
            }

            letCon = "";
            numCon = "";
            specCon = "";
            letConRan = "";
            numConRan = "";
            specConRan = "";
            password = "";

            Object again = JOptionPane.showOptionDialog(null, "Do you want to try again?", "Password Generator",
                    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, tryAgain, tryAgain[1]);

            if (again.equals(JOptionPane.NO_OPTION) || again.equals(JOptionPane.CLOSED_OPTION)) {
                break;
            }

        } while (true);
    }
}
