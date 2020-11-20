package Design_mode.pattern_facade;


import Design_mode.pattern_facade.organization.AdminOfIndustry;
import Design_mode.pattern_facade.organization.Bank;
import Design_mode.pattern_facade.organization.Company;
import Design_mode.pattern_facade.organization.Taxation;

public class Facade {

	private AdminOfIndustry admin = new AdminOfIndustry();
	private Bank bank = new Bank();
	private Taxation taxation = new Taxation();

	public Company openCompany(String name) {
		Company c = this.admin.register(name);
		String bankAccount = this.bank.openAccount(c.getId());
		c.setBankAccount(bankAccount);
		String taxCode = this.taxation.applyTaxCode(c.getId());
		c.setTaxCode(taxCode);
		return c;
	}
}
