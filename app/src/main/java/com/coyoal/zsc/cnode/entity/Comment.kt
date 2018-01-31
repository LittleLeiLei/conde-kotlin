package com.coyoal.zsc.cnode.entity

import android.os.Parcel
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*

/**
 *
 * Created by Administrator on 2017/11/5.
 */
@JsonIgnoreProperties("is_uped")
class Comment() : Parcelable {
    var id: String = ""
    var author: User = User()
    var content: String = ""
    var create_at: String = ""
    var reply_id: String? = ""
    // var is_uped: Boolean = false
    var ups: List<String> = ArrayList()

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        author = parcel.readParcelable(User::class.java.classLoader)
        content = parcel.readString()
        create_at = parcel.readString()
        reply_id = parcel.readString()
        ups = parcel.createStringArrayList()
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeParcelable(author, flags)
        parcel.writeString(content)
        parcel.writeString(create_at)
        parcel.writeString(reply_id)
        parcel.writeStringList(ups)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Comment> {
        override fun createFromParcel(parcel: Parcel): Comment {
            return Comment(parcel)
        }

        override fun newArray(size: Int): Array<Comment?> {
            return arrayOfNulls(size)
        }
    }
}