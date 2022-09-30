package theme_06_DefiningClasses.Lab.P03_BankAccount;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Map<Integer, BankAccount> bankAccounts = new HashMap<>();

        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");
            String command = tokens[0];
            String output = null;

            if (command.equals("Create")) {
                BankAccount bankAccount = new BankAccount();
                int id = bankAccount.getID();
                bankAccounts.put(id, bankAccount);
                output = String.format("Account ID%d created", id);

            } else if (command.equals("Deposit")) {
                int id = Integer.parseInt(tokens[1]);
                int amount = Integer.parseInt(tokens[2]);

                if (bankAccounts.containsKey(id)) {
                    BankAccount bankAccount = bankAccounts.get(id);
                    bankAccount.deposit(amount);
                    output = String.format("Deposited %d to ID%d", amount, id);
                } else {
                    output = "Account does not exist";
                }

            } else if (command.equals("SetInterest")) {
                double interest = Double.parseDouble(tokens[1]);
                BankAccount.setInterestRate(interest);

            } else if (command.equals("GetInterest")) {
                int id = Integer.parseInt(tokens[1]);
                int years = Integer.parseInt(tokens[2]);

                if (bankAccounts.containsKey(id)) {
                    BankAccount bankAccount = bankAccounts.get(id);
                    double interest = bankAccount.getInterest(years);
                    output = String.format("%.2f", interest);
                } else {
                    output = "Account does not exist";
                }
            }

            if (output != null) {
                System.out.println(output);
            }

            line = scanner.nextLine();
        }

    }
}
