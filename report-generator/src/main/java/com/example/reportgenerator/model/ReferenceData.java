package com.example.reportgenerator.model;

import java.util.Objects;

public class ReferenceData {
    private String refkey1;
    private String refdata1;
    private String refkey2;
    private String refdata2;
    private String refdata3;
    private Double refdata4;

    /**
     * Default constructor.
     */
    public ReferenceData() {}

    /**
     * Parameterized constructor.
     *
     * @param refkey1 Reference key 1
     * @param refdata1 Reference data 1
     * @param refkey2 Reference key 2
     * @param refdata2 Reference data 2
     * @param refdata3 Reference data 3
     * @param refdata4 Reference data 4
     */
    public ReferenceData(String refkey1, String refdata1, String refkey2, String refdata2, String refdata3, Double refdata4) {
        this.refkey1 = refkey1;
        this.refdata1 = refdata1;
        this.refkey2 = refkey2;
        this.refdata2 = refdata2;
        this.refdata3 = refdata3;
        this.refdata4 = refdata4;
    }

    // Getters and setters

    public String getRefkey1() {
        return refkey1;
    }

    public void setRefkey1(String refkey1) {
        this.refkey1 = refkey1;
    }

    public String getRefdata1() {
        return refdata1;
    }

    public void setRefdata1(String refdata1) {
        this.refdata1 = refdata1;
    }

    public String getRefkey2() {
        return refkey2;
    }

    public void setRefkey2(String refkey2) {
        this.refkey2 = refkey2;
    }

    public String getRefdata2() {
        return refdata2;
    }

    public void setRefdata2(String refdata2) {
        this.refdata2 = refdata2;
    }

    public String getRefdata3() {
        return refdata3;
    }

    public void setRefdata3(String refdata3) {
        this.refdata3 = refdata3;
    }

    public Double getRefdata4() {
        return refdata4;
    }

    public void setRefdata4(Double refdata4) {
        this.refdata4 = refdata4;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReferenceData that = (ReferenceData) o;
        return Objects.equals(refkey1, that.refkey1) &&
                Objects.equals(refdata1, that.refdata1) &&
                Objects.equals(refkey2, that.refkey2) &&
                Objects.equals(refdata2, that.refdata2) &&
                Objects.equals(refdata3, that.refdata3) &&
                Objects.equals(refdata4, that.refdata4);
    }

    @Override
    public int hashCode() {
        return Objects.hash(refkey1, refdata1, refkey2, refdata2, refdata3, refdata4);
    }

    @Override
    public String toString() {
        return "ReferenceData{" +
                "refkey1='" + refkey1 + '\'' +
                ", refdata1='" + refdata1 + '\'' +
                ", refkey2='" + refkey2 + '\'' +
                ", refdata2='" + refdata2 + '\'' +
                ", refdata3='" + refdata3 + '\'' +
                ", refdata4=" + refdata4 +
                '}';
    }
}
