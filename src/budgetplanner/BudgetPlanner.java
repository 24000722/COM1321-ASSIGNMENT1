
package budgetplanner;

/*COM1321 GROUP N MEMBERS

1.24039285 Nevhungoni MC
2.24000722 Tendani S
3.23014829 Daswa VTR
4.24059706 Khoza IS
5.23024734 Baloyi TH
6.24055635 ndhlovu Q
7.23004806 Netshidzati  U
8.23022573 Masindi A.M
9.21012784 Nemakonde  E
10.23005777 Muleya K
11.23024564 Sikhwetha RJ
12.21004764 Makhadi T
13.23005777 Muleya K
14.23020613 Ratshikombo LS
*/


import java.util.*;

public class BudgetPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter gross monthly income: ");
        double grossIncome = scanner.nextDouble();

        System.out.print("Enter estimated monthly tax deducted: ");
        double tax = scanner.nextDouble();

        ArrayList<String> expenseNames = new ArrayList<>();
        ArrayList<Double> expenseAmounts = new ArrayList<>();

        System.out.print("Enter monthly expenditure on groceries: ");
        double groceries = scanner.nextDouble();
        expenseNames.add("Groceries");
        expenseAmounts.add(groceries);

        System.out.print("Enter monthly expenditure on water and lights: ");
        double waterAndLights = scanner.nextDouble();
        expenseNames.add("Water and lights");
        expenseAmounts.add(waterAndLights);

        System.out.print("Enter monthly travel costs: ");
        double travel = scanner.nextDouble();
        expenseNames.add("Travel");
        expenseAmounts.add(travel);

        System.out.print("Enter monthly cell phone and telephone costs: ");
        double phone = scanner.nextDouble();
        expenseNames.add("Phone");
        expenseAmounts.add(phone);

        System.out.print("Enter other monthly expenses: ");
        double otherExpenses = scanner.nextDouble();
        expenseNames.add("Other expenses");
        expenseAmounts.add(otherExpenses);

        System.out.print("Do you want to rent or buy a property? (rent/buy): ");
        String choice = scanner.next();
        double accommodationExpense = 0;
        if (choice.equalsIgnoreCase("rent")) {
            System.out.print("Enter monthly rental amount: ");
            accommodationExpense = scanner.nextDouble();
            expenseNames.add("Rent");
            expenseAmounts.add(accommodationExpense);
        } else if (choice.equalsIgnoreCase("buy")) {
            System.out.print("Enter purchase price of the property: ");
            double purchasePrice = scanner.nextDouble();

            System.out.print("Enter total deposit: ");
            double deposit = scanner.nextDouble();

            System.out.print("Enter interest rate (percentage): ");
            double interestRate = scanner.nextDouble();

            System.out.print("Enter number of months to repay (240-360): ");
            int months = scanner.nextInt();

            double loanAmount = purchasePrice - deposit;
            double monthlyInterestRate = interestRate / 100 / 12;
            accommodationExpense = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -months));
            expenseNames.add("Home loan repayment");
            expenseAmounts.add(accommodationExpense);
        }

        System.out.print("Do you want to buy a vehicle? (yes/no): ");
        choice = scanner.next();
        double vehicleExpense = 0;
        if (choice.equalsIgnoreCase("yes")) {
            System.out.print("Enter model and make: ");
            String modelAndMake = scanner.next();

            System.out.print("Enter purchase price: ");
            double purchasePrice = scanner.nextDouble();

            System.out.print("Enter total deposit: ");
            double deposit = scanner.nextDouble();

            System.out.print("Enter interest rate (percentage): ");
            double interestRate = scanner.nextDouble();

            System.out.print("Enter estimated insurance premium: ");
            double insurancePremium = scanner.nextDouble();

            double loanAmount = purchasePrice - deposit;
            double monthlyInterestRate = interestRate / 100 / 12;
            int months = 60; // 5 years
            vehicleExpense = (loanAmount * monthlyInterestRate) / (1 - Math.pow(1 + monthlyInterestRate, -months));
            expenseNames.add("Vehicle loan repayment");
            expenseAmounts.add(vehicleExpense);
            expenseNames.add("Vehicle insurance");
            expenseAmounts.add(insurancePremium);
        }

        double totalExpenses = 0;
        for (double expense : expenseAmounts) {
            totalExpenses += expense;
        }

        double netIncome = grossIncome - tax - totalExpenses;

        System.out.println("Expenses:");
        for (int i = 0; i < expenseNames.size(); i++) {
            System.out.println(expenseNames.get(i) + ": " + expenseAmounts.get(i));
        }

        if (totalExpenses > 0.75 * (grossIncome - tax)) {
            System.out.println("Expenses exceed 75% of income.");
        }

        System.out.println("Net income: " + netIncome);
    }
}