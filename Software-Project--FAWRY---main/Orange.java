public class Orange extends ServiceProviderFactory{
    @Override
    public MobileRechargeService createMobileService() { return new OrangeMobileService();
    }

    @Override
    public InternetService createInternetService() { return new OrangeInternetService();
    }

    }

