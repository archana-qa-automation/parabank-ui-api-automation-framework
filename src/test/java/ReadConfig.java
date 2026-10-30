import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(
            "src/test/resources/config.properties");

        Properties prop = new Properties();

        prop.load(fis);

        System.out.println(prop.getProperty("url"));
        System.out.println(prop.getProperty("browser"));
        System.out.println(prop.getProperty("environment"));

        fis.close();
    }
}