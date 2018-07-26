import affilinet.advws.client.*;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.Handler;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class DummyServiceClient {

    public OrderManagementContract getPort() {
        return port;
    }

    private OrderManagementContract port;
    private int programId;

    public DummyServiceClient(String username, String password, int programId, Optional<String> endpoint) {
        this.programId = programId;

        OrderManagementService service = new OrderManagementService();
        port = service.getPort(OrderManagementContract.class);

        BindingProvider prov = (BindingProvider) port;
        List<Handler> handlerChain = prov.getBinding().getHandlerChain();
        handlerChain.add(new UsernameTokenHandler(username, password));

        prov.getBinding().setHandlerChain(handlerChain);

        if (endpoint.isPresent()) {
            prov.getRequestContext().put(prov.ENDPOINT_ADDRESS_PROPERTY, endpoint.get());
        }
    }



    public GetOrdersRequest BuildDummyTransactionsRequest() throws DatatypeConfigurationException {
        GetOrdersRequest request = new GetOrdersRequest();
        request.setPage(1);
        request.setPageSize(2);
        request.setProgramId(programId);

        XMLGregorianCalendar startDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 4, 1, 0, 0, 0, 0, 0);
        XMLGregorianCalendar endDate = DatatypeFactory.newInstance().newXMLGregorianCalendar(2017, 6, 30, 0, 0, 0, 0, 0);

        request.setStartDate(startDate);
        request.setEndDate(endDate);

        String nameOfMessages = "http://affilinet.framework.esbfa/advertiserservices/ordermanagement/messages";
        QName transactionStatusQName = new QName(nameOfMessages, TransactionStatus.class.getSimpleName());
        JAXBElement<TransactionStatus> transactionStatus = new JAXBElement<TransactionStatus>(transactionStatusQName, TransactionStatus.class, TransactionStatus.ALL);
        request.setTransactionStatus(transactionStatus);

        QName valuationTypeQName = new QName(nameOfMessages, ValuationType.class.getSimpleName());
        JAXBElement<ValuationType> valuationType = new JAXBElement<ValuationType>(valuationTypeQName, ValuationType.class, ValuationType.REGISTRATION_DATE);
        request.setValuationType(valuationType);

        return request;
    }

    class UsernameTokenHandler implements SOAPHandler<SOAPMessageContext> {

        private String username;
        private String password;

        public UsernameTokenHandler(String username, String password) {
            this.username = username;
            this.password = password;
        }
        public boolean handleMessage(SOAPMessageContext context) {
            Boolean isOutbound = (Boolean) context.get(context.MESSAGE_OUTBOUND_PROPERTY);
            if (isOutbound.booleanValue()) {
                context.put(com.sun.xml.wss.XWSSConstants.USERNAME_PROPERTY, username);
                context.put(com.sun.xml.wss.XWSSConstants.PASSWORD_PROPERTY, password);
            }
            return true;
        }
        public Set<QName> getHeaders() {
            return null;
        }
        public boolean handleFault(SOAPMessageContext context) {
            return true;
        }

        public void close(MessageContext context) {        }

    }

}
