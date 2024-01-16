package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class CheckedTest {


    static class MyCheckedException extends Exception{
        public MyCheckedException(String message){
            super(message);
        }
    }


}
