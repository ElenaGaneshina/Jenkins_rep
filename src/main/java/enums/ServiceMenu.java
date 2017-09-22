package enums;

public enum ServiceMenu {
    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table "),
    SIMPLE_TABLE("Simple Table "),
    TABLE_WITH_PAGES("Table with pages"),
    DIFFERENT_ELEMENTS("Different elements");
    public String serviceItem;

    ServiceMenu(String serviceItem) {
        this.serviceItem = serviceItem;
    }

}