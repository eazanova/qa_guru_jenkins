package config;

import org.aeonbits.owner.Config;

/**
 * Title
 *
 * @author eazanova
 * @since 16.05.2022
 */
@Config.Sources("classpath:config/credentials.properties")
public interface CredentialsConfig extends Config
{
    String login();
    String pswd();
}
