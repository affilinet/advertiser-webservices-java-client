import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

/**
 * Created by twohlatz on 25.05.2018.
 */
public class ConectionTest  {

    @Test
    public void VerifyConnection(){


        String endponint="https://advertiser-webservices.affili.net/V5/advertiserservice.svc";

        String username = "";
        String password = "";
        int programId= -1;

        DummyServiceClient client = new DummyServiceClient(username,password,programId, Optional.of(endponint));

        Assert.assertTrue( "Error during connection test, please check console output!",DummyRuntime.process(client));



    }
}
