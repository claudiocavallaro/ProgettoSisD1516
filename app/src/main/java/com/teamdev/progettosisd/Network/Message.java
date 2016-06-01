package com.teamdev.progettosisd.Network;
/**
 * Created by claud on 01/06/2016.
 */
import java.io.Serializable;

public class Message implements Serializable {

    private byte type;
    private Object content;

    public Message(byte type, Object content) {
        super();
        this.type = type;
        this.content = content;
    }

    public byte getType() {
        return type;
    }

    public void setType(byte type) {
        this.type = type;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

}

