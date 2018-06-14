# Example Java Client affilinet Advertiser Webservices

This is the dummy implementation for a Java advertiser webservices client, for the affilinet infrastructure.

If you want to use this for managing your advertiser account and transactions,
be assure:
- You have a valid user name and password credentials,
- you program is not on hold deleted or otherwise inactive

**Attention** 
affilinet is right now merging with the awin affilinet marketing network, which provides no webservice infrastructure for controlling your advertiser account.
Within the awin platform currently you can only upload CSV files for automated management your transactions.

If you have any questions, please consult you key account manager, within the affilinet company.

**Howto use this client implementation:**
* Setup the project
* Ensure all maven dependencies from within the POM are satisfied
* Execute the maven goal 'clean compile jaxws:wsimport'
    * this will generate the proxy client from the wsdl url within the POM file
    * If everything works fine
        * proxy BL classes will appear under 'src.generated.java'
        * and the project is compiling
* Replace your credentials and account data within the connection test
    * execute the test to verify your connection


