package dramaman.compiler;

public interface MacroDefinitions
{
    public static final String eol = System.getProperty("line.separator");
    public static final String wmeTestGetWMEListNoMemoryMacroString = "definemacro wmeTestGetWMEListNoMemory(wmeCount, wmeClassName)List wmeList@wmeCount;" + MacroDefinitions.eol + "Iterator wmeIter@wmeCount;" + MacroDefinitions.eol + "wmeList@wmeCount = DramaManager.lookupWME(\"wmeClassName\");" + MacroDefinitions.eol + "wmeIter@wmeCount = wmeList@wmeCount.listIterator();";
    public static final String wmeTestGetWMEListMemoryMacroString = "definemacro wmeTestGetWMEListMemory(wmeCount, wmeClassName, memoryName)List wmeList@wmeCount;" + MacroDefinitions.eol + "Iterator wmeIter@wmeCount;" + MacroDefinitions.eol + "wmeList@wmeCount = WorkingMemory.lookupWME(\"memoryName\", \"wmeClassName\");" + MacroDefinitions.eol + "wmeIter@wmeCount = wmeList@wmeCount.listIterator();";
    public static final String wmeTestWhileMacroString = "definemacro wmeTestWhile(wmeCount)while(wmeIter@wmeCount.hasNext()) {";
    public static final String wmeTestWhileNextAssignMacroString = "definemacro wmeTestWhileNext(wmeCount, wmeClassName, wmeAssignVar)wmeClassName wme__@wmeCount = (wmeClassName)wmeIter@wmeCount.next();" + MacroDefinitions.eol + "wmeAssignVar = wme__@wmeCount;";
    public static final String wmeTestWhileNextNoAssignMacroString = "definemacro wmeTestWhileNext(wmeCount, wmeClassName)wmeClassName wme__@wmeCount = (wmeClassName)wmeIter@wmeCount.next();";
    public static final String scopeInitializerMacroString = "definemacro scope(parentScope, scopeName)new VariableScopeThrowsErrors(parentScope, \"@scopeName_scope\")";
    public static final String defineVariableMacroString = "definemacro defineVariable(variableName, initializer, type)_scope.defineVariable(\"variableName\", initializer, \"type\");";
}
