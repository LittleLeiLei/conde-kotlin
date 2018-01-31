package com.coyoal.zsc.cnode.entity

import android.os.Parcel
import android.os.Parcelable

/**
 *
 * Created by Administrator on 2017/11/5.
 */
class User() : Parcelable {
    var id: String = ""
    var loginname: String = ""
    var avatar_url: String = ""

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        loginname = parcel.readString()
        avatar_url = parcel.readString()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(loginname)
        parcel.writeString(avatar_url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}