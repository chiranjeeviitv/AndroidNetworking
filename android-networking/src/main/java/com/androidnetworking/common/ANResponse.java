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

package com.androidnetworking.common;

import com.androidnetworking.error.ANError;

/**
 * Created by amitshekhar on 22/03/16.
 */
public class ANResponse<T> {

    private final T mResult;

    private final ANError mANError;

    public static <T> ANResponse<T> success(T result) {
        return new ANResponse<>(result);
    }

    public static <T> ANResponse<T> failed(ANError ANError) {
        return new ANResponse<>(ANError);
    }

    private ANResponse(T result) {
        this.mResult = result;
        this.mANError = null;
    }

    private ANResponse(ANError ANError) {
        this.mResult = null;
        this.mANError = ANError;
        this.mANError.setErrorCode(0);
        this.mANError.setErrorDetail(ANConstants.PARSE_ERROR);
    }

    public T getResult() {
        return mResult;
    }

    public boolean isSuccess() {
        return mANError == null;
    }

    public ANError getError() {
        return mANError;
    }

}
