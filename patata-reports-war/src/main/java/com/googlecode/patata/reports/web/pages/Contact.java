package com.googlecode.patata.reports.web.pages;

import org.apache.tapestry5.MarkupWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Contact {

    private static final Logger logger = LoggerFactory.getLogger(Contact.class);

    void setupRender() {
        logger.info("void setupRender()");
    }

    boolean beginRender(MarkupWriter writer) throws Exception {
        logger.info("boolean beginRender(MarkupWriter writer)");
        return true;
    }
}
