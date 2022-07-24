import com.ql.util.express.DefaultContext;
import com.ql.util.express.ExpressRunner;

public class Main {

    public static void main(String[] args) {

        CompositeModel compositeModel = new CompositeModel("SUCCESS", "PROCESSING");

        ExpressRunner runner = new ExpressRunner();
        DefaultContext<String, Object> context = new DefaultContext<>();
        context.put("compositeModel", compositeModel);
        String expression = "\"PROCESSING\".equals(compositeModel.lastStatus)";
        Object result = null;
        try {
            result = runner.execute(expression, context, null, false, false);
        } catch (Exception exception) {
            exception.printStackTrace();
        }

        System.out.println(result);
    }
}
