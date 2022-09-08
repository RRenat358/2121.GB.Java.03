import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CurrentClass {

    private static final Logger logger = LogManager.getLogger(CurrentClass.class);


    //==============================
    //Logger, Appender, Layout

    //==============================
    //logLevels

    // Trace > Debug > Info > Warn > Error > Fatal
    //     1       2      3      4       5       6


    //==============================
    public static void main(String[] args) {

        int logLevel = 2;

        //==============================
        int a = 50;

        if (logLevel <= 2) {
            System.out.println(System.currentTimeMillis() + " our method: a = " + a);
        }
        // OR Logger:
        logger.debug("a = {}", a);


        //==============================
        int b = 10;

        if (logLevel <= 2) {
            System.out.println(System.currentTimeMillis() + " our method: b = " + b);
        }
        // OR Logger:
        logger.debug("b = {}", b);


        //==============================
        int c = a + b;

        if (logLevel <= 2) {
            System.out.println(System.currentTimeMillis() + " our method: c = " + c);
        }
        // OR Logger:
        logger.info("c = {} + {} = {}", a, b, c);


        //==============================
        logger.trace("Trace");
        logger.debug("Debug");
        logger.info("Info");
        logger.warn("Warn");
        logger.error("Error");
        logger.fatal("Fatal");


    }


}
