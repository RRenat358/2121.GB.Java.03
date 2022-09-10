
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

//import java.util.logging.FileHandler;
//import java.util.logging.Handler;
import java.io.IOException;



public class CurrentClass {

    //Simple Logger ~
//    private static final Logger logger = Logger.getLogger("");


    private static final Logger logger = LogManager.getLogger(CurrentClass.class);


    //==============================
    //Logger, Appender, Layout

    //==============================
    //logLevels

    // Trace > Debug > Info > Warn > Error > Fatal
    //     6       5      4      3       2       1


    //==============================
    public static void main(String[] args) throws IOException {

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


        if(logger.isDebugEnabled()){
            logger.debug(" =DebugEnabled= ");
        }

/*
        //Simple Logger ~

        logger.log(Level.INFO, "Info Message");
        logger.setLevel(Level.WARNING);

        logger.getHandlers()[0].setFormatter(new Formatter() {
            @Override
            public String format(LogRecord record) {
                return record.getLevel() + "\t" + record.getMessage() + "\t" + record.getMillis() + "\n";
            }
        });

        logger.log(Level.INFO, "Info Message");
        logger.setLevel(Level.ALL);

        Handler handler = new FileHandler("mylog.log", true);

        logger.addHandler(handler);
        logger.log(Level.WARNING, "Info Message");
        logger.log(Level.CONFIG, "Info Message");
        logger.log(Level.FINER, "Info Message");
*/


    }


}
