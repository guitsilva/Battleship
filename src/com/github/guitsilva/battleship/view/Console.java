package com.github.guitsilva.battleship.view;

public class Console {

    public static void print(String text) {
        print(text, 80, false, ' ');
    }

    public static void print(String text, boolean centerInScreen) {
        print(text, 80, centerInScreen, ' ');
    }

    public static void print(String text, int lineLen) {
        print(text, lineLen, false, ' ');
    }

    public static void print(String text, int lineLen, boolean centerInScreen) {
        print(text, lineLen, centerInScreen, ' ');
    }

    public static void print(String text, int lineLen, boolean centerInScreen, char fillChar) {

        while (text.length() > lineLen) {
            String line = text.substring(0, lineLen);

            text = text.substring(lineLen);

            print(line, lineLen, centerInScreen, fillChar);
        }

        if (centerInScreen) {
            int spaces = (lineLen - text.length()) / 2;

            if (spaces > 0) {
                System.out.printf("%" + spaces + "s %s %" + spaces + "s%n", fillChar, text, fillChar);
            } else {
                System.out.printf(" %" + lineLen + "s %n", text);
            }
        } else {
            System.out.println(text);
        }
    }

    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
