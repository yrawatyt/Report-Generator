package com.example.reportgenerator.model;

import java.util.Objects;

public class InputData {
    private String field1;
    private String field2;
    private String field3;
    private String field4;
    private Double field5;
    private String refkey1;
    private String refkey2;

    /**
     * Default constructor.
     */
    public InputData() {}

    /**
     * Parameterized constructor.
     *
     * @param field1 Field 1
     * @param field2 Field 2
     * @param field3 Field 3
     * @param field4 Field 4
     * @param field5 Field 5
     * @param refkey1 Reference key 1
     * @param refkey2 Reference key 2
     */
    public InputData(String field1, String field2, String field3, String field4, Double field5, String refkey1, String refkey2) {
        this.field1 = field1;
        this.field2 = field2;
        this.field3 = field3;
        this.field4 = field4;
        this.field5 = field5;
        this.refkey1 = refkey1;
        this.refkey2 = refkey2;
    }

    // Getters and setters

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getField4() {
        return field4;
    }

    public void setField4(String field4) {
        this.field4 = field4;
    }

    public Double getField5() {
        return field5;
    }

    public void setField5(Double field5) {
        this.field5 = field5;
    }

    public String getRefkey1() {
        return refkey1;
    }

    public void setRefkey1(String refkey1) {
        this.refkey1 = refkey1;
    }

    public String getRefkey2() {
        return refkey2;
    }

    public void setRefkey2(String refkey2) {
        this.refkey2 = refkey2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InputData inputData = (InputData) o;
        return Objects.equals(field1, inputData.field1) &&
                Objects.equals(field2, inputData.field2) &&
                Objects.equals(field3, inputData.field3) &&
                Objects.equals(field4, inputData.field4) &&
                Objects.equals(field5, inputData.field5) &&
                Objects.equals(refkey1, inputData.refkey1) &&
                Objects.equals(refkey2, inputData.refkey2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field1, field2, field3, field4, field5, refkey1, refkey2);
    }

    @Override
    public String toString() {
        return "InputData{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", field4='" + field4 + '\'' +
                ", field5=" + field5 +
                ", refkey1='" + refkey1 + '\'' +
                ", refkey2='" + refkey2 + '\'' +
                '}';
    }
}
