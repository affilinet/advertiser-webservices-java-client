import affilinet.advws.client.GetOrdersRequest;
import affilinet.advws.client.GetOrdersResponse;
import affilinet.advws.client.GetTransactionsRequest;
import affilinet.advws.client.GetTransactionsResponse;

import java.util.Optional;

public class DummyRuntime {

    public static void main(String[] args) {

        DummyServiceClient client = new DummyServiceClient("Dummy", "Value",0, Optional.empty());
        if(process(client)){
            System.out.println("Successful executed AdvWs client");
            return;
        }
        System.out.println("Unsuccessful executed AdvWs client");

    }

    public static boolean process(DummyServiceClient client) {
    boolean processSuccessful = false;
        try {

            GetOrdersRequest request = client.BuildDummyTransactionsRequest();
            GetOrdersResponse response = client.getPort().getOrders(request);

//            GetTransactionsRequest request = client.BuildDummyTransactionsRequest();
//            GetTransactionsResponse response = client.getPort().getTransactions(request);

            System.out.println("Total transactions matching the request-parameters: " + response.getTotalCount());
            System.out.println("Number of transactions in this response: " + response.getOrderCollection().getValue().getOrder().size());
            processSuccessful=true;
        } catch (Exception ex) {
            System.out.println(ex);
            if (ex.getMessage().startsWith("2030000020")) {
                System.out.println("You are not allowd to access the provided programId data or \r\nyour source IP is not white listed in the affilinet infrastructure for using Advertiser Webservices, \r\nplease contact you KAM");
            }
        }
        return processSuccessful;
    }
}
