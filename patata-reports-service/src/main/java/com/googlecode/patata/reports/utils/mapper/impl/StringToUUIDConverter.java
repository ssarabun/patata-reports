package com.googlecode.patata.reports.utils.mapper.impl;

import java.util.UUID;
import org.dozer.DozerConverter;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 4, 2014
 */
public class StringToUUIDConverter extends DozerConverter<UUID, String> {

    public StringToUUIDConverter() {
        super(UUID.class, String.class);
    }

    @Override
    public String convertTo(UUID a, String b) {
        if (a == null) {
            return null;
        }

        return a.toString();
    }

    @Override
    public UUID convertFrom(String b, UUID a) {
        if (b == null) {
            return null;
        }

        return UUID.fromString(b);
    }
}
