package com.sharelibrary.interfaces;


import com.sharelibrary.bean.ShareEntity;

/**
 * Created by zhanglifeng
 */
public interface IShareBase {
    /**
     * @param data {@link ShareEntity}
     * @param listener {@link OnShareListener}
     */
    void share(ShareEntity data, OnShareListener listener);
}
