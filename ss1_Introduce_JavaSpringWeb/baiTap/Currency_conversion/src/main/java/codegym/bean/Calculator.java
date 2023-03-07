package codegym.bean;

public class Calculator {
    private double first;
    private double indexTranfer;
    private double result;

    public Calculator() {
    }

    public Calculator(double result) {
        this.result = result;
    }

    public double getFirst() {
        return first;
    }

    public void setFirst(double first) {
        this.first = first;
    }

    public double getIndexTranfer() {
        return indexTranfer;
    }

    public void setIndexTranfer(double indexTranfer) {
        this.indexTranfer = indexTranfer;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }
}
