package edu.esprit.entities;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

public class Message implements Parcelable {
    private int idMessage;
    private Date date;
    private String text;
    private int me;
    private User sender;
    private User receiver;

    public Message() {
    }

    public Message(Parcel in) {
        idMessage = in.readInt();
        date = new Date(in.readLong());
        text = in.readString();
        me = in.readInt();
        sender = in.readParcelable(User.class.getClassLoader());
        receiver = in.readParcelable(User.class.getClassLoader());
    }

    public int getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(int idMessage) {
        this.idMessage = idMessage;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getMe() {
        return me;
    }

    public void setMe(int me) {
        this.me = me;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idMessage);
        dest.writeLong(date.getTime());
        dest.writeString(text);
        dest.writeInt(me);
        dest.writeParcelable(sender, flags);
        dest.writeParcelable(receiver, flags);
    }

    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel source) {
            return new Message(source);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        return idMessage == message.idMessage;

    }

    @Override
    public int hashCode() {
        return idMessage;
    }
}
