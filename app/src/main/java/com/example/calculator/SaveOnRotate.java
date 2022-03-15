package com.example.calculator;

import android.os.Parcel;
import android.os.Parcelable;

public class SaveOnRotate implements Parcelable {

    private double input1 = 0, input2 = 0;
    private boolean Plus, Minus, Multiply, Div;

    public SaveOnRotate() {
        input1 = 0;
        input2 = 0;
        Plus = false;
        Minus = false;
        Multiply = false;
        Div = false;
    }

    protected SaveOnRotate(Parcel in) {
        input1 = in.readInt();
        input2 = in.readInt();
        Plus = in.readByte() != 0;
        Minus = in.readByte() != 0;
        Multiply = in.readByte() != 0;
        Div = in.readByte() != 0;
    }

    public static final Creator<SaveOnRotate> CREATOR = new Creator<SaveOnRotate>() {
        @Override
        public SaveOnRotate createFromParcel(Parcel in) {
            return new SaveOnRotate(in);
        }

        @Override
        public SaveOnRotate[] newArray(int size) {
            return new SaveOnRotate[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(input1);
        parcel.writeDouble(input2);
        parcel.writeByte((byte) (Plus ? 1 : 0));
        parcel.writeByte((byte) (Minus ? 1 : 0));
        parcel.writeByte((byte) (Multiply ? 1 : 0));
        parcel.writeByte((byte) (Div ? 1 : 0));
    }

    public double getInput1() {
        return input1;
    }

    public double getInput2() {
        return input2;
    }

    public boolean isPlus() {
        return Plus;
    }

    public boolean isMinus() {
        return Minus;
    }

    public boolean isMultiply() {
        return Multiply;
    }

    public boolean isDiv() {
        return Div;
    }

    public void setInput1(double input1) {
        this.input1 = input1;
    }

    public void setInput2(double input2) {
        this.input2 = input2;
    }

    public void setPlus(boolean plus) {
        Plus = plus;
    }

    public void setMinus(boolean minus) {
        Minus = minus;
    }

    public void setMultiply(boolean multiply) {
        Multiply = multiply;
    }

    public void setDiv(boolean div) {
        Div = div;
    }
}
