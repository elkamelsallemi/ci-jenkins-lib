package org.demoJenkins.common

class ContextRegistry implements Serializable{
    private static def _context  // Store the Jenkins context (script/steps)

    // Registers a context globally
    static void registerContext(def context) {
        _context = context
    }

    // Returns the registered context
    static def getContext() {
        return _context
    }
}
