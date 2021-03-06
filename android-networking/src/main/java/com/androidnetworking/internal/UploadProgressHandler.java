/*
 *    Copyright (C) 2016 Amit Shekhar
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package com.androidnetworking.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.androidnetworking.common.ANConstants;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.androidnetworking.model.Progress;

import java.lang.ref.WeakReference;

/**
 * Created by amitshekhar on 24/05/16.
 */
public class UploadProgressHandler extends Handler {

    private final WeakReference<UploadProgressListener> mUploadProgressListenerWeakRef;

    public UploadProgressHandler(UploadProgressListener uploadProgressListener) {
        super(Looper.getMainLooper());
        mUploadProgressListenerWeakRef = new WeakReference<>(uploadProgressListener);
    }

    @Override
    public void handleMessage(Message msg) {
        final UploadProgressListener uploadProgressListener = mUploadProgressListenerWeakRef.get();
        switch (msg.what) {
            case ANConstants.UPDATE:
                if (uploadProgressListener != null) {
                    final Progress progress = (Progress) msg.obj;
                    uploadProgressListener.onProgress(progress.currentBytes, progress.totalBytes);
                }
                break;
            default:
                super.handleMessage(msg);
                break;
        }
    }
}
