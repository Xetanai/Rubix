package moe.xetanai.rubix.utils;

import moe.xetanai.rubix.Main;
import moe.xetanai.rubix.RubixInfo;
import net.dv8tion.jda.core.entities.SelfUser;
import net.dv8tion.jda.core.entities.User;

public class BotMetaUtils {

    private static SelfUser BOT_USER = null;

    private static String PREFIX = "!"; // Should all else fail, we *need* a prefix of some sort, lest chaos ensue.

    private BotMetaUtils () {}

    /**
     * @return the bot's {@link net.dv8tion.jda.core.entities.SelfUser SelfUser} object
     */
    public static SelfUser getBotUser () {
        if (BOT_USER == null) {
            BOT_USER = Main.getApi().getSelfUser();
        }
        // We have to fetch it post-start at least once, since this is unavailable until logged in.
        return BOT_USER;
    }

    /**
     * I don't expect to ever have codevelopers, but having the framework in place doesn't hurt.
     *
     * @return An array of users instantiated using the IDs in RubixInfo.OWNER_IDS
     */
    public static User[] getOwners () {
        User[] owners = new User[RubixInfo.OWNER_IDS.length];
        for (int i = 0; i < owners.length; i++) {
            owners[i] = Main.getApi().getUserById(RubixInfo.OWNER_IDS[i]);
        }
        return owners;
    }

    /**
     * @return the default prefix to use when none is configured by the guild
     */
    public static String getDefaultPrefix () {
        return PREFIX;
    }

    /**
     * Sets the prefix to be used when none is configured
     *
     * @param prefix The new prefix to use
     */
    public static void setDefaultPrefix (String prefix) {
        PREFIX = prefix;
    }
}
