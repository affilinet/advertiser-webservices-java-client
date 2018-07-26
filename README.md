# Example Java Client affilinet OrderManagement Webservice

This is an example implementation for a Java advertiser webservices client for the affilinet OrderManagement Webservice for advertisers.

If you want to use this for managing your advertiser account and transactions, be assure:
- You have a valid user name and password credentials,
- you program is not on hold, deleted or otherwise inactive

**Attention** 

The affilinet platform is currently merging with the AWIN platform, which at the moment provides no webservice infrastructure for controlling your advertiser account at.
Within the AWIN platform you can currently upload CSV files for automated management of your transactions.

If you have any questions, please consult your key account manager.

**How to use this client implementation:**
* Setup the project
* Ensure all maven dependencies from within the POM are satisfied
* Execute the maven goal 'clean compile jaxws:wsimport'
    * this will generate the proxy client from the wsdl url within the POM file
    * If everything works fine
        * proxy BL classes will appear under 'src.generated.java'
        * and the project is compiling
* Replace your credentials and account data within the connection test
    * execute the test to verify your connection with maven goal 'test'


