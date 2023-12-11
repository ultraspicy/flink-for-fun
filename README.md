This project is the centralized place for all flink jobs for BlitzScaling business.

### Prerequisites
 -  you need to have [Apache Maven](https://maven.apache.org/) installed. Verify your installation by running `mvn --version` and you should see something similar like 
```
    Apache Maven 3.8.1 (05c21c65bdfed0f71a2f2ada8b84da59348c4c5d)
    Maven home: /usr/local/Cellar/maven/3.8.1/libexec
    Java version: 16.0.1, vendor: Homebrew, runtime: /usr/local/Cellar/openjdk/16.0.1/libexec/openjdk.jdk/Contents/Home
    Default locale: en_US, platform encoding: UTF-8
    OS name: "mac os x", version: "11.4", arch: "x86_64", family: "mac"                                                                                                                                                                 
```
 - Download [Apache Flink](https://flink.apache.org/). 
 - Add environment variables in `~/.bash_profile`, or `~/.zshrc` if you use zsh. For example,
 ```
    export FLINK_HOME=$HOME/flink-1.13.1
    export PATH="$FLINK_HOME/bin:$PATH"
 ``` 
 - verify the flink installation is correct by running `flink -v`, you should see something similar like 
 ```
    Version: 1.13.1, Commit ID: a7f3192
```

### How to run a sample flink job locally 
Here we take the src/main/java/BlitzScaling/ExampleJob class as the example

 - clone this project to your local. Under project root, run `mvn clean package` to build all packages 
 - in a separate terminal(referred as t1), `run nc -l 9000` to open a text socket port so your flink job and take its input from there
 - in a another separate terminal(refereed as t2), change your directory to `$FLINK_HOME/log` and run `tail -f flink-*-taskexecutor-0-*.out` to track the log files
 - in PROJ_ROOT, run 
 ```
    flink run -c BlitzScaling.ExampleJob ./target/flink-1.0-SNAPSHOT.jar --host 127.0.0.1 --port 9000
 ``` 
   and go to [Flink UI](localhost:8081) to check out the job status
 - in t1, type some random string and you should be able to see it in t2.
 
 
Still WIP 