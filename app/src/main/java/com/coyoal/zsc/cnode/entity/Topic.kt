package com.coyoal.zsc.cnode.entity

import android.os.Parcel
import android.os.Parcelable
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.util.*

/**
 *
 * Created by Administrator on 2017/11/5.
 */
@JsonIgnoreProperties("is_collect")
class Topic() : Parcelable {
    var id: String = ""
    var author_id: String = ""
    var tab: String = ""
    var content: String = ""
    var title: String = ""
    var last_reply_at: String = ""
    var good: Boolean = false
    var top: Boolean = false
    var is_collect: Boolean = false
    var reply_count: Int = 0
    var visit_count: Int = 0
    var create_at: String = ""
    var author: User = User()
    var replies: ArrayList<Comment> = ArrayList()

    constructor(parcel: Parcel) : this() {
        id = parcel.readString()
        author_id = parcel.readString()
        tab = parcel.readString()
        content = parcel.readString()
        title = parcel.readString()
        last_reply_at = parcel.readString()
        good = parcel.readByte() != 0.toByte()
        top = parcel.readByte() != 0.toByte()
        is_collect = parcel.readByte() != 0.toByte()
        reply_count = parcel.readInt()
        visit_count = parcel.readInt()
        create_at = parcel.readString()
        author = parcel.readParcelable(User::class.java.classLoader)
        replies = parcel.createTypedArrayList(Comment.CREATOR)
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(author_id)
        parcel.writeString(tab)
        parcel.writeString(content)
        parcel.writeString(title)
        parcel.writeString(last_reply_at)
        parcel.writeByte(if (good) 1 else 0)
        parcel.writeByte(if (top) 1 else 0)
        parcel.writeByte(if (is_collect) 1 else 0)
        parcel.writeInt(reply_count)
        parcel.writeInt(visit_count)
        parcel.writeString(create_at)
        parcel.writeParcelable(author, flags)
        parcel.writeTypedList(replies)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Topic> {
        override fun createFromParcel(parcel: Parcel): Topic {
            return Topic(parcel)
        }

        override fun newArray(size: Int): Array<Topic?> {
            return arrayOfNulls(size)
        }
    }
}