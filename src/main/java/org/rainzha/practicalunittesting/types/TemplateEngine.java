package org.rainzha.practicalunittesting.types;

public interface TemplateEngine {
    String prepareMessage(Template template, Client client);
}
