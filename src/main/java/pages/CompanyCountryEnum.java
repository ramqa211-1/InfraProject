package pages;

import io.qameta.allure.Step;

public enum CompanyCountryEnum {

    ALFREDS_FUTTERKISTE("Alfreds Futterkiste", "Germany"),
    CENTRO_COMERCIAL_MOCTEZUMA("Centro comercial Moctezuma", "Mexico"),
    ERNST_HANDEL("Ernst Handel", "Austria"),
    ISLAND_TRADING("Island Trading", "UK"),
    LAUGHING_BACCHUS_WINECELLARS("Laughing Bacchus Winecellars", "Canada"),
    MAGAZZINI_ALIMENTARI_RIUNITI("Magazzini Alimentari Riuniti", "Italy");

    private final String companyName;
    private final String country;

    CompanyCountryEnum(String companyName, String country) {
        this.companyName = companyName;
        this.country = country;
    }

    @Step("get company name")
    public String getCompanyName() {
        return companyName;
    }

    @Step("get country name")
    public String getCountry() {
        return country;
    }
}
