package Constants;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Utils {

   public static void wait(int args)
    {
// WAIT IN SECONDS
        try
        {
            TimeUnit.SECONDS.sleep(4);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
