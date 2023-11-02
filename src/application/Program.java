package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.TaxPayer;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<TaxPayer> list = new ArrayList<>();

		System.out.print("How many Tax Payer you will be typing? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println();
			System.out.println("Enter the datas of " + (i) + "o taxpayer:");
			System.out.print("Annual Income with salary: ");
			double salary = sc.nextDouble();
			System.out.print("Annual Income with services: ");
			double services = sc.nextDouble();
			System.out.print("Annual Income with capital gain: ");
			double capital = sc.nextDouble();
			System.out.print("Health Spending: ");
			double health = sc.nextDouble();
			System.out.print("Education Spending: ");
			double education = sc.nextDouble();
			list.add(new TaxPayer(salary, services, capital, health, education));
		}

		System.out.println();
		int i = 1;
		for (TaxPayer payer : list) {
			System.out.println("Resume of " + i + "o TaxPayer:");
			System.out.println(payer);
			i++;
		}

		sc.close();

	}

}
