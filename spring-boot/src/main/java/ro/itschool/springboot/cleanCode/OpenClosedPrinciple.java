package ro.itschool.springboot.cleanCode;

public class OpenClosedPrinciple {

    public static void main(String[] args) {
        PricingService pricingService = new PricingService();

        pricingService.setPricingStrategy(new DefaultPricingStrategy());
        double defaultPrice = pricingService.calculateFinalPrice(100.00);

        pricingService.setPricingStrategy(new DiscountPricingStrategy(10));
        double discountedPrice = pricingService.calculateFinalPrice(100.00);
    }
}

interface PricingStrategy {

    double calculatePrice(double price);
}

class DefaultPricingStrategy implements PricingStrategy {

    @Override
    public double calculatePrice(double price) {
        //implement logic
        return 0;
    }
}

class DiscountPricingStrategy implements PricingStrategy {

    private double discountPercentage;

    public DiscountPricingStrategy(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public double calculatePrice(double price) {
        //implement logic with discountPercentage
        return 0;
    }
}

class SpecialOfferPricingStrategy implements PricingStrategy {

    private double specialOfferDiscount;

    public SpecialOfferPricingStrategy(double specialOfferDiscount) {
        this.specialOfferDiscount = specialOfferDiscount;
    }

    @Override
    public double calculatePrice(double price) {
        //implement logic with specialOfferDiscount
        return 0;
    }
}

class PricingService {

    private PricingStrategy pricingStrategy;

    public void setPricingStrategy(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateFinalPrice(double price) {
        return pricingStrategy.calculatePrice(price);
    }
}