package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by chenyangli.
 */
public class Exceptions extends BasicAttributeInfo {

    private short numberOfExceptions;
    private short[] exceptionIndexTable;

    public Exceptions(short attributeNameIndex) {
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 attributeNameIndexU2 = U2.read(inputStream);
        U4 attributeLengthU4 = U4.read(inputStream);
        U2 numberOfExceptionsU2 = U2.read(inputStream);
        setAttributeNameIndex(attributeNameIndexU2.getValue());
        setAttributeLength(attributeLengthU4.getValue());
        numberOfExceptions = numberOfExceptionsU2.getValue();
        exceptionIndexTable = new short[numberOfExceptions];
        for (int i = 0; i < numberOfExceptions; i++) {
            U2 exceptionIndexU2 = U2.read(inputStream);
            exceptionIndexTable[i] = exceptionIndexU2.getValue();
        }
    }

    @Override
    public String toString() {
        return "Exceptions{" +
                "attributeNameIndex=" + getAttributeNameIndex() +
                ", attributeLength=" + getAttributeLength() +
                ", numberOfExceptions=" + numberOfExceptions +
                ", exceptionIndexTable=" + Arrays.toString(exceptionIndexTable) +
                '}';
    }

}
