package designpattern.factorydesignpattern;

public class DriverSetupFactory {

    public static DriverSetup getDriverSetup(String platformName){

        return switch (platformName.toLowerCase()) {
            case "android" -> new AndroidDriverSetup();
            case "ios" -> new IosDriverSetup();
            case "chrome" -> new ChromeDriverSetup();
            case "edge" -> new EdgeDriverSetup();
            default -> throw new IllegalArgumentException("No matching driver for given platformName.");
        };


    }




}
