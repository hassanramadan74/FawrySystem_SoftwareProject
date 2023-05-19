public class We extends ServiceProviderFactory{

    @Override
    public MobileRechargeService createMobileService() {
        return new WeMobileService();
    }

    @Override
    public InternetService createInternetService() { return new WeInternetService();
    }
}

