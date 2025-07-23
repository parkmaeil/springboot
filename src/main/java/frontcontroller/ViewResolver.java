package frontcontroller;

public class ViewResolver {
    private static final String VIEWS_PREFIX="/WEB-INF/views/";
    private static final String VIEWS_EXTENSION=".jsp";
    public static String makeView(String viewName){
        return VIEWS_PREFIX+viewName+VIEWS_EXTENSION;
    }
}
