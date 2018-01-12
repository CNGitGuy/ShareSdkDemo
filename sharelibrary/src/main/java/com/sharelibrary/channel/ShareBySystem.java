package com.sharelibrary.channel;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.sharelibrary.R;
import com.sharelibrary.bean.ShareEntity;
import com.sharelibrary.interfaces.OnShareListener;
import com.sharelibrary.interfaces.ShareConstant;
import com.sharelibrary.util.ShareUtil;
import com.sharelibrary.util.ToastUtil;

/**
 * Created by zhanglifeng
 */
public class ShareBySystem extends ShareBase {

    public ShareBySystem(Context context) {
        super(context);
    }

    @Override
    public void share(ShareEntity data, OnShareListener listener) {
        if (data == null || TextUtils.isEmpty(data.getContent())) {
            ToastUtil.showToast(context, R.string.share_empty_tip, true);
            return;
        }
        String content;
        if (TextUtils.isEmpty(data.getContent())) {
            content = data.getTitle() + data.getUrl();
        } else {
            content = data.getContent() + data.getUrl();
        }

        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, content);
        shareIntent.setType("text/plain");
        if(ShareUtil.startActivity(context, Intent.createChooser(
                shareIntent, context.getString(R.string.share_to)))) {
            if (null != listener) {
                listener.onShare(ShareConstant.SHARE_CHANNEL_SYSTEM, ShareConstant.SHARE_STATUS_COMPLETE);
            }
        } else {
            if (null != listener) {
                listener.onShare(ShareConstant.SHARE_CHANNEL_SYSTEM, ShareConstant.SHARE_STATUS_FAILED);
            }
        }
    }
}
