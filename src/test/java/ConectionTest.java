import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by twohlatz on 25.05.2018.
 */
public class ConectionTest  {

    @Test
    public void VerifyConnection(){

        String endponint="";
        String username = "Your user name";
        String password = "and password";
        int programId= -1;

        DummyServiceClient client = new DummyServiceClient(username,password,programId,Optional.empty());

        Assert.assertTrue( "Error during connection test, please check console output!",DummyRuntime.process(client));



    }
}
