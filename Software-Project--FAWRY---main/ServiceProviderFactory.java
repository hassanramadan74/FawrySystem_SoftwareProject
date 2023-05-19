public abstract class ServiceProviderFactory {

    public Services Create(String request) {
        Services service;
        if (request.equals("1") || request.equalsIgnoreCase("MobileRecharge"))
            service = createMobileService();
        else
            service = createInternetService();
        return service;
    }

    public abstract MobileRechargeService createMobileService();

    public abstract InternetService createInternetService();

}
