package Design_mode.pattern_facade;

import Design_mode.pattern_facade.organization.Company;

import java.io.IOException;



/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 
 * @author liaoxuefeng
 */
public class Main {

	public static void main(String[] args) throws IOException {
		Facade facade = new Facade();
		Company c = facade.openCompany("Facade Software Ltd.");
		System.out.println(c);
	}
}
