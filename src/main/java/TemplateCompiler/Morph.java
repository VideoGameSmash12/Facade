package TemplateCompiler;

class Morph
{
    public static native String morphstr(final String p0);
    
    public static void main(final String[] array) {
        System.out.println(morphstr(array[0]));
    }
    
    static {
        System.loadLibrary("morph");
    }
}
