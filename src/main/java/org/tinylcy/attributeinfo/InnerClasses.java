package org.tinylcy.attributeinfo;

import org.tinylcy.basictype.U2;
import org.tinylcy.basictype.U4;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by chenyangli.
 */
public class InnerClasses extends BasicAttributeInfo {

    private short numberOfClasses;
    private InnerClassesInfo[] innerClasses;

    public InnerClasses(short attributeNameIndex) {
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        U2 attributeNameIndexU2 = U2.read(inputStream);
        U4 attributeLengthU4 = U4.read(inputStream);
        U2 numberOfClassesU2 = U2.read(inputStream);
        setAttributeNameIndex(attributeNameIndexU2.getValue());
        setAttributeLength(attributeLengthU4.getValue());
        numberOfClasses = numberOfClassesU2.getValue();
        innerClasses = new InnerClassesInfo[numberOfClasses];
        for (int i = 0; i < numberOfClasses; i++) {
            InnerClassesInfo innerClassesInfo = new InnerClassesInfo();
            innerClassesInfo.read(inputStream);
            innerClasses[i] = innerClassesInfo;
        }
    }

    @Override
    public String toString() {
        return "InnerClasses{" +
                "attributeNameIndex=" + getAttributeNameIndex() +
                ", attributeLength=" + getAttributeLength() +
                ", numberOfClasses=" + numberOfClasses +
                ", innerClasses=" + Arrays.toString(innerClasses) +
                '}';
    }

    private class InnerClassesInfo {
        public short innerClassInfoIndex;
        public short outerClassInfoIndex;
        public short innerNameIndex;
        public short innerClassAccessFlags;

        public void read(InputStream inputStream) {
            U2 innerClassInfoIndexU2 = U2.read(inputStream);
            U2 outerClassInfoIndexU2 = U2.read(inputStream);
            U2 innerNameIndexU2 = U2.read(inputStream);
            U2 innerClassAccessFlagsU2 = U2.read(inputStream);
            innerClassInfoIndex = innerClassInfoIndexU2.getValue();
            outerClassInfoIndex = outerClassInfoIndexU2.getValue();
            innerNameIndex = innerNameIndexU2.getValue();
            innerClassAccessFlags = innerClassAccessFlagsU2.getValue();
        }

        @Override
        public String toString() {
            return "InnerClassesInfo{" +
                    "innerClassInfoIndex=" + innerClassInfoIndex +
                    ", outerClassInfoIndex=" + outerClassInfoIndex +
                    ", innerNameIndex=" + innerNameIndex +
                    ", innerClassAccessFlags=" + innerClassAccessFlags +
                    '}';
        }
    }
}
