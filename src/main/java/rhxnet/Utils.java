package rhxnet;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {
    /**
     * @param name Logger name
     * @return new logger instance
     */
    public static Logger getLogger(String name)
    {
        final Logger logger = Logger.getLogger(name);
        logger.setLevel(Level.ALL); // FIXME: remove
        return logger;
    }

}
