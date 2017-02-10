package org.tinylcy.attributeinfo;

import org.tinylcy.constantpool.ConstantPool;

import java.io.InputStream;
import java.util.Arrays;

/**
 * Created by chenyangli.
 */
public class BootstrapMethods extends BasicAttributeInfo {

    private short numBootstrapMethods;
    private BootstrapMethod[] bootstrapMethod;

    public BootstrapMethods(short attributeNameIndex) {
        setAttributeNameIndex(attributeNameIndex);
    }

    @Override
    public void read(InputStream inputStream) {
        super.read(inputStream);
    }

    @Override
    public void read(ConstantPool constantPool, InputStream inputStream) {
        super.read(constantPool, inputStream);
    }

    @Override
    public String toString() {
        return "BootstrapMethods{" +
                "attributeNameIndex=" + getAttributeNameIndex() +
                ", attributeLength=" + getAttributeLength() +
                ", numBootstrapMethods=" + numBootstrapMethods +
                ", bootstrapMethod=" + Arrays.toString(bootstrapMethod) +
                '}';
    }

    private class BootstrapMethod {

        public short bootstrapMethodRef;
        public short numBootstrapArguments;
        public short bootstrapArguments;

        @Override
        public String toString() {
            return "BootstrapMethod{" +
                    "bootstrapMethodRef=" + bootstrapMethodRef +
                    ", numBootstrapArguments=" + numBootstrapArguments +
                    ", bootstrapArguments=" + bootstrapArguments +
                    '}';
        }
    }
}
