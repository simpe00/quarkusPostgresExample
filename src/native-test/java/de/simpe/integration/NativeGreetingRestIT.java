package de.simpe.integration;

import io.quarkus.test.junit.NativeImageTest;

@NativeImageTest
public class NativeGreetingRestIT extends GreetingRestTest {

    // Execute the same tests but in native mode.
}