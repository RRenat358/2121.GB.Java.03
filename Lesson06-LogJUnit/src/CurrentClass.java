import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CurrentClass {

    private static final Logger logger = LogManager.getLogger(CurrentClass.class);


    //logLevels

    // Trace > Debug > Info > Warn > Error > Fatal
    //     1       2      3      4       5       6


    public static void main(String[] args) {

        int logLevel = 2;

        int a = 50;
        if (logLevel <= 2) {
            System.out.println(System.currentTimeMillis() + " our method: a = " + a);
        }
        logger.debug("a = {}", a);

        int b = 10;
        if (logLevel <= 2) {
            System.out.println(System.currentTimeMillis() + " our method: b = " + b);
        }
        logger.debug("b = {}", b);

        int c = a + b;
        if (logLevel <= 2) {
            System.out.println(System.currentTimeMillis() + " our method: c = " + c);
        }
        logger.info("c = {} + {} = {}", a, b, c);


        //Logger, Appender, Layout

        logger.trace("Trace");
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("Warn");
        logger.error("Error");
        logger.fatal("Fatal");


    }


}
