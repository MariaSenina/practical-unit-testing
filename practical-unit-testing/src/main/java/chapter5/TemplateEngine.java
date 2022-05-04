package chapter5;

import chapter3.Client;

public class TemplateEngine {
    public String prepareMessage(Template template, Client client) {
        return "Message prepared: template -> " + template + "; client -> " + client;
    }
}
