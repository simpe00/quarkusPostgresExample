package org.acme.integration;

import io.quarkus.test.junit.NativeImageTest;
import org.acme.integration.GreetingRestTest;

@NativeImageTest
public class NativeGreetingRestIT extends GreetingRestTest {

    // Execute the same tests but in native mode.
}