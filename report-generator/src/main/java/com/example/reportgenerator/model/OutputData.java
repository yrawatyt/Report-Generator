package com.example.reportgenerator.model;

import java.util.Objects;

public class OutputData {
    private String outfield1;
    private String outfield2;
    private String outfield3;
    private Double outfield4;
    private Double outfield5;

    /**
     * Default constructor.
     */
    public OutputData() {}

    /**
     * Parameterized constructor.
     *
     * @param outfield1 Output field 1
     * @param outfield2 Output field 2
     * @param outfield3 Output field 3
     * @param outfield4 Output field 4
     * @param outfield5 Output field 5
     */
    public OutputData(String outfield1, String outfield2, String outfield3, Double outfield4, Double outfield5) {
        this.outfield1 = outfield1;
        this.outfield2 = outfield2;
        this.outfield3 = outfield3;
        this.outfield4 = outfield4;
        this.outfield5 = outfield5;
    }

    // Getters and setters

    public String getOutfield1() {
        return outfield1;
    }

    public void setOutfield1(String outfield1) {
        this.outfield1 = outfield1;
    }

    public String getOutfield2() {
        return outfield2;
    }

    public void setOutfield2(String outfield2) {
        this.outfield2 = outfield2;
    }

    public String getOutfield3() {
        return outfield3;
    }

    public void setOutfield3(String outfield3) {
        this.outfield3 = outfield3;
    }

    public Double getOutfield4() {
        return outfield4;
    }

    public void setOutfield4(Double outfield4) {
        this.outfield4 = outfield4;
    }

    public Double getOutfield5() {
        return outfield5;
    }

    public void setOutfield5(Double outfield5) {
        this.outfield5 = outfield5;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OutputData that = (OutputData) o;
        return Objects.equals(outfield1, that.outfield1) &&
                Objects.equals(outfield2, that.outfield2) &&
                Objects.equals(outfield3, that.outfield3) &&
                Objects.equals(outfield4, that.outfield4) &&
                Objects.equals(outfield5, that.outfield5);
    }

    @Override
    public int hashCode() {
        return Objects.hash(outfield1, outfield2, outfield3, outfield4, outfield5);
    }

    @Override
    public String toString() {
        return "OutputData{" +
                "outfield1='" + outfield1 + '\'' +
                ", outfield2='" + outfield2 + '\'' +
                ", outfield3='" + outfield3 + '\'' +
                ", outfield4=" + outfield4 +
                ", outfield5=" + outfield5 +
                '}';
    }
}
