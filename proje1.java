import java.util.Scanner;

public class proje1 {

    // GENERAL INFORMATION All valid ASCII codes for uppercase letters is stored in the range [65, 90]
    // All valid ASCII codes for uppercase letters is stored in the range [65, 90]
    // All valid ASCII codes for lowercase letters is stored in the range [97, 122]
    // Subtracting 32 from lowercase letter's ASCII code converts it to uppercase
    // Vice versa, adding 32 to uppercase letter's ASCII code converts it to lowercase

    public static void main(String[] args){
        //Initialize the scanner class to be used for the menu and inputs of functions
        Scanner sc = new Scanner(System.in);
        // Keeping the menu intact unless the selection is a "stop" command
        while (true) {
            // Presenting the main menu
            System.out.print("Project 1 User Menu\n\n" +
                    "1. Print character sequence\n" +
                    "2. Convert uppercase\n" +
                    "3. Cipher and decipher\n" +
                    "4. Draw letter\n\n" +
                    "Make a selection: ");
            // Taking the selection as input
            String secim = sc.next();
            // Checking against the selection
            if (secim.equals("1")) { // If the choice is "1"
                // Ask the user for input
                System.out.print("Enter the character sequence: ");
                // Flushing the scanner because otherwise it only retrieves the rest of previous input
                // which is just an empty string
                sc.nextLine();
                // Retrieving the input
                String input = sc.nextLine();
                // Passing the input to function
                karakterDizisiCizdir(input);
            } else if (secim.equals("2")) { //If the choice is "2"
                // Asking the user for input
                System.out.print("Enter the sentence: ");
                // Same as the previous condition -- Flushing the scanner because otherwise it only retrieves
                // the rest of previous input which is just an empty string
                sc.nextLine();
                // Retrieving the input
                String input = sc.nextLine();
                // Passing it to the function
                String output = buyukharfeCevir(input);
                // Checking against the function's error condition to confirm the input is intact
                if (output != null) {
                    // Passing the output to stdout
                    System.out.print("Output: " + output + "\n\n");
                }
            } else if (secim.equals("3")) { // If the choice is "3"
                // Asking the user for input
                System.out.print("Enter the sentence: ");
                // Same as the previous conditions -- Flushing the scanner because otherwise it only retrieves
                // the rest of previous input which is just an empty string
                sc.nextLine();
                // Retrieving the sentence
                String input = sc.nextLine();
                // Asking the user for shift value
                System.out.print("Enter the shift value: ");
                // Retrieving the shift value
                int kaydirma_degeri = sc.nextInt();
                // Passing the inputs to the function
                String output = sifreleCoz(input, kaydirma_degeri);
                // Checking against the function's error condition to confirm function has succeeded
                if (output != null) {
                    // Passing the output to stdout
                    System.out.print("Output: " + output + "\n\n");
                }
            } else if (secim.equals("4")) { // If the choice is "4"
                // Initializing the variables to be used
                String karakter = "";
                int boyut = 0;

                // Setting infinite loop up so that menu can repeat itself if character input is not supported
                while (true) {
                    // Asking the user for character
                    System.out.print("Enter the character: ");
                    // Retrieving the input
                    karakter = sc.next();
                    // Checking if the character is invalid
                    if (!karakter.equals("X") && !karakter.equals("Z")) {
                        // If the character is invalid, inform the user and return to the start of the loop
                        System.out.println("This character is invalid.");
                        continue;
                    }
                    // If the character is supported, escape the if-condition and end the loop
                    break;
                }
                // Setting infinite loop up so that menu can repeat itself if the size is not supported
                while (true) {
                    // Asking the user for size
                    System.out.print("Enter the size: ");
                    // Retrieving the size from user
                    boyut = sc.nextInt();
                    // Checking if the size is invalid
                    if ((boyut % 2 == 0) || boyut < 5) {
                        // If the size is not supported, inform the user and return to the start of the loop
                        System.out.println("This size is invalid");
                        continue;
                    }
                    // If the size is supported, escape the if-condition and end the loop
                    break;
                }
                // Print a newline so that the menu is not clobbered
                System.out.print("\n");
                // Passing the inputs to the function
                harfCizdir(karakter, boyut);
            } else if (secim.equals("dur") || secim.equals("Dur") || secim.equals("DUR") || secim.equals("DuR") ||
                    secim.equals("dUr") || secim.equals("duR") || secim.equals("DUr") || secim.equals("dUR")) {
                // If the choice is a "stop" command confirm that the program has ended and break out of the menu's loop
                // therefore ending the program
                System.out.print("Program ended.\n");
                break;
            }
        }
    }

    public static void karakterDizisiCizdir(String input) {
        // Setting the default value for characters
        int number = 1;
        // Setting for-loop up to make sure invalid memory is not accessed
        for (int i = 0; i < input.length(); i++) {
            // Checking against the character
            if (input.charAt(i) == 'b') { // If the character is "b"
                for (int j = 0; j < number; j++) {
                    // Print space until the number input is fulfilled
                    System.out.print(" ");
                }
                // Set number back to default
                number = 1;
            } else if (input.charAt(i) == 's') { // If the character is "s"
                for (int j = 0; j < number; j++) {
                    // Print star until the number input is fulfilled
                    System.out.print("*");
                }
                // Set number back to default
                number = 1;
            } else if (input.charAt(i) == 'n') { // If the character is "n"
                for (int j = 0; j < number; j++) {
                    // Print newline until the number input is fulfilled
                    System.out.print("\n");
                }
                // Set number back to default
                number = 1;
            } else if (input.charAt(i) == 't') { // If the character is "t"
                for (int j = 0; j < number; j++) {
                    // Leave three spaces until the number input is fulfilled
                    System.out.print("   ");
                }
                // Set number back to default
                number = 1;
            } else if (input.charAt(i) >= 49 && input.charAt(i) <= 57) { // If the character is a digit(Digits' ASCII codes are between 48(0) and 57(9)
                // Set the number to specified digit
                // This is done through modifying ASCII codes. Subtracting 48 from the digit's ASCII code returns the digit itself
                number = input.charAt(i) - 48;
            } else {
                // If the character is anything else, then it is unsupported
                // Inform the user that input contains unsupported character and specify which one that is
                System.out.println("Input contains unsupported character: " + input.charAt(i));
                // Then terminate the function and return to the main loop
                break;
            }
        }
        System.out.print("\n\n");
    }


    public static String buyukharfeCevir(String input) {
        // Initialize new string to be used by function
        String new_string = "";
        // Check if the first letter is lowercase
        if (input.charAt(0) >= 97 && input.charAt(0) <= 122) {
            // If the first letter is lowercase, convert it to uppercase and pass it to new string
            // This is done by modifying ASCII codes. Subtracting 32 from ASCII code returns the letter's uppercase form
            new_string += (char)(input.charAt(0) - 32);
        } else {
            // If the letter is uppercase, pass it to the new string as is
            new_string += (char)(input.charAt(0));
        }
        // Setting for loop up so that invalid memory is not accessed
        // Loop starts from second index since first letter is already worked on
        for (int i = 1; i < input.length(); i++) {
            // Check if the character at input[i] is a space
            if (input.charAt(i) == 32) {
                new_string += ' '; // Add space to the string
                if ((i + 1) < input.length()) { // If next character is valid
                    // Check if the letter is lowercase
                    if (input.charAt(i + 1) <= 122 && input.charAt(i + 1) >= 97) {
                        // Then, convert the next letter to uppercase and add it to the string
                        new_string += (char) (input.charAt(i + 1) - 32);
                    } else if (input.charAt(i) <= 90 && input.charAt(i) >= 65) {
                        // If the letter is uppercase, add it to the string as is
                        new_string += input.charAt(i);
                    }
                }
            } else if ((input.charAt(i) >= 97 && input.charAt(i) <= 122)){ // If the letter is lowercase
                if (input.charAt(i - 1) != 32) { // Check if the character before input[i] is space
                    // If not, add the character to the new string
                    new_string += input.charAt(i);
                }
                // If the character before input[i] is indeed space, skip it because that letter is already processed
                // and adding it to the string would result in duplicating the converted letter with its previous form
                // since string is still iterated one by one
            } else {
                // If the character doesn't have a valid ASCII code, inform the user that it is unsupported and terminate
                // the function with null value. This error is handled in the main method
                System.out.print("Sentence contains character or characters that are not supported by this function.\n\n");
                return null;
            }
        }
        // After the whole input is processed, return the new string as output
        return new_string;
    }


    public static String sifreleCoz(String input, int kaydirma_degeri) {
        // Initialize the string classes to be used in the function
        String temp = ""; // The string to store the input as converted to uppercase
        String output = ""; // The string to store output
        // Set for loop up to prevent invalid memory access
        for (int i = 0; i < input.length(); i++) {
            // Check if the letter is lowercase
            if (input.charAt(i) <= 122 && input.charAt(i) >= 97) {
                // If the letter is lowercase, convert it to uppercase
                temp += (char)(input.charAt(i) - 32);
            } else if ((input.charAt(i) <= 90 && input.charAt(i) >= 65) || input.charAt(i) == 32) {
                // If the letter is uppercase, pass it to the string as is
                temp += input.charAt(i);
            }
        }

        // Check if the shift value is negative
        if (kaydirma_degeri >= -25 && kaydirma_degeri <= -1) {
            // Set for loop up to iterate through the string while preventing invalid memory access
            for (int i = 0; i < temp.length(); i++) {
                // Check input[i] against space character's ASCII code
                if (temp.charAt(i) != 32) {
                    // If not equal, then shift the character by the specified value
                    int subtracted_value = temp.charAt(i) + kaydirma_degeri;
                    // In the specification, values that are lesser than the ASCII code of letter 'A'
                    // resume from letter 'B' which the ASCII code is 90. That means all letters have to be checked
                    // just in case if letter is lesser than A.
                    if (subtracted_value < 65) {
                        // If the subtracted value is lesser than 'A', resume it from letter 'Z' and lessers.
                        // How it works: If the character was 'A'(ASCII code: 65) and shift value was -1,
                        // shifted value would be 64. But according to the table, shifted letter gives us character 'Z'
                        // which the ASCII code is 90. To cipher it correctly, we need to add 26 to the shifted value.
                        // To give another example, if letter 'C'(ASCII code: 67) was shifted by 7,
                        // result would be 60 which is 5 letters below A, V(ASCII code: 86) in the table.
                        // As seen, difference between the subtracted value and the value we should get is always 26.
                        // Therefore, to keep the letter in the range specified by project, 26 is added to the shifted value.
                        // After that, result is added to the output string.
                        int change_value = subtracted_value + 26;
                        output += (char)(change_value);
                    } else {
                        // If the shifted value doesn't exceed the range, it is added to the string as is.
                        output += (char)(subtracted_value);
                    }
                } else {
                    // If the character is a space, add it to the string directly.
                    output += temp.charAt(i);
                }
            }
        } else if (kaydirma_degeri <= 25 && kaydirma_degeri >= 1) { // Shift value is positive
            // Set for loop up to iterate through the string while preventing invalid memory access
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) != 32) { // If the character is an actual letter
                    // Shifting the letter by specified value
                    int added_value = temp.charAt(i) + kaydirma_degeri;
                    // If the added value is higher than letter 'Z'(ASCII code: 90), resume it from letter 'A' and highers.
                    // How it works: If the character was 'Z'(ASCII code: 90) and shift value was 1,
                    // shifted value would be 91. According to the specification, shifted letter should give us character 'A',
                    // which has the ASCII code 65. To cipher it correctly, we subtract 90 from the value to get how much it
                    // exceeds 90. In this case, 91 exceeds 'A' by 1. If we want the letter to become 'A' by 1 move,
                    // we should set the starting point as 64. As a whole, 'Z'(ASCII code: 90) becomes 91 when it is shifted by 1.
                    // We subtract 90 from it to find it exceeds 'Z' by 1. To set it 'A'(ASCII code: 65) by 1 move, we simply add
                    // 1 to 64 which we set as the checkpoint. To give another example, 'X'(ASCII code: 88) is to be shifted by 5.
                    // In the table, that gives us 'C'. But when it is shifted directly, we get 93. After 'Z', it should move 3 more.
                    // As seen, the value we got is 90 + 3. Hence, we subtract 90 from the value to see how much the letter should move
                    // to be ciphered correctly.
                    if (added_value > 90) {
                        int change_value = added_value - 90;
                        output += (char) (64 + change_value);
                    } else {
                        // If the shifted value is lesser than 'Z', it can be ciphered directly. Therefore, it is added to the
                        // string directly.
                        output += (char) (added_value);
                    }
                } else {
                    // If the character is a space, add it to the string directly.
                    output += temp.charAt(i);
                }
            }
        } else {
            // If the character is not on ASCII table, it is unsupported. Inform the user and terminate the function.
                System.out.print("This shift value is not supported. The value you enter must be in the ranges [-25, -1] and [1, 25]\n\n");
                return null;

        }
        // If function is completed without termination, return the output string.
        return output;
    }



    public static void harfCizdir(String karakter, int boyut) {
        // If the character is 'X'
        if (karakter.equals("X")) {
            // This line calculates one half of the character. The " - 1" is for the middle star which prints only one
            // in the middle.
            int half = (boyut - 1) / 2;
            // Space on the left of first star starts from 0 to one lesser of the half we calculated as seen from
            // the example in the project paper, so it is appropriate to define it like this
            for (int left_space = 0; left_space < half; left_space++) { // Iterating the upper half

                for (int j = 0; j < left_space; j++) { // Printing the leftmost space
                    System.out.print(" ");
                }

                System.out.print("*"); // Printing the left star

                // Calculating middle space so it can have enough size to fit all the stars printed below in while
                // being decreased by 2 in every iteration
                int middle_space = ((half - left_space) * 2) - 1;

                for (int k = 0; k < middle_space; k++) { // Printing the space between two stars
                    System.out.print(" ");
                }

                System.out.println("*"); // Printing the right star and ending the line
            }

            for (int space = 0; space < half; space++) { // Printing the space for middle part
                System.out.print(" ");
            }

            System.out.println("*"); // Printing the middle star and ending the line

            for (int b = 0; b < half; b++) { // Iterating the bottom half
                int left_space = half - (b + 1); // This time, leftmost space decreases by each iteration
                for (int l = 0; l < left_space; l++) { // Printing the leftmost space
                    System.out.print(" ");
                }
                System.out.print("*"); // Printing the left star

                int middle_space = ((half - left_space) * 2) - 1; // Middle space increases as opposite to upper half
                for (int m = 0; m < middle_space; m++) { // Printing the middle space
                    System.out.print(" ");
                }
                System.out.println("*"); // Printing the right star and ending the line
            }
            System.out.print("\n"); // End the function with a newline so menu can be seen clearer after the function ends
        } else { // If the character is 'Z'
            for (int i = 0; i < boyut; i++) { // Printing the upper line of stars as specified by "boyut"
                System.out.print("*");
            }
            System.out.print("\n"); // End the line to start the middle part
            int middle_part = boyut - 2; // 'Z' character is as many lines as 'boyut' while 2 lines of this is
                                         // occupied with whole-star lines so middle part is everything between those lines
            for (int j = 0; j < middle_part; j++) { // Iterating through the middle part
                int left_space = middle_part - j; // Left space decreases by one more in each iteration
                for (int k = 0; k < left_space; k++) { // Printing the space on the left of star
                    System.out.print(" ");
                }
                System.out.println("*"); // Printing the star and ending the line
            }

            for (int i = 0; i < boyut; i++) { // Printing the bottom line of stars as specified by "boyut"
                System.out.print("*");
            }
            System.out.print("\n\n"); // End the function with newlines so menu can be seen clearer when the function ends
        }
    }
}
