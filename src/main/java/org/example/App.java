package org.example;

import org.example.model.CreditCard;

import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class App {
    public static void main( String[] args ) throws UnsupportedEncodingException {
        PrintStream consoleOut = new PrintStream(System.out, true, "UTF-8");
        consoleOut.println("_____________________________________________");
        consoleOut.println("Пример (кредитная карта)\n");
        consoleOut.println(
                "Кредитная карта с лимитом 10 000. \n" +
                "Кредитные средства: 10 000.\n" +
                "Собственные средства: 0.\n"
        );
        CreditCard creditCard = new CreditCard(0d, 10000d);

        creditCard.addBalance(5000d);
        consoleOut.println("После пополнения карты на 5 000:");
        consoleOut.println("Кредитные средства: " + creditCard.getBalanceInfo().getCreditBalance());
        consoleOut.println("Собственные средства: " + creditCard.getBalanceInfo().getBalance() + "\n");

        creditCard.removeBalance(5000d);
        consoleOut.println("После оплаты на 5 000:");
        consoleOut.println("Кредитные средства: " + creditCard.getBalanceInfo().getCreditBalance());
        consoleOut.println("Собственные средства: " + creditCard.getBalanceInfo().getBalance() + "\n");

        creditCard.removeBalance(3000d);
        consoleOut.println("После оплаты на 3 000:");
        consoleOut.println("Кредитные средства: " + creditCard.getBalanceInfo().getCreditBalance());
        consoleOut.println("Собственные средства: " + creditCard.getBalanceInfo().getBalance() + "\n");

        creditCard.addBalance(2000d);
        consoleOut.println("После пополнения карты на 2 000:");
        consoleOut.println("Кредитные средства: " + creditCard.getBalanceInfo().getCreditBalance());
        consoleOut.println("Собственные средства: " + creditCard.getBalanceInfo().getBalance() + "\n");

        creditCard.addBalance(2000d);
        consoleOut.println("После пополнения карты на 2 000:");
        consoleOut.println("Кредитные средства: " + creditCard.getBalanceInfo().getCreditBalance());
        consoleOut.println("Собственные средства: " + creditCard.getBalanceInfo().getBalance() + "\n");

        consoleOut.println("_____________________________________________");
    }
}
