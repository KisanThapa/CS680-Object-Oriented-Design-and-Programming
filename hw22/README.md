• Set up:
– <proj dir>
• hw02.xml (You can name it as you like.) • src [source code directory]
– edu/umb/cs680/hw02/Calculator.java • bin [binary code directory]
– Calculator.class will be placed under this directory.
• test [test code directory] – src
» edu/umb/cs680/hw02/CalculatorTest.java – bin
» CalculatorTest.class will be placed under this directory.
13
• Write hw02.xml yourself.
• Use Ant to build and run Calculator and CalculatorTest
– SetupthedirectorywhereCalculator.classisplaced. • <proj dir>/bin/edu/umb/cs680/hw02
– Set up the directory where CalculatorTest.class is placed. • <proj dir>/test/bin/edu/umb/cs680/hw02
– Set up CLASSPATH
• <proj dir>/bin
• <proj dir>/test/bin
• JUnit JAR files (see the next slide)
– CompileCalculator.javaandgenerateCalculator.classto<proj dir>/bin/edu/.../hw02
– CompileCalculatorTest.javaandgenerateCalculatorTest.classto <proj dir>/test/bin/edu/.../hw02
– RunCalculatorTest.classwithJUnit
– RunCalculator.class