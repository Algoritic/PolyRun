# Explanation of the Java Code

- File Path: The JavaScript file `greetings.js` is loaded using a `FileReader`.
    - Script Engine Setup:
        A `ScriptEngineManager` instance is created to get the JavaScript engine.
        The code checks for the engine’s availability, which is useful if running on a platform that may lack JavaScript support.
    - Script Loading:
        Using `engine.eval(reader)`;, we load the script from the file.
    - Invocable Casting:
        The `ScriptEngine` is cast to `Invocable`, allowing us to call specific JavaScript functions from Java.
    - Function Invocation:
        invokeFunction("greet", name); calls the greet function in greetings.js and passes name as an argument.
    - Error Handling:
        Uses `try-catch` blocks to handle various exceptions:
            - `ScriptException` for JavaScript execution errors.
            - `NoSuchMethodException` if the JavaScript function is missing.
            - `IOException` for file reading issues.

## Running the Script
Save both `JavaScriptExecutor.java` and `greetings.js` in the same directory or provide the path to `greetings.js`.
Compile the Java file and execute it
```bash
    # Compile the Java file
    javac JavaScriptExecutor.java

    # Run the Java application
    java JavaScriptExecutor
```

If everything is set up correctly, the output should be:
```bash
Hello, Java Developer! Welcome to Java and JavaScript integration.
```