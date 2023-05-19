public class Vodafone extends ServiceProviderFactory {

    @Override
    public MobileRechargeService createMobileService() {
        return new VodafoneMobileService();
    }

    @Override
    public InternetService createInternetService() {
        return new VodafoneInternerService();
    }
}
