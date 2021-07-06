public class DaoFactory {
    private static Products productsDao;

    public static Products getProductsDao() {
//        singleton pattern: makes sure there is only a single creation of the Dao. prevents duplication of data
        if (productsDao == null) {
            productsDao = new ListProducts();
        }
        return productsDao;
    }


    private static Ads adsDao;

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }
}
