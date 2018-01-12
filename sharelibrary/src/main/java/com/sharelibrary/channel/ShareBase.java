package com.sharelibrary.channel;

import android.content.Context;

import com.sharelibrary.interfaces.IShareBase;


/**
 * Created by zhanglifeng
 */
public abstract class ShareBase implements IShareBase {

    Context context;

    public ShareBase(Context context) {
        this.context = context;
    }

}
