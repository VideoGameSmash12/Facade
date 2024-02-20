package TemplateCompiler;

import jess.JessException;

class JessExceptionHelper
{
    static void processJessException(final JessException ex) {
        if (ex.getCause() != null) {
            System.out.println(ex.getCause());
        }
        System.out.println(ex.getRoutine() + ' ' + ex.getProgramText() + ' ' + ex.getData() + ' ' + ex.getLineNumber());
        System.out.println(ex.getNextException());
        throw new RuntimeException(ex.getMessage());
    }
}
