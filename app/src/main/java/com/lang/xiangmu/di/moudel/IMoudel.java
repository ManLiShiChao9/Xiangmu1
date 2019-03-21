package com.lang.xiangmu.di.moudel;

import com.lang.xiangmu.data.Constant;
import com.lang.xiangmu.di.contract.IContract;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

public class IMoudel implements IContract.IMoudel {
    @Override
    public void callBack(final oncallBack callback) {
        OkGo.<String>post(Constant.DLURL).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String s = response.body().toString();
                callback.oncallBack(s);
            }
        });
    }
}
