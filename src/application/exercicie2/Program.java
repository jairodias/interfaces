package application.exercicie2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import application.exercicie2.model.entities.Contract;
import application.exercicie2.model.entities.Installment;
import application.exercicie2.model.services.ContractService;
import application.exercicie2.model.services.PaypalService;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data: ");
        System.out.print("Number: ");
        int number = sc.nextInt();

        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.next());

        System.out.print("Contract value: ");
        double totalValue = sc.nextDouble();

        Contract contract = new Contract(number, date, totalValue);

        System.out.print("Enter number of installments: ");
        int installments = sc.nextInt();

        System.out.println("Installments: ");

        ContractService contractService = new ContractService(new PaypalService());

        contractService.processContract(contract, installments);

        System.out.println("Installments:");
        for (Installment x : contract.getInstallments()) {
            System.out.println(x);
        }

        sc.close();
    }
}
