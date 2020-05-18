package java.io;


public abstract class Writer implements java.io.Closeable , java.io.Flushable , java.lang.Appendable {
    private char[] writeBuffer;

    private static final int WRITE_BUFFER_SIZE = 1024;

    protected java.lang.Object lock;

    protected Writer() {
        this.lock = this;
    }

    protected Writer(java.lang.Object lock) {
        if (lock == null) {
            throw new java.lang.NullPointerException();
        }
        this.lock = lock;
    }

    public void write(int c) throws java.io.IOException {
        synchronized(lock) {
            if ((writeBuffer) == null) {
                writeBuffer = new char[java.io.Writer.WRITE_BUFFER_SIZE];
            }
            writeBuffer[0] = ((char) (c));
            write(writeBuffer, 0, 1);
        }
    }

    public void write(char[] cbuf) throws java.io.IOException {
        write(cbuf, 0, cbuf.length);
    }

    public abstract void write(char[] cbuf, int off, int len) throws java.io.IOException;

    public void write(java.lang.String str) throws java.io.IOException {
        write(str, 0, str.length());
    }

    public void write(java.lang.String str, int off, int len) throws java.io.IOException {
        synchronized(lock) {
            char[] cbuf;
            if (len <= (java.io.Writer.WRITE_BUFFER_SIZE)) {
                if ((writeBuffer) == null) {
                    writeBuffer = new char[java.io.Writer.WRITE_BUFFER_SIZE];
                }
                cbuf = writeBuffer;
            }else {
                cbuf = new char[len];
            }
            str.getChars(off, (off + len), cbuf, 0);
            write(cbuf, 0, len);
        }
    }

    public java.io.Writer append(java.lang.CharSequence csq) throws java.io.IOException {
        if (csq == null)
            write("null");
        else
            write(csq.toString());

        return this;
    }

    public java.io.Writer append(java.lang.CharSequence csq, int start, int end) throws java.io.IOException {
        java.lang.CharSequence cs = (csq == null) ? "null" : csq;
        write(cs.subSequence(start, end).toString());
        return this;
    }

    public java.io.Writer append(char c) throws java.io.IOException {
        write(c);
        return this;
    }

    public abstract void flush() throws java.io.IOException;

    public abstract void close() throws java.io.IOException;
}

