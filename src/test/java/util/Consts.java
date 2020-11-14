package util;
public final class Consts  {

    public static final int WAIT_SECONDS_MEDIUM = 10;
    public static final int WAIT_PAGE_LOAD = 30;

    public static final String DEFAULT_USER = "a.terrong@gmail.com";
    public static final String DEFAULT_PASSWORD = "Ovi$link1265";

    public static final String BASE_URL = "https://qknows-qa.basf.com";

    private Consts(){
        //this prevents from calling this constructor
        throw new AssertionError();
    }
}
