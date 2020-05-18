package java.io;


public class StringWriter extends java.io.Writer {
    private java.lang.StringBuffer buf;

    public StringWriter() {
        buf = new java.lang.StringBuffer();
        lock = buf;
    }

    public StringWriter(int initialSize) {
        if (initialSize < 0) {
            throw new java.lang.IllegalArgumentException("Negative buffer size");
        }
        buf = new java.lang.StringBuffer(initialSize);
        lock = buf;
    }

    public void write(int c) {
        buf.append(((char) (c)));
    }

    public void write(char[] cbuf, int off, int len) {
        if (((((off < 0) || (off > (cbuf.length))) || (len < 0)) || ((off + len) > (cbuf.length))) || ((off + len) < 0)) {
            throw new java.lang.IndexOutOfBoundsException();
        }else
            if (len == 0) {
                return ;
            }

        buf.append(cbuf, off, len);
    }

    public void write(java.lang.String str) {
        buf.append(str);
    }

    public void write(java.lang.String str, int off, int len) {
        buf.append(str.substring(off, (off + len)));
    }

    public java.io.StringWriter append(java.lang.CharSequence csq) {
        if (csq == null)
            write("null");
        else
            write(csq.toString());

        return this;
    }

    public java.io.StringWriter append(java.lang.CharSequence csq, int start, int end) {
        java.lang.CharSequence cs = (csq == null) ? "null" : csq;
        write(cs.subSequence(start, end).toString());
        return this;
    }

    public java.io.StringWriter append(char c) {
        write(c);
        return this;
    }

    public java.lang.String toString() {
        return buf.toString();
    }

    public java.lang.StringBuffer getBuffer() {
        return buf;
    }

    public void flush() {
    }

    public void close() throws java.io.IOException {
    }
}

