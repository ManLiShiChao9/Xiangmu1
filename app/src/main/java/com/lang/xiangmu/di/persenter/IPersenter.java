package com.lang.xiangmu.di.persenter;

import com.lang.xiangmu.di.contract.IContract;
import com.lang.xiangmu.di.moudel.IMoudel;

import java.lang.ref.SoftReference;

public class IPersenter implements IContract.IPersenter<IContract.IView> {
    IContract.IView iView;
    private SoftReference<IMoudel> reference;
    private IMoudel iMoudel;

    @Override
    public void attachView(IContract.IView iView) {
        this.iView = iView;
        iMoudel = new IMoudel();
        reference = new SoftReference<>(iMoudel);
    }

    @Override
    public void destach(IContract.IView iView) {
        reference.clear();

    }

    @Override
    public void request() {
        iMoudel.callBack(new IContract.IMoudel.oncallBack() {
            @Override
            public void oncallBack(String s) {
                iView.showData(s);
            }
        });
    }
}
