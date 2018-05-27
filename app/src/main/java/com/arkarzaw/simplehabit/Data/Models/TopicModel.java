package com.arkarzaw.simplehabit.Data.Models;

import android.os.Parcel;
import android.os.Parcelable;

public class TopicModel implements Parcelable {
    int Image;
    String Title,Content;

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public static Creator<TopicModel> getCREATOR() {
        return CREATOR;
    }

    public TopicModel(int image, String title, String content) {

        Image = image;
        Title = title;
        Content = content;
    }

    protected TopicModel(Parcel in) {
        Image = in.readInt();
        Title = in.readString();
        Content = in.readString();
    }

    public static final Creator<TopicModel> CREATOR = new Creator<TopicModel>() {
        @Override
        public TopicModel createFromParcel(Parcel in) {
            return new TopicModel(in);
        }

        @Override
        public TopicModel[] newArray(int size) {
            return new TopicModel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(Image);
        parcel.writeString(Title);
        parcel.writeString(Content);
    }
}
