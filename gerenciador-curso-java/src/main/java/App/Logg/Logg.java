package App.Logg;

import org.apache.log4j.Logger;

public class Logg {

    public static void init() {
        org.apache.log4j.PropertyConfigurator.configure("src\\test\\java\\log4j.properties");
    }
}
