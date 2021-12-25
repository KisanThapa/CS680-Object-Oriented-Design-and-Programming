• Will send you:
– <proj dir>/src/edu/umb/cs680/junit5intro/Calculator.java – <proj dir>/hw.xml
• Run the build script (on your command-line shell) in the directory where it is located (i.e., at <proj dir>).
– Type:ant-fhw.xml
• Understand how it builds and runs Calculator
– SetupthedirectorywhereCalculator.classisplaced. • <proj dir>/bin/edu/umb/cs680/junit5intro
– Set up CLASSPATH
• <proj dir>/bin
– CompileCalculator.javaandgenerateCalculator.classto<proj
dir>/bin/edu/.../junit5intro • Use<javac>task
– RunCalculator.class
• Use <java> task to run Calculator’s main()
7
• No need to do unit testing
– No need to use JUnit and CalculatorTest
• No need to turn in anything. Just make sure that the build script runs properly.
– At least, on your shell
– Preferably, on both your shell and IDE
