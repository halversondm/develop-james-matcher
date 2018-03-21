package com.halversondm;

import org.apache.mailet.MailAddress;
import org.apache.mailet.base.GenericRecipientMatcher;

import javax.mail.MessagingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WhiteListRecipient extends GenericRecipientMatcher {

    List<String> emailNames = new ArrayList<>();

    public WhiteListRecipient() {
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("email_whitelist.txt");
        if (inputStream != null) {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    if (!line.startsWith("#") && !line.isEmpty()) {
                        emailNames.add(line);
                    }
                }
            } catch (IOException ie) {
                ie.printStackTrace();
            } finally {
                try {
                    inputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else {
            throw new RuntimeException("The email_whitelist.txt file on the classpath is necessary to use this Matcher");
        }
    }

    public boolean matchRecipient(MailAddress mailAddress) throws MessagingException {
        String localPart = mailAddress.getLocalPart().toLowerCase();
        return emailNames.contains(localPart);
    }
}
