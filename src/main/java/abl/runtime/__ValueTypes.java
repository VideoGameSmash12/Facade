package abl.runtime;

public class __ValueTypes
{
    public static class IntVar
    {
        public int i;
        
        public String toString() {
            return Integer.toString(this.i);
        }
        
        public IntVar(final int i) {
            this.i = i;
        }
        
        public IntVar(final Integer n) {
            this.i = n;
        }
        
        public IntVar() {
        }
    }
    
    public static class LongVar
    {
        public long l;
        
        public String toString() {
            return Long.toString(this.l);
        }
        
        public LongVar(final long l) {
            this.l = l;
        }
        
        public LongVar(final Long n) {
            this.l = n;
        }
        
        public LongVar() {
        }
    }
    
    public static class ShortVar
    {
        public short s;
        
        public String toString() {
            return Short.toString(this.s);
        }
        
        public ShortVar(final short s) {
            this.s = s;
        }
        
        public ShortVar(final Short n) {
            this.s = n;
        }
        
        public ShortVar() {
        }
    }
    
    public static class ByteVar
    {
        public byte b;
        
        public String toString() {
            return Byte.toString(this.b);
        }
        
        public ByteVar(final byte b) {
            this.b = b;
        }
        
        public ByteVar(final Byte b) {
            this.b = b;
        }
        
        public ByteVar() {
        }
    }
    
    public static class FloatVar
    {
        public float f;
        
        public String toString() {
            return Float.toString(this.f);
        }
        
        public FloatVar(final float f) {
            this.f = f;
        }
        
        public FloatVar(final Float n) {
            this.f = n;
        }
        
        public FloatVar() {
        }
    }
    
    public static class DoubleVar
    {
        public double d;
        
        public String toString() {
            return Double.toString(this.d);
        }
        
        public DoubleVar(final double d) {
            this.d = d;
        }
        
        public DoubleVar(final Double n) {
            this.d = n;
        }
        
        public DoubleVar() {
        }
    }
    
    public static class BooleanVar
    {
        public boolean b;
        
        public String toString() {
            return new Boolean(this.b).toString();
        }
        
        public BooleanVar(final boolean b) {
            this.b = b;
        }
        
        public BooleanVar(final Boolean b) {
            this.b = b;
        }
        
        public BooleanVar() {
        }
    }
    
    public static class CharVar
    {
        public char c;
        
        public String toString() {
            return new Character(this.c).toString();
        }
        
        public CharVar(final char c) {
            this.c = c;
        }
        
        public CharVar(final Character c) {
            this.c = c;
        }
        
        public CharVar() {
        }
    }
    
    public static class ObjectVar
    {
        public Object o;
        
        public String toString() {
            return this.o.toString();
        }
        
        public ObjectVar(final Object o) {
            this.o = o;
        }
        
        public ObjectVar() {
        }
    }
}
