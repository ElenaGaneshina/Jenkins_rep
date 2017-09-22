package enums;

public enum Log {
    WIND_TRUE("Wind: condition changed to true"),
    WATER_TRUE("Water: condition changed to true"),
    EARTH_TRUE("Earth: condition changed to true"),
    FIRE_TRUE("Fire: condition changed to true"),
    WIND_FALSE("Wind: condition changed to false"),
    WATER_FALSE("Water: condition changed to false"),
    EARTH_FALSE("Earth: condition changed to false"),
    FIRE_FALSE("Fire: condition changed to false"),

    BRONZE_SET("metal: value changed to Bronze"),
    GOLD_SET("metal: value changed to Gold"),
    SILVER_SET("metal: value changed to Silver"),
    SELEN_SET("metal: value changed to Selen"),

    YELLOW_SET("Colors: value changed to Yellow"),
    RED_SET("Colors: value changed to Red"),
    GREEN_SET("Colors: value changed to Green"),
    BLUE_SET("Colors: value changed to Blue");

    public String log;

    Log(String radioBtn){
        this.log = radioBtn ;
    }
}
