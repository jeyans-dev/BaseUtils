# BaseUtils

A lightweight Java utility library designed to streamline common development tasks. Currently, it features a robust, automated logging utility to replace repetitive boilerplate code.

## 📁 Project Structure

```text
BaseUtils
├── src
│   └── main
│       └── java
│           └── org.jeyan.utils
│               └── LogUtil.java    <-- Core Logging Utility
└── target
    └── logs/                       <-- Default log output directory
```

## 🚀 Features

* **Automatic Log Rotation:** Generates unique log files based on system timestamps (MMddyy-hhmmss).
* **Self-Healing Paths:** Automatically detects and creates the target/logs directory if it is missing.
* **Simplified API:** Easy-to-use wrappers for info, warn, and error levels using standard Java Logging.
* **Resource Management:** Includes a close() method to safely release file locks.

## 🛠️ Getting Started

### Prerequisites
* Java 8 or higher
* Maven

### Installation
Clone the repository and build the project:
```bash
git clone https://github.com/your-username/BaseUtils.git
cd BaseUtils
mvn clean install
```

## 📖 Usage

To use the logging utility in your project, instantiate LogUtil and call the desired log level method.

```java
import org.jeyan.utils.LogUtil;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize the Utility
        LogUtil log = new LogUtil();

        // 2. Log messages
        log.info("System initialized successfully.");
        log.warn("Memory usage is reaching threshold.");
        log.error("Failed to connect to the database.");

        // 3. Close the handler to release the file
        log.close();
    }
}
```

## 📊 Log Output
Logs are stored in the target/logs/ directory with the following naming convention:
log-MMddyy-hhmmss.log

**Example Content:**
```text
Apr 08, 2026 1:51:57 PM org.jeyan.utils.LogUtil info
INFO: System initialized successfully.
```

## 🚧 Roadmap
* [ ] Implement Singleton pattern for LogUtil.
* [ ] Add automated Shutdown Hooks for resource cleanup.
* [ ] Expand BaseUtils with String and File manipulation helpers.