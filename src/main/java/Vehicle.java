import java.math.BigDecimal;

public class Vehicle extends Asset {

    private String makeModel;
    private int year;
    private int odometer;

    public Vehicle(String description, String dateAcquired, BigDecimal originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    @Override
    public BigDecimal getValue() {
        int age = 2027 - year;

        BigDecimal value;
        BigDecimal depreciation = null;
        BigDecimal oneMinusDepreciation = BigDecimal.ONE.subtract(depreciation);

        if (age > 10) {
            value = new BigDecimal("1000.00");
        }

        if (age <= 3) {
            depreciation = new BigDecimal("0.03");
        } else if (age <= 6) {
            depreciation = new BigDecimal("0.06");
        } else {
            depreciation = new BigDecimal("0.08");
        }



            value = getOriginalCost().multiply(BigDecimal.valueOf(Math.pow(oneMinusDepreciation, age)));
        }

        // Reduce value by 25% if over 100,000 miles
        // unless make/model contains Honda or Toyota
        String model = makeModel.toLowerCase();

        if (odometer > 100000
                && !model.contains("honda")
                && !model.contains("toyota")) {

            value = value.multiply(new BigDecimal("0.75"));
        }

        return value;
    }
    }
}
