package com.arkarzaw.simplehabit.Data.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemModel implements Parcelable {
    int Image;
    String Header,Time;

    public ItemModel(int image, String header, String time) {
        Image = image;
        Header = header;
        Time = time;
    }

    protected ItemModel(Parcel in) {
        Image = in.readInt();
        Header = in.readString();
        Time = in.readString();
    }

    public static final Creator<ItemModel> CREATOR = new Creator<ItemModel>() {
        @Override
        public ItemModel createFromParcel(Parcel in) {
            return new ItemModel(in);
        }

        @Override
        public ItemModel[] newArray(int size) {
            return new ItemModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(Image);
        parcel.writeString(Header);
        parcel.writeString(Time);
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getHeader() {
        return Header;
    }

    public void setHeader(String header) {
        Header = header;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public static Creator<ItemModel> getCREATOR() {
        return CREATOR;
    }
}
