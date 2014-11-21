package com.googlecode.patata.reports.toa.convertor;

import java.io.Serializable;

/**
 *
 * @author sergey.sarabun@gmail.com
 * @date Aug 7, 2014
 */
public interface IIdentifierConvertor<EID extends Serializable, VID extends Serializable> {

    VID convertEntityId(EID id);

    EID convertViewId(VID id);
}
