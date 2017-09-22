package enums;

public enum MainMenu {
    HOME("Home"),
    CONTACT_FORM("Contact form"),
    SERVICE("Service"),
    METAL_AND_COLORS("Metals & Colors");

    public String menuItem;

    MainMenu(String menuItem) {
        this.menuItem = menuItem;
    }
}
