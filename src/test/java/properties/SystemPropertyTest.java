package properties;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

/**
 * Title
 *
 * @author eazanova
 * @since 16.05.2022
 */
public class SystemPropertyTest
{
    CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    @Test
    void someTest()
    {
        String br = System.getProperty("browser");
        System.out.println(br);
    }

    @Test
    void ownerTest()
    {
        String login = config.login();
        String pswd = config.pswd();

        System.out.println(login);
        System.out.println(pswd);
    }
}
