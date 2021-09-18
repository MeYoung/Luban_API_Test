package com.lucky.common.testng.dataprovider;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Iterator;
import java.util.function.Consumer;

@Slf4j
public class TxtIterator implements Iterator<Object[]> {

    //数据文件
    File txtFile;
    BufferedReader bs;
    String currentLine;

    public TxtIterator(File txtFile) throws IOException {
        super();
        this.txtFile = txtFile;
        try {
            bs = new BufferedReader(new FileReader(txtFile));
        } catch (FileNotFoundException e) {
            log.error("未能找到文件！！！");
            e.printStackTrace();
        }
        currentLine = bs.readLine();
    }

    @Override
    public boolean hasNext() {
        if (currentLine != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Object[] next() {
        String returnLine = currentLine;
        try {
            currentLine = bs.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return returnLine.split(",");
    }

    @Override
    public void remove() {
        Iterator.super.remove();
    }

    @Override
    public void forEachRemaining(Consumer<? super Object[]> action) {
        Iterator.super.forEachRemaining(action);
    }
}
