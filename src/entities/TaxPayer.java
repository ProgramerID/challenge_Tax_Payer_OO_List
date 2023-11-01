package entities;

public class TaxPayer {
	
	private double salaryIncome;
	private double servicesIncome;
	private double capitalIncome;
	private double healthSpending;
	private double educationSpending;
	
	
	public TaxPayer() {
	}

	public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending,
			double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public double salaryTax() {
		 salaryIncome = salaryIncome / 12;
		 if(salaryIncome > 5000) {
			return (salaryIncome * 12) * 0.2;
		 }else if (salaryIncome >= 3000 && salaryIncome <= 5000) {
			 return (salaryIncome * 12) * 0.1;
		 }else {
			return salaryIncome = 0.0;
		 }
	}
	
	public double servicesTax() {
		if(servicesIncome != 0.0) {
			return servicesIncome = servicesIncome * 0.15;
		}else {
			return 0.0;
		}
	}
	
	public double capitalTax() {
		if(capitalIncome != 0.0) {
			return capitalIncome = capitalIncome * 0.2 ;
		}else {
			return 0.0;
		}
	}
	
	public double grossTax() {
		double grossTax = salaryTax() + servicesTax() + capitalTax();;
		return grossTax;
		
	}
	
	public double taxRebate() {
		double expensesDeduction = educationSpending + healthSpending;
		double maxDeduction = grossTax() * 0.3;
		
		if (maxDeduction > educationSpending + healthSpending) {
			return expensesDeduction;
		}else {
			return maxDeduction;
		}
	}
	
	public double netTax() {
		return grossTax() - taxRebate();
	}
	
	@Override
	public String toString() {
		return "Gross Tax Total: "
				+ String.format("%.2f%n", grossTax())
				+ "Rebate: "
				+ String.format("%.2f%n", taxRebate())
				+ "Net Tax: "
				+ String.format("%.2f%n", netTax());
	}

}
