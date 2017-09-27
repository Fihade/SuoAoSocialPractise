package com.matrixxun.producttour;

import java.io.Serializable;

/**
 * Created by swaggymiller on 2017/7/23.
 */

public class TransmitBean implements Serializable {


    private byte[] byteCS=new byte[1024];

    public void setByte(byte[] bytes) {
        this.byteCS = bytes;
    }

    public byte[] getByte(){

        return this.byteCS;
    }
}