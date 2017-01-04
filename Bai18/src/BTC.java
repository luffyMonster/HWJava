
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luffy monster
 */
public class BTC implements TableIO,Serializable{
    CN cn;
    SP sp;
    int sl;

    public BTC(CN cn, SP sp, int sl) {
        this.cn = cn;
        this.sp = sp;
        this.sl = sl;
    }

    public CN getCn() {
        return cn;
    }

    public SP getSp() {
        return sp;
    }

    public int getSl() {
        return sl;
    }
    
    @Override
    public Object[] toObject() {
        return new Object[]{cn.getId(), cn.getTen(), sp.getId(), sl};
    }
    
}
