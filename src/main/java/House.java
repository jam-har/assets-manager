import java.math.BigDecimal;
import java.math.RoundingMode;

public class House extends Asset {

    private String address;
    private int condition;
    private int squareFoot;
    private int lotSize;

    public House(String description, String dateAcquired, BigDecimal originalCost, String address, int condition, int squareFoot, int lotSize) {
        super(description, dateAcquired, originalCost);
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCondition() {
        return condition;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    @Override
    public BigDecimal getValue() {
        BigDecimal pricePerSqFt = getOriginalCost().divide(BigDecimal.valueOf(squareFoot), 2, RoundingMode.HALF_UP);
        if (condition == 1) {
            pricePerSqFt = BigDecimal.valueOf(180.00);
        } else if (condition == 2) {
            pricePerSqFt = BigDecimal.valueOf(130.00);
        } else if (condition == 3) {
            pricePerSqFt = BigDecimal.valueOf(90.00);
        } else if (condition == 4) {
            pricePerSqFt = BigDecimal.valueOf(80.00);
        }

        BigDecimal lotValue = BigDecimal.valueOf(0.25).multiply(BigDecimal.valueOf(squareFoot));

        return lotValue.add(pricePerSqFt);
    }
}
