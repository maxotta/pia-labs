package org.danekja.edu.pia.manager.stubs;

import org.danekja.edu.pia.utils.Encoder;

import java.util.Objects;

public class EncoderStub implements Encoder {

    @Override
    public String encode(String text) {
        return hash(text);
    }

    @Override
    public boolean validate(String text, String hash) {
        return Objects.equals(hash(text), hash);
    }

    private String hash(String text) {
        return "HASHED" + text;
    }
}
