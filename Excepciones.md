# Excepciones

*ArithmeticException:*

It is thrown when an exceptional condition has occurred in an arithmetic operation.

**Java Code**

public class ArithmeticExceptionExample {
    public static void main(String[] args) {
        try {
            int result = 10 / 0; // This will throw ArithmeticException
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Caught ArithmeticException: " + e.getMessage());
        }
    }
}


*ArrayIndexOutOfBoundsException:*
It is thrown to indicate that an array has been accessed with an illegal index. The index is either negative or greater than or equal to the size of the array.

**Java Code**

public class ArrayIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        try {
            int[] array = new int[3];
            int value = array[5]; // This will throw ArrayIndexOutOfBoundsException
            System.out.println("Value: " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}


*ClassNotFoundException:*
This Exception is raised when we try to access a class whose definition is not found

**Java Code**

public class ClassNotFoundExceptionExample {
    public static void main(String[] args) {
        try {
            Class.forName("com.example.NonExistentClass"); // This will throw ClassNotFoundException
        } catch (ClassNotFoundException e) {
            System.out.println("Caught ClassNotFoundException: " + e.getMessage());
        }
    }
}


*FileNotFoundException:*
This Exception is raised when a file is not accessible or does not open.

**Java Code**

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileNotFoundExceptionExample {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader(new File("nonexistent_file.txt")); // This will throw FileNotFoundException
        } catch (FileNotFoundException e) {
            System.out.println("Caught FileNotFoundException: " + e.getMessage());
        }
    }
}



*IOException:*
It is thrown when an input-output operation failed or interrupted

**Java Code**

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class IOExceptionExample {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("example.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Caught IOException: " + e.getMessage());
        }
    }
}



*InterruptedException:*
It is thrown when a thread is waiting, sleeping, or doing some processing, and it is interrupted.

**Java Code**

public class InterruptedExceptionExample {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000); // This may throw InterruptedException
            } catch (InterruptedException e) {
                System.out.println("Caught InterruptedException: " + e.getMessage());
            }
        });
        thread.start();
        
        // Interrupt the thread
        thread.interrupt();
    }
}



*NoSuchFieldException:*
It is thrown when a class does not contain the field (or variable) specified

**Java Code**

import java.lang.reflect.Field;

public class NoSuchFieldExceptionExample {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            Field field = clazz.getField("nonexistentField"); // This will throw NoSuchFieldException
        } catch (NoSuchFieldException e) {
            System.out.println("Caught NoSuchFieldException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Caught ClassNotFoundException: " + e.getMessage());
        }
    }
}


*NoSuchMethodException:*
It is thrown when accessing a method that is not found.

**Java Code**

import java.lang.reflect.Method;

public class NoSuchMethodExceptionExample {
    public static void main(String[] args) {
        try {
            Class<?> clazz = Class.forName("java.lang.String");
            Method method = clazz.getMethod("nonexistentMethod"); // This will throw NoSuchMethodException
        } catch (NoSuchMethodException e) {
            System.out.println("Caught NoSuchMethodException: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Caught ClassNotFoundException: " + e.getMessage());
        }
    }
}



*NullPointerException:*
This exception is raised when referring to the members of a null object. Null represents nothing

**Java Code**

public class NullPointerExceptionExample {
    public static void main(String[] args) {
        try {
            String str = null;
            System.out.println(str.length()); // This will throw NullPointerException
        } catch (NullPointerException e) {
            System.out.println("Caught NullPointerException: " + e.getMessage());
        }
    }
}



*NumberFormatException:*
This exception is raised when a method could not convert a string into a numeric format.

**Java Code**

public class NumberFormatExceptionExample {
    public static void main(String[] args) {
        try {
            String str = "abc";
            int number = Integer.parseInt(str); // This will throw NumberFormatException
            System.out.println("Number: " + number);
        } catch (NumberFormatException e) {
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }
    }
}




*RuntimeException:*
This represents an exception that occurs during runtime.

**Java Code**

public class RuntimeExceptionExample {
    public static void main(String[] args) {
        try {
            throw new RuntimeException("This is a runtime exception");
        } catch (RuntimeException e) {
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }
}



*StringIndexOutOfBoundsException:*
It is thrown by String class methods to indicate that an index is either negative or greater than the size of the string

**Java Code**

public class StringIndexOutOfBoundsExceptionExample {
    public static void main(String[] args) {
        try {
            String str = "Hello, world!";
            char ch = str.charAt(20); // This will throw StringIndexOutOfBoundsException
            System.out.println("Character: " + ch);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException: " + e.getMessage());
        }
    }
}



*IllegalArgumentException :*
This exception will throw the error or error statement when the method receives an argument which is not accurately fit to the given relation or condition. It comes under the unchecked exception. 

**Java Code**

public class IllegalArgumentExceptionExample {
    public static void main(String[] args) {
        try {
            someMethod(-5); // Passing an illegal argument
        } catch (IllegalArgumentException e) {
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
    }

    public static void someMethod(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Value must be non-negative");
        }
        System.out.println("Value is valid");
    }
}



*IllegalStateException :*
This exception will throw an error or error message when the method is not accessed for the particular operation in the application. It comes under the unchecked exception.

**Java Code**

import java.util.concurrent.atomic.AtomicInteger;

public class IllegalStateExceptionExample {
    private static AtomicInteger state = new AtomicInteger(0);
    
    public static void main(String[] args) {
        try {
            someOperation();
            state.set(2); // Setting an invalid state
            someOperation(); // This will throw IllegalStateException
        } catch (IllegalStateException e) {
            System.out.println("Caught IllegalStateException: " + e.getMessage());
        }
    }

    public static void someOperation() {
        if (state.get() != 0) {
            throw new IllegalStateException("Invalid state: state must be 0");
        }
        System.out.println("Operation performed successfully");
    }
}


