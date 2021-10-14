package otp.lucky.common.testng.dataprovider;

import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @Author shijin.huang
 * @Date 2021/09/26
 */
@Slf4j
public class TxtIterator implements Iterator<Object[]> {

    File txtFile;
    BufferedReader bs;
    String currentLine;

    public TxtIterator(File txtFile) throws IOException {
        super();
        this.txtFile = txtFile;
        try {
            bs = new BufferedReader(new FileReader(txtFile));
        } catch (FileNotFoundException e) {
            log.error("未能找到文件！！！",e);
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
            log.error("读取错误",e);
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
