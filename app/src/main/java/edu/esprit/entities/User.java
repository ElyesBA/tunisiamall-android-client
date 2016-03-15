package edu.esprit.entities;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    private int idUser;
    private String address;
    private String firstName;
    private String gender;
    private String job;
    private String lastName;
    private String login;
    private String mail;
    private String password;
    private String phone;
    private String pictureUrl;

    public User() {
    }

    public User(Parcel in) {
        idUser = in.readInt();
        address = in.readString();
        firstName = in.readString();
        gender = in.readString();
        job = in.readString();
        lastName = in.readString();
        login = in.readString();
        mail = in.readString();
        password = in.readString();
        phone = in.readString();
        pictureUrl = in.readString();
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(idUser);
        dest.writeString(address);
        dest.writeString(firstName);
        dest.writeString(gender);
        dest.writeString(job);
        dest.writeString(lastName);
        dest.writeString(login);
        dest.writeString(mail);
        dest.writeString(password);
        dest.writeString(phone);
        dest.writeString(pictureUrl);
    }

    public static final Parcelable.Creator<User> CREATOR = new Parcelable.Creator<User>() {
        @Override
        public User createFromParcel(Parcel source) {
            return new User(source);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return idUser == user.idUser;

    }

    @Override
    public int hashCode() {
        return idUser;
    }
}
