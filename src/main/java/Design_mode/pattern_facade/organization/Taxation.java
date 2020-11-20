package Design_mode.pattern_facade.organization;

public class Taxation {

	public String applyTaxCode(String companyId) {
		return String.format("1%015d", 0x7fffffff & companyId.hashCode());
	}
}
