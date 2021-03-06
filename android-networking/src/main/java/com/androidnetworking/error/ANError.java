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

package com.androidnetworking.error;

import com.androidnetworking.common.ANData;
import com.androidnetworking.common.ANConstants;

/**
 * Created by amitshekhar on 22/03/16.
 */
public class ANError extends Exception {

    private ANData data;

    private String errorBody;

    private int errorCode = 0;

    private String errorDetail;

    public ANError() {
    }

    public ANError(ANData data) {
        this.data = data;
    }

    public ANError(String message) {
        super(message);
    }

    public ANError(String message, ANData data) {
        super(message);
        this.data = data;
    }

    public ANError(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ANError(String message, ANData data, Throwable throwable) {
        super(message, throwable);
        this.data = data;
    }

    public ANError(ANData data, Throwable throwable) {
        super(throwable);
        this.data = data;
    }

    public ANError(Throwable throwable) {
        super(throwable);
    }

    public ANData getData() {
        return data;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public String getErrorDetail() {
        return this.errorDetail;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public void setCancellationMessageInError() {
        this.errorDetail = ANConstants.REQUEST_CANCELLED_ERROR;
    }

    public String getErrorBody() {
        return errorBody;
    }

    public void setErrorBody(String errorBody) {
        this.errorBody = errorBody;
    }

}
