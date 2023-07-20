package util;

public enum Grade {
    A("A", 4),
    B("B", 3),
    C("C", 2),
    D("D", 1),
    F("F", 0);

    private String stringValue;
    private int numericValue;

    Grade(String stringValue, int numericValue) {
        this.stringValue = stringValue;
        this.numericValue = numericValue;
    }

    public String getStringValue() {
        return stringValue;
    }

    public int getNumericValue() {
        return numericValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public void setNumericValue(int numericValue) {
        this.numericValue = numericValue;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "stringValue='" + stringValue + '\'' +
                ", numericValue=" + numericValue +
                '}';
    }
}
