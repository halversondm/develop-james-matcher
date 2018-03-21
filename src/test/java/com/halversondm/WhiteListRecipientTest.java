package com.halversondm;

import org.apache.mailet.MailAddress;
import org.junit.Assert;
import org.junit.Test;

public class WhiteListRecipientTest {

    WhiteListRecipient unit;

    @Test
    public void constructor_WhenTypical() {
        unit = new WhiteListRecipient();
        Assert.assertFalse(unit.emailNames.isEmpty());
        Assert.assertEquals(4, unit.emailNames.size());
    }

    @Test
    public void matchReceipient_WhenTypical() throws Exception {
        unit = new WhiteListRecipient();
        MailAddress mailAddress = new MailAddress("daniel.m.halverson@gmail.com");
        boolean isValid = unit.matchRecipient(mailAddress);
        Assert.assertTrue(isValid);
    }

    @Test
    public void matchReceipient_WhenNotFound() throws Exception {
        unit = new WhiteListRecipient();
        MailAddress mailAddress = new MailAddress("spot.doe@gmail.com");
        boolean isValid = unit.matchRecipient(mailAddress);
        Assert.assertFalse(isValid);
    }

    @Test
    public void matchReceipient_WhenAddressHasDifferentCaseThanWhiteList() throws Exception {
        unit = new WhiteListRecipient();
        MailAddress mailAddress = new MailAddress("dAnIeL.m.HaLvErSoN@gmail.com");
        boolean isValid = unit.matchRecipient(mailAddress);
        Assert.assertTrue(isValid);
    }
}
