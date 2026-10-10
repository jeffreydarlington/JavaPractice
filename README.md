# JavaPractice

Small, focused Java programs I wrote to learn the fundamentals of `java.util.Properties`: how to store, read, loop over, save, and reload simple key-value configuration.

> **Goal:** understand *why* each piece works, not just copy it. Each file is one concept, kept short enough to rebuild from memory.

## What's inside

| File | Concept | What it shows |
|---|---|---|
| `db.java` | Basics | `setProperty`, `getProperty`, default values, `remove` |
| `ConfigFileExample.java` | File I/O | Saving with `store()` and reloading with `load()` using `FileWriter` / `FileReader` |
| `IterateProperties.java` | Iteration | Looping over every key with `keySet().iterator()` |

All files live in `src/main/java/org/example/`.

## What is `Properties`?

`Properties` is a `Map`-like class where **both keys and values are Strings**. Its special trick is that it can write itself to a `.properties` file and read itself back. That makes it a simple, built-in way to handle app configuration (ports, database URLs, feature flags, language settings).

## How to run

**In IntelliJ:** open the file and click the green run arrow next to `main`.

**From the command line** (from the project root):

```bash
javac -d out src/main/java/org/example/*.java
java -cp out org.example.db
java -cp out org.example.ConfigFileExample
java -cp out org.example.IterateProperties
```

Requires a JDK (Java 11 or newer, since the encoding examples use `Charset` overloads of `FileWriter` and `FileReader` that were added in Java 11).

## Examples and expected output

### 1. `db.java`: the basics

Sets three properties, reads one, reads a missing one with a default, then removes one.

```java
Properties props = new Properties();
props.setProperty("db.url", "jdbc:postgresql://localhost:5432/mydb");
props.setProperty("db.user", "jeff");
props.setProperty("app.env", "development");

String logLevel = props.getProperty("log.level", "INFO"); // default used
props.remove("app.env");
```

```
DB URL: jdbc:postgresql://localhost:5432/mydb
Log level: INFO
app.env after remove: null
```

**Takeaway:** `getProperty(key, default)` returns the default instead of `null` when a key is missing, which prevents `NullPointerException`s from absent config values.

### 2. `ConfigFileExample.java`: save and reload

Builds a config, writes it to `config.properties`, then loads it back into a brand-new `Properties` object, as if the app had just restarted.

```
#App configuration
Loaded port: 8080
Name : MyPipeline
```

The generated `config.properties` looks like:

```properties
#App configuration
#<timestamp>
app.port=8080
app.name=MyPipeline
```

**Takeaway:** config outlives the program. Lines starting with `#` are comments, and each setting is one `key=value` line.

### 3. `IterateProperties.java`: looping over keys

Loops over `keySet()` with an `Iterator` and prints each pair.

```
goal = Cybersecurity
name = Jeff
role = Junior Developer
```

**Takeaway:** the order is **not guaranteed**, because `Properties` is backed by a hash table, so your output may differ from the order you set the values in. The `(String)` cast is needed because `keySet()` returns `Object` keys.

## Mistakes I made (and what they taught me)

- **Statements in the class body.** I put `props.setProperty(...)` directly inside the class instead of inside `main`, and got *"Cannot resolve symbol."* A class body can only contain declarations (fields, methods, constructors). Executable statements must live inside a method.
- **Missing separator in output.** `"Log level" + logLevel` printed `Log levelINFO`. Always add the `": "` yourself, because string concatenation adds nothing for you.
- **Naming.** Java class names should start with a capital letter (`Db`, not `db`), and the file name must match the public class name.

## Gotchas to remember

1. **Use `setProperty` / `getProperty`, never `put` / `get`.** `Properties` secretly extends `Hashtable`, so `put("count", 5)` compiles, but `getProperty("count")` then returns `null` because the value isn't a String.
2. **Encoding differs by format.** Plain `.properties` files default to ISO-8859-1, while XML properties default to UTF-8.
3. **Never hardcode real secrets.** Load credentials from a config file instead of source code.
4. **Keep real config files out of git.** Add them to `.gitignore` and commit a template like `config.properties.example` with fake values.
5. **Git history is permanent.** If a real secret is ever committed, deleting it later isn't enough. Rotate the secret.

## Where this connects

- Spring Boot's `application.properties` uses the same `key=value` idea.
- `.env` files in Docker and Node projects solve the same configuration problem.
- `System.getProperties()` is the JVM's own built-in `Properties` object.