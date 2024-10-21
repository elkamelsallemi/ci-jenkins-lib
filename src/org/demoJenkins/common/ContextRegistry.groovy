package org.demoJenkins.common

class ContextRegistry implements Serializable{

    private static IJenkinsContext _context  // Store the Jenkins context (script/steps)

    // Registers a context globally
    static void registerContext(IJenkinsContext context) {
        _context = context
    }

    // Returns the registered context
    static IJenkinsContext getContext() {
        return _context
    }
}
