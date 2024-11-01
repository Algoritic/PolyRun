import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JavaScriptExecutor {
    
    private static final String JS_FILE_PATH = "greetings.js";
    
    public static void main(String[] args) {
        JavaScriptExecutor executor = new JavaScriptExecutor();
        executor.runScript("Java Developer");
    }

    /**
     * Executes the JavaScript 'greet' function with a given name.
     * @param name The name to pass to the JavaScript function.
     */
    public void runScript(String name) {
        // Step 1: Create a ScriptEngineManager and obtain the JavaScript engine.
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");

        // Step 2: Check if JavaScript engine is available
        if (engine == null) {
            System.err.println("JavaScript engine not available. Ensure compatibility.");
            return;
        }

        // Step 3: Load and execute the JavaScript file
        try (FileReader reader = new FileReader(JS_FILE_PATH)) {
            engine.eval(reader); // Load the script into the engine

            // Step 4: Cast the engine to Invocable to call specific functions
            if (engine instanceof Invocable) {
                Invocable invocable = (Invocable) engine;

                // Step 5: Invoke the greet function in JavaScript with the provided name
                Object result = invocable.invokeFunction("greet", name);
                System.out.println(result.toString());
            } else {
                System.err.println("Engine does not support function invocation.");
            }

        } catch (ScriptException | NoSuchMethodException e) {
            System.err.println("JavaScript execution error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Error reading JavaScript file: " + e.getMessage());
        }
    }
}
