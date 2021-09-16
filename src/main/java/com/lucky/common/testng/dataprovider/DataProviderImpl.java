package com.lucky.common.testng.dataprovider;

import java.util.Iterator;

public interface DataProviderImpl {

    public Iterator<Object[]> getData(String path);

    public void setData();
}
