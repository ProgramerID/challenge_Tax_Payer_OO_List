package entities;

public class TaxPayer {
	
	private Double salaryIncome;
	private Double servicesIncome;
	private Double capitalIncome;
	private Double healthSpending;
	private Double educationSpending;
	
	
	public TaxPayer() {
	}

	public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending,
			Double educationSpending) {
		this.salaryIncome = salaryIncome;
		this.servicesIncome = servicesIncome;
		this.capitalIncome = capitalIncome;
		this.healthSpending = healthSpending;
		this.educationSpending = educationSpending;
	}

	public Double getSalaryIncome() {
		return salaryIncome;
	}

	public void setSalaryIncome(Double salaryIncome) {
		this.salaryIncome = salaryIncome;
	}

	public Double getServicesIncome() {
		return servicesIncome;
	}

	public void setServicesIncome(Double servicesIncome) {
		this.servicesIncome = servicesIncome;
	}

	public Double getCapitalIncome() {
		return capitalIncome;
	}

	public void setCapitalIncome(Double capitalIncome) {
		this.capitalIncome = capitalIncome;
	}

	public Double getHealthSpending() {
		return healthSpending;
	}

	public void setHealthSpending(Double healthSpending) {
		this.healthSpending = healthSpending;
	}

	public Double getEducationSpending() {
		return educationSpending;
	}

	public void setEducationSpending(Double educationSpending) {
		this.educationSpending = educationSpending;
	}
	
	public Double salaryTax() {
		Double salaryTax;
		 if(salaryIncome / 12 > 5000) {
			salaryTax = salaryIncome * 0.2;
		 }else if (salaryIncome / 12 >= 3000 && salaryIncome / 12 <= 5000) {
			 salaryTax =  salaryIncome * 0.1;
		 }else {
			salaryTax =  salaryIncome ;
		 }
		 return salaryTax;
	}
	
	public Double servicesTax() {
		Double services = 0.0;
		if(servicesIncome > 0.0) {
			services = servicesIncome * 0.15;
		}else {
			services = 0.0;
		}
		return services;
		
	}
	
	public Double capitalTax() {
		Double capital = 0.0;
		
		if(capitalIncome > 0.0) {
			capital = capitalIncome * 0.2 ;
		}else {
			capital =  0.0;
		}
		
		return capital;
	}
	
	public Double grossTax() {
		Double grossTax = salaryTax() + servicesTax() + capitalTax();;
		return grossTax;
		
	}
	
	public Double taxRebate() {
		Double expensesDeduction = educationSpending + healthSpending;
		Double maxDeduction = grossTax() * 0.3;
		Double taxRebate = 0.0;
		
		if (maxDeduction > expensesDeduction) {
			taxRebate = expensesDeduction;
		}else {
			taxRebate =  maxDeduction;
		}
		return taxRebate;
	}
	
	public Double netTax() {
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
